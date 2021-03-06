/*******************************************************************************
 * Copyright (c) 2007-2014 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.sequence.description.tool.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.sirius.diagram.sequence.description.DescriptionFactory;
import org.eclipse.sirius.diagram.sequence.description.tool.MessageCreationTool;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.sirius.diagram.sequence.description.tool.MessageCreationTool}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MessageCreationToolItemProvider extends SequenceDiagramToolDescriptionItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
        IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MessageCreationToolItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addDocumentationPropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            addLabelPropertyDescriptor(object);
            addPreconditionPropertyDescriptor(object);
            addForceRefreshPropertyDescriptor(object);
            addEdgeMappingsPropertyDescriptor(object);
            addIconPathPropertyDescriptor(object);
            addExtraSourceMappingsPropertyDescriptor(object);
            addExtraTargetMappingsPropertyDescriptor(object);
            addConnectionStartPreconditionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Documentation feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDocumentationPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DocumentedElement_documentation_feature"), getString("_UI_DocumentedElement_documentation_description"), DescriptionPackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION,
                true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_DocumentationPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_IdentifiedElement_name_feature"), getString("_UI_IdentifiedElement_name_description"), DescriptionPackage.Literals.IDENTIFIED_ELEMENT__NAME, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Label feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_IdentifiedElement_label_feature"), getString("_UI_IdentifiedElement_label_description"), DescriptionPackage.Literals.IDENTIFIED_ELEMENT__LABEL, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Connection Completion
     * Precondition ( feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated-not
     */
    protected void addPreconditionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeCreationDescription_precondition_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractToolDescription_precondition_feature", "_UI_AbstractToolDescription_type"),
                ToolPackage.Literals.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Force Refresh feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addForceRefreshPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractToolDescription_forceRefresh_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractToolDescription_forceRefresh_feature", "_UI_AbstractToolDescription_type"),
                ToolPackage.Literals.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Edge Mappings feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addEdgeMappingsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeCreationDescription_edgeMappings_feature"), getString("_UI_EdgeCreationDescription_edgeMappings_description"),
                org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__EDGE_MAPPINGS, true, false, true, null, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Icon Path feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIconPathPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeCreationDescription_iconPath_feature"), getString("_UI_EdgeCreationDescription_iconPath_description"),
                org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__ICON_PATH, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_AdvancedPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Extra Source Mappings feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addExtraSourceMappingsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeCreationDescription_extraSourceMappings_feature"), getString("_UI_EdgeCreationDescription_extraSourceMappings_description"),
                org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__EXTRA_SOURCE_MAPPINGS, true, false, true, null, getString("_UI_AdvancedPropertyCategory"),
                null));
    }

    /**
     * This adds a property descriptor for the Extra Target Mappings feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addExtraTargetMappingsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeCreationDescription_extraTargetMappings_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EdgeCreationDescription_extraTargetMappings_feature", "_UI_EdgeCreationDescription_type"),
                org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__EXTRA_TARGET_MAPPINGS, true, false, true, null, getString("_UI_AdvancedPropertyCategory"),
                null));
    }

    /**
     * This adds a property descriptor for the Connection Start Precondition
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addConnectionStartPreconditionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeCreationDescription_connectionStartPrecondition_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EdgeCreationDescription_connectionStartPrecondition_feature", "_UI_EdgeCreationDescription_type"),
                org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__CONNECTION_START_PRECONDITION, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in
     * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(ToolPackage.Literals.ABSTRACT_TOOL_DESCRIPTION__FILTERS);
            childrenFeatures.add(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__SOURCE_VARIABLE);
            childrenFeatures.add(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__TARGET_VARIABLE);
            childrenFeatures.add(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__SOURCE_VIEW_VARIABLE);
            childrenFeatures.add(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__TARGET_VIEW_VARIABLE);
            childrenFeatures.add(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__INITIAL_OPERATION);
            childrenFeatures.add(org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.Literals.ORDERED_ELEMENT_CREATION_TOOL__STARTING_END_PREDECESSOR);
            childrenFeatures.add(org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.Literals.ORDERED_ELEMENT_CREATION_TOOL__FINISHING_END_PREDECESSOR);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper
        // feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns MessageCreationTool.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/MessageCreationTool"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((MessageCreationTool) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_MessageCreationTool_type") : getString("_UI_MessageCreationTool_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached children and by creating a viewer notification, which
     * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(MessageCreationTool.class)) {
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__DOCUMENTATION:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__NAME:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__LABEL:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__PRECONDITION:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__FORCE_REFRESH:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__ICON_PATH:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__CONNECTION_START_PRECONDITION:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__FILTERS:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__SOURCE_VARIABLE:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__TARGET_VARIABLE:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__SOURCE_VIEW_VARIABLE:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__TARGET_VIEW_VARIABLE:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__INITIAL_OPERATION:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__STARTING_END_PREDECESSOR:
        case org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.MESSAGE_CREATION_TOOL__FINISHING_END_PREDECESSOR:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children that can be created under this object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(createChildParameter(ToolPackage.Literals.ABSTRACT_TOOL_DESCRIPTION__FILTERS, ToolFactory.eINSTANCE.createToolFilterDescription()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__SOURCE_VARIABLE,
                org.eclipse.sirius.diagram.description.tool.ToolFactory.eINSTANCE.createSourceEdgeCreationVariable()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__TARGET_VARIABLE,
                org.eclipse.sirius.diagram.description.tool.ToolFactory.eINSTANCE.createTargetEdgeCreationVariable()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__SOURCE_VIEW_VARIABLE,
                org.eclipse.sirius.diagram.description.tool.ToolFactory.eINSTANCE.createSourceEdgeViewCreationVariable()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__TARGET_VIEW_VARIABLE,
                org.eclipse.sirius.diagram.description.tool.ToolFactory.eINSTANCE.createTargetEdgeViewCreationVariable()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.description.tool.ToolPackage.Literals.EDGE_CREATION_DESCRIPTION__INITIAL_OPERATION,
                ToolFactory.eINSTANCE.createInitEdgeCreationOperation()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.Literals.ORDERED_ELEMENT_CREATION_TOOL__STARTING_END_PREDECESSOR,
                DescriptionFactory.eINSTANCE.createMessageEndVariable()));

        newChildDescriptors.add(createChildParameter(org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.Literals.ORDERED_ELEMENT_CREATION_TOOL__FINISHING_END_PREDECESSOR,
                DescriptionFactory.eINSTANCE.createMessageEndVariable()));
    }

    /**
     * This returns the label text for
     * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify = childFeature == org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.Literals.ORDERED_ELEMENT_CREATION_TOOL__STARTING_END_PREDECESSOR
                || childFeature == org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage.Literals.ORDERED_ELEMENT_CREATION_TOOL__FINISHING_END_PREDECESSOR;

        if (qualify) {
            return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

}
