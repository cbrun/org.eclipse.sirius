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
package org.eclipse.sirius.diagram.business.internal.componentization.mappings;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.common.tools.api.util.EqualityHelper;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromViewpointsComputationCache;
import org.eclipse.sirius.diagram.business.api.componentization.MappingsFromViewpointsComputationResult;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * The implementation of {@link MappingsFromViewpointsComputationCache}.
 *
 * @author mchauvin
 * @since 0.9.0
 */
public final class MappingsFromViewpointComputationCacheImpl implements MappingsFromViewpointsComputationCache {

    private final Map<Key, MappingsFromViewpointsComputationResult> diagramDescriptionMappingsManagers = new HashMap<Key, MappingsFromViewpointsComputationResult>();

    /**
     * Avoid instantiation.
     */
    private MappingsFromViewpointComputationCacheImpl() {
        SessionManager.INSTANCE.addSessionsListener(new SessionManagerListener.Stub() {
            @Override
            public void notifyRemoveSession(final Session removedSession) {
                // In normal condition this clean was already done during the
                // closing of the session (see the notify method above).
                cleanDiagramDescriptionMappingsManagers(removedSession);
            }

            @Override
            public void viewpointDeselected(final Viewpoint deselectedSirius) {
                clearchCache();
            }

            @Override
            public void viewpointSelected(final Viewpoint selectedSirius) {
                clearchCache();
            }

            @Override
            public void notify(Session closingSession, int notification) {
                if (notification == SessionListener.CLOSING) {
                    cleanDiagramDescriptionMappingsManagers(closingSession);
                }
            }
        });
    }

    /**
     * Create a new instance.
     *
     * @return a new instance
     */
    public static MappingsFromViewpointsComputationCache init() {
        return new MappingsFromViewpointComputationCacheImpl();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.MappingsFromViewpointsComputationCache#getDiagramDescriptionMappingsManager(org.eclipse.sirius.business.api.session.Session,
     *      org.eclipse.sirius.viewpoint.description.DiagramDescription)
     */
    public MappingsFromViewpointsComputationResult getDiagramDescriptionMappingsManager(final Session session, final DiagramDescription description) {
        final Key key = new Key(session.getSelectedViewpoints(false), description);
        if (diagramDescriptionMappingsManagers.containsKey(key)) {
            return diagramDescriptionMappingsManagers.get(key);
        } else {
            final MappingsFromViewpointsComputationResult newManager = new MappingsFromViewpointComputationResultImpl(description);
            diagramDescriptionMappingsManagers.put(key, newManager);
            if (session != null) {
                newManager.computeMappings(session.getSelectedViewpoints(false));
            } else {
                newManager.computeMappings(null);
            }
            return newManager;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.MappingsFromViewpointsComputationCache#clearchCache()
     */
    public void clearchCache() {

        cleanDiagramDescriptionNoMoreInResource();

        for (final Entry<Key, MappingsFromViewpointsComputationResult> manager : diagramDescriptionMappingsManagers.entrySet()) {
            if (manager.getKey().getSelectedViewpoints() != null) {
                manager.getValue().computeMappings(manager.getKey().getSelectedViewpoints());
            } else {
                manager.getValue().computeMappings(null);
            }
        }
    }

    private void cleanDiagramDescriptionNoMoreInResource() {
        final Set<Key> keysToRemove = new HashSet<Key>();
        for (final Key key : diagramDescriptionMappingsManagers.keySet()) {
            if (key.description == null || key.description.eResource() == null) {
                keysToRemove.add(key);
            }
        }
        for (final Key keyToRemove : keysToRemove) {
            final MappingsFromViewpointsComputationResult manager = diagramDescriptionMappingsManagers.get(keyToRemove);
            diagramDescriptionMappingsManagers.remove(keyToRemove);
            manager.dispose();
        }
    }

    private void cleanDiagramDescriptionMappingsManagers(final Session session) {
        diagramDescriptionMappingsManagers.clear();
//        final Set<Key> keysToRemove = new HashSet<Key>();
//        for (final Key key : diagramDescriptionMappingsManagers.keySet()) {
//            // TODO before commit : figure out how to cleanup
//            // if (key.session == session) {
//            // keysToRemove.add(key);
//            // }
//        }
//        for (final Key keyToRemove : keysToRemove) {
//            // diagramDescriptionMappingsManagers.remove(keyToRemove);
//            final MappingsFromViewpointsComputationResult manager = diagramDescriptionMappingsManagers.get(keyToRemove);
//            diagramDescriptionMappingsManagers.remove(keyToRemove);
//            manager.dispose();
//        }
    }

    /**
     * A class to serve as key in the map
     *
     * @author mchauvin
     */
    private class Key {

        private final DiagramDescription description;

        private List<Viewpoint> selectedViewpoints;

        public Key(final Collection<Viewpoint> viewpoints, final DiagramDescription description) {
            this.selectedViewpoints = Ordering.natural().onResultOf(new Function<Viewpoint, String>() {

                @Override
                public String apply(Viewpoint input) {
                    return input.getName();
                }
            }).sortedCopy(viewpoints);
            this.description = description;
        }

        /**
         * {@inheritDoc}
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + MappingsFromViewpointComputationCacheImpl.this.hashCode();
            result = prime * result + ((description == null) ? 0 : description.hashCode());
            result = prime * result + ((selectedViewpoints == null) ? 0 : selectedViewpoints.hashCode());
            return result;
        }

        /**
         * {@inheritDoc}
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        // CHECKSTYLE:OFF
        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }

            final Key other = (Key) obj;
            if (description == null) {
                if (other.description != null)
                    return false;
            } else if (!EqualityHelper.areEquals(description, other.description))
                return false;
            if (selectedViewpoints == null) {
                if (other.selectedViewpoints != null)
                    return false;
            } else if (selectedViewpoints.size() == other.selectedViewpoints.size()) {
                Iterator<Viewpoint> itThis = selectedViewpoints.iterator();
                Iterator<Viewpoint> itOther = other.selectedViewpoints.iterator();
                while (itThis.hasNext() && itOther.hasNext()) {
                    Viewpoint thisLayer = itThis.next();
                    Viewpoint otherLayer = itOther.next();
                    if (!EqualityHelper.areEquals(thisLayer, otherLayer)) {
                        return false;
                    }
                }

            } else {
                return false;
            }

            return true;
        }

        public Collection<Viewpoint> getSelectedViewpoints() {
            return this.selectedViewpoints;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).add("description", description.getName())
                    .add("viewpoints", Joiner.on(",").join(Iterables.transform(this.selectedViewpoints, new Function<Viewpoint, String>() {

                        @Override
                        public String apply(Viewpoint input) {
                            return input.getName();
                        }
                    }))).toString();
        }
    }
    // CHECKSTYLE:ON

}
