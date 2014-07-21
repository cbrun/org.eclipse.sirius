/*******************************************************************************
 * Copyright (c) 2014 Obeo
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
import java.util.Iterator;
import java.util.List;

import org.eclipse.sirius.common.tools.api.util.EqualityHelper;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.Layer;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * A key with a consistent hashcode/equals implementation to bind instances
 * which are dependent of a diagram description and a collection of layers. Two
 * keys instances will be equals if they have the same diagram description and
 * the same collection of layers (order matters here).
 * 
 * @author cedric
 *
 */
public class DiagramMappingsManagerKey {

    private DiagramDescription description;

    private List<Layer> activatedLayers;

    /**
     * Create a new key from a given {@link DiagramDescription} and a list of
     * layers.
     * 
     * @param description
     *            the diagram description.
     * @param layers
     *            the collection of layers.
     */
    public DiagramMappingsManagerKey(DiagramDescription description, Collection<Layer> layers) {
        this.description = description;
        this.activatedLayers = Ordering.natural().onResultOf(new Function<Layer, String>() {

            @Override
            public String apply(Layer input) {
                return input.getName();
            }
        }).sortedCopy(layers);
    }

    /**
     * Utility constructor to directly create a new key from a diagram instance.
     * It will retrieve the {@link DiagramDescription} used by the diagram
     * instance and the activated layers. Typically, any other diagram using the
     * same diagram description and the same collection of activated layers will
     * return a key which is considered as equal to the first one.
     * 
     * @param diagram
     *            a diagram instance matching the key.
     * @return a new key.
     */
    public static DiagramMappingsManagerKey fromDiagram(DDiagram diagram) {
        return new DiagramMappingsManagerKey(diagram.getDescription(), diagram.getActivatedLayers());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activatedLayers == null) ? 0 : activatedLayers.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    // CHECKSTYLE:OFF
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiagramMappingsManagerKey other = (DiagramMappingsManagerKey) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!EqualityHelper.areEquals(description, other.description))
            return false;
        if (activatedLayers == null) {
            if (other.activatedLayers != null)
                return false;
        } else if (activatedLayers.size() == other.activatedLayers.size()) {
            Iterator<Layer> itThis = activatedLayers.iterator();
            Iterator<Layer> itOther = other.activatedLayers.iterator();
            while (itThis.hasNext() && itOther.hasNext()) {
                Layer thisLayer = itThis.next();
                Layer otherLayer = itOther.next();
                if (!EqualityHelper.areEquals(thisLayer, otherLayer)) {
                    return false;
                }
            }

        } else {
            return false;
        }

        return true;
    }
    //CHECKSTYLE:ON

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("description", description.getName()).add("layers", Joiner.on(",").join(Iterables.transform(activatedLayers, new Function<Layer, String>() {

            @Override
            public String apply(Layer input) {
                return input.getName();
            }
        }))).toString();
    }
}
