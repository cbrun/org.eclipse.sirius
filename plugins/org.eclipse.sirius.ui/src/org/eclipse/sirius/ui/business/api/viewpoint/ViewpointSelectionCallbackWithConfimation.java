/*******************************************************************************
 * Copyright (c) 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.ui.business.api.viewpoint;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.query.IdentifiedElementQuery;
import org.eclipse.sirius.business.api.query.ViewpointQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.google.common.collect.Sets;

/**
 * Asks the user for confirmation when de-selecting a viewpoint if there are
 * opened editors using this viewpoint.
 * 
 * <p>
 * All methods must be executed in transactional mode.
 * </p>
 * 
 * @author mchauvin
 */
public class ViewpointSelectionCallbackWithConfimation extends ViewpointSelectionCallback {
    private static final String TITLE = "Confirmation dialog";

    private static final String QUESTION = "\nDisabling this viewpoint will close the concerned editors without saving. Continue?";

    /**
     * {@inheritDoc}
     */
    @Override
    public void deselectViewpoint(Viewpoint deselectedViewpoint, Session session, IProgressMonitor monitor) {
        IEditingSession editingSession = SessionUIManager.INSTANCE.getUISession(session);
        Collection<IEditorPart> openedEditors = Sets.newHashSet();
        if (editingSession != null) {
            openedEditors = getConcernedEditors(deselectedViewpoint, editingSession.getEditors());
        }
        if (editingSession == null || openedEditors.isEmpty() || userConfirmsDeselection(deselectedViewpoint, openedEditors)) {
            for (IEditorPart iEditorPart : openedEditors) {
                DialectUIManager.INSTANCE.closeEditor(iEditorPart, false);
            }
            super.deselectViewpoint(deselectedViewpoint, session, monitor);
        }
    }

    private boolean userConfirmsDeselection(Viewpoint deselectedViewpoint, Collection<IEditorPart> openedEditors) {
        StringBuilder builder = new StringBuilder();
        for (IEditorPart iEditorPart : openedEditors) {
            builder.append(iEditorPart.getTitle());
            builder.append(",\n");
        }
        final String message = MessageFormat.format("The viewpoint {0} is used by these opened editors:\n\n{1}{2}", new IdentifiedElementQuery(deselectedViewpoint).getLabel(), builder, QUESTION);
        final AtomicBoolean confirmation = new AtomicBoolean(false);
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                confirmation.set(MessageDialog.openConfirm(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TITLE, message));
            }
        });
        return confirmation.get();
    }

    private Collection<IEditorPart> getConcernedEditors(Viewpoint viewpoint, Collection<? extends IEditorPart> editors) {
        Collection<IEditorPart> result = Sets.newHashSet();
        for (RepresentationDescription representationDescription : new ViewpointQuery(viewpoint).getAllRepresentationDescriptions()) {
            for (IEditorPart editor : editors) {
                if (DialectUIManager.INSTANCE.isRepresentationDescriptionManagedByEditor(representationDescription, editor)) {
                    result.add(editor);
                }
            }
        }
        return result;
    }
}
