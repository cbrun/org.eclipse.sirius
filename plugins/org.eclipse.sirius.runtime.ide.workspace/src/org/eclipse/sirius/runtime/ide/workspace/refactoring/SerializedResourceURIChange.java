package org.eclipse.sirius.runtime.ide.workspace.refactoring;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.sirius.runtime.ide.workspace.dependencies.DependenciesCollector;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;

public class SerializedResourceURIChange extends Change {

	private URI resourceToUpdate;

	private Optional<URIChange> resourceToUpdateURIChange = Optional.absent();

	private Set<URIChange> changes = Sets.newLinkedHashSet();

	public SerializedResourceURIChange(URI resourceToUpdate) {
		this.resourceToUpdate = resourceToUpdate;
	}

	@Override
	public String getName() {
		return "change resource uri in file";
	}

	public void addURIChange(URIChange change) {
		this.changes.add(change);
	}

	public void setResourceToUpdateURIChange(URIChange change) {
		this.resourceToUpdateURIChange = Optional.of(change);
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {

	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		if (changes.size() > 0) {
			DependenciesCollector collector = new DependenciesCollector();
			Set<EObject> proxies = Sets.newLinkedHashSet();
			URI uriToUse = resourceToUpdate;
			if (resourceToUpdateURIChange.isPresent()) {
				uriToUse = resourceToUpdateURIChange.get().getNewURI();
			}
			Resource res = null;
			try {
			res =  collector.collectAllProxies(uriToUse,
						proxies);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			boolean changed = false;
			for (EObject proxy : proxies) {
				if (proxy instanceof InternalEObject) {
					URI resolved = ((InternalEObject) proxy).eProxyURI()
							.resolve(uriToUse);
					String eObjectFragment = resolved.fragment();
					for (URIChange uriChange : changes) {
						if (uriChange.getOldURI().equals(
								resolved.trimFragment())) {
							((InternalEObject) proxy).eSetProxyURI(uriChange
									.getNewURI()
									.appendFragment(eObjectFragment));
							changed = true;
						}
					}
				}
			}
			if (changed && res!=null) {
				/*
				 * our resource uri might have changed in the process too if the
				 * user move several files at once.
				 */
				if (resourceToUpdateURIChange.isPresent()) {
					res.setURI(resourceToUpdateURIChange.get().getNewURI());
				}
				try {
					res.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
				}
			}
		}

		return null;
	}

	@Override
	public Object getModifiedElement() {
		/*
		 * we might not want to return the modified elements to avoid looping
		 */
//		if (resourceToUpdate.isPlatformResource()) {
//			return ResourcesPlugin.getWorkspace().getRoot()
//					.findMember(resourceToUpdate.toPlatformString(true));
//		}
		return null;
	}

}
