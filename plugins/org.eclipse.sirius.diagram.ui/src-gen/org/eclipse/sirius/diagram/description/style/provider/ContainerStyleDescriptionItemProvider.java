/**
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Obeo - initial API and implementation
 * 
 */
package org.eclipse.sirius.diagram.description.style.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.sirius.diagram.description.style.ContainerStyleDescription;
import org.eclipse.sirius.diagram.description.style.StylePackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.sirius.diagram.description.style.ContainerStyleDescription}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ContainerStyleDescriptionItemProvider extends RoundedCornerStyleDescriptionItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
        IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ContainerStyleDescriptionItemProvider(AdapterFactory adapterFactory) {
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

            addBorderSizeComputationExpressionPropertyDescriptor(object);
            addBorderColorPropertyDescriptor(object);
            addLabelSizePropertyDescriptor(object);
            addLabelFormatPropertyDescriptor(object);
            addShowIconPropertyDescriptor(object);
            addLabelExpressionPropertyDescriptor(object);
            addLabelColorPropertyDescriptor(object);
            addIconPathPropertyDescriptor(object);
            addLabelAlignmentPropertyDescriptor(object);
            addTooltipExpressionPropertyDescriptor(object);
            addRoundedCornerPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Border Size Computation
     * Expression feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBorderSizeComputationExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BorderedStyleDescription_borderSizeComputationExpression_feature"), getString("_UI_BorderedStyleDescription_borderSizeComputationExpression_description"),
                StylePackage.Literals.BORDERED_STYLE_DESCRIPTION__BORDER_SIZE_COMPUTATION_EXPRESSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_BorderPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Border Color feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBorderColorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BorderedStyleDescription_borderColor_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_BorderedStyleDescription_borderColor_feature", "_UI_BorderedStyleDescription_type"),
                StylePackage.Literals.BORDERED_STYLE_DESCRIPTION__BORDER_COLOR, true, false, false, null, getString("_UI_ColorPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Label Size feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelSizePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BasicLabelStyleDescription_labelSize_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_BasicLabelStyleDescription_labelSize_feature", "_UI_BasicLabelStyleDescription_type"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.BASIC_LABEL_STYLE_DESCRIPTION__LABEL_SIZE, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                getString("_UI_LabelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Label Format feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelFormatPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BasicLabelStyleDescription_labelFormat_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_BasicLabelStyleDescription_labelFormat_feature", "_UI_BasicLabelStyleDescription_type"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.BASIC_LABEL_STYLE_DESCRIPTION__LABEL_FORMAT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_LabelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Show Icon feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addShowIconPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BasicLabelStyleDescription_showIcon_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_BasicLabelStyleDescription_showIcon_feature", "_UI_BasicLabelStyleDescription_type"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.BASIC_LABEL_STYLE_DESCRIPTION__SHOW_ICON, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                getString("_UI_LabelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Label Expression feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BasicLabelStyleDescription_labelExpression_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_BasicLabelStyleDescription_labelExpression_feature", "_UI_BasicLabelStyleDescription_type"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.BASIC_LABEL_STYLE_DESCRIPTION__LABEL_EXPRESSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_LabelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Label Color feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelColorPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                        getString("_UI_BasicLabelStyleDescription_labelColor_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_BasicLabelStyleDescription_labelColor_feature", "_UI_BasicLabelStyleDescription_type"),
                        org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.BASIC_LABEL_STYLE_DESCRIPTION__LABEL_COLOR, true, false, true, null,
                        getString("_UI_ColorPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Icon Path feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIconPathPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_BasicLabelStyleDescription_iconPath_feature"), getString("_UI_BasicLabelStyleDescription_iconPath_description"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.BASIC_LABEL_STYLE_DESCRIPTION__ICON_PATH, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_AdvancedPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Label Alignment feature. <!--
     * begin-user-doc -->
     * 
     * @since 0.9.0 <!-- end-user-doc -->
     * @generated
     */
    protected void addLabelAlignmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_LabelStyleDescription_labelAlignment_feature"), getString("_UI_LabelStyleDescription_labelAlignment_description"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.LABEL_STYLE_DESCRIPTION__LABEL_ALIGNMENT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_LabelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Tooltip Expression feature. <!--
     * begin-user-doc -->
     * 
     * @since 0.9.0 <!-- end-user-doc -->
     * @generated
     */
    protected void addTooltipExpressionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_TooltipStyleDescription_tooltipExpression_feature"), getString("_UI_TooltipStyleDescription_tooltipExpression_description"),
                org.eclipse.sirius.viewpoint.description.style.StylePackage.Literals.TOOLTIP_STYLE_DESCRIPTION__TOOLTIP_EXPRESSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_GeneralPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Rounded Corner feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addRoundedCornerPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_ContainerStyleDescription_roundedCorner_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_ContainerStyleDescription_roundedCorner_feature", "_UI_ContainerStyleDescription_type"),
                StylePackage.Literals.CONTAINER_STYLE_DESCRIPTION__ROUNDED_CORNER, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_CornerPropertyCategory"), null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        Integer labelValue = ((ContainerStyleDescription) object).getArcWidth();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ? getString("_UI_ContainerStyleDescription_type") : getString("_UI_ContainerStyleDescription_type") + " " + label;
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

        switch (notification.getFeatureID(ContainerStyleDescription.class)) {
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__BORDER_SIZE_COMPUTATION_EXPRESSION:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__BORDER_COLOR:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__LABEL_SIZE:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__LABEL_FORMAT:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__SHOW_ICON:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__LABEL_EXPRESSION:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__ICON_PATH:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__LABEL_ALIGNMENT:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__TOOLTIP_EXPRESSION:
        case StylePackage.CONTAINER_STYLE_DESCRIPTION__ROUNDED_CORNER:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getCreateChildText(java.lang.Object,
     *      java.lang.Object, java.lang.Object, java.util.Collection)
     * @not-generated
     */
    @Override
    public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        boolean qualify = feature == org.eclipse.sirius.diagram.description.style.StylePackage.Literals.BORDERED_STYLE_DESCRIPTION__BORDER_COLOR;

        if (qualify) {
            return getString("_UI_CreateChild_text2", new Object[] { getTypeText(child), getFeatureText(feature), getTypeText(owner) });
        }

        return super.getCreateChildText(owner, feature, child, selection);
    }
}
