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
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;
import org.eclipse.sirius.business.api.session.SessionManager;

import com.google.common.collect.Lists;

public class MoveModelResourceParticipant extends MoveParticipant {

	private List<Change> changes = Lists.newArrayList();
	
	

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			return SessionManager.INSTANCE.getSessions().size() > 0;
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
		changes = Lists.newArrayList();
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
			if ((resourceDelta.getMovedToPath() != null || resourceDelta
					.getMovedFromPath() != null)
					&& resourceDelta.getResource() instanceof IFile
					&& resourceDelta.getResource().getFullPath() != null) {
				InMemoryResourceURIChange.appendInMemoryURIChanges(changes,
						resourceDelta);
				return new RefactoringStatus();

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
		if (changes.size() == 1) {
			return changes.get(0);
		}
		if (changes.size() > 1) {
			CompositeChange compo = new CompositeChange("update sessions",
					changes.toArray(new Change[changes.size()]));
			return compo;
		}
		return null;
	}

}
