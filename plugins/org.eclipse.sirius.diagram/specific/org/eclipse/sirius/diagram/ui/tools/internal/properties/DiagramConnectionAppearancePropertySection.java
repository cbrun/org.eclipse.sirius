/*******************************************************************************
 * Copyright (c) 2008, 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.properties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ConnectionAppearancePropertySection;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.diagram.internal.refresh.diagram.ViewPropertiesSynchronizer;
import org.eclipse.sirius.diagram.part.SiriusDiagramEditorPlugin;
import org.eclipse.sirius.diagram.tools.internal.actions.style.ResetStylePropertiesToDefaultValuesAction;
import org.eclipse.sirius.diagram.ui.tools.internal.dialogs.ColorPalettePopup;
import org.eclipse.sirius.viewpoint.BracketEdgeStyle;
import org.eclipse.sirius.viewpoint.DEdge;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.EdgeStyle;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.UserFixedColor;

/**
 * allow color customization of diagram edges.
 * 
 * @author fmorel
 * 
 */
@SuppressWarnings("restriction")
public class DiagramConnectionAppearancePropertySection extends ConnectionAppearancePropertySection {

    /** button to set back the view to default color. */
    protected Button resetStylePropertiesToDefaultValuesButton;

    private Composite routingGroups;

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorsAndFontsPropertySection#changeColor(org.eclipse.swt.events.SelectionEvent,
     *      org.eclipse.swt.widgets.Button, java.lang.String, java.lang.String,
     *      org.eclipse.jface.resource.ImageDescriptor)
     */
    @Override
    protected RGB changeColor(final SelectionEvent event, final Button button, final String propertyId, final String commandName, final ImageDescriptor imageDescriptor) {

        RGB colorToReturn = null;
        if (!Properties.ID_FILLCOLOR.equals(propertyId) && !Properties.ID_LINECOLOR.equals(propertyId) && !Properties.ID_FONTCOLOR.equals(propertyId)) {
            colorToReturn = super.changeColor(event, button, propertyId, commandName, imageDescriptor);
        } else {
            final ColorPalettePopup popup = new ColorPalettePopup(button.getParent().getShell(), IDialogConstants.BUTTON_BAR_HEIGHT);
            // popup.setPreviousColor(previousColor);
            final Rectangle r = button.getBounds();
            final Point location = button.getParent().toDisplay(r.x, r.y);
            popup.open(new Point(location.x, location.y + r.height));
            if (popup.getSelectedColor() == null && !popup.useDefaultColor()) {
                return null;
            }
            // selectedColor should be null if we are to use the default color
            final RGB selectedColor = popup.getSelectedColor();

            final EStructuralFeature feature = (EStructuralFeature) PackageUtil.getElement(propertyId);

            // Update model in response to user

            final List<ICommand> commands = new ArrayList<ICommand>();
            final Iterator<?> it = getInputIterator();

            colorToReturn = selectedColor;
            RGB color = selectedColor;
            while (it.hasNext()) {
                final IGraphicalEditPart ep = (IGraphicalEditPart) it.next();

                color = selectedColor;
                if (popup.useDefaultColor()) {
                    final Object preferredValue = ep.getPreferredValue(feature);
                    if (preferredValue instanceof Integer) {
                        color = FigureUtilities.integerToRGB((Integer) preferredValue);
                    }
                }

                // If we are using default colors, we want to return the color
                // of the first selected element to be consistent
                if (colorToReturn == null) {
                    colorToReturn = color;
                }

                if (color != null) {
                    final RGB finalColor = color; // need a final variable
                    commands.add(createCommand(commandName, ((View) ep.getModel()).eResource(), new Runnable() {

                        public void run() {
                            final ENamedElement element = PackageUtil.getElement(propertyId);
                            if (element instanceof EStructuralFeature) {
                                ep.setStructuralFeatureValue(feature, FigureUtilities.RGBToInteger(finalColor));
                            }

                            // get the view.
                            final View view = (View) ep.getModel();

                            // change the color.
                            final UserFixedColor newColor = DescriptionFactory.eINSTANCE.createUserFixedColor();
                            newColor.setName("<anonymous>");
                            newColor.setBlue(finalColor.blue);
                            newColor.setGreen(finalColor.green);
                            newColor.setRed(finalColor.red);

                            IInterpreter interpreter = new EObjectQuery(view).getSession().getInterpreter();
                            new ViewPropertiesSynchronizer().synchronizeDDiagramElementStyleColorProperties(view, newColor, propertyId, interpreter);
                        }
                    }));
                }
            }
            if (!commands.isEmpty()) {
                executeAsCompositeCommand(commandName, commands);
                final Image overlyedImage = new ColorOverlayImageDescriptor(imageDescriptor.getImageData(), color).createImage();
                disposeImage(button.getImage());
                button.setImage(overlyedImage);
            }
        }
        return colorToReturn;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ShapeColorsAndFontsPropertySection#createFontsGroup(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Composite createFontsGroup(final Composite parent) {
        final Composite toolBar = super.createFontsGroup(parent);

        final String path = "icons/undo_edit.gif";
        final Image image = SiriusDiagramEditorPlugin.getInstance().getBundledImage(path);

        resetStylePropertiesToDefaultValuesButton = new Button(toolBar, SWT.PUSH);
        resetStylePropertiesToDefaultValuesButton.setToolTipText(ResetStylePropertiesToDefaultValuesAction.ACTION_NAME);
        resetStylePropertiesToDefaultValuesButton.setImage(image);
        resetStylePropertiesToDefaultValuesButton.addSelectionListener(new ResetStylePropertiesToDefaultValuesSelectionAdapter(this));
        resetStylePropertiesToDefaultValuesButton.setEnabled(!isReadOnly());

        return toolBar;
    }

    /**
     * Overridden to access to the routing group.
     * 
     * {@inheritDoc}
     */
    @Override
    protected void createRouterOptionsGroup(Composite groups) {
        super.createRouterOptionsGroup(groups);
        routingGroups = groups;
    }

    /**
     * Overridden to display property of selection only if semantic element of
     * selection exists.
     * 
     * {@inheritDoc}
     */
    @Override
    public void setInput(IWorkbenchPart workbenchPart, ISelection selection) {
        if (selection.isEmpty() || !(selection instanceof StructuredSelection)) {
            super.setInput(workbenchPart, selection);
            return;
        }
        StructuredSelection structuredSelection = (StructuredSelection) selection;
        List<Object> newSelection = new ArrayList<Object>();
        Iterator<?> it = structuredSelection.iterator();
        while (it.hasNext()) {
            Object selectionItem = it.next();
            if (transformSelection(selectionItem) != null) {
                newSelection.add(selectionItem);
            }
        }
        composite.setVisible(!newSelection.isEmpty());
        super.setInput(workbenchPart, new StructuredSelection(newSelection));
    }

    /**
     * Transform selection to have {@link DSemanticDecorator} instead of
     * {@link EditPart} or null if the semantic element (target) not exists.
     * 
     * @param selection
     *            the currently selected object
     * @return the unwrapped object
     */
    protected Object transformSelection(final Object selection) {

        Object object = selection;

        if (object instanceof EditPart) {
            object = ((EditPart) object).getModel();
        } else if (object instanceof IAdaptable) {
            object = ((IAdaptable) object).getAdapter(View.class);
        }

        if (object instanceof View) {
            object = ((View) object).getElement();
        }

        if (object instanceof DSemanticDecorator) {
            EObject target = ((DSemanticDecorator) object).getTarget();
            if (target == null || target.eResource() == null) {
                object = null;
            }
        }
        return object;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorsAndFontsPropertySection#dispose()
     */
    @Override
    public void dispose() {
        resetStylePropertiesToDefaultValuesButton = null;
        routingGroups = null;
        super.dispose();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ShapeColorsAndFontsPropertySection#refresh()
     */
    @Override
    public void refresh() {
        if (!isDisposed() && getSingleInput() != null) {
            super.refresh();
            executeAsReadAction(new Runnable() {

                public void run() {
                    boolean hasBracketStyle = false;
                    final IGraphicalEditPart ep = getSingleInput();
                    if (ep != null) {
                        final View view = (View) ep.getModel();
                        final EObject dDiagElement = view.getElement();
                        if (dDiagElement instanceof DEdge) {
                            DEdge dEdge = (DEdge) dDiagElement;
                            EdgeStyle edgeStyle = dEdge.getOwnedStyle();
                            hasBracketStyle = edgeStyle instanceof BracketEdgeStyle;
                        }
                        boolean isReadOnly = isReadOnly();
                        boolean isCustomizedView = ResetStylePropertiesToDefaultValuesSelectionAdapter.isCustomizedView(view);
                        resetStylePropertiesToDefaultValuesButton.setEnabled(!isReadOnly && isCustomizedView);
                        enableRoutingGroup(hasBracketStyle);
                    }
                }
            });
        }
    }

    /**
     * Disable the routing group and all its children for Bracket edge.
     * 
     * @param hasBracketStyle
     *            true if we must disable, false otherwise
     */
    private void enableRoutingGroup(boolean hasBracketStyle) {
        routingGroups.setEnabled(!hasBracketStyle);
        for (Control childControl : routingGroups.getChildren()) {
            childControl.setEnabled(!hasBracketStyle);
            if (childControl instanceof Composite) {
                Composite childComposite = (Composite) childControl;
                for (Control childOfChildControl : childComposite.getChildren()) {
                    childOfChildControl.setEnabled(!hasBracketStyle);
                }
            }
        }
        for (Object object : Routing.VALUES) {
            Object buttonObj = buttons.get(object);
            if (buttonObj instanceof Button) {
                Button button = (Button) buttonObj;
                button.setEnabled(!hasBracketStyle);
            }
        }
    }
}
