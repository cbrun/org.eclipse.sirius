/*******************************************************************************
 * Copyright (c) 2009, 2014 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.editor.tools.internal.menu.child;

import org.eclipse.sirius.diagram.description.tool.ToolPackage;
import org.eclipse.sirius.editor.tools.api.menu.AbstractTypeRestrictingMenuBuilder;

/**
 * The edit menu.
 * 
 * @author cbrun
 * 
 */
public class EditToolsMenuBuilder extends AbstractTypeRestrictingMenuBuilder {
    /**
     * build the menu.
     */
    public EditToolsMenuBuilder() {
        super();
        addValidType(ToolPackage.eINSTANCE.getDirectEditLabel());
        addValidType(ToolPackage.eINSTANCE.getReconnectEdgeDescription());
        addValidType(ToolPackage.eINSTANCE.getContainerDropDescription());
        addValidType(ToolPackage.eINSTANCE.getDeleteElementDescription());
        addValidType(ToolPackage.eINSTANCE.getDoubleClickDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel() {
        return "New Element Edition";
    }

}
