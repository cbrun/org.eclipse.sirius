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
package org.eclipse.sirius.business.api.helper.task;

import java.util.ArrayList;
import java.util.List;

/**
 * A default implementation of {@link ICommandTask}.
 * 
 * @author Mariot Chauvin (mchauvin
 */
public abstract class AbstractCommandTask implements ICommandTask {

    /** sub tasks. */
    private List<ICommandTask> childrenTasks = new ArrayList<ICommandTask>();

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#getChildrenTasks()
     */
    public List<ICommandTask> getChildrenTasks() {
        return childrenTasks;
    }

    /**
     * {@inheritDoc} Return true by default, subclass if you need to change.
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#canExecute()
     */
    public boolean canExecute() {
        return true;
    }

    /**
     * {@inheritDoc} Do nothing as it should be done by emft.
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#undo()
     */
    public void undo() {
        // do nothing
    }

    /**
     * {@inheritDoc} Do nothing as it should be done by emft.
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#redo()
     */
    public void redo() {
        // do nothing
    }

    /**
     * {@inheritDoc} Return false. Subclass if you need to execute children
     * tasks yourself
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#executeMyselfChildrenTasks()
     */
    public boolean executeMyselfChildrenTasks() {
        return false;
    }

}
