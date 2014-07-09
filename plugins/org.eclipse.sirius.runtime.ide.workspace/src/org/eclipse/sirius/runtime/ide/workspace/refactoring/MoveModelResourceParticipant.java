package org.eclipse.sirius.runtime.ide.workspace.refactoring;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;

import com.google.common.collect.Lists;

public class MoveModelResourceParticipant extends MoveParticipant {

	private List<URIChange> changes = Lists.newArrayList();

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "Model Resource Move";
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws OperationCanceledException {
		
		ResourceChangeChecker checker = (ResourceChangeChecker) context
				.getChecker(ResourceChangeChecker.class);
		IResourceChangeDescriptionFactory deltaFactory = checker
				.getDeltaFactory();
		IResourceDelta[] affectedChildren = deltaFactory.getDelta()
				.getAffectedChildren();

		return verifyAffectedChildren(affectedChildren, deltaFactory);
	}

	private RefactoringStatus verifyAffectedChildren(
			IResourceDelta[] affectedChildren,
			IResourceChangeDescriptionFactory deltaFactory) {

		for (IResourceDelta resourceDelta : affectedChildren) {
			if (resourceDelta.getResource() instanceof IFile
					&& resourceDelta.getResource().getFullPath() != null) {
				InMemoryResourceURIChange.appendInMemoryURIChanges(changes,
						resourceDelta);				

			} else {
				return verifyAffectedChildren(
						resourceDelta.getAffectedChildren(), deltaFactory);
			}
		}

		return new RefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		return InMemoryResourceURIChange.toRefactoringChange(changes, pm);
	}

}
