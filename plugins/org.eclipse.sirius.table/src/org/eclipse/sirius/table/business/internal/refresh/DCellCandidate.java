/*******************************************************************************
 * Copyright (c) 2007, 2008, 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.table.business.internal.refresh;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.util.RefreshIDFactory;
import org.eclipse.sirius.table.metamodel.table.DCell;
import org.eclipse.sirius.table.metamodel.table.DColumn;
import org.eclipse.sirius.table.metamodel.table.DLine;
import org.eclipse.sirius.table.metamodel.table.description.ColumnMapping;

/**
 * This class represents a candidate for a DCell, a candidate is a "possible"
 * DCell which has not been confirmed yet by validation and preconditions.
 * 
 * @author cbrun
 * 
 */
public class DCellCandidate {

    private final EObject semantic;

    private final ColumnMapping mapping;

    private final DColumn column;

    private final DLine line;

    /**
     * The original element from which the candidate has been created. May be
     * null if no element has been used.
     */
    private DCell element;

    private int hashcode;

    /**
     * Create a new candidate.
     * 
     * @param mapping
     *            the column mapping.
     * @param semanticElement
     *            the target semantic element.
     * @param line
     *            the cell line.
     * @param column
     *            the cell column.
     */
    public DCellCandidate(final ColumnMapping mapping, final EObject semanticElement, final DLine line, final DColumn column) {
        this.mapping = mapping;
        this.semantic = semanticElement;
        this.line = line;
        this.column = column;
        this.hashcode = computeHashCode();
    }

    /**
     * Create a new candidate from a diagram element.
     * 
     * @param tableElement
     *            an existing diagram element.
     */
    public DCellCandidate(final DCell tableElement) {
        this((tableElement.getColumn() != null) ? tableElement.getColumn().getOriginMapping() : null, tableElement.getTarget(), tableElement.getLine(), tableElement.getColumn());
        this.element = tableElement;
    }

    /**
     * Tells wether this candidate has been created from an existing element or
     * not.
     * 
     * @return true if the candidate has been created from an existing element.
     */
    public boolean comesFromTableElement() {
        return getOriginalElement() != null;
    }

    /**
     * Return the original element which has been used for the candidate
     * creation.
     * 
     * @return the original element which has been used for the candidate
     *         creation, null if no element has been used.
     */
    public DCell getOriginalElement() {
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.hashcode;
    }

    private int computeHashCode() {
        final int[] parts = new int[4];
        parts[0] = (mapping == null) ? 0 : mapping.hashCode();
        parts[1] = (semantic == null) ? 0 : getSemanticID();
        parts[2] = (line == null) ? 0 : getLineID();
        parts[3] = (column == null) ? 0 : getColumnID();
        final String sep = "/";
        return KeyCache.DEFAULT.getKey(parts[0] + sep + parts[1] + sep + parts[2] + sep + parts[3]);
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(final Object obj) {
        Boolean result = null;
        if (this == obj)
            result = true;
        if (result == null && obj == null)
            result = false;
        if (result == null && !(obj instanceof DCellCandidate))
            result = false;
        final DCellCandidate other = (DCellCandidate) obj;
        /*
         * the semantic element, lines and columns are less likely to be the
         * same than the mapping. We should check for those first.
         */
        if (result == null && semantic == null) {
            if (other.semantic != null)
                result = false;
        } else if (result == null && !getSemanticID().equals(other.getSemanticID()))
            result = false;
        if (result == null && line == null) {
            if (other.line != null)
                result = false;
        } else if (result == null && !getLineID().equals(other.getLineID()))
            result = false;
        if (result == null && column == null) {
            if (other.column != null)
                result = false;
        } else if (result == null && !getColumnID().equals(other.getColumnID()))
            result = false;
        if (result == null && mapping == null) {
            if (other.mapping != null)
                result = false;
        } else if (result == null && !mapping.equals(other.mapping))
            result = false;

        if (result == null)
            result = true;
        return result;
    }

    private Integer getColumnID() {
        return RefreshIDFactory.getOrCreateID(column);
    }

    private Integer getLineID() {
        return RefreshIDFactory.getOrCreateID(line);
    }

    private Integer getSemanticID() {
        return RefreshIDFactory.getOrCreateID(semantic);
    }

    public ColumnMapping getMapping() {
        return this.mapping;
    }

    public EObject getSemantic() {
        return this.semantic;
    }

    /**
     * return the column.
     * 
     * @return the column
     */
    public DColumn getColumn() {
        return column;
    }

    /**
     * return the line.
     * 
     * @return the line
     */
    public DLine getLine() {
        return line;
    }

}
