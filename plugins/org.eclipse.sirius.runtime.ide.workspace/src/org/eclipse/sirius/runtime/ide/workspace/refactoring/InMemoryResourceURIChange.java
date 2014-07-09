package org.eclipse.sirius.runtime.ide.workspace.refactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.runtime.ide.workspace.dependencies.ModelDependenciesGraph;
import org.eclipse.sirius.runtime.ide.workspace.dependencies.WorkspaceDependencies;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class InMemoryResourceURIChange extends Change {

	private URIChange uriChange;

	public InMemoryResourceURIChange(URIChange uriChange) {
		this.uriChange = uriChange;
	}

	@Override
	public String getName() {
		return "change resource uri";
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		/*
		 * nothing to initialize
		 */
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {

		for (Session session : SessionManager.INSTANCE.getSessions()) {
			if (session.isOpen()) {
				for (Resource res : ImmutableList.copyOf(session
						.getTransactionalEditingDomain().getResourceSet()
						.getResources())) {
					if (res.getURI().equals(uriChange.getOldURI())) {
						res.setURI(uriChange.getNewURI());
						/*
						 * TODO : find a way to make the session dirty. There
						 * was no logical changes yet most of the models will
						 * need to be reserialized.
						 */
					}
				}
			}
		}
		return new InMemoryResourceURIChange(uriChange.inverse());
	}

	@Override
	public Object getModifiedElement() {
		return null;
	}

	public static void appendInMemoryURIChanges(List<URIChange> changes,
			IResourceDelta resourceDelta) {

		URI oldURI = null;
		URI newURI = null;
		if (resourceDelta.getMovedToPath() != null) {
			oldURI = URI.createPlatformResourceURI(resourceDelta.getResource()
					.getFullPath().toPortableString(), true);
			newURI = URI.createPlatformResourceURI(resourceDelta
					.getMovedToPath().toPortableString(), true);
		}
		if (resourceDelta.getMovedFromPath() != null) {
			oldURI = URI.createPlatformResourceURI(resourceDelta
					.getMovedFromPath().toPortableString(), true);
			newURI = URI.createPlatformResourceURI(resourceDelta.getResource()
					.getFullPath().toPortableString(), true);
		}

		if (oldURI != null && newURI != null) {
			changes.add(new URIChange(oldURI, newURI));
		}

	}

	public static Change toRefactoringChange(List<URIChange> changes,
			IProgressMonitor pm) {
		List<Change> refactoringChange = InMemoryResourceURIChange
				.toRefactoringChanges(changes, pm);

		if (refactoringChange.size() == 1) {
			return refactoringChange.get(0);
		}
		if (refactoringChange.size() > 1) {
			CompositeChange compo = new CompositeChange("update sessions",
					refactoringChange.toArray(new Change[refactoringChange
							.size()]));
			return compo;
		}
		return null;
	}

	public static List<Change> toRefactoringChanges(List<URIChange> changes,
			IProgressMonitor pm) {
		List<Change> refactoringChanges = Lists.newArrayList();
		Set<URI> loadedURIs = Sets.newLinkedHashSet();
		for (Session session : SessionManager.INSTANCE.getSessions()) {
			if (session.isOpen()) {
				for (Resource inMemoryResource : session
						.getTransactionalEditingDomain().getResourceSet()
						.getResources()) {
					if (inMemoryResource != null) {
						loadedURIs.add(inMemoryResource.getURI());
					}
				}
			}
		}
		Set<URIChange> notLoaded = Sets.newLinkedHashSet(changes);
		for (URIChange uriChange : changes) {
			if (loadedURIs.contains(uriChange.getOldURI())) {
				refactoringChanges
						.add(new InMemoryResourceURIChange(uriChange));
			} else {
				notLoaded.add(uriChange);
			}
		}

		if (notLoaded.size() > 0) {
			Map<URI, SerializedResourceURIChange> serializedRefactorings = Maps
					.newHashMap();
			ModelDependenciesGraph graph = new WorkspaceDependencies()
					.buildModelDependencyGraph(ResourcesPlugin.getWorkspace());
			for (URIChange uriChange : notLoaded) {
				for (URI toReserialize : graph.getInverseRequirements(uriChange
						.getOldURI())) {
					SerializedResourceURIChange alreadyHere = serializedRefactorings
							.get(toReserialize);
					if (alreadyHere == null) {
						alreadyHere = new SerializedResourceURIChange(
								toReserialize);
						/*
						 * the resource for which we need to update the content
						 * might have a new uri too.
						 */
						for (URIChange uriChange2 : notLoaded) {
							if (toReserialize.equals(uriChange2.getOldURI())) {
								alreadyHere
										.setResourceToUpdateURIChange(uriChange2);
							}
						}
						serializedRefactorings.put(toReserialize, alreadyHere);
					}
					alreadyHere.addURIChange(uriChange);
					System.out.println("to migrate : " + toReserialize);
				}
			}
			refactoringChanges.addAll(serializedRefactorings.values());
		}
		return refactoringChanges;
	}
}
