/*******************************************************************************
 * Copyright (c) 2007-2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tree.description;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.viewpoint.description.style.StylePackage;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.sirius.tree.description.DescriptionFactory
 * @model kind="package"
 * @generated
 */
public interface DescriptionPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "description";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/sirius/tree/description/1.0.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "description";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    DescriptionPackage eINSTANCE = org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl.init();

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeDescriptionImpl
     * <em>Tree Description</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeDescriptionImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeDescription()
     * @generated
     */
    int TREE_DESCRIPTION = 0;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__DOCUMENTATION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>End User Documentation</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__END_USER_DOCUMENTATION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__END_USER_DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__NAME = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__LABEL = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Title Expression</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__TITLE_EXPRESSION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__TITLE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Initialisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__INITIALISATION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__INITIALISATION;

    /**
     * The feature id for the '<em><b>Metamodel</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__METAMODEL = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__METAMODEL;

    /**
     * The feature id for the '<em><b>Show On Startup</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__SHOW_ON_STARTUP = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION__SHOW_ON_STARTUP;

    /**
     * The feature id for the '<em><b>Sub Item Mappings</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__SUB_ITEM_MAPPINGS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Drop Tools</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__DROP_TOOLS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Domain Class</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__DOMAIN_CLASS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Precondition Expression</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__PRECONDITION_EXPRESSION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Create Tree Item</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__CREATE_TREE_ITEM = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '
     * <em><b>Owned Representation Creation Descriptions</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__OWNED_REPRESENTATION_CREATION_DESCRIPTIONS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '
     * <em><b>Owned Representation Navigation Descriptions</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION__OWNED_REPRESENTATION_NAVIGATION_DESCRIPTIONS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Tree Description</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_DESCRIPTION_FEATURE_COUNT = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_DESCRIPTION_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeMappingImpl
     * <em>Tree Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeMappingImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeMapping()
     * @generated
     */
    int TREE_MAPPING = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_MAPPING__NAME = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_ELEMENT_MAPPING__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_MAPPING__LABEL = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_ELEMENT_MAPPING__LABEL;

    /**
     * The feature id for the '<em><b>Detail Descriptions</b></em>' reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_MAPPING__DETAIL_DESCRIPTIONS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_ELEMENT_MAPPING__DETAIL_DESCRIPTIONS;

    /**
     * The feature id for the '<em><b>Navigation Descriptions</b></em>'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_MAPPING__NAVIGATION_DESCRIPTIONS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_ELEMENT_MAPPING__NAVIGATION_DESCRIPTIONS;

    /**
     * The feature id for the '<em><b>Semantic Elements</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_MAPPING__SEMANTIC_ELEMENTS = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_ELEMENT_MAPPING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Tree Mapping</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_MAPPING_FEATURE_COUNT = org.eclipse.sirius.viewpoint.description.DescriptionPackage.REPRESENTATION_ELEMENT_MAPPING_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemMappingImpl
     * <em>Tree Item Mapping</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemMappingImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemMapping()
     * @generated
     */
    int TREE_ITEM_MAPPING = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__NAME = TREE_MAPPING__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__LABEL = TREE_MAPPING__LABEL;

    /**
     * The feature id for the '<em><b>Detail Descriptions</b></em>' reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DETAIL_DESCRIPTIONS = TREE_MAPPING__DETAIL_DESCRIPTIONS;

    /**
     * The feature id for the '<em><b>Navigation Descriptions</b></em>'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__NAVIGATION_DESCRIPTIONS = TREE_MAPPING__NAVIGATION_DESCRIPTIONS;

    /**
     * The feature id for the '<em><b>Semantic Elements</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__SEMANTIC_ELEMENTS = TREE_MAPPING__SEMANTIC_ELEMENTS;

    /**
     * The feature id for the '<em><b>Default Style</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DEFAULT_STYLE = TREE_MAPPING_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Conditional Styles</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__CONDITIONAL_STYLES = TREE_MAPPING_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Direct Edit</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DIRECT_EDIT = TREE_MAPPING_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Sub Item Mappings</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__SUB_ITEM_MAPPINGS = TREE_MAPPING_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Drop Tools</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DROP_TOOLS = TREE_MAPPING_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Domain Class</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DOMAIN_CLASS = TREE_MAPPING_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Precondition Expression</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__PRECONDITION_EXPRESSION = TREE_MAPPING_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Semantic Candidates Expression</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__SEMANTIC_CANDIDATES_EXPRESSION = TREE_MAPPING_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Reused Tree Item Mappings</b></em>'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__REUSED_TREE_ITEM_MAPPINGS = TREE_MAPPING_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>All Sub Mappings</b></em>' reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__ALL_SUB_MAPPINGS = TREE_MAPPING_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Specialize</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__SPECIALIZE = TREE_MAPPING_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Delete</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DELETE = TREE_MAPPING_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Create</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__CREATE = TREE_MAPPING_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Dnd Tools</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__DND_TOOLS = TREE_MAPPING_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Popup Menus</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING__POPUP_MENUS = TREE_MAPPING_FEATURE_COUNT + 14;

    /**
     * The number of structural features of the '<em>Tree Item Mapping</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING_FEATURE_COUNT = TREE_MAPPING_FEATURE_COUNT + 15;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemStyleDescriptionImpl
     * <em>Tree Item Style Description</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemStyleDescriptionImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemStyleDescription()
     * @generated
     */
    int TREE_ITEM_STYLE_DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Label Size</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__LABEL_SIZE = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Label Format</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__LABEL_FORMAT = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Show Icon</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__SHOW_ICON = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Label Expression</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__LABEL_EXPRESSION = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Label Color</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__LABEL_COLOR = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Icon Path</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__ICON_PATH = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Label Alignment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__LABEL_ALIGNMENT = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION__BACKGROUND_COLOR = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '
     * <em>Tree Item Style Description</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_STYLE_DESCRIPTION_FEATURE_COUNT = StylePackage.STYLE_DESCRIPTION_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.ConditionalTreeItemStyleDescriptionImpl
     * <em>Conditional Tree Item Style Description</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.ConditionalTreeItemStyleDescriptionImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getConditionalTreeItemStyleDescription()
     * @generated
     */
    int CONDITIONAL_TREE_ITEM_STYLE_DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Predicate Expression</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONDITIONAL_TREE_ITEM_STYLE_DESCRIPTION__PREDICATE_EXPRESSION = org.eclipse.sirius.viewpoint.description.DescriptionPackage.CONDITIONAL_STYLE_DESCRIPTION__PREDICATE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Style</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONDITIONAL_TREE_ITEM_STYLE_DESCRIPTION__STYLE = org.eclipse.sirius.viewpoint.description.DescriptionPackage.CONDITIONAL_STYLE_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '
     * <em>Conditional Tree Item Style Description</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONDITIONAL_TREE_ITEM_STYLE_DESCRIPTION_FEATURE_COUNT = org.eclipse.sirius.viewpoint.description.DescriptionPackage.CONDITIONAL_STYLE_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemToolImpl
     * <em>Tree Item Tool</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemToolImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemTool()
     * @generated
     */
    int TREE_ITEM_TOOL = 4;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__DOCUMENTATION = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__NAME = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__LABEL = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__PRECONDITION = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__FORCE_REFRESH = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__FILTERS = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS;

    /**
     * The feature id for the '<em><b>First Model Operation</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__FIRST_MODEL_OPERATION = ToolPackage.ABSTRACT_TOOL_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL__VARIABLES = ToolPackage.ABSTRACT_TOOL_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Tree Item Tool</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_TOOL_FEATURE_COUNT = ToolPackage.ABSTRACT_TOOL_DESCRIPTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemDragToolImpl
     * <em>Tree Item Drag Tool</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemDragToolImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemDragTool()
     * @generated
     */
    int TREE_ITEM_DRAG_TOOL = 5;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__DOCUMENTATION = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__NAME = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__LABEL = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__PRECONDITION = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__FORCE_REFRESH = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__FILTERS = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__FILTERS;

    /**
     * The feature id for the '<em><b>First Model Operation</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__FIRST_MODEL_OPERATION = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__VARIABLES = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Old Container</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__OLD_CONTAINER = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>New Container</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__NEW_CONTAINER = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__ELEMENT = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>New View Container</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__NEW_VIEW_CONTAINER = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Containers</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__CONTAINERS = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Drag Source Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__DRAG_SOURCE_TYPE = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Preceding Siblings</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL__PRECEDING_SIBLINGS = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Tree Item Drag Tool</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DRAG_TOOL_FEATURE_COUNT = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 9;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemContainerDropToolImpl
     * <em>Tree Item Container Drop Tool</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemContainerDropToolImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemContainerDropTool()
     * @generated
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL = 6;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__DOCUMENTATION = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__NAME = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__LABEL = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__PRECONDITION = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__FORCE_REFRESH = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__FILTERS = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION__FILTERS;

    /**
     * The feature id for the '<em><b>First Model Operation</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__FIRST_MODEL_OPERATION = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__VARIABLES = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Old Container</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__OLD_CONTAINER = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>New Container</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__NEW_CONTAINER = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__ELEMENT = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>New View Container</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__NEW_VIEW_CONTAINER = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Preceding Siblings</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__PRECEDING_SIBLINGS = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Drag Source</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL__DRAG_SOURCE = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '
     * <em>Tree Item Container Drop Tool</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CONTAINER_DROP_TOOL_FEATURE_COUNT = ToolPackage.MAPPING_BASED_TOOL_DESCRIPTION_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemCreationToolImpl
     * <em>Tree Item Creation Tool</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemCreationToolImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemCreationTool()
     * @generated
     */
    int TREE_ITEM_CREATION_TOOL = 7;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__DOCUMENTATION = TREE_ITEM_TOOL__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__NAME = TREE_ITEM_TOOL__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__LABEL = TREE_ITEM_TOOL__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__PRECONDITION = TREE_ITEM_TOOL__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__FORCE_REFRESH = TREE_ITEM_TOOL__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__FILTERS = TREE_ITEM_TOOL__FILTERS;

    /**
     * The feature id for the '<em><b>First Model Operation</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__FIRST_MODEL_OPERATION = TREE_ITEM_TOOL__FIRST_MODEL_OPERATION;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__VARIABLES = TREE_ITEM_TOOL__VARIABLES;

    /**
     * The feature id for the '<em><b>Mapping</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL__MAPPING = TREE_ITEM_TOOL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '
     * <em>Tree Item Creation Tool</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_CREATION_TOOL_FEATURE_COUNT = TREE_ITEM_TOOL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemEditionToolImpl
     * <em>Tree Item Edition Tool</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemEditionToolImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemEditionTool()
     * @generated
     */
    int TREE_ITEM_EDITION_TOOL = 8;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__DOCUMENTATION = TREE_ITEM_TOOL__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__NAME = TREE_ITEM_TOOL__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__LABEL = TREE_ITEM_TOOL__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__PRECONDITION = TREE_ITEM_TOOL__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__FORCE_REFRESH = TREE_ITEM_TOOL__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__FILTERS = TREE_ITEM_TOOL__FILTERS;

    /**
     * The feature id for the '<em><b>First Model Operation</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__FIRST_MODEL_OPERATION = TREE_ITEM_TOOL__FIRST_MODEL_OPERATION;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__VARIABLES = TREE_ITEM_TOOL__VARIABLES;

    /**
     * The feature id for the '<em><b>Mask</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__MASK = TREE_ITEM_TOOL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Mapping</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__MAPPING = TREE_ITEM_TOOL_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__ELEMENT = TREE_ITEM_TOOL_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL__ROOT = TREE_ITEM_TOOL_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Tree Item Edition Tool</em>
     * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_EDITION_TOOL_FEATURE_COUNT = TREE_ITEM_TOOL_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemDeletionToolImpl
     * <em>Tree Item Deletion Tool</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemDeletionToolImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemDeletionTool()
     * @generated
     */
    int TREE_ITEM_DELETION_TOOL = 9;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__DOCUMENTATION = TREE_ITEM_TOOL__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__NAME = TREE_ITEM_TOOL__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__LABEL = TREE_ITEM_TOOL__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__PRECONDITION = TREE_ITEM_TOOL__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__FORCE_REFRESH = TREE_ITEM_TOOL__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__FILTERS = TREE_ITEM_TOOL__FILTERS;

    /**
     * The feature id for the '<em><b>First Model Operation</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__FIRST_MODEL_OPERATION = TREE_ITEM_TOOL__FIRST_MODEL_OPERATION;

    /**
     * The feature id for the '<em><b>Variables</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__VARIABLES = TREE_ITEM_TOOL__VARIABLES;

    /**
     * The feature id for the '<em><b>Mapping</b></em>' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL__MAPPING = TREE_ITEM_TOOL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '
     * <em>Tree Item Deletion Tool</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_DELETION_TOOL_FEATURE_COUNT = TREE_ITEM_TOOL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeCreationDescriptionImpl
     * <em>Tree Creation Description</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeCreationDescriptionImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeCreationDescription()
     * @generated
     */
    int TREE_CREATION_DESCRIPTION = 10;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__DOCUMENTATION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__NAME = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__LABEL = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__PRECONDITION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__FORCE_REFRESH = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__FILTERS = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__FILTERS;

    /**
     * The feature id for the '<em><b>Title Expression</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__TITLE_EXPRESSION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__TITLE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Browse Expression</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__BROWSE_EXPRESSION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__BROWSE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Representation Description</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__REPRESENTATION_DESCRIPTION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__REPRESENTATION_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Initial Operation</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__INITIAL_OPERATION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__INITIAL_OPERATION;

    /**
     * The feature id for the '<em><b>Container View Variable</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__CONTAINER_VIEW_VARIABLE = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__CONTAINER_VIEW_VARIABLE;

    /**
     * The feature id for the '<em><b>Representation Name Variable</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__REPRESENTATION_NAME_VARIABLE = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION__REPRESENTATION_NAME_VARIABLE;

    /**
     * The feature id for the '<em><b>Tree Description</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION__TREE_DESCRIPTION = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '
     * <em>Tree Creation Description</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_CREATION_DESCRIPTION_FEATURE_COUNT = ToolPackage.REPRESENTATION_CREATION_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeNavigationDescriptionImpl
     * <em>Tree Navigation Description</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeNavigationDescriptionImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeNavigationDescription()
     * @generated
     */
    int TREE_NAVIGATION_DESCRIPTION = 11;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__DOCUMENTATION = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__NAME = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__LABEL = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__PRECONDITION = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__FORCE_REFRESH = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__FILTERS = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__FILTERS;

    /**
     * The feature id for the '<em><b>Browse Expression</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__BROWSE_EXPRESSION = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__BROWSE_EXPRESSION;

    /**
     * The feature id for the '<em><b>Navigation Name Expression</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__NAVIGATION_NAME_EXPRESSION = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__NAVIGATION_NAME_EXPRESSION;

    /**
     * The feature id for the '<em><b>Representation Description</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__REPRESENTATION_DESCRIPTION = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__REPRESENTATION_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Container View Variable</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__CONTAINER_VIEW_VARIABLE = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__CONTAINER_VIEW_VARIABLE;

    /**
     * The feature id for the '<em><b>Container Variable</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__CONTAINER_VARIABLE = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__CONTAINER_VARIABLE;

    /**
     * The feature id for the '<em><b>Representation Name Variable</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__REPRESENTATION_NAME_VARIABLE = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION__REPRESENTATION_NAME_VARIABLE;

    /**
     * The feature id for the '<em><b>Tree Description</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION__TREE_DESCRIPTION = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '
     * <em>Tree Navigation Description</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_NAVIGATION_DESCRIPTION_FEATURE_COUNT = ToolPackage.REPRESENTATION_NAVIGATION_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.StyleUpdaterImpl
     * <em>Style Updater</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.StyleUpdaterImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getStyleUpdater()
     * @generated
     */
    int STYLE_UPDATER = 13;

    /**
     * The feature id for the '<em><b>Default Style</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STYLE_UPDATER__DEFAULT_STYLE = 0;

    /**
     * The feature id for the '<em><b>Conditional Styles</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STYLE_UPDATER__CONDITIONAL_STYLES = 1;

    /**
     * The number of structural features of the '<em>Style Updater</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STYLE_UPDATER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeVariableImpl
     * <em>Tree Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeVariableImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeVariable()
     * @generated
     */
    int TREE_VARIABLE = 14;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_VARIABLE__NAME = ToolPackage.ABSTRACT_VARIABLE__NAME;

    /**
     * The feature id for the '<em><b>Sub Variables</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_VARIABLE__SUB_VARIABLES = ToolPackage.ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_VARIABLE__DOCUMENTATION = ToolPackage.ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Tree Variable</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_VARIABLE_FEATURE_COUNT = ToolPackage.ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreeItemUpdaterImpl
     * <em>Tree Item Updater</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreeItemUpdaterImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemUpdater()
     * @generated
     */
    int TREE_ITEM_UPDATER = 15;

    /**
     * The feature id for the '<em><b>Direct Edit</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_UPDATER__DIRECT_EDIT = 0;

    /**
     * The number of structural features of the '<em>Tree Item Updater</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_UPDATER_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.PrecedingSiblingsVariablesImpl
     * <em>Preceding Siblings Variables</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.PrecedingSiblingsVariablesImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getPrecedingSiblingsVariables()
     * @generated
     */
    int PRECEDING_SIBLINGS_VARIABLES = 16;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRECEDING_SIBLINGS_VARIABLES__NAME = TREE_VARIABLE__NAME;

    /**
     * The feature id for the '<em><b>Sub Variables</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRECEDING_SIBLINGS_VARIABLES__SUB_VARIABLES = TREE_VARIABLE__SUB_VARIABLES;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRECEDING_SIBLINGS_VARIABLES__DOCUMENTATION = TREE_VARIABLE__DOCUMENTATION;

    /**
     * The number of structural features of the '
     * <em>Preceding Siblings Variables</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRECEDING_SIBLINGS_VARIABLES_FEATURE_COUNT = TREE_VARIABLE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.TreeItemMappingContainer
     * <em>Tree Item Mapping Container</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.TreeItemMappingContainer
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemMappingContainer()
     * @generated
     */
    int TREE_ITEM_MAPPING_CONTAINER = 17;

    /**
     * The feature id for the '<em><b>Sub Item Mappings</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING_CONTAINER__SUB_ITEM_MAPPINGS = 0;

    /**
     * The feature id for the '<em><b>Drop Tools</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING_CONTAINER__DROP_TOOLS = 1;

    /**
     * The number of structural features of the '
     * <em>Tree Item Mapping Container</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_ITEM_MAPPING_CONTAINER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.impl.TreePopupMenuImpl
     * <em>Tree Popup Menu</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.impl.TreePopupMenuImpl
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreePopupMenu()
     * @generated
     */
    int TREE_POPUP_MENU = 18;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__DOCUMENTATION = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__NAME = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__LABEL = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL;

    /**
     * The feature id for the '<em><b>Precondition</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__PRECONDITION = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION;

    /**
     * The feature id for the '<em><b>Force Refresh</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__FORCE_REFRESH = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__FILTERS = ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS;

    /**
     * The feature id for the '<em><b>Menu Item Descriptions</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU__MENU_ITEM_DESCRIPTIONS = ToolPackage.ABSTRACT_TOOL_DESCRIPTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Tree Popup Menu</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TREE_POPUP_MENU_FEATURE_COUNT = ToolPackage.ABSTRACT_TOOL_DESCRIPTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.sirius.tree.description.TreeDragSource
     * <em>Tree Drag Source</em>}' enum. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.sirius.tree.description.TreeDragSource
     * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeDragSource()
     * @generated
     */
    int TREE_DRAG_SOURCE = 19;

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeDescription
     * <em>Tree Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Tree Description</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDescription
     * @generated
     */
    EClass getTreeDescription();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeDescription#getDomainClass
     * <em>Domain Class</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Domain Class</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDescription#getDomainClass()
     * @see #getTreeDescription()
     * @generated
     */
    EAttribute getTreeDescription_DomainClass();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeDescription#getPreconditionExpression
     * <em>Precondition Expression</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '
     *         <em>Precondition Expression</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDescription#getPreconditionExpression()
     * @see #getTreeDescription()
     * @generated
     */
    EAttribute getTreeDescription_PreconditionExpression();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeDescription#getCreateTreeItem
     * <em>Create Tree Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Create Tree Item</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDescription#getCreateTreeItem()
     * @see #getTreeDescription()
     * @generated
     */
    EReference getTreeDescription_CreateTreeItem();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeDescription#getOwnedRepresentationCreationDescriptions
     * <em>Owned Representation Creation Descriptions</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Owned Representation Creation Descriptions</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDescription#getOwnedRepresentationCreationDescriptions()
     * @see #getTreeDescription()
     * @generated
     */
    EReference getTreeDescription_OwnedRepresentationCreationDescriptions();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeDescription#getOwnedRepresentationNavigationDescriptions
     * <em>Owned Representation Navigation Descriptions</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Owned Representation Navigation Descriptions</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDescription#getOwnedRepresentationNavigationDescriptions()
     * @see #getTreeDescription()
     * @generated
     */
    EReference getTreeDescription_OwnedRepresentationNavigationDescriptions();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping
     * <em>Tree Item Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Tree Item Mapping</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping
     * @generated
     */
    EClass getTreeItemMapping();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getDomainClass
     * <em>Domain Class</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Domain Class</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getDomainClass()
     * @see #getTreeItemMapping()
     * @generated
     */
    EAttribute getTreeItemMapping_DomainClass();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getPreconditionExpression
     * <em>Precondition Expression</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '
     *         <em>Precondition Expression</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getPreconditionExpression()
     * @see #getTreeItemMapping()
     * @generated
     */
    EAttribute getTreeItemMapping_PreconditionExpression();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getSemanticCandidatesExpression
     * <em>Semantic Candidates Expression</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '
     *         <em>Semantic Candidates Expression</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getSemanticCandidatesExpression()
     * @see #getTreeItemMapping()
     * @generated
     */
    EAttribute getTreeItemMapping_SemanticCandidatesExpression();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getReusedTreeItemMappings
     * <em>Reused Tree Item Mappings</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference list '
     *         <em>Reused Tree Item Mappings</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getReusedTreeItemMappings()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_ReusedTreeItemMappings();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getAllSubMappings
     * <em>All Sub Mappings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the reference list '<em>All Sub Mappings</em>
     *         '.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getAllSubMappings()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_AllSubMappings();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getSpecialize
     * <em>Specialize</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Specialize</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getSpecialize()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_Specialize();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getDelete
     * <em>Delete</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Delete</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getDelete()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_Delete();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getCreate
     * <em>Create</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Create</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getCreate()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_Create();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getDndTools
     * <em>Dnd Tools</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Dnd Tools</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getDndTools()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_DndTools();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMapping#getPopupMenus
     * <em>Popup Menus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Popup Menus</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMapping#getPopupMenus()
     * @see #getTreeItemMapping()
     * @generated
     */
    EReference getTreeItemMapping_PopupMenus();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemStyleDescription
     * <em>Tree Item Style Description</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Style Description</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemStyleDescription
     * @generated
     */
    EClass getTreeItemStyleDescription();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemStyleDescription#getBackgroundColor
     * <em>Background Color</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the reference '<em>Background Color</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemStyleDescription#getBackgroundColor()
     * @see #getTreeItemStyleDescription()
     * @generated
     */
    EReference getTreeItemStyleDescription_BackgroundColor();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.ConditionalTreeItemStyleDescription
     * <em>Conditional Tree Item Style Description</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '
     *         <em>Conditional Tree Item Style Description</em>'.
     * @see org.eclipse.sirius.tree.description.ConditionalTreeItemStyleDescription
     * @generated
     */
    EClass getConditionalTreeItemStyleDescription();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.ConditionalTreeItemStyleDescription#getStyle
     * <em>Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Style</em>'.
     * @see org.eclipse.sirius.tree.description.ConditionalTreeItemStyleDescription#getStyle()
     * @see #getConditionalTreeItemStyleDescription()
     * @generated
     */
    EReference getConditionalTreeItemStyleDescription_Style();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemTool
     * <em>Tree Item Tool</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Tool</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemTool
     * @generated
     */
    EClass getTreeItemTool();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemTool#getFirstModelOperation
     * <em>First Model Operation</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>First Model Operation</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemTool#getFirstModelOperation()
     * @see #getTreeItemTool()
     * @generated
     */
    EReference getTreeItemTool_FirstModelOperation();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemTool#getVariables
     * <em>Variables</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Variables</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemTool#getVariables()
     * @see #getTreeItemTool()
     * @generated
     */
    EReference getTreeItemTool_Variables();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool
     * <em>Tree Item Drag Tool</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Tree Item Drag Tool</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool
     * @generated
     */
    EClass getTreeItemDragTool();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getOldContainer
     * <em>Old Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Old Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getOldContainer()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EReference getTreeItemDragTool_OldContainer();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getNewContainer
     * <em>New Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>New Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getNewContainer()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EReference getTreeItemDragTool_NewContainer();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getElement
     * <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Element</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getElement()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EReference getTreeItemDragTool_Element();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getNewViewContainer
     * <em>New View Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference '
     *         <em>New View Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getNewViewContainer()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EReference getTreeItemDragTool_NewViewContainer();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getContainers
     * <em>Containers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Containers</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getContainers()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EReference getTreeItemDragTool_Containers();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getDragSourceType
     * <em>Drag Source Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the attribute '<em>Drag Source Type</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getDragSourceType()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EAttribute getTreeItemDragTool_DragSourceType();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemDragTool#getPrecedingSiblings
     * <em>Preceding Siblings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Preceding Siblings</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDragTool#getPrecedingSiblings()
     * @see #getTreeItemDragTool()
     * @generated
     */
    EReference getTreeItemDragTool_PrecedingSiblings();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool
     * <em>Tree Item Container Drop Tool</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Container Drop Tool</em>
     *         '.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool
     * @generated
     */
    EClass getTreeItemContainerDropTool();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getOldContainer
     * <em>Old Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Old Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getOldContainer()
     * @see #getTreeItemContainerDropTool()
     * @generated
     */
    EReference getTreeItemContainerDropTool_OldContainer();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getNewContainer
     * <em>New Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>New Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getNewContainer()
     * @see #getTreeItemContainerDropTool()
     * @generated
     */
    EReference getTreeItemContainerDropTool_NewContainer();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getElement
     * <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Element</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getElement()
     * @see #getTreeItemContainerDropTool()
     * @generated
     */
    EReference getTreeItemContainerDropTool_Element();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getNewViewContainer
     * <em>New View Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference '
     *         <em>New View Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getNewViewContainer()
     * @see #getTreeItemContainerDropTool()
     * @generated
     */
    EReference getTreeItemContainerDropTool_NewViewContainer();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getPrecedingSiblings
     * <em>Preceding Siblings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Preceding Siblings</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getPrecedingSiblings()
     * @see #getTreeItemContainerDropTool()
     * @generated
     */
    EReference getTreeItemContainerDropTool_PrecedingSiblings();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getDragSource
     * <em>Drag Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Drag Source</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemContainerDropTool#getDragSource()
     * @see #getTreeItemContainerDropTool()
     * @generated
     */
    EAttribute getTreeItemContainerDropTool_DragSource();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemCreationTool
     * <em>Tree Item Creation Tool</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Creation Tool</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemCreationTool
     * @generated
     */
    EClass getTreeItemCreationTool();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemCreationTool#getMapping
     * <em>Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Mapping</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemCreationTool#getMapping()
     * @see #getTreeItemCreationTool()
     * @generated
     */
    EReference getTreeItemCreationTool_Mapping();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemEditionTool
     * <em>Tree Item Edition Tool</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Edition Tool</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemEditionTool
     * @generated
     */
    EClass getTreeItemEditionTool();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemEditionTool#getMask
     * <em>Mask</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Mask</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemEditionTool#getMask()
     * @see #getTreeItemEditionTool()
     * @generated
     */
    EReference getTreeItemEditionTool_Mask();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemEditionTool#getMapping
     * <em>Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Mapping</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemEditionTool#getMapping()
     * @see #getTreeItemEditionTool()
     * @generated
     */
    EReference getTreeItemEditionTool_Mapping();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemEditionTool#getElement
     * <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Element</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemEditionTool#getElement()
     * @see #getTreeItemEditionTool()
     * @generated
     */
    EReference getTreeItemEditionTool_Element();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemEditionTool#getRoot
     * <em>Root</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemEditionTool#getRoot()
     * @see #getTreeItemEditionTool()
     * @generated
     */
    EReference getTreeItemEditionTool_Root();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemDeletionTool
     * <em>Tree Item Deletion Tool</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Deletion Tool</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDeletionTool
     * @generated
     */
    EClass getTreeItemDeletionTool();

    /**
     * Returns the meta object for the container reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemDeletionTool#getMapping
     * <em>Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Mapping</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemDeletionTool#getMapping()
     * @see #getTreeItemDeletionTool()
     * @generated
     */
    EReference getTreeItemDeletionTool_Mapping();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeCreationDescription
     * <em>Tree Creation Description</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Creation Description</em>'.
     * @see org.eclipse.sirius.tree.description.TreeCreationDescription
     * @generated
     */
    EClass getTreeCreationDescription();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.sirius.tree.description.TreeCreationDescription#getTreeDescription
     * <em>Tree Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the reference '<em>Tree Description</em>'.
     * @see org.eclipse.sirius.tree.description.TreeCreationDescription#getTreeDescription()
     * @see #getTreeCreationDescription()
     * @generated
     */
    EReference getTreeCreationDescription_TreeDescription();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeNavigationDescription
     * <em>Tree Navigation Description</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Navigation Description</em>'.
     * @see org.eclipse.sirius.tree.description.TreeNavigationDescription
     * @generated
     */
    EClass getTreeNavigationDescription();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.sirius.tree.description.TreeNavigationDescription#getTreeDescription
     * <em>Tree Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the reference '<em>Tree Description</em>'.
     * @see org.eclipse.sirius.tree.description.TreeNavigationDescription#getTreeDescription()
     * @see #getTreeNavigationDescription()
     * @generated
     */
    EReference getTreeNavigationDescription_TreeDescription();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeMapping
     * <em>Tree Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Mapping</em>'.
     * @see org.eclipse.sirius.tree.description.TreeMapping
     * @generated
     */
    EClass getTreeMapping();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeMapping#getSemanticElements
     * <em>Semantic Elements</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the attribute '<em>Semantic Elements</em>'.
     * @see org.eclipse.sirius.tree.description.TreeMapping#getSemanticElements()
     * @see #getTreeMapping()
     * @generated
     */
    EAttribute getTreeMapping_SemanticElements();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.StyleUpdater
     * <em>Style Updater</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Style Updater</em>'.
     * @see org.eclipse.sirius.tree.description.StyleUpdater
     * @generated
     */
    EClass getStyleUpdater();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.StyleUpdater#getDefaultStyle
     * <em>Default Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Default Style</em>'.
     * @see org.eclipse.sirius.tree.description.StyleUpdater#getDefaultStyle()
     * @see #getStyleUpdater()
     * @generated
     */
    EReference getStyleUpdater_DefaultStyle();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.StyleUpdater#getConditionalStyles
     * <em>Conditional Styles</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Conditional Styles</em>'.
     * @see org.eclipse.sirius.tree.description.StyleUpdater#getConditionalStyles()
     * @see #getStyleUpdater()
     * @generated
     */
    EReference getStyleUpdater_ConditionalStyles();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeVariable
     * <em>Tree Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Variable</em>'.
     * @see org.eclipse.sirius.tree.description.TreeVariable
     * @generated
     */
    EClass getTreeVariable();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.sirius.tree.description.TreeVariable#getDocumentation
     * <em>Documentation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Documentation</em>'.
     * @see org.eclipse.sirius.tree.description.TreeVariable#getDocumentation()
     * @see #getTreeVariable()
     * @generated
     */
    EAttribute getTreeVariable_Documentation();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemUpdater
     * <em>Tree Item Updater</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Tree Item Updater</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemUpdater
     * @generated
     */
    EClass getTreeItemUpdater();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.eclipse.sirius.tree.description.TreeItemUpdater#getDirectEdit
     * <em>Direct Edit</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Direct Edit</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemUpdater#getDirectEdit()
     * @see #getTreeItemUpdater()
     * @generated
     */
    EReference getTreeItemUpdater_DirectEdit();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.PrecedingSiblingsVariables
     * <em>Preceding Siblings Variables</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Preceding Siblings Variables</em>
     *         '.
     * @see org.eclipse.sirius.tree.description.PrecedingSiblingsVariables
     * @generated
     */
    EClass getPrecedingSiblingsVariables();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreeItemMappingContainer
     * <em>Tree Item Mapping Container</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Item Mapping Container</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMappingContainer
     * @generated
     */
    EClass getTreeItemMappingContainer();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMappingContainer#getSubItemMappings
     * <em>Sub Item Mappings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Sub Item Mappings</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMappingContainer#getSubItemMappings()
     * @see #getTreeItemMappingContainer()
     * @generated
     */
    EReference getTreeItemMappingContainer_SubItemMappings();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreeItemMappingContainer#getDropTools
     * <em>Drop Tools</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Drop Tools</em>'.
     * @see org.eclipse.sirius.tree.description.TreeItemMappingContainer#getDropTools()
     * @see #getTreeItemMappingContainer()
     * @generated
     */
    EReference getTreeItemMappingContainer_DropTools();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.sirius.tree.description.TreePopupMenu
     * <em>Tree Popup Menu</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tree Popup Menu</em>'.
     * @see org.eclipse.sirius.tree.description.TreePopupMenu
     * @generated
     */
    EClass getTreePopupMenu();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.sirius.tree.description.TreePopupMenu#getMenuItemDescriptions
     * <em>Menu Item Descriptions</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Menu Item Descriptions</em>'.
     * @see org.eclipse.sirius.tree.description.TreePopupMenu#getMenuItemDescriptions()
     * @see #getTreePopupMenu()
     * @generated
     */
    EReference getTreePopupMenu_MenuItemDescriptions();

    /**
     * Returns the meta object for enum '
     * {@link org.eclipse.sirius.tree.description.TreeDragSource
     * <em>Tree Drag Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for enum '<em>Tree Drag Source</em>'.
     * @see org.eclipse.sirius.tree.description.TreeDragSource
     * @generated
     */
    EEnum getTreeDragSource();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DescriptionFactory getDescriptionFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeDescriptionImpl
         * <em>Tree Description</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeDescriptionImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeDescription()
         * @generated
         */
        EClass TREE_DESCRIPTION = eINSTANCE.getTreeDescription();

        /**
         * The meta object literal for the '<em><b>Domain Class</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_DESCRIPTION__DOMAIN_CLASS = eINSTANCE.getTreeDescription_DomainClass();

        /**
         * The meta object literal for the '
         * <em><b>Precondition Expression</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_DESCRIPTION__PRECONDITION_EXPRESSION = eINSTANCE.getTreeDescription_PreconditionExpression();

        /**
         * The meta object literal for the '<em><b>Create Tree Item</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_DESCRIPTION__CREATE_TREE_ITEM = eINSTANCE.getTreeDescription_CreateTreeItem();

        /**
         * The meta object literal for the '
         * <em><b>Owned Representation Creation Descriptions</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_DESCRIPTION__OWNED_REPRESENTATION_CREATION_DESCRIPTIONS = eINSTANCE.getTreeDescription_OwnedRepresentationCreationDescriptions();

        /**
         * The meta object literal for the '
         * <em><b>Owned Representation Navigation Descriptions</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_DESCRIPTION__OWNED_REPRESENTATION_NAVIGATION_DESCRIPTIONS = eINSTANCE.getTreeDescription_OwnedRepresentationNavigationDescriptions();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemMappingImpl
         * <em>Tree Item Mapping</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemMappingImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemMapping()
         * @generated
         */
        EClass TREE_ITEM_MAPPING = eINSTANCE.getTreeItemMapping();

        /**
         * The meta object literal for the '<em><b>Domain Class</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_ITEM_MAPPING__DOMAIN_CLASS = eINSTANCE.getTreeItemMapping_DomainClass();

        /**
         * The meta object literal for the '
         * <em><b>Precondition Expression</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_ITEM_MAPPING__PRECONDITION_EXPRESSION = eINSTANCE.getTreeItemMapping_PreconditionExpression();

        /**
         * The meta object literal for the '
         * <em><b>Semantic Candidates Expression</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_ITEM_MAPPING__SEMANTIC_CANDIDATES_EXPRESSION = eINSTANCE.getTreeItemMapping_SemanticCandidatesExpression();

        /**
         * The meta object literal for the '
         * <em><b>Reused Tree Item Mappings</b></em>' reference list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__REUSED_TREE_ITEM_MAPPINGS = eINSTANCE.getTreeItemMapping_ReusedTreeItemMappings();

        /**
         * The meta object literal for the '<em><b>All Sub Mappings</b></em>'
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__ALL_SUB_MAPPINGS = eINSTANCE.getTreeItemMapping_AllSubMappings();

        /**
         * The meta object literal for the '<em><b>Specialize</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__SPECIALIZE = eINSTANCE.getTreeItemMapping_Specialize();

        /**
         * The meta object literal for the '<em><b>Delete</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__DELETE = eINSTANCE.getTreeItemMapping_Delete();

        /**
         * The meta object literal for the '<em><b>Create</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__CREATE = eINSTANCE.getTreeItemMapping_Create();

        /**
         * The meta object literal for the '<em><b>Dnd Tools</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__DND_TOOLS = eINSTANCE.getTreeItemMapping_DndTools();

        /**
         * The meta object literal for the '<em><b>Popup Menus</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING__POPUP_MENUS = eINSTANCE.getTreeItemMapping_PopupMenus();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemStyleDescriptionImpl
         * <em>Tree Item Style Description</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemStyleDescriptionImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemStyleDescription()
         * @generated
         */
        EClass TREE_ITEM_STYLE_DESCRIPTION = eINSTANCE.getTreeItemStyleDescription();

        /**
         * The meta object literal for the '<em><b>Background Color</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_STYLE_DESCRIPTION__BACKGROUND_COLOR = eINSTANCE.getTreeItemStyleDescription_BackgroundColor();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.ConditionalTreeItemStyleDescriptionImpl
         * <em>Conditional Tree Item Style Description</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.ConditionalTreeItemStyleDescriptionImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getConditionalTreeItemStyleDescription()
         * @generated
         */
        EClass CONDITIONAL_TREE_ITEM_STYLE_DESCRIPTION = eINSTANCE.getConditionalTreeItemStyleDescription();

        /**
         * The meta object literal for the '<em><b>Style</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONDITIONAL_TREE_ITEM_STYLE_DESCRIPTION__STYLE = eINSTANCE.getConditionalTreeItemStyleDescription_Style();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemToolImpl
         * <em>Tree Item Tool</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemToolImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemTool()
         * @generated
         */
        EClass TREE_ITEM_TOOL = eINSTANCE.getTreeItemTool();

        /**
         * The meta object literal for the '
         * <em><b>First Model Operation</b></em>' containment reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_TOOL__FIRST_MODEL_OPERATION = eINSTANCE.getTreeItemTool_FirstModelOperation();

        /**
         * The meta object literal for the '<em><b>Variables</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_TOOL__VARIABLES = eINSTANCE.getTreeItemTool_Variables();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemDragToolImpl
         * <em>Tree Item Drag Tool</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemDragToolImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemDragTool()
         * @generated
         */
        EClass TREE_ITEM_DRAG_TOOL = eINSTANCE.getTreeItemDragTool();

        /**
         * The meta object literal for the '<em><b>Old Container</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DRAG_TOOL__OLD_CONTAINER = eINSTANCE.getTreeItemDragTool_OldContainer();

        /**
         * The meta object literal for the '<em><b>New Container</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DRAG_TOOL__NEW_CONTAINER = eINSTANCE.getTreeItemDragTool_NewContainer();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DRAG_TOOL__ELEMENT = eINSTANCE.getTreeItemDragTool_Element();

        /**
         * The meta object literal for the '<em><b>New View Container</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DRAG_TOOL__NEW_VIEW_CONTAINER = eINSTANCE.getTreeItemDragTool_NewViewContainer();

        /**
         * The meta object literal for the '<em><b>Containers</b></em>'
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DRAG_TOOL__CONTAINERS = eINSTANCE.getTreeItemDragTool_Containers();

        /**
         * The meta object literal for the '<em><b>Drag Source Type</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_ITEM_DRAG_TOOL__DRAG_SOURCE_TYPE = eINSTANCE.getTreeItemDragTool_DragSourceType();

        /**
         * The meta object literal for the '<em><b>Preceding Siblings</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DRAG_TOOL__PRECEDING_SIBLINGS = eINSTANCE.getTreeItemDragTool_PrecedingSiblings();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemContainerDropToolImpl
         * <em>Tree Item Container Drop Tool</em>}' class. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemContainerDropToolImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemContainerDropTool()
         * @generated
         */
        EClass TREE_ITEM_CONTAINER_DROP_TOOL = eINSTANCE.getTreeItemContainerDropTool();

        /**
         * The meta object literal for the '<em><b>Old Container</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_CONTAINER_DROP_TOOL__OLD_CONTAINER = eINSTANCE.getTreeItemContainerDropTool_OldContainer();

        /**
         * The meta object literal for the '<em><b>New Container</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_CONTAINER_DROP_TOOL__NEW_CONTAINER = eINSTANCE.getTreeItemContainerDropTool_NewContainer();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_CONTAINER_DROP_TOOL__ELEMENT = eINSTANCE.getTreeItemContainerDropTool_Element();

        /**
         * The meta object literal for the '<em><b>New View Container</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_CONTAINER_DROP_TOOL__NEW_VIEW_CONTAINER = eINSTANCE.getTreeItemContainerDropTool_NewViewContainer();

        /**
         * The meta object literal for the '<em><b>Preceding Siblings</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_CONTAINER_DROP_TOOL__PRECEDING_SIBLINGS = eINSTANCE.getTreeItemContainerDropTool_PrecedingSiblings();

        /**
         * The meta object literal for the '<em><b>Drag Source</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_ITEM_CONTAINER_DROP_TOOL__DRAG_SOURCE = eINSTANCE.getTreeItemContainerDropTool_DragSource();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemCreationToolImpl
         * <em>Tree Item Creation Tool</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemCreationToolImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemCreationTool()
         * @generated
         */
        EClass TREE_ITEM_CREATION_TOOL = eINSTANCE.getTreeItemCreationTool();

        /**
         * The meta object literal for the '<em><b>Mapping</b></em>' reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_CREATION_TOOL__MAPPING = eINSTANCE.getTreeItemCreationTool_Mapping();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemEditionToolImpl
         * <em>Tree Item Edition Tool</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemEditionToolImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemEditionTool()
         * @generated
         */
        EClass TREE_ITEM_EDITION_TOOL = eINSTANCE.getTreeItemEditionTool();

        /**
         * The meta object literal for the '<em><b>Mask</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_EDITION_TOOL__MASK = eINSTANCE.getTreeItemEditionTool_Mask();

        /**
         * The meta object literal for the '<em><b>Mapping</b></em>' reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_EDITION_TOOL__MAPPING = eINSTANCE.getTreeItemEditionTool_Mapping();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_EDITION_TOOL__ELEMENT = eINSTANCE.getTreeItemEditionTool_Element();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_EDITION_TOOL__ROOT = eINSTANCE.getTreeItemEditionTool_Root();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemDeletionToolImpl
         * <em>Tree Item Deletion Tool</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemDeletionToolImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemDeletionTool()
         * @generated
         */
        EClass TREE_ITEM_DELETION_TOOL = eINSTANCE.getTreeItemDeletionTool();

        /**
         * The meta object literal for the '<em><b>Mapping</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_DELETION_TOOL__MAPPING = eINSTANCE.getTreeItemDeletionTool_Mapping();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeCreationDescriptionImpl
         * <em>Tree Creation Description</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeCreationDescriptionImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeCreationDescription()
         * @generated
         */
        EClass TREE_CREATION_DESCRIPTION = eINSTANCE.getTreeCreationDescription();

        /**
         * The meta object literal for the '<em><b>Tree Description</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_CREATION_DESCRIPTION__TREE_DESCRIPTION = eINSTANCE.getTreeCreationDescription_TreeDescription();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeNavigationDescriptionImpl
         * <em>Tree Navigation Description</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeNavigationDescriptionImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeNavigationDescription()
         * @generated
         */
        EClass TREE_NAVIGATION_DESCRIPTION = eINSTANCE.getTreeNavigationDescription();

        /**
         * The meta object literal for the '<em><b>Tree Description</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_NAVIGATION_DESCRIPTION__TREE_DESCRIPTION = eINSTANCE.getTreeNavigationDescription_TreeDescription();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeMappingImpl
         * <em>Tree Mapping</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeMappingImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeMapping()
         * @generated
         */
        EClass TREE_MAPPING = eINSTANCE.getTreeMapping();

        /**
         * The meta object literal for the '<em><b>Semantic Elements</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_MAPPING__SEMANTIC_ELEMENTS = eINSTANCE.getTreeMapping_SemanticElements();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.StyleUpdaterImpl
         * <em>Style Updater</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.StyleUpdaterImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getStyleUpdater()
         * @generated
         */
        EClass STYLE_UPDATER = eINSTANCE.getStyleUpdater();

        /**
         * The meta object literal for the '<em><b>Default Style</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference STYLE_UPDATER__DEFAULT_STYLE = eINSTANCE.getStyleUpdater_DefaultStyle();

        /**
         * The meta object literal for the '<em><b>Conditional Styles</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference STYLE_UPDATER__CONDITIONAL_STYLES = eINSTANCE.getStyleUpdater_ConditionalStyles();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeVariableImpl
         * <em>Tree Variable</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeVariableImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeVariable()
         * @generated
         */
        EClass TREE_VARIABLE = eINSTANCE.getTreeVariable();

        /**
         * The meta object literal for the '<em><b>Documentation</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TREE_VARIABLE__DOCUMENTATION = eINSTANCE.getTreeVariable_Documentation();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreeItemUpdaterImpl
         * <em>Tree Item Updater</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreeItemUpdaterImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemUpdater()
         * @generated
         */
        EClass TREE_ITEM_UPDATER = eINSTANCE.getTreeItemUpdater();

        /**
         * The meta object literal for the '<em><b>Direct Edit</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_UPDATER__DIRECT_EDIT = eINSTANCE.getTreeItemUpdater_DirectEdit();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.PrecedingSiblingsVariablesImpl
         * <em>Preceding Siblings Variables</em>}' class. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.PrecedingSiblingsVariablesImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getPrecedingSiblingsVariables()
         * @generated
         */
        EClass PRECEDING_SIBLINGS_VARIABLES = eINSTANCE.getPrecedingSiblingsVariables();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.TreeItemMappingContainer
         * <em>Tree Item Mapping Container</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.TreeItemMappingContainer
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeItemMappingContainer()
         * @generated
         */
        EClass TREE_ITEM_MAPPING_CONTAINER = eINSTANCE.getTreeItemMappingContainer();

        /**
         * The meta object literal for the '<em><b>Sub Item Mappings</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING_CONTAINER__SUB_ITEM_MAPPINGS = eINSTANCE.getTreeItemMappingContainer_SubItemMappings();

        /**
         * The meta object literal for the '<em><b>Drop Tools</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_ITEM_MAPPING_CONTAINER__DROP_TOOLS = eINSTANCE.getTreeItemMappingContainer_DropTools();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.impl.TreePopupMenuImpl
         * <em>Tree Popup Menu</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.impl.TreePopupMenuImpl
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreePopupMenu()
         * @generated
         */
        EClass TREE_POPUP_MENU = eINSTANCE.getTreePopupMenu();

        /**
         * The meta object literal for the '
         * <em><b>Menu Item Descriptions</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TREE_POPUP_MENU__MENU_ITEM_DESCRIPTIONS = eINSTANCE.getTreePopupMenu_MenuItemDescriptions();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.sirius.tree.description.TreeDragSource
         * <em>Tree Drag Source</em>}' enum. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.eclipse.sirius.tree.description.TreeDragSource
         * @see org.eclipse.sirius.tree.description.impl.DescriptionPackageImpl#getTreeDragSource()
         * @generated
         */
        EEnum TREE_DRAG_SOURCE = eINSTANCE.getTreeDragSource();

    }

} // DescriptionPackage
