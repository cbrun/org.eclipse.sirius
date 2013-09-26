/*******************************************************************************
 * Copyright (c) 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.metamodel.helper;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.helper.graphicalfilters.HideFilterHelper;
import org.eclipse.sirius.business.api.query.DDiagramElementQuery;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.HideFilter;
import org.eclipse.sirius.viewpoint.HideLabelFilter;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * Default implementation of an helper to handle HideFilter.
 * 
 * @author mporhel
 */
public final class HideFilterHelperImpl implements HideFilterHelper {

    private HideFilterHelperImpl() {
        // Do nothing...
    }

    /**
     * Create a new instance of {@link HideFilterHelperImpl}.
     * 
     * @return an instance of {@link HideFilterHelperImpl}
     */
    public static HideFilterHelperImpl init() {
        return new HideFilterHelperImpl();
    }

    /**
     * {@inheritDoc}
     * 
     * @deprecated Use
     *             {@link org.eclipse.sirius.business.api.query.DDiagramElementQuery#isHidden()}
     */
    @Deprecated
    public boolean isDirectlyHidden(final DDiagramElement element) {
        DDiagramElementQuery query = new DDiagramElementQuery(element);
        return element != null && query.isHidden();
    }

    /**
     * {@inheritDoc}
     * 
     * @deprecated Use
     *             {@link org.eclipse.sirius.business.api.query.DDiagramElementQuery#isIndirectlyHidden()}
     */
    @Deprecated
    public boolean isIndirectlyHidden(final DDiagramElement element) {
        DDiagramElementQuery query = new DDiagramElementQuery(element);
        return element != null && query.isIndirectlyHidden();
    }

    /**
     * {@inheritDoc}
     * 
     * @see HideFilterHelper#hide(DDiagramElement, boolean)
     */
    public void hide(final DDiagramElement element) {
        if (new DDiagramElementQuery(element).isHidden()) {
            return;
        }

        HideFilter filter = ViewpointFactory.eINSTANCE.createHideFilter();
        element.getGraphicalFilters().add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see HideFilterHelper#reveal(DDiagramElement, boolean)
     */
    public void reveal(final DDiagramElement element) {
        if (!isDirectlyHidden(element)) {
            return;
        }

        final Object hidefilter = EcoreUtil.getObjectByType(element.getGraphicalFilters(), ViewpointPackage.eINSTANCE.getHideFilter());
        if (hidefilter instanceof HideFilter) {
            element.getGraphicalFilters().remove(hidefilter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see HideFilterHelper#hide(DDiagramElement, boolean)
     */
    public void hideLabel(final DDiagramElement element) {
        if (new DDiagramElementQuery(element).isLabelHidden()) {
            return;
        }

        HideLabelFilter filter = ViewpointFactory.eINSTANCE.createHideLabelFilter();
        element.getGraphicalFilters().add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see HideFilterHelper#reveal(DDiagramElement, boolean)
     */
    public void revealLabel(final DDiagramElement element) {
        if (!new DDiagramElementQuery(element).isLabelHidden()) {
            return;
        }

        final Object filter = EcoreUtil.getObjectByType(element.getGraphicalFilters(), ViewpointPackage.eINSTANCE.getHideLabelFilter());
        if (filter instanceof HideLabelFilter) {
            element.getGraphicalFilters().remove(filter);
        }
    }
}
