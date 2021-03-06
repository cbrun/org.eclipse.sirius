/*******************************************************************************
 * Copyright (c) 2007, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.internal.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.ui.edit.api.part.AbstractDiagramBorderNodeEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.policies.BorderedNodeLayoutEditPolicy;
import org.eclipse.sirius.diagram.ui.internal.edit.policies.DNode4ItemSemanticEditPolicy;
import org.eclipse.sirius.diagram.ui.internal.edit.policies.canonicals.DumnySiriusCanonicalEditPolicy;
import org.eclipse.sirius.diagram.ui.part.SiriusVisualIDRegistry;
import org.eclipse.sirius.diagram.ui.tools.api.figure.AirDefaultSizeNodeFigure;
import org.eclipse.sirius.diagram.ui.tools.api.figure.DBorderedNodeFigure;
import org.eclipse.sirius.diagram.ui.tools.api.figure.FoldingToggleAwareClippingStrategy;
import org.eclipse.sirius.diagram.ui.tools.api.figure.FoldingToggleImageFigure;
import org.eclipse.sirius.diagram.ui.tools.api.figure.SiriusWrapLabel;
import org.eclipse.sirius.diagram.ui.tools.api.figure.anchor.AnchorProvider;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.IBorderItemOffsets;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.IStyleConfigurationRegistry;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.StyleConfiguration;
import org.eclipse.sirius.viewpoint.DStylizable;
import org.eclipse.swt.graphics.Color;

/**
 * @was-generated
 */
public class DNode4EditPart extends AbstractDiagramBorderNodeEditPart {

    /**
     * @was-generated
     */
    public static final int VISUAL_ID = 3012;

    /**
     * @not-generated
     */
    protected DefaultSizeNodeFigure nodePlate = null;

    /**
     * @was-generated
     */
    protected IFigure contentPane;

    /**
     * @was-generated
     */
    protected IFigure primaryShape;

    /**
     * Construct the edit part from the view.
     * 
     * @param view
     *            the view.
     */
    public DNode4EditPart(final View view) {
        super(view);
    }

    /**
     */
    public IFigure getNodePlate() {
        return nodePlate;
    }

    /**
     * @not-generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DNode4ItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DumnySiriusCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new BorderedNodeLayoutEditPolicy());

        /*
         * remove the connection items display
         */
        removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @not-generated add the folding toggle figure as bordered figure
     */
    @Override
    protected NodeFigure createNodeFigure() {
        DBorderedNodeFigure nodeFigure = new DBorderedNodeFigure(createMainFigure());
        nodeFigure.getBorderItemContainer().add(new FoldingToggleImageFigure(this));
        nodeFigure.getBorderItemContainer().setClippingStrategy(new FoldingToggleAwareClippingStrategy());
        return nodeFigure;
    }

    /**
     * @was-generated
     */
    protected IFigure createNodeShape() {
        final ViewNodePortFigureDesc figure = new ViewNodePortFigureDesc();
        return primaryShape = figure;
    }

    /**
     * @not-generated
     */
    public ViewNodePortFigureDesc getPrimaryShape() {
        return (ViewNodePortFigureDesc) primaryShape;
    }

    /**
     * @was-generated
     */
    protected void addBorderItem(final IFigure borderItemContainer, final IBorderItemEditPart borderItemEditPart) {
        if (borderItemEditPart instanceof DNodeNameEditPart) {
            if (this.resolveSemanticElement() instanceof DNode) {
                final DNode node = (DNode) this.resolveSemanticElement();
                final StyleConfiguration styleConfiguration = IStyleConfigurationRegistry.INSTANCE.getStyleConfiguration(node.getDiagramElementMapping(), node.getStyle());
                final IBorderItemLocator locator = styleConfiguration.getNameBorderItemLocator(node, getMainFigure());
                borderItemContainer.add(borderItemEditPart.getFigure(), locator);
            } else {
                // Older behaviour
                final BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
                locator.setBorderItemOffset(IBorderItemOffsets.NO_OFFSET);
                borderItemContainer.add(borderItemEditPart.getFigure(), locator);
            }
        } else {
            super.addBorderItem(borderItemContainer, borderItemEditPart);
        }
    }

