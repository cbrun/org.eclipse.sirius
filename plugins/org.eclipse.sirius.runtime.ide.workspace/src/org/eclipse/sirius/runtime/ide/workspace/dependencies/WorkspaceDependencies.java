package org.eclipse.sirius.runtime.ide.workspace.dependencies;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.helper.SiriusUtil;

public class WorkspaceDependencies {

	public ModelDependenciesGraph buildModelDependencyGraph(IWorkspace wks) {
		final ModelDependenciesGraph graph = new ModelDependenciesGraph(
				new DependenciesCollector());

		try {
			wks.getRoot().accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile
							&& resource.getFileExtension() != null
							&& SiriusUtil.SESSION_RESOURCE_EXTENSION
									.equals(resource.getFileExtension())) {
						graph.registerModel(URI.createPlatformResourceURI(
								resource.getFullPath().toOSString(), true));
					}
					return true;
				}
			});
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return graph;
	}

}
