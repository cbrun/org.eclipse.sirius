/*******************************************************************************
 * Copyright (c) 2007, 2008, 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.metamodel.spec;

import org.eclipse.sirius.business.internal.metamodel.operations.BorderedStyleSpecOperation;
import org.eclipse.sirius.business.internal.metamodel.operations.StyleSpecOperations;
import org.eclipse.sirius.viewpoint.impl.WorkspaceImageImpl;

/**
 * Implementation of {@link org.eclipse.sirius.viewpoint.WorkspaceImage}.
 * 
 * @author cbru, mchauvin, ymortier
 */
public class WorkspaceImageSpec extends WorkspaceImageImpl {

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.viewpoint.impl.NodeStyleImpl#refresh()
     */
    @Override
    public void refresh() {
        StyleSpecOperations.refresh(this);
        BorderedStyleSpecOperation.refresh(this);
    }

}