    /**
     * @not-generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = null;
        final EObject eObj = resolveSemanticElement();
        if (eObj instanceof DStylizable && eObj instanceof DDiagramElement) {
            final DStylizable viewNode = (DStylizable) eObj;
            final StyleConfiguration styleConfiguration = IStyleConfigurationRegistry.INSTANCE.getStyleConfiguration(((DDiagramElement) eObj).getDiagramElementMapping(), viewNode.getStyle());
            final AnchorProvider anchorProvider = styleConfiguration.getAnchorProvider();
            result = new AirDefaultSizeNodeFigure(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), anchorProvider);
            nodePlate = result;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.edit.api.part.AbstractDiagramBorderNodeEditPart#activate()
     */
    @Override
    public void activate() {
        if (nodePlate instanceof AirDefaultSizeNodeFigure)
            ((AirDefaultSizeNodeFigure) nodePlate).setZoomManager(getZoomManager());
        super.activate();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.diagram.edit.api.part.AbstractDiagramBorderNodeEditPart#deactivate()
     */
    @Override
    public void deactivate() {
        super.deactivate();
        if (nodePlate instanceof AirDefaultSizeNodeFigure)
            ((AirDefaultSizeNodeFigure) nodePlate).setZoomManager(null);
    }

    /**
     * Creates figure for this edit part. Body of this method does not depend on
     * settings in generation model so you may safely remove <i>generated</i>
     * tag and modify it.
     * 
     * @not-generated : remove the layout manager to fix the size
     */
    protected NodeFigure createMainFigure() {
        final NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        final IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane. Respects
     * layout one may have set for generated figure.
     * 
     * @param nodeShape
     *            instance of generated figure class
     * @was-generated
     */
    protected IFigure setupContentPane(final IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            final ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(getMapMode().DPtoLP(5));
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @was-generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @was-generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(SiriusVisualIDRegistry.getType(NotationViewIDs.DNODE_NAME_4_EDIT_PART_VISUAL_ID));
    }

    /**
     * @was-generated
     */
    public class ViewNodePortFigureDesc extends RectangleFigure {

        /**
         * @not-generated
         */
        private final SiriusWrapLabel nodeLabel = new SiriusWrapLabel();

        /**
         * @not-generated
         */
        public ViewNodePortFigureDesc() {
            final FlowLayout layoutThis = new FlowLayout();
            layoutThis.setStretchMinorAxis(false);
            layoutThis.setMinorAlignment(FlowLayout.ALIGN_TOPLEFT);

            layoutThis.setMajorAlignment(FlowLayout.ALIGN_TOPLEFT);
            layoutThis.setMajorSpacing(5);
            layoutThis.setMinorSpacing(5);
            layoutThis.setHorizontal(true);

            this.setLayoutManager(layoutThis);

            this.setFill(false);
            this.setOutline(false);
            this.setLineWidth(0);

            nodeLabel.setTextWrap(true);
            nodeLabel.setForegroundColor(ColorConstants.black);
        }

        /**
         * @was-generated
         */
        private boolean myUseLocalCoordinates = false;

        /**
         * @was-generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * @was-generated
         */
        protected void setUseLocalCoordinates(final boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

        /**
         * Return the label that is in the node.
         * 
         * @return the nodeLabel
         */
        public SiriusWrapLabel getNodeLabel() {
            return this.nodeLabel;
        }

    }

    /**
     * @was-generated
     */
    static final Color THIS_BACK = new Color(null, 25, 22, 123);

    /**
     * @not-generated
     */
    public SiriusWrapLabel getNodeLabel() {
        return getPrimaryShape().getNodeLabel();
    }

    /**
     * @was-generated
     */
    public IFigure getPrimaryFigure() {
        return getPrimaryShape();
    }

    public Class<?> getMetamodelType() {
        return DNode.class;
    }
}
