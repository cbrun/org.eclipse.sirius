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
package org.eclipse.sirius.diagram.sequence.description.tool.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.sirius.diagram.sequence.SequencePackage;
import org.eclipse.sirius.diagram.sequence.description.DescriptionPackage;
import org.eclipse.sirius.diagram.sequence.description.impl.DescriptionPackageImpl;
import org.eclipse.sirius.diagram.sequence.description.tool.CombinedFragmentCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.CoveringElementCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.ExecutionCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.InstanceRoleCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.InstanceRoleReorderTool;
import org.eclipse.sirius.diagram.sequence.description.tool.InteractionUseCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.LifelineCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.MessageCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.ObservationPointCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.OperandCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.OrderedElementCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.ReorderTool;
import org.eclipse.sirius.diagram.sequence.description.tool.SequenceDiagramToolDescription;
import org.eclipse.sirius.diagram.sequence.description.tool.StateCreationTool;
import org.eclipse.sirius.diagram.sequence.description.tool.ToolFactory;
import org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage;
import org.eclipse.sirius.diagram.sequence.impl.SequencePackageImpl;
import org.eclipse.sirius.diagram.sequence.ordering.OrderingPackage;
import org.eclipse.sirius.diagram.sequence.ordering.impl.OrderingPackageImpl;
import org.eclipse.sirius.diagram.sequence.template.TemplatePackage;
import org.eclipse.sirius.diagram.sequence.template.impl.TemplatePackageImpl;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ToolPackageImpl extends EPackageImpl implements ToolPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass sequenceDiagramToolDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass orderedElementCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass coveringElementCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass instanceRoleCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass lifelineCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass messageCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass executionCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stateCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass reorderToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass instanceRoleReorderToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass observationPointCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass interactionUseCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass combinedFragmentCreationToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass operandCreationToolEClass = null;

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
     * @see org.eclipse.sirius.diagram.sequence.description.tool.ToolPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ToolPackageImpl() {
        super(eNS_URI, ToolFactory.eINSTANCE);
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
     * This method is used to initialize {@link ToolPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they
     * should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ToolPackage init() {
        if (isInited)
            return (ToolPackage) EPackage.Registry.INSTANCE.getEPackage(ToolPackage.eNS_URI);

        // Obtain or create and register package
        ToolPackageImpl theToolPackage = (ToolPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ToolPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ToolPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ViewpointPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        SequencePackageImpl theSequencePackage = (SequencePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SequencePackage.eNS_URI) instanceof SequencePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SequencePackage.eNS_URI) : SequencePackage.eINSTANCE);
        DescriptionPackageImpl theDescriptionPackage = (DescriptionPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(DescriptionPackage.eNS_URI) instanceof DescriptionPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(DescriptionPackage.eNS_URI) : DescriptionPackage.eINSTANCE);
        OrderingPackageImpl theOrderingPackage = (OrderingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(OrderingPackage.eNS_URI) instanceof OrderingPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(OrderingPackage.eNS_URI) : OrderingPackage.eINSTANCE);
        TemplatePackageImpl theTemplatePackage = (TemplatePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TemplatePackage.eNS_URI) instanceof TemplatePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(TemplatePackage.eNS_URI) : TemplatePackage.eINSTANCE);

        // Create package meta-data objects
        theToolPackage.createPackageContents();
        theSequencePackage.createPackageContents();
        theDescriptionPackage.createPackageContents();
        theOrderingPackage.createPackageContents();
        theTemplatePackage.createPackageContents();

        // Initialize created meta-data
        theToolPackage.initializePackageContents();
        theSequencePackage.initializePackageContents();
        theDescriptionPackage.initializePackageContents();
        theOrderingPackage.initializePackageContents();
        theTemplatePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theToolPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ToolPackage.eNS_URI, theToolPackage);
        return theToolPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSequenceDiagramToolDescription() {
        return sequenceDiagramToolDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOrderedElementCreationTool() {
        return orderedElementCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOrderedElementCreationTool_StartingEndPredecessor() {
        return (EReference) orderedElementCreationToolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOrderedElementCreationTool_FinishingEndPredecessor() {
        return (EReference) orderedElementCreationToolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCoveringElementCreationTool() {
        return coveringElementCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCoveringElementCreationTool_CoveredLifelines() {
        return (EReference) coveringElementCreationToolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInstanceRoleCreationTool() {
        return instanceRoleCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstanceRoleCreationTool_Predecessor() {
        return (EReference) instanceRoleCreationToolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLifelineCreationTool() {
        return lifelineCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMessageCreationTool() {
        return messageCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getExecutionCreationTool() {
        return executionCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getStateCreationTool() {
        return stateCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getReorderTool() {
        return reorderToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getReorderTool_Mappings() {
        return (EReference) reorderToolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getReorderTool_StartingEndPredecessorBefore() {
        return (EReference) reorderToolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getReorderTool_StartingEndPredecessorAfter() {
        return (EReference) reorderToolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getReorderTool_FinishingEndPredecessorBefore() {
        return (EReference) reorderToolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getReorderTool_FinishingEndPredecessorAfter() {
        return (EReference) reorderToolEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getReorderTool_OnEventMovedOperation() {
        return (EReference) reorderToolEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInstanceRoleReorderTool() {
        return instanceRoleReorderToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstanceRoleReorderTool_Mappings() {
        return (EReference) instanceRoleReorderToolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstanceRoleReorderTool_PredecessorBefore() {
        return (EReference) instanceRoleReorderToolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstanceRoleReorderTool_PredecessorAfter() {
        return (EReference) instanceRoleReorderToolEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getInstanceRoleReorderTool_InstanceRoleMoved() {
        return (EReference) instanceRoleReorderToolEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getObservationPointCreationTool() {
        return observationPointCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInteractionUseCreationTool() {
        return interactionUseCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCombinedFragmentCreationTool() {
        return combinedFragmentCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOperandCreationTool() {
        return operandCreationToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ToolFactory getToolFactory() {
        return (ToolFactory) getEFactoryInstance();
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
        sequenceDiagramToolDescriptionEClass = createEClass(SEQUENCE_DIAGRAM_TOOL_DESCRIPTION);

        orderedElementCreationToolEClass = createEClass(ORDERED_ELEMENT_CREATION_TOOL);
        createEReference(orderedElementCreationToolEClass, ORDERED_ELEMENT_CREATION_TOOL__STARTING_END_PREDECESSOR);
        createEReference(orderedElementCreationToolEClass, ORDERED_ELEMENT_CREATION_TOOL__FINISHING_END_PREDECESSOR);

        coveringElementCreationToolEClass = createEClass(COVERING_ELEMENT_CREATION_TOOL);
        createEReference(coveringElementCreationToolEClass, COVERING_ELEMENT_CREATION_TOOL__COVERED_LIFELINES);

        instanceRoleCreationToolEClass = createEClass(INSTANCE_ROLE_CREATION_TOOL);
        createEReference(instanceRoleCreationToolEClass, INSTANCE_ROLE_CREATION_TOOL__PREDECESSOR);

        lifelineCreationToolEClass = createEClass(LIFELINE_CREATION_TOOL);

        messageCreationToolEClass = createEClass(MESSAGE_CREATION_TOOL);

        executionCreationToolEClass = createEClass(EXECUTION_CREATION_TOOL);

        stateCreationToolEClass = createEClass(STATE_CREATION_TOOL);

        interactionUseCreationToolEClass = createEClass(INTERACTION_USE_CREATION_TOOL);

        combinedFragmentCreationToolEClass = createEClass(COMBINED_FRAGMENT_CREATION_TOOL);

        operandCreationToolEClass = createEClass(OPERAND_CREATION_TOOL);

        observationPointCreationToolEClass = createEClass(OBSERVATION_POINT_CREATION_TOOL);

        reorderToolEClass = createEClass(REORDER_TOOL);
        createEReference(reorderToolEClass, REORDER_TOOL__MAPPINGS);
        createEReference(reorderToolEClass, REORDER_TOOL__STARTING_END_PREDECESSOR_BEFORE);
        createEReference(reorderToolEClass, REORDER_TOOL__STARTING_END_PREDECESSOR_AFTER);
        createEReference(reorderToolEClass, REORDER_TOOL__FINISHING_END_PREDECESSOR_BEFORE);
        createEReference(reorderToolEClass, REORDER_TOOL__FINISHING_END_PREDECESSOR_AFTER);
        createEReference(reorderToolEClass, REORDER_TOOL__ON_EVENT_MOVED_OPERATION);

        instanceRoleReorderToolEClass = createEClass(INSTANCE_ROLE_REORDER_TOOL);
        createEReference(instanceRoleReorderToolEClass, INSTANCE_ROLE_REORDER_TOOL__MAPPINGS);
        createEReference(instanceRoleReorderToolEClass, INSTANCE_ROLE_REORDER_TOOL__PREDECESSOR_BEFORE);
        createEReference(instanceRoleReorderToolEClass, INSTANCE_ROLE_REORDER_TOOL__PREDECESSOR_AFTER);
        createEReference(instanceRoleReorderToolEClass, INSTANCE_ROLE_REORDER_TOOL__INSTANCE_ROLE_MOVED);
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
        org.eclipse.sirius.viewpoint.description.tool.ToolPackage theToolPackage_1 = (org.eclipse.sirius.viewpoint.description.tool.ToolPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.eclipse.sirius.viewpoint.description.tool.ToolPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        instanceRoleCreationToolEClass.getESuperTypes().add(theToolPackage_1.getNodeCreationDescription());
        instanceRoleCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        lifelineCreationToolEClass.getESuperTypes().add(theToolPackage_1.getContainerCreationDescription());
        lifelineCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        messageCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        messageCreationToolEClass.getESuperTypes().add(theToolPackage_1.getEdgeCreationDescription());
        messageCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        executionCreationToolEClass.getESuperTypes().add(theToolPackage_1.getNodeCreationDescription());
        executionCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        executionCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        stateCreationToolEClass.getESuperTypes().add(theToolPackage_1.getNodeCreationDescription());
        stateCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        stateCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        interactionUseCreationToolEClass.getESuperTypes().add(theToolPackage_1.getContainerCreationDescription());
        interactionUseCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        interactionUseCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        interactionUseCreationToolEClass.getESuperTypes().add(this.getCoveringElementCreationTool());
        combinedFragmentCreationToolEClass.getESuperTypes().add(theToolPackage_1.getContainerCreationDescription());
        combinedFragmentCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        combinedFragmentCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        combinedFragmentCreationToolEClass.getESuperTypes().add(this.getCoveringElementCreationTool());
        operandCreationToolEClass.getESuperTypes().add(theToolPackage_1.getContainerCreationDescription());
        operandCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        operandCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        observationPointCreationToolEClass.getESuperTypes().add(theToolPackage_1.getNodeCreationDescription());
        observationPointCreationToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        observationPointCreationToolEClass.getESuperTypes().add(this.getOrderedElementCreationTool());
        reorderToolEClass.getESuperTypes().add(theToolPackage_1.getAbstractToolDescription());
        reorderToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());
        instanceRoleReorderToolEClass.getESuperTypes().add(theToolPackage_1.getAbstractToolDescription());
        instanceRoleReorderToolEClass.getESuperTypes().add(this.getSequenceDiagramToolDescription());

        // Initialize classes and features; add operations and parameters
        initEClass(sequenceDiagramToolDescriptionEClass, SequenceDiagramToolDescription.class, "SequenceDiagramToolDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(orderedElementCreationToolEClass, OrderedElementCreationTool.class, "OrderedElementCreationTool", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOrderedElementCreationTool_StartingEndPredecessor(), theDescriptionPackage.getMessageEndVariable(), null, "startingEndPredecessor", null, 0, 1,
                OrderedElementCreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOrderedElementCreationTool_FinishingEndPredecessor(), theDescriptionPackage.getMessageEndVariable(), null, "finishingEndPredecessor", null, 0, 1,
                OrderedElementCreationTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(coveringElementCreationToolEClass, CoveringElementCreationTool.class, "CoveringElementCreationTool", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCoveringElementCreationTool_CoveredLifelines(), theDescriptionPackage.getCoveredLifelinesVariable(), null, "coveredLifelines", null, 1, 1, CoveringElementCreationTool.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(instanceRoleCreationToolEClass, InstanceRoleCreationTool.class, "InstanceRoleCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInstanceRoleCreationTool_Predecessor(), theToolPackage_1.getElementVariable(), null, "predecessor", null, 0, 1, InstanceRoleCreationTool.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lifelineCreationToolEClass, LifelineCreationTool.class, "LifelineCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(messageCreationToolEClass, MessageCreationTool.class, "MessageCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(executionCreationToolEClass, ExecutionCreationTool.class, "ExecutionCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stateCreationToolEClass, StateCreationTool.class, "StateCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(interactionUseCreationToolEClass, InteractionUseCreationTool.class, "InteractionUseCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(combinedFragmentCreationToolEClass, CombinedFragmentCreationTool.class, "CombinedFragmentCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(operandCreationToolEClass, OperandCreationTool.class, "OperandCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(observationPointCreationToolEClass, ObservationPointCreationTool.class, "ObservationPointCreationTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(reorderToolEClass, ReorderTool.class, "ReorderTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReorderTool_Mappings(), theDescriptionPackage.getEventMapping(), null, "mappings", null, 0, -1, ReorderTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReorderTool_StartingEndPredecessorBefore(), theDescriptionPackage.getMessageEndVariable(), null, "startingEndPredecessorBefore", null, 0, 1, ReorderTool.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReorderTool_StartingEndPredecessorAfter(), theDescriptionPackage.getMessageEndVariable(), null, "startingEndPredecessorAfter", null, 0, 1, ReorderTool.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReorderTool_FinishingEndPredecessorBefore(), theDescriptionPackage.getMessageEndVariable(), null, "finishingEndPredecessorBefore", null, 0, 1, ReorderTool.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReorderTool_FinishingEndPredecessorAfter(), theDescriptionPackage.getMessageEndVariable(), null, "finishingEndPredecessorAfter", null, 0, 1, ReorderTool.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReorderTool_OnEventMovedOperation(), theToolPackage_1.getInitialOperation(), null, "onEventMovedOperation", null, 1, 1, ReorderTool.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(instanceRoleReorderToolEClass, InstanceRoleReorderTool.class, "InstanceRoleReorderTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInstanceRoleReorderTool_Mappings(), theDescriptionPackage.getInstanceRoleMapping(), null, "mappings", null, 0, -1, InstanceRoleReorderTool.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInstanceRoleReorderTool_PredecessorBefore(), theToolPackage_1.getElementVariable(), null, "predecessorBefore", null, 0, 1, InstanceRoleReorderTool.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInstanceRoleReorderTool_PredecessorAfter(), theToolPackage_1.getElementVariable(), null, "predecessorAfter", null, 0, 1, InstanceRoleReorderTool.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInstanceRoleReorderTool_InstanceRoleMoved(), theToolPackage_1.getInitialOperation(), null, "instanceRoleMoved", null, 1, 1, InstanceRoleReorderTool.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create annotations
        // toolVariable
        createToolVariableAnnotations();
    }

    /**
     * Initializes the annotations for <b>toolVariable</b>. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createToolVariableAnnotations() {
        String source = "toolVariable";
        addAnnotation(getOrderedElementCreationTool_StartingEndPredecessor(), source, new String[] { "name", "startingEndPredecessor" });
        addAnnotation(getOrderedElementCreationTool_FinishingEndPredecessor(), source, new String[] { "name", "finishingEndPredecessor" });
        addAnnotation(getInstanceRoleCreationTool_Predecessor(), source, new String[] { "name", "predecessor" });
        addAnnotation(getReorderTool_StartingEndPredecessorBefore(), source, new String[] { "name", "startingEndPredecessorBefore" });
        addAnnotation(getReorderTool_StartingEndPredecessorAfter(), source, new String[] { "name", "startingEndPredecessorAfter" });
        addAnnotation(getReorderTool_FinishingEndPredecessorBefore(), source, new String[] { "name", "finishingEndPredecessorBefore" });
        addAnnotation(getReorderTool_FinishingEndPredecessorAfter(), source, new String[] { "name", "finishingEndPredecessorAfter" });
        addAnnotation(getInstanceRoleReorderTool_PredecessorBefore(), source, new String[] { "name", "predecessorBefore" });
        addAnnotation(getInstanceRoleReorderTool_PredecessorAfter(), source, new String[] { "name", "predecessorAfter" });
    }

} // ToolPackageImpl
