/*******************************************************************************
 * Copyright (c) 2007, 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.internal.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * @was-generated
 */
public class DNodeCreateCommand extends CreateElementCommand {

    /**
     * @param editingDomain
     * @param graphicalEditPart
     * @was-generated-not
     */
    public DNodeCreateCommand(CreateElementRequest req) {
        super(req);
    }

    /**
     * @was-generated
     */
    protected EObject getElementToEdit() {
        EObject container = ((CreateElementRequest) getRequest()).getContainer();
        if (container instanceof View) {
            container = ((View) container).getElement();
        }
        return container;
    }

    /**
     * @was-generated
     */
    protected EClass getEClassToEdit() {
        return ViewpointPackage.eINSTANCE.getDDiagram();
    }

    /**
     * @override
     * 
     */
    protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        return super.doExecute(monitor, info);
    }

    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        return null;
    }
}
