/*******************************************************************************
 * Copyright (c) 2007 - 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.editor.properties.sections.tool.reconnectedgedescription;

// Start of user code imports

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.sirius.diagram.description.DescriptionPackage;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.tool.ReconnectEdgeDescription;
import org.eclipse.sirius.editor.editorPlugin.SiriusEditor;
import org.eclipse.sirius.editor.properties.sections.common.AbstractEditorDialogWithListPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;

// End of user code imports

/**
 * A section for the mappings property of a ReconnectEdgeDescription object.
 */
public class ReconnectEdgeDescriptionMappingsPropertySection extends AbstractEditorDialogWithListPropertySection {
    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getDefaultLabelText()
     */
    @Override
    protected String getDefaultLabelText() {
        return "Mappings"; //$NON-NLS-1$
    }

    /**
     * @see org.eclipse.sirius.editor.properties.sections.AbstractEditorDialogPropertySection#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String labelText;
        labelText = super.getLabelText() + "*:"; //$NON-NLS-1$
        // Start of user code get label text

        // End of user code get label text
        return labelText;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
        text.setToolTipText("Edge mappings on which this reconnect edge tool apply.");

        CLabel help = getWidgetFactory().createCLabel(composite, "");
        FormData data = new FormData();
        data.top = new FormAttachment(text, 0, SWT.TOP);
        data.left = new FormAttachment(nameLabel);
        help.setLayoutData(data);
        help.setFont(SiriusEditor.getFontRegistry().get("description"));
        help.setImage(getHelpIcon());
        help.setToolTipText("Edge mappings on which this reconnect edge tool apply.");

        nameLabel.setFont(SiriusEditor.getFontRegistry().get("required"));
        // Start of user code create controls

        // End of user code create controls
    }

    // Start of user code user operations
    @Override
    protected List getCurrentValue() {
        return ((ReconnectEdgeDescription) eObject).getMappings();
    }

    @Override
    protected boolean getSortChoice() {
        return true;
    }

    /**
     * Fetches the list of available values for the feature.
     * 
     * @return The list of available values for the feature.
     */
    @Override
    protected List getChoiceOfValues() {
        UnmodifiableIterator<EdgeMapping> filter = Iterators.filter(eObject.eResource().getResourceSet().getAllContents(), EdgeMapping.class);
        return Lists.newArrayList(filter);
    }

    /**
     * Handle the modification event given the result of the section's
     * {@link org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog
     * FeatureEditorDialog}.
     */
    @Override
    protected void handleFeatureModified(List result) {
        boolean equals = isEqual(result);

        if (!equals) {
            EditingDomain editingDomain = ((IEditingDomainProvider) getPart()).getEditingDomain();
            Object value = result;

            if (eObjectList.size() == 1) {
                // if (getFeature().isTransient()) {
                CompoundCommand compoundCommand = new CompoundCommand();
                Object eGet = getCurrentValue();
                if (eGet instanceof EList) {
                    for (Object object : (EList) eGet) {
                        compoundCommand.append(RemoveCommand.create(editingDomain, object, DescriptionPackage.eINSTANCE.getEdgeMapping_Reconnections(), eObject));
                    }
                }
                editingDomain.getCommandStack().execute(compoundCommand);

                compoundCommand = new CompoundCommand();
                if (value instanceof EList) {
                    for (Iterator iterator = ((EList) value).iterator(); iterator.hasNext();) {
                        Object object = iterator.next();
                        compoundCommand.append(AddCommand.create(editingDomain, object, DescriptionPackage.eINSTANCE.getEdgeMapping_Reconnections(), eObject));
                    }
                }
                editingDomain.getCommandStack().execute(compoundCommand);
                // } else {
                // // apply the property change to single selected object
                // editingDomain.getCommandStack().execute(SetCommand.create(editingDomain,
                // eObject, getFeature(), value));
                // }
            } else {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (EObject nextObject : eObjectList) {
                    compoundCommand.append(SetCommand.create(editingDomain, nextObject, getFeature(), value));
                }
                editingDomain.getCommandStack().execute(compoundCommand);
            }
        }
    }
    // End of user code user operations
}
