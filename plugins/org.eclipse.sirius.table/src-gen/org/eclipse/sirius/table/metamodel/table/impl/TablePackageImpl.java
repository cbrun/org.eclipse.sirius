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
package org.eclipse.sirius.table.metamodel.table.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.sirius.table.metamodel.table.DCell;
import org.eclipse.sirius.table.metamodel.table.DCellStyle;
import org.eclipse.sirius.table.metamodel.table.DColumn;
import org.eclipse.sirius.table.metamodel.table.DFeatureColumn;
import org.eclipse.sirius.table.metamodel.table.DLine;
import org.eclipse.sirius.table.metamodel.table.DTable;
import org.eclipse.sirius.table.metamodel.table.DTableElement;
import org.eclipse.sirius.table.metamodel.table.DTableElementStyle;
import org.eclipse.sirius.table.metamodel.table.DTableElementSynchronizer;
import org.eclipse.sirius.table.metamodel.table.DTableElementUpdater;
import org.eclipse.sirius.table.metamodel.table.DTargetColumn;
import org.eclipse.sirius.table.metamodel.table.LineContainer;
import org.eclipse.sirius.table.metamodel.table.TableFactory;
import org.eclipse.sirius.table.metamodel.table.TablePackage;
import org.eclipse.sirius.table.metamodel.table.description.DescriptionPackage;
import org.eclipse.sirius.table.metamodel.table.description.impl.DescriptionPackageImpl;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class TablePackageImpl extends EPackageImpl implements TablePackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dTableEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dTableElementUpdaterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dTableElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass lineContainerEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dLineEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dCellEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dCellStyleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dColumnEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dTargetColumnEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dFeatureColumnEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dTableElementSynchronizerEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dTableElementStyleEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.sirius.table.metamodel.table.TablePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private TablePackageImpl() {
        super(eNS_URI, TableFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * 
     * <p>
     * This method is used to initialize {@link TablePackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static TablePackage init() {
        if (isInited)
            return (TablePackage) EPackage.Registry.INSTANCE.getEPackage(TablePackage.eNS_URI);

        // Obtain or create and register package
        TablePackageImpl theTablePackage = (TablePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TablePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TablePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ViewpointPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        DescriptionPackageImpl theDescriptionPackage = (DescriptionPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(DescriptionPackage.eNS_URI) instanceof DescriptionPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(DescriptionPackage.eNS_URI) : DescriptionPackage.eINSTANCE);

        // Create package meta-data objects
        theTablePackage.createPackageContents();
        theDescriptionPackage.createPackageContents();

        // Initialize created meta-data
        theTablePackage.initializePackageContents();
        theDescriptionPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTablePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TablePackage.eNS_URI, theTablePackage);
        return theTablePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDTable() {
        return dTableEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDTable_Columns() {
        return (EReference) dTableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDTable_Description() {
        return (EReference) dTableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDTable_HeaderColumnWidth() {
        return (EAttribute) dTableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDTableElementUpdater() {
        return dTableElementUpdaterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDTableElement() {
        return dTableElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDTableElement_TableElementMapping() {
        return (EReference) dTableElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLineContainer() {
        return lineContainerEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getLineContainer_Lines() {
        return (EReference) lineContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDLine() {
        return dLineEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDLine_Label() {
        return (EAttribute) dLineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDLine_OriginMapping() {
        return (EReference) dLineEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDLine_Visible() {
        return (EAttribute) dLineEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDLine_Collapsed() {
        return (EAttribute) dLineEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDLine_Cells() {
        return (EReference) dLineEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDLine_Container() {
        return (EReference) dLineEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDLine_OrderedCells() {
        return (EReference) dLineEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDLine_CurrentStyle() {
        return (EReference) dLineEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDCell() {
        return dCellEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDCell_Label() {
        return (EAttribute) dCellEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCell_Line() {
        return (EReference) dCellEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCell_Column() {
        return (EReference) dCellEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCell_CurrentStyle() {
        return (EReference) dCellEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCell_Updater() {
        return (EReference) dCellEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCell_IntersectionMapping() {
        return (EReference) dCellEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDCellStyle() {
        return dCellStyleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCellStyle_ForegroundStyleOrigin() {
        return (EReference) dCellStyleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDCellStyle_BackgroundStyleOrigin() {
        return (EReference) dCellStyleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDColumn() {
        return dColumnEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDColumn_Label() {
        return (EAttribute) dColumnEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDColumn_Cells() {
        return (EReference) dColumnEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDColumn_OriginMapping() {
        return (EReference) dColumnEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDColumn_Table() {
        return (EReference) dColumnEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDColumn_OrderedCells() {
        return (EReference) dColumnEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDColumn_Visible() {
        return (EAttribute) dColumnEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDColumn_Width() {
        return (EAttribute) dColumnEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDColumn_CurrentStyle() {
        return (EReference) dColumnEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDTargetColumn() {
        return dTargetColumnEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDFeatureColumn() {
        return dFeatureColumnEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDFeatureColumn_FeatureName() {
        return (EAttribute) dFeatureColumnEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDTableElementSynchronizer() {
        return dTableElementSynchronizerEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDTableElementStyle() {
        return dTableElementStyleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDTableElementStyle_LabelSize() {
        return (EAttribute) dTableElementStyleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDTableElementStyle_LabelFormat() {
        return (EAttribute) dTableElementStyleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDTableElementStyle_ForegroundColor() {
        return (EReference) dTableElementStyleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDTableElementStyle_BackgroundColor() {
        return (EReference) dTableElementStyleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDTableElementStyle_DefaultForegroundStyle() {
        return (EAttribute) dTableElementStyleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDTableElementStyle_DefaultBackgroundStyle() {
        return (EAttribute) dTableElementStyleEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TableFactory getTableFactory() {
        return (TableFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        dTableEClass = createEClass(DTABLE);
        createEReference(dTableEClass, DTABLE__COLUMNS);
        createEAttribute(dTableEClass, DTABLE__HEADER_COLUMN_WIDTH);
        createEReference(dTableEClass, DTABLE__DESCRIPTION);

        dTableElementUpdaterEClass = createEClass(DTABLE_ELEMENT_UPDATER);

        dTableElementEClass = createEClass(DTABLE_ELEMENT);
        createEReference(dTableElementEClass, DTABLE_ELEMENT__TABLE_ELEMENT_MAPPING);

        lineContainerEClass = createEClass(LINE_CONTAINER);
        createEReference(lineContainerEClass, LINE_CONTAINER__LINES);

        dLineEClass = createEClass(DLINE);
        createEAttribute(dLineEClass, DLINE__LABEL);
        createEReference(dLineEClass, DLINE__ORIGIN_MAPPING);
        createEAttribute(dLineEClass, DLINE__VISIBLE);
        createEAttribute(dLineEClass, DLINE__COLLAPSED);
        createEReference(dLineEClass, DLINE__CELLS);
        createEReference(dLineEClass, DLINE__CONTAINER);
        createEReference(dLineEClass, DLINE__ORDERED_CELLS);
        createEReference(dLineEClass, DLINE__CURRENT_STYLE);

        dCellEClass = createEClass(DCELL);
        createEAttribute(dCellEClass, DCELL__LABEL);
        createEReference(dCellEClass, DCELL__LINE);
        createEReference(dCellEClass, DCELL__COLUMN);
        createEReference(dCellEClass, DCELL__CURRENT_STYLE);
        createEReference(dCellEClass, DCELL__UPDATER);
        createEReference(dCellEClass, DCELL__INTERSECTION_MAPPING);

        dCellStyleEClass = createEClass(DCELL_STYLE);
        createEReference(dCellStyleEClass, DCELL_STYLE__FOREGROUND_STYLE_ORIGIN);
        createEReference(dCellStyleEClass, DCELL_STYLE__BACKGROUND_STYLE_ORIGIN);

        dColumnEClass = createEClass(DCOLUMN);
        createEAttribute(dColumnEClass, DCOLUMN__LABEL);
        createEReference(dColumnEClass, DCOLUMN__CELLS);
        createEReference(dColumnEClass, DCOLUMN__ORIGIN_MAPPING);
        createEReference(dColumnEClass, DCOLUMN__TABLE);
        createEReference(dColumnEClass, DCOLUMN__ORDERED_CELLS);
        createEAttribute(dColumnEClass, DCOLUMN__VISIBLE);
        createEAttribute(dColumnEClass, DCOLUMN__WIDTH);
        createEReference(dColumnEClass, DCOLUMN__CURRENT_STYLE);

        dTargetColumnEClass = createEClass(DTARGET_COLUMN);

        dFeatureColumnEClass = createEClass(DFEATURE_COLUMN);
        createEAttribute(dFeatureColumnEClass, DFEATURE_COLUMN__FEATURE_NAME);

        dTableElementSynchronizerEClass = createEClass(DTABLE_ELEMENT_SYNCHRONIZER);

        dTableElementStyleEClass = createEClass(DTABLE_ELEMENT_STYLE);
        createEAttribute(dTableElementStyleEClass, DTABLE_ELEMENT_STYLE__LABEL_SIZE);
        createEAttribute(dTableElementStyleEClass, DTABLE_ELEMENT_STYLE__LABEL_FORMAT);
        createEReference(dTableElementStyleEClass, DTABLE_ELEMENT_STYLE__FOREGROUND_COLOR);
        createEReference(dTableElementStyleEClass, DTABLE_ELEMENT_STYLE__BACKGROUND_COLOR);
        createEAttribute(dTableElementStyleEClass, DTABLE_ELEMENT_STYLE__DEFAULT_FOREGROUND_STYLE);
        createEAttribute(dTableElementStyleEClass, DTABLE_ELEMENT_STYLE__DEFAULT_BACKGROUND_STYLE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        DescriptionPackage theDescriptionPackage = (DescriptionPackage) EPackage.Registry.INSTANCE.getEPackage(DescriptionPackage.eNS_URI);
        ViewpointPackage theViewpointPackage = (ViewpointPackage) EPackage.Registry.INSTANCE.getEPackage(ViewpointPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Add subpackages
        getESubpackages().add(theDescriptionPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        dTableEClass.getESuperTypes().add(theViewpointPackage.getDRepresentation());
        dTableEClass.getESuperTypes().add(this.getLineContainer());
        dTableEClass.getESuperTypes().add(this.getDTableElementUpdater());
        dTableElementEClass.getESuperTypes().add(theViewpointPackage.getDRepresentationElement());
        lineContainerEClass.getESuperTypes().add(theViewpointPackage.getDSemanticDecorator());
        dLineEClass.getESuperTypes().add(this.getLineContainer());
        dLineEClass.getESuperTypes().add(this.getDTableElement());
        dLineEClass.getESuperTypes().add(this.getDTableElementUpdater());
        dCellEClass.getESuperTypes().add(theViewpointPackage.getDSemanticDecorator());
        dCellEClass.getESuperTypes().add(this.getDTableElement());
        dCellEClass.getESuperTypes().add(this.getDTableElementUpdater());
        dCellStyleEClass.getESuperTypes().add(this.getDTableElementStyle());
        dColumnEClass.getESuperTypes().add(this.getDTableElement());
        dTargetColumnEClass.getESuperTypes().add(theViewpointPackage.getDSemanticDecorator());
        dTargetColumnEClass.getESuperTypes().add(this.getDColumn());
        dTargetColumnEClass.getESuperTypes().add(this.getDTableElementUpdater());
        dFeatureColumnEClass.getESuperTypes().add(this.getDColumn());

        // Initialize classes and features; add operations and parameters
        initEClass(dTableEClass, DTable.class, "DTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDTable_Columns(), this.getDColumn(), this.getDColumn_Table(), "columns", null, 0, -1, DTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDTable_HeaderColumnWidth(), theEcorePackage.getEInt(), "headerColumnWidth", null, 0, 1, DTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDTable_Description(), theDescriptionPackage.getTableDescription(), null, "description", null, 0, 1, DTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dTableElementUpdaterEClass, DTableElementUpdater.class, "DTableElementUpdater", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        EOperation op = addEOperation(dTableElementUpdaterEClass, null, "activate", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDTableElementSynchronizer(), "sync", 1, 1, IS_UNIQUE, IS_ORDERED);

        addEOperation(dTableElementUpdaterEClass, null, "deactivate", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(dTableElementEClass, DTableElement.class, "DTableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDTableElement_TableElementMapping(), theDescriptionPackage.getTableMapping(), null, "tableElementMapping", null, 0, 1, DTableElement.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(lineContainerEClass, LineContainer.class, "LineContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLineContainer_Lines(), this.getDLine(), this.getDLine_Container(), "lines", null, 0, -1, LineContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dLineEClass, DLine.class, "DLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDLine_Label(), theEcorePackage.getEString(), "label", null, 0, 1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getDLine_OriginMapping(), theDescriptionPackage.getLineMapping(), null, "originMapping", null, 1, 1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDLine_Visible(), theEcorePackage.getEBoolean(), "visible", "true", 1, 1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDLine_Collapsed(), theEcorePackage.getEBoolean(), "collapsed", "false", 1, 1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getDLine_Cells(), this.getDCell(), this.getDCell_Line(), "cells", null, 0, -1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDLine_Container(), this.getLineContainer(), this.getLineContainer_Lines(), "container", null, 0, 1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDLine_OrderedCells(), this.getDCell(), null, "orderedCells", null, 0, -1, DLine.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDLine_CurrentStyle(), this.getDTableElementStyle(), null, "currentStyle", null, 0, 1, DLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dCellEClass, DCell.class, "DCell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDCell_Label(), theEcorePackage.getEString(), "label", null, 0, 1, DCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getDCell_Line(), this.getDLine(), this.getDLine_Cells(), "line", null, 0, 1, DCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDCell_Column(), this.getDColumn(), this.getDColumn_Cells(), "column", null, 0, 1, DCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDCell_CurrentStyle(), this.getDCellStyle(), null, "currentStyle", null, 0, 1, DCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDCell_Updater(), theDescriptionPackage.getCellUpdater(), null, "updater", null, 0, 1, DCell.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDCell_IntersectionMapping(), theDescriptionPackage.getIntersectionMapping(), null, "intersectionMapping", null, 0, 1, DCell.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dCellStyleEClass, DCellStyle.class, "DCellStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDCellStyle_ForegroundStyleOrigin(), theDescriptionPackage.getTableMapping(), null, "foregroundStyleOrigin", null, 0, 1, DCellStyle.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDCellStyle_BackgroundStyleOrigin(), theDescriptionPackage.getTableMapping(), null, "backgroundStyleOrigin", null, 0, 1, DCellStyle.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dColumnEClass, DColumn.class, "DColumn", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDColumn_Label(), theEcorePackage.getEString(), "label", null, 0, 1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getDColumn_Cells(), this.getDCell(), this.getDCell_Column(), "cells", null, 0, -1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDColumn_OriginMapping(), theDescriptionPackage.getColumnMapping(), null, "originMapping", null, 1, 1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDColumn_Table(), this.getDTable(), this.getDTable_Columns(), "table", null, 0, 1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDColumn_OrderedCells(), this.getDCell(), null, "orderedCells", null, 0, -1, DColumn.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDColumn_Visible(), theEcorePackage.getEBoolean(), "visible", "true", 1, 1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDColumn_Width(), theEcorePackage.getEInt(), "width", null, 0, 1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getDColumn_CurrentStyle(), this.getDTableElementStyle(), null, "currentStyle", null, 0, 1, DColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dTargetColumnEClass, DTargetColumn.class, "DTargetColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(dFeatureColumnEClass, DFeatureColumn.class, "DFeatureColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDFeatureColumn_FeatureName(), theEcorePackage.getEString(), "featureName", null, 1, 1, DFeatureColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dTableElementSynchronizerEClass, DTableElementSynchronizer.class, "DTableElementSynchronizer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = addEOperation(dTableElementSynchronizerEClass, null, "refresh", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDCell(), "cell", 1, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(dTableElementSynchronizerEClass, null, "refresh", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDColumn(), "column", 1, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(dTableElementSynchronizerEClass, null, "refresh", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getDLine(), "line", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(dTableElementStyleEClass, DTableElementStyle.class, "DTableElementStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDTableElementStyle_LabelSize(), theEcorePackage.getEInt(), "labelSize", "8", 0, 1, DTableElementStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDTableElementStyle_LabelFormat(), theViewpointPackage.getFontFormat(), "labelFormat", "normal", 0, 1, DTableElementStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDTableElementStyle_ForegroundColor(), theViewpointPackage.getRGBValues(), null, "foregroundColor", null, 0, 1, DTableElementStyle.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDTableElementStyle_BackgroundColor(), theViewpointPackage.getRGBValues(), null, "backgroundColor", null, 0, 1, DTableElementStyle.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDTableElementStyle_DefaultForegroundStyle(), theEcorePackage.getEBoolean(), "defaultForegroundStyle", "false", 0, 1, DTableElementStyle.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDTableElementStyle_DefaultBackgroundStyle(), theEcorePackage.getEBoolean(), "defaultBackgroundStyle", "false", 0, 1, DTableElementStyle.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // TablePackageImpl
