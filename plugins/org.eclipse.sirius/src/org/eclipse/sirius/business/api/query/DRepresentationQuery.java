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

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Lists;

import org.eclipse.sirius.common.tools.api.util.Option;
import org.eclipse.sirius.common.tools.api.util.Options;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.AnnotationEntry;
import org.eclipse.sirius.viewpoint.description.DAnnotation;

/**
 * A class aggregating all the queries (read-only!) having a
 * {@link DRepresentation} as a starting point.
 * 
 * @author mporhel
 * 
 */
public class DRepresentationQuery {

    private DRepresentation representation;

    /**
     * Create a new query.
     * 
     * @param representation
     *            the element to query.
     */
    public DRepresentationQuery(DRepresentation representation) {
        this.representation = representation;
    }

    /**
     * Get the annotation of a representation with id source and data eObject.
     * 
     * @param source
     *            the source of the annotation
     * @param eObject
     *            the data of the annotation
     * @return the annotation entry
     */
    public Option<AnnotationEntry> getAnnotation(final String source, final EObject eObject) {
        for (AnnotationEntry annotation : representation.getOwnedAnnotationEntries()) {
            if (source.equals(annotation.getSource()) && eObject.equals(annotation.getData())) {
                return Options.newSome(annotation);
            }
        }
        return Options.newNone();
    }

    /**
     * Get all the annotations of a representation with id source.
     * 
     * @param source
     *            the source of the annotation
     * @return the annotation entries
     */
    public Collection<AnnotationEntry> getAnnotation(final String source) {
        final Collection<AnnotationEntry> annotationEntries = Lists.newArrayList();
        for (AnnotationEntry annotation : representation.getOwnedAnnotationEntries()) {
            if (source.equals(annotation.getSource())) {
                annotationEntries.add(annotation);
            }
        }
        return annotationEntries;
    }

    /**
     * Get the annotation of a representation with id source and map details.
     * 
     * @param source
     *            the source of the annotation
     * @param detail
     *            the detail of the annotations
     * @return the annotation
     */
    public Option<DAnnotation> getDAnnotation(final String source, String detail) {
        DAnnotation annotation = representation.getDAnnotation(source);
        if (annotation != null && annotation.getDetails().get(detail) != null) {
            return Options.newSome(annotation);
        }
        return Options.newNone();
    }
}
