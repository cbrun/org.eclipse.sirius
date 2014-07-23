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
package org.eclipse.sirius.diagram.business.internal.helper.display;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.DslCommonPlugin;
import org.eclipse.sirius.common.tools.api.listener.Notification;
import org.eclipse.sirius.common.tools.api.listener.NotificationUtil;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.GraphicalFilter;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationResult;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationCache;
import org.eclipse.sirius.diagram.business.api.helper.display.DisplayService;
import org.eclipse.sirius.diagram.business.api.query.DDiagramElementQuery;
import org.eclipse.sirius.diagram.business.internal.metamodel.helper.LayerHelper;
import org.eclipse.sirius.tools.api.profiler.SiriusTasksKey;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Default implementation of {@link DisplayService}.
 * 
 * @author mchauvin
 */
public final class DisplayServiceImpl implements DisplayService {

    private Map<DDiagramElement, Boolean> cache;

    /**
     * Avoid instantiation.
     */
    private DisplayServiceImpl() {
    }

    /**
     * Initialize a new {@link DisplayService}.
     * 
     * @return a new created instance
     */
    public static DisplayService init() {
        return new DisplayServiceImpl();
    }

    /**
     * Refresh visibility of all elements for the given diagram.
     * 
     * @param diagram
     *            the given diagram..
     */
    public void refreshAllElementsVisibility(final DDiagram diagram) {
        deactivateCache();
        activateCache();

        Session session = SessionManager.INSTANCE.getSession(((DSemanticDiagram) diagram).getTarget());
        MappingsFromLayersComputationResult mappingManager = MappingsFromLayersComputationCache.INSTANCE.getDiagramMappingsManager(session, diagram);

        NotificationUtil.sendNotification(diagram, Notification.Kind.START, Notification.REFRESH_VISIBILITY_ON_DIAGRAM);
        DslCommonPlugin.PROFILER.startWork(SiriusTasksKey.IS_VISIBLE_KEY);
        for (final DDiagramElement diagramElement : diagram.getDiagramElements()) {
            diagramElement.setVisible(computeVisibility(mappingManager, diagram, diagramElement));
        }
        DslCommonPlugin.PROFILER.stopWork(SiriusTasksKey.IS_VISIBLE_KEY);
        NotificationUtil.sendNotification(diagram, Notification.Kind.STOP, Notification.REFRESH_VISIBILITY_ON_DIAGRAM);
        deactivateCache();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.business.api.helper.display.DisplayService#isDisplayed(DDiagram,
     *      DDiagramElement)
     */
    public boolean isDisplayed(final DDiagram diagram, final DDiagramElement element) {
        DslCommonPlugin.PROFILER.startWork(SiriusTasksKey.IS_VISIBLE_KEY);
        final boolean result = element.isVisible();
        DslCommonPlugin.PROFILER.stopWork(SiriusTasksKey.IS_VISIBLE_KEY);
        return result;
    }

    private void addToCache(final DDiagramElement element, final boolean b) {
        if (cache != null) {
            cache.put(element, Boolean.valueOf(b));
        }
    }

    private Boolean getFromCache(final DDiagramElement element) {
        Boolean visible = null;
        if (cache != null) {
            visible = cache.get(element);
        }
        return visible;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.business.api.helper.display.DisplayService#activateCache()
     */
    public void activateCache() {
        if (cache == null) {
            cache = new HashMap<DDiagramElement, Boolean>();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.business.api.helper.display.DisplayService#deactivateCache()
     */
    public void deactivateCache() {
        if (cache != null) {
            cache.clear();
            cache = null;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.business.api.helper.display.DisplayService#computeVisibility(MappingsFromLayersComputationResult,
     *      DDiagram, DDiagramElement)
     */
    public boolean computeVisibility(MappingsFromLayersComputationResult session, final DDiagram diagram, final DDiagramElement element) {
        DslCommonPlugin.PROFILER.startWork(SiriusTasksKey.REFRESH_VISIBILITY_KEY);
        final boolean result = doIsVisible(session, diagram, element);
        DslCommonPlugin.PROFILER.stopWork(SiriusTasksKey.REFRESH_VISIBILITY_KEY);
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.business.api.helper.display.DisplayService#computeLabelVisibility(DDiagram,
     *      DDiagramElement)
     */
    public boolean computeLabelVisibility(DDiagram diagram, DDiagramElement element) {
        return !(new DDiagramElementQuery(element).isLabelHidden());
    }

    /**
     * Tell whether an element is displayed or not in a {@link DDiagram}.
     * 
     * @param diagramMappingsManager
     *            the {@link MappingsFromLayersComputationResult} to use
     * @param diagram
     *            the diagram.
     * @param element
     *            an element.
     * @return true if the element is in the viewpoint, false otherwise.
     */
    private boolean doIsVisible(MappingsFromLayersComputationResult diagramMappingsManager, final DDiagram diagram, final DDiagramElement element) {

        boolean isVisible = true;
        final Boolean cachedValue = getFromCache(element);
        if (cachedValue != null) {
            isVisible = cachedValue.booleanValue();
        } else {
            DDiagramElementQuery ddeQuery = new DDiagramElementQuery(element);
            if (ddeQuery.isHidden() || ddeQuery.isFiltered()) {
                isVisible = false;
            }

            if (isVisible) {
                final EObject eContainer = element.eContainer();
                if (eContainer instanceof DDiagramElement) {
                    isVisible = computeVisibility(diagramMappingsManager, diagram, (DDiagramElement) eContainer);
                } else if (element instanceof DEdge) {
                    isVisible = isDEdgeVisible(diagramMappingsManager, diagram, (DEdge) element);
                }
            }

            /* if element seems to be visible, check its parent layer */
            if (isVisible) {
                isVisible = LayerHelper.isInActivatedLayer(diagramMappingsManager, element);
            }
            if (isVisible) {
                isVisible = !isFold(element);
            }
            addToCache(element, isVisible);
        }
        return isVisible;
    }

    private boolean isDEdgeVisible(MappingsFromLayersComputationResult diagramMappingsManager, final DDiagram vp, final DEdge edge) {
        boolean isVisible = true;
        if (edge.getSourceNode() instanceof DDiagramElement) {
            isVisible = computeVisibility(diagramMappingsManager, vp, (DDiagramElement) edge.getSourceNode());
        }
        if (isVisible && edge.getTargetNode() instanceof DDiagramElement) {
            isVisible = computeVisibility(diagramMappingsManager, vp, (DDiagramElement) edge.getTargetNode());
        }
        return isVisible;
    }

    private boolean isFold(final DDiagramElement element) {
        return Iterables.any(element.getGraphicalFilters(), new Predicate<GraphicalFilter>() {
            public boolean apply(GraphicalFilter input) {
                return DiagramPackage.eINSTANCE.getFoldingFilter().isInstance(input) || DiagramPackage.eINSTANCE.getFoldingPointFilter().isInstance(input);
            }
        });
    }
}
