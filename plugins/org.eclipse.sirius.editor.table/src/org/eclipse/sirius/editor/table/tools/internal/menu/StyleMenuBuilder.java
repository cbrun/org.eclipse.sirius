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
package org.eclipse.sirius.editor.table.tools.internal.menu;

import org.eclipse.sirius.editor.tools.api.menu.AbstractTypeRestrictingMenuBuilder;

/**
 * the style menu for tables.
 * 
 * @author cbrun
 * 
 */
public class StyleMenuBuilder extends AbstractTypeRestrictingMenuBuilder {
    /**
     * create the menu.
     */
    public StyleMenuBuilder() {
        super();
        addValidType(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.eINSTANCE.getForegroundStyleDescription());
        addValidType(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.eINSTANCE.getBackgroundStyleDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel() {
        return "New Style";
    }

}
