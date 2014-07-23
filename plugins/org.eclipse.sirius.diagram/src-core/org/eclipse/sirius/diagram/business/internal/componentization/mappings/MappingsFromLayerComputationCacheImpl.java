/*******************************************************************************
 * Copyright (c) 2009, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.business.internal.componentization.mappings;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationCache;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationResult;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromViewpointsComputationCache;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromViewpointsComputationResult;
import org.eclipse.sirius.diagram.description.DiagramDescription;

/**
 * Registry of diagram mappings.
 *
 * @author mchauvin
 * @since 0.9.0
 */
public final class MappingsFromLayerComputationCacheImpl  implements MappingsFromLayersComputationCache {

    private Map<MappingsFromLayerComputationKey, MappingsFromLayersComputationResult> diagramMappingsManagers = new HashMap<MappingsFromLayerComputationKey, MappingsFromLayersComputationResult>();

    /**
     * Construct a new {@link MappingsFromLayerComputationCacheImpl} instance.
     */
    private MappingsFromLayerComputationCacheImpl() {
        diagramMappingsManagers = new HashMap<MappingsFromLayerComputationKey, MappingsFromLayersComputationResult>();
        SessionManager.INSTANCE.addSessionsListener(new SessionManagerListener.Stub() {
            @Override
            public void notifyRemoveSession(final Session removedSession) {
                // In normal condition this clean was already done during the
                // closing of the session (see the notify method above).
                cleanDiagramMappingsManagers(removedSession);
            }

            @Override
            public void notify(Session closingSession, int notification) {
                if (notification == SessionListener.CLOSING) {
                    cleanDiagramMappingsManagers(closingSession);
                }
            }
        });
    }

    /**
     * Construct a new instance.
     *
     * @return a new instance
     */
    public static MappingsFromLayersComputationCache init() {
        return new MappingsFromLayerComputationCacheImpl();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationCache#getDiagramMappingsManager(Session,
     *      DDiagram)
     */
    public MappingsFromLayersComputationResult getDiagramMappingsManager(final Session session, final DDiagram diagram) {
        if (diagram == null) {
            throw new IllegalArgumentException("Parameter \"diagram\" cannot be null");
        }
        MappingsFromLayerComputationKey key = MappingsFromLayerComputationKey.fromDiagram(diagram);


        if (diagramMappingsManagers.containsKey(key)) {
            return diagramMappingsManagers.get(key);
        } else {
            final DiagramDescription desc = diagram.getDescription();
            final MappingsFromViewpointsComputationCache mappingsRegistry = MappingsFromViewpointsComputationCache.INSTANCE;
            final MappingsFromViewpointsComputationResult descManager = mappingsRegistry.getDiagramDescriptionMappingsManager(session, desc);

            final MappingsFromLayersComputationResultImpl newManager = new MappingsFromLayersComputationResultImpl(descManager);
            if (session != null) {
                newManager.computeMappings(session.getSelectedViewpoints(false), diagram.getActivatedLayers(), false);
            } else {
                newManager.computeMappings(null, diagram.getActivatedLayers(), false);
            }
            diagramMappingsManagers.put(key, newManager);
            return newManager;
        }
    }


    private void cleanDiagramMappingsManagers(final Session session) {
        diagramMappingsManagers.clear();
        
//        final Set<DDiagram> diagramInSession = new HashSet<DDiagram>();
//        for (final DRepresentation representation : DialectManager.INSTANCE.getAllRepresentations(session)) {
//            if (representation instanceof DDiagram) {
//                diagramInSession.add((DDiagram) representation);
//            }
//        }
        // FIXME before commit..see how we cleanup.
        // final Set<DDiagram> keysToRemove = new HashSet<DDiagram>();
        // for (final DDiagram diagram : diagramMappingsManagers.keySet()) {
        // if (diagramInSession.contains(diagram)) {
        // keysToRemove.add(diagram);
        // }
        // }
        // for (final DDiagram keyToRemove : keysToRemove) {
        // diagramMappingsManagers.remove(keyToRemove);
        // }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationCache#removeDiagramMappingsManagers(org.eclipse.sirius.diagram.business.api.componentization.MappingsFromLayersComputationResult)
     */
    public void removeDiagramMappingsManagers(MappingsFromLayersComputationResult manager) {
        final Set<MappingsFromLayerComputationKey> toRemove = new LinkedHashSet<MappingsFromLayerComputationKey>();
        for (final Entry<MappingsFromLayerComputationKey, MappingsFromLayersComputationResult> entry : diagramMappingsManagers.entrySet()) {
            if (entry.getValue() == manager) {
                toRemove.add(entry.getKey());
            }
        }
        for (final MappingsFromLayerComputationKey diagramToRemove : toRemove) {
            diagramMappingsManagers.remove(diagramToRemove);
        }
    }
}
