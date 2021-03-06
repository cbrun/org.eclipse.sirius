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
 * the table element menu for tables.
 * 
 * @author cbrun
 * 
 */
public class TableElementsMenuBuilder extends AbstractTypeRestrictingMenuBuilder {
    /**
     * create the menu.
     */
    public TableElementsMenuBuilder() {
        super();
        addValidType(org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage.eINSTANCE.getTableMapping());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel() {
        return "New Table Element";
    }

}
