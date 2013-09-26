/*******************************************************************************
 * Copyright (c) 2007, 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.api.query;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.sirius.viewpoint.DMappingBased;
import org.eclipse.sirius.viewpoint.description.AbstractNodeMapping;
import org.eclipse.sirius.viewpoint.description.DiagramElementMapping;

/**
 * A class aggregating all the queries (read-only!) having a
 * {@link DMappingBased} as a starting point.
 * 
 * @author mporhel
 * 
 */
public class DMappingBasedQuery {

    private DMappingBased dMappingBased;

    /**
     * Create a new query.
     * 
     * @param dMappingBased
     *            the element to query.
     */
    public DMappingBasedQuery(DMappingBased dMappingBased) {
        this.dMappingBased = dMappingBased;
    }

    /**
     * Return true if the given element is from any mapping given in the list.
     * 
     * @param mappings
     *            mappings to consider
     * @return true if the given element is from any mapping given in the list.
     */
    public boolean isFromAnyMapping(final Collection<? extends DiagramElementMapping> mappings) {
        boolean anyIsfrom = false;
        final Iterator<? extends DiagramElementMapping> it = mappings.iterator();
        while (it.hasNext() && !anyIsfrom) {
            if (dMappingBased.getMapping() instanceof AbstractNodeMapping) {
                anyIsfrom = new DiagramElementMappingQuery(it.next()).isSuperTypeOf((AbstractNodeMapping) dMappingBased.getMapping());
            } else {
                anyIsfrom = new DiagramElementMappingQuery(it.next()).isTypeOf(dMappingBased);
            }
        }
        return anyIsfrom;
    }
}
