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

public class DiagramMappingsManagerKey {

    private DiagramDescription description;

    private List<Layer> activatedLayers;

    public DiagramMappingsManagerKey(DiagramDescription description, Collection<Layer> activatedLayers) {
        this.description = description;
        this.activatedLayers = Ordering.natural().onResultOf(new Function<Layer, String>() {

            @Override
            public String apply(Layer input) {
                return input.getName();
            }
        }).sortedCopy(activatedLayers);
    }

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
