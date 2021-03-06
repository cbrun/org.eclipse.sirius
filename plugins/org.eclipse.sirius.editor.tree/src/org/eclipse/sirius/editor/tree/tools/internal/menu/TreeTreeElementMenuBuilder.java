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
package org.eclipse.sirius.editor.tree.tools.internal.menu;

import org.eclipse.sirius.editor.tools.api.menu.AbstractTypeRestrictingMenuBuilder;
import org.eclipse.sirius.tree.description.DescriptionPackage;

/**
 * Menu containing all Tree Elements.
 * 
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 */
public class TreeTreeElementMenuBuilder extends AbstractTypeRestrictingMenuBuilder {

    /**
     * Initializes the TreeToolsMenuBuilder.
     * 
     */
    public TreeTreeElementMenuBuilder() {
        super();
        addValidType(DescriptionPackage.eINSTANCE.getTreeMapping());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.editor.tools.api.menu.AbstractMenuBuilder#getLabel()
     */
    @Override
    public String getLabel() {
        return "New Tree Element";
    }

}
