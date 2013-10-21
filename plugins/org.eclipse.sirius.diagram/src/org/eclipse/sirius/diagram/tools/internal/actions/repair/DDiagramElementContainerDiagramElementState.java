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
package org.eclipse.sirius.diagram.tools.internal.actions.repair;

import org.eclipse.sirius.diagram.tools.api.migration.DiagramCrossReferencer;
import org.eclipse.sirius.viewpoint.DDiagramElementContainer;

/**
 * Diagram element state for {@link DDiagramElementContainer}.
 * 
 * @author dlecan
 */
public class DDiagramElementContainerDiagramElementState extends AbstractAbstractDNodeDiagramElementState<DDiagramElementContainer> {

    /**
     * Constructor.
     * 
     * @param id
     *            Identifier
     * @param crossReferencer
     *            the cross-referencer
     */
    public DDiagramElementContainerDiagramElementState(Identifier id, DiagramCrossReferencer crossReferencer) {
        super(id, crossReferencer);
    }

}