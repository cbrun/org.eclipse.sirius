/*******************************************************************************
 * Copyright (c) 2010, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.sequence.ui.tool.internal.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.part.SiriusVisualIDRegistry;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.CombinedFragment;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.EndOfLife;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.Execution;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.InstanceRole;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.InteractionUse;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.Lifeline;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.LostMessageEnd;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.Message;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.ObservationPoint;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.Operand;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.SequenceDiagram;
import org.eclipse.sirius.diagram.sequence.business.internal.elements.State;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.CombinedFragmentCompartmentEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.CombinedFragmentEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.EndOfLifeEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.ExecutionEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.InstanceRoleEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.InteractionUseEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.LifelineEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.LostMessageEndEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.ObservationPointEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.OperandCompartmentEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.OperandEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.SequenceBracketEdgeEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.SequenceDiagramEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.SequenceMessageEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.SequenceMessageNameEditPart;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.StateEditPart;
import org.eclipse.sirius.viewpoint.BracketEdgeStyle;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DEdge;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * Provides specific edit parts for Sirius Sequence Diagrams.
 * 
 * @author pcdavid
 */
public class SequenceDiagramEditPartProvider extends AbstractEditPartProvider {
    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?> getDiagramEditPartClass(View view) {
        if (view instanceof Diagram) {
            EObject semanticElement = ViewUtil.resolveSemanticElement(view);
            if (semanticElement instanceof DDiagram && SequenceDiagram.viewpointElementPredicate().apply((DDiagram) semanticElement)) {
                return SequenceDiagramEditPart.class;
            }
        }
        return super.getDiagramEditPartClass(view);
    }

    /**
     * {@inheritDoc}
     */
    // CHECKSTYLE:OFF
    @Override
    protected Class<?> getNodeEditPartClass(View view) {
        if (view instanceof Node) {
            EObject semanticElement = ViewUtil.resolveSemanticElement(view);
            if (ViewpointPackage.eINSTANCE.getDNode().isInstance(semanticElement)) {
                if (InstanceRole.notationPredicate().apply(view)) {
                    return InstanceRoleEditPart.class;
                } else if (Lifeline.notationPredicate().apply(view)) {
                    return LifelineEditPart.class;
                } else if (Execution.notationPredicate().apply(view)) {
                    return ExecutionEditPart.class;
                } else if (State.notationPredicate().apply(view)) {
                    return StateEditPart.class;
                } else if (EndOfLife.notationPredicate().apply(view)) {
                    return EndOfLifeEditPart.class;
                } else if (LostMessageEnd.notationPredicate().apply(view)) {
                    return LostMessageEndEditPart.class;
                } else if (ObservationPoint.notationPredicate().apply(view)) {
                    return ObservationPointEditPart.class;
                }
            } else if (ViewpointPackage.eINSTANCE.getDNodeContainer().isInstance(semanticElement)) {
                if (InteractionUse.notationPredicate().apply(view)) {
                    return InteractionUseEditPart.class;
                } else if (CombinedFragment.notationPredicate().apply(view)) {
                    return CombinedFragmentEditPart.class;
                } else if (CombinedFragment.compartmentNotationPredicate().apply(view)) {
                    return CombinedFragmentCompartmentEditPart.class;
                } else if (Operand.notationPredicate().apply(view)) {
                    return OperandEditPart.class;
                } else if (Operand.compartmentNotationPredicate().apply(view)) {
                    return OperandCompartmentEditPart.class;
                }
            } else if (ViewpointPackage.eINSTANCE.getDEdge().isInstance(semanticElement)) {
                DEdge edge = (DEdge) semanticElement;
                if (Message.viewpointElementPredicate().apply(edge) && SiriusVisualIDRegistry.getVisualID(view) == SequenceMessageNameEditPart.VISUAL_ID) {
                    return SequenceMessageNameEditPart.class;
                }
            }
        }
        return super.getNodeEditPartClass(view);
    }

    // CHECKSTYLE:ON

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?> getEdgeEditPartClass(View view) {
        Class<?> edgeEditPartClass = null;
        if (view instanceof Edge) {
            EObject semanticElement = ViewUtil.resolveSemanticElement(view);
            if (semanticElement instanceof DEdge) {
                DEdge edge = (DEdge) semanticElement;
                if (Message.viewpointElementPredicate().apply((DEdge) semanticElement)) {
                    edgeEditPartClass = SequenceMessageEditPart.class;
                } else if (SequenceDiagram.viewpointElementPredicate().apply(edge.getParentDiagram()) && edge.getStyle() instanceof BracketEdgeStyle) {
                    // Force the default location.
                    edgeEditPartClass = SequenceBracketEdgeEditPart.class;
                }
            }
        }

        if (edgeEditPartClass == null) {
            edgeEditPartClass = super.getEdgeEditPartClass(view);
        }

        return edgeEditPartClass;
    }
}
