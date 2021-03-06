/*******************************************************************************
 * Copyright (c) 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tools.api.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.ecore.extender.business.api.permission.exception.LockedInstanceException;

/**
 * A command that throws a {@link LockedInstanceException} when it gets
 * executed. Can be used when building a command trying to modify elements that
 * the
 * {@link org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority}
 * consider as non editable.
 * 
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 * 
 */
public class InvalidPermissionCommand extends SiriusCommand {

    /**
     * The elements that user tried to modify.
     */
    private EObject lockedElement;

    /**
     * Creates a new {@link InvalidPermissionCommand}.
     * 
     * @param domain
     *            the editing domain in which this command will be executed
     * @param label
     *            the message explaning the permission issues
     */
    public InvalidPermissionCommand(TransactionalEditingDomain domain, String label) {
        super(domain, label);
    }

    /**
     * Creates a new {@link InvalidPermissionCommand}.
     * 
     * @param domain
     *            the editing domain in which this command will be executed
     * @param lockedElement
     *            the element that user tried to modify
     */
    public InvalidPermissionCommand(TransactionalEditingDomain domain, EObject lockedElement) {
        super(domain, "Invalid Permission : cannot modify " + lockedElement);
        this.lockedElement = lockedElement;
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
     */
    @Override
    public boolean canExecute() {
        return true;
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
     */
    @Override
    protected void doExecute() {
        if (lockedElement != null) {
            throw new LockedInstanceException(lockedElement);
        } else {
            throw new LockedInstanceException(getLabel());
        }

    }

}
