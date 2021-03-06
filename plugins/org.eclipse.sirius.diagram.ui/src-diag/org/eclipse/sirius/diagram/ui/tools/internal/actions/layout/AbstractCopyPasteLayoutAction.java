/*******************************************************************************
 * Copyright (c) 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.actions.layout;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.api.diagramtype.DiagramTypeDescriptorRegistry;
import org.eclipse.sirius.diagram.business.api.diagramtype.IDiagramDescriptionProvider;
import org.eclipse.sirius.diagram.business.api.diagramtype.IDiagramTypeDescriptor;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Abstract class to define a common enablement computation.
 * 
 * @author mporhel
 */
public abstract class AbstractCopyPasteLayoutAction extends DiagramAction {
    private IWorkbenchPart representationPart;

    /**
     * Default constructor.
     * 
     * @param workbenchPage
     *            the active workbench page
     * @param actionWorkbenchPart
     *            the part concerned by this action. Could be null.
     */
    public AbstractCopyPasteLayoutAction(final IWorkbenchPage workbenchPage, IWorkbenchPart actionWorkbenchPart) {
        super(workbenchPage);
        this.representationPart = actionWorkbenchPart;

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
     */
    @Override
    protected final Request createTargetRequest() {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
     */
    @Override
    protected final boolean isSelectionListener() {
        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
        representationPart = null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#calculateEnabled()
     */
    @Override
    protected final boolean calculateEnabled() {
        boolean enable = false;
        if (representationPart != null && !representationPart.equals(getWorkbenchPart())) {
            return super.isEnabled();
        }
        Collection<DSemanticDecorator> dSelection = getDSelection(getSelectedObjects());

        DDiagram parentDiagram = null;
        for (DSemanticDecorator dsem : dSelection) {
            if (dsem instanceof DDiagram) {
                parentDiagram = (DDiagram) dsem;
            } else if (dsem instanceof DDiagramElement) {
                parentDiagram = ((DDiagramElement) dsem).getParentDiagram();
            }

            if (parentDiagram != null) {
                break;
            }
        }

        if (parentDiagram != null) {
            Predicate<DSemanticDecorator> allowsPasteLayout = allowsCopyPasteLayout(parentDiagram);
            if (Iterables.all(dSelection, allowsPasteLayout)) {
                enable = super.calculateEnabled();
            }
        }
        return enable;
    }

    /**
     * Get current selected diagram elements.
     * 
     * @param selection
     *            Selection
     * @return Selected elements.
     */
    private Collection<DSemanticDecorator> getDSelection(Collection<?> selection) {
        if (selection != null && !selection.isEmpty()) {
            final Collection<DSemanticDecorator> elements = Lists.newArrayList();
            for (IGraphicalEditPart part : Iterables.filter(selection, IGraphicalEditPart.class)) {
                EObject semanticElement = part.resolveSemanticElement();
                if (semanticElement instanceof DDiagramElement) {
                    elements.add((DDiagramElement) semanticElement);
                } else if (semanticElement instanceof DSemanticDiagram) {
                    elements.add((DSemanticDiagram) semanticElement);
                }
            }
            return elements;
        }
        return Collections.emptyList();
    }

    /**
     * Indicates if the given ddiagram is allowing copy/paste layout.
     * 
     * @param diagram
     *            the diagram to inspect
     * @return true if the given ddiagram is allowing copy/paste layout actions,
     *         false otherwise
     */
    public static Predicate<DSemanticDecorator> allowsCopyPasteLayout(DDiagram diagram) {
        // default return value is true (for basic DDiagram that are not handled
        // by any DiagramDescriptionProvider).
        Predicate<DSemanticDecorator> result = Predicates.alwaysTrue();

        // If an aird has been opened from the Package Explorer View, then
        // we return false as no diagram is associated to this editor
        if (diagram == null || diagram.getDescription() == null) {
            return Predicates.alwaysFalse();
        }

        // If diagram is not null, we search for a possible
        // DiagramDescriptionProvider handling this type of diagram
        for (final IDiagramTypeDescriptor diagramTypeDescriptor : DiagramTypeDescriptorRegistry.getInstance().getAllDiagramTypeDescriptors()) {
            if (diagramTypeDescriptor.getDiagramDescriptionProvider().handles(diagram.getDescription().eClass().getEPackage())) {
                // This DiagramDescriptionProvider may forbid copy/paste layout.
                final IDiagramDescriptionProvider provider = diagramTypeDescriptor.getDiagramDescriptionProvider();
                result = new Predicate<DSemanticDecorator>() {
                    @Override
                    public boolean apply(DSemanticDecorator input) {
                        return provider.allowsCopyPasteLayout(input);
                    }
                };
                break;
            }
        }

        return result;
    }
}
