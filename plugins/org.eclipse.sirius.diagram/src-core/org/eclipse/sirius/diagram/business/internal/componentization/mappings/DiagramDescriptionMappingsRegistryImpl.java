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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.common.tools.api.util.EqualityHelper;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsManager;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsRegistry;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * The implementation of {@link DiagramDescriptionMappingsRegistry}.
 *
 * @author mchauvin
 * @since 0.9.0
 */
public final class DiagramDescriptionMappingsRegistryImpl implements DiagramDescriptionMappingsRegistry {

    private final Map<Key, DiagramDescriptionMappingsManager> diagramDescriptionMappingsManagers = new HashMap<Key, DiagramDescriptionMappingsManager>();

    /**
     * Avoid instantiation.
     */
    private DiagramDescriptionMappingsRegistryImpl() {
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
    public static DiagramDescriptionMappingsRegistry init() {
        return new DiagramDescriptionMappingsRegistryImpl();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsRegistry#getDiagramDescriptionMappingsManager(org.eclipse.sirius.business.api.session.Session,
     *      org.eclipse.sirius.viewpoint.description.DiagramDescription)
     */
    public DiagramDescriptionMappingsManager getDiagramDescriptionMappingsManager(final Session session, final DiagramDescription description) {
        Collection<Viewpoint> selectedVPs = Lists.newArrayList();
        /*
         * this code might be code with a null session (at least in some tests
         * like .ReferencedModelResourceMigrationTest.
         * testMigrationOfBaseVSMIsNotPartialWhenMigratingReferencingVSM it
         * does.
         */
        if (session != null) {
            selectedVPs.addAll(session.getSelectedViewpoints(false));
        }

        final Key key = new Key(selectedVPs, description);
        if (diagramDescriptionMappingsManagers.containsKey(key)) {
            return diagramDescriptionMappingsManagers.get(key);
        } else {
            final DiagramDescriptionMappingsManager newManager = new DiagramDescriptionMappingsManagerImpl(description);
            diagramDescriptionMappingsManagers.put(key, newManager);
            if (session != null) {
                newManager.computeMappings(selectedVPs);
            } else {
                newManager.computeMappings(null);
            }
            return newManager;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsRegistry#clearchCache()
     */
    public void clearchCache() {
        diagramDescriptionMappingsManagers.clear();
    }

    private void cleanDiagramDescriptionMappingsManagers(final Session session) {
        clearchCache();
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
            result = prime * result + DiagramDescriptionMappingsRegistryImpl.this.hashCode();
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
