package org.eclipse.sirius.runtime.ide.workspace.refactoring;

import java.util.List;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;

import com.google.common.collect.ImmutableList;

public class InMemoryResourceURIChange extends Change {

	private Session session;
	private URI oldURI;
	private URI newURI;

	public InMemoryResourceURIChange(Session session, URI oldURI, URI newURI) {
		this.session = session;
		this.oldURI = oldURI;
		this.newURI = newURI;

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
		for (Resource res : ImmutableList.copyOf(session
				.getTransactionalEditingDomain().getResourceSet()
				.getResources())) {
			if (res.getURI().equals(oldURI)) {
				res.setURI(newURI);
				/*
				 * TODO : find a way to make the session dirty. There was no
				 * logical changes yet most of the models will need to be
				 * reserialized.
				 */				
			}
		}
		return new InMemoryResourceURIChange(session, newURI, oldURI);
	}

	@Override
	public Object getModifiedElement() {
		return null;
	}

	public static void appendInMemoryURIChanges(List<Change> changes,
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

			for (Session session : SessionManager.INSTANCE.getSessions()) {
				if (session.isOpen()) {
					for (Resource inMemoryResource : session
							.getTransactionalEditingDomain().getResourceSet()
							.getResources()) {
						System.out.println(inMemoryResource.getURI() + "=?="
								+ oldURI);
						if (hasSameWorkspaceURI(inMemoryResource, oldURI)) {
							changes.add(new InMemoryResourceURIChange(session,
									inMemoryResource.getURI(), newURI));

						}
					}
				}
			}
		}

	}

	private static boolean hasSameWorkspaceURI(Resource inMemoryResource, URI fileURI) {
		return inMemoryResource.getURI() != null
				&& inMemoryResource.getURI().isPlatformResource()
				&& inMemoryResource.getURI().equals(fileURI);
	}

}
