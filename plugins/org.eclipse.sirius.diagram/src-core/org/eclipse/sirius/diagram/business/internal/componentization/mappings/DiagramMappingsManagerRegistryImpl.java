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
import org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsManager;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsRegistry;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramMappingsManager;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramMappingsManagerRegistry;
import org.eclipse.sirius.diagram.business.api.helper.layers.LayerService;
import org.eclipse.sirius.diagram.description.DiagramDescription;

/**
 * Registry of diagram mappings.
 *
 * @author mchauvin
 * @since 0.9.0
 */
public final class DiagramMappingsManagerRegistryImpl implements DiagramMappingsManagerRegistry {

    private Map<DiagramMappingsManagerKey, DiagramMappingsManager> previousComputationResults = new HashMap<DiagramMappingsManagerKey, DiagramMappingsManager>();

    /**
     * Construct a new {@link DiagramMappingsManagerRegistryImpl} instance.
     */
    private DiagramMappingsManagerRegistryImpl() {
        previousComputationResults = new HashMap<DiagramMappingsManagerKey, DiagramMappingsManager>();
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
    public static DiagramMappingsManagerRegistry init() {
        return new DiagramMappingsManagerRegistryImpl();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.DiagramMappingsManagerRegistry#getDiagramMappingsManager(Session,
     *      DDiagram)
     */
    public DiagramMappingsManager getDiagramMappingsManager(final Session session, final DDiagram diagram) {
        if (diagram == null) {
            throw new IllegalArgumentException("Parameter \"diagram\" cannot be null");
        }
        DiagramMappingsManagerKey key = DiagramMappingsManagerKey.fromDiagram(diagram);

        if (previousComputationResults.containsKey(key)) {
            return previousComputationResults.get(key);
        } else {
            final DiagramDescription desc = diagram.getDescription();
            final DiagramDescriptionMappingsRegistry mappingsRegistry = DiagramDescriptionMappingsRegistry.INSTANCE;
            final DiagramDescriptionMappingsManager descManager = mappingsRegistry.getDiagramDescriptionMappingsManager(session, desc);
            DiagramMappingsManager newManager = null;
            if (LayerService.withoutLayersMode(desc)) {
                newManager = new DiagramMappingsManagerNoLayerImpl(descManager);
            } else {
                newManager = new DiagramMappingsManagerImpl(descManager);
            }

            if (session != null) {
                newManager.computeMappings(session.getSelectedViewpoints(false), diagram.getActivatedLayers(), false);
            } else {
                newManager.computeMappings(null, diagram.getActivatedLayers(), false);
            }
            previousComputationResults.put(key, newManager);
            return newManager;
        }
    }

    private void cleanDiagramMappingsManagers(final Session session) {
        previousComputationResults.clear();

        // final Set<DDiagram> diagramInSession = new HashSet<DDiagram>();
        // for (final DRepresentation representation :
        // DialectManager.INSTANCE.getAllRepresentations(session)) {
        // if (representation instanceof DDiagram) {
        // diagramInSession.add((DDiagram) representation);
        // }
        // }
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
     * @see org.eclipse.sirius.diagram.business.api.componentization.DiagramMappingsManagerRegistry#removeDiagramMappingsManagers(org.eclipse.sirius.diagram.business.api.componentization.DiagramMappingsManager)
     */
    public void removeDiagramMappingsManagers(DiagramMappingsManager manager) {
        final Set<DiagramMappingsManagerKey> toRemove = new LinkedHashSet<DiagramMappingsManagerKey>();
        for (final Entry<DiagramMappingsManagerKey, DiagramMappingsManager> entry : previousComputationResults.entrySet()) {
            if (entry.getValue() == manager) {
                toRemove.add(entry.getKey());
            }
        }
        for (final DiagramMappingsManagerKey diagramToRemove : toRemove) {
            previousComputationResults.remove(diagramToRemove);
        }
    }
}
