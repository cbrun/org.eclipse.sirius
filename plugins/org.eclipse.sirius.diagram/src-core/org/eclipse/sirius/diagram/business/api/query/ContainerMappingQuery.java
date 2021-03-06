/*******************************************************************************
 * Copyright (c) 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.business.api.query;

import org.eclipse.sirius.diagram.ContainerLayout;
import org.eclipse.sirius.diagram.description.ContainerMapping;

/**
 * A class aggregating all the queries (read-only!) having a ContainerMapping as
 * a starting point.
 * 
 * @author mporhel
 * 
 */
public class ContainerMappingQuery {

    private ContainerMapping mapping;

    /**
     * Create a new query.
     * 
     * @param mapping
     *            the element to query.
     */
    public ContainerMappingQuery(ContainerMapping mapping) {
        this.mapping = mapping;
    }

    /**
     * Tests whether or not the {@link ContainerMapping} is a list container,
     * according to the {@link ContainerLayout} specified in the VSM.
     * 
     * @return <code>true</code> if the {@link ContainerMapping} has a list
     *         children presentation.
     */
    public boolean isListContainer() {
        return ContainerLayout.LIST == mapping.getChildrenPresentation();
    }

    /**
     * Tests whether or not the {@link ContainerMapping} is a free form
     * container, according to the {@link ContainerLayout} specified in the VSM.
     * 
     * @return <code>true</code> if the {@link ContainerMapping} has a free form
     *         children presentation.
     */
    public boolean isFreeFormContainer() {
        return ContainerLayout.FREE_FORM == mapping.getChildrenPresentation();
    }

}
