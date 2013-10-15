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
package org.eclipse.sirius.viewpoint.description.tool.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.IdentifiedElement;
import org.eclipse.sirius.viewpoint.description.impl.DocumentedElementImpl;
import org.eclipse.sirius.viewpoint.description.tool.AbstractToolDescription;
import org.eclipse.sirius.viewpoint.description.tool.ToolFilterDescription;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Tool Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.viewpoint.description.tool.impl.AbstractToolDescriptionImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.viewpoint.description.tool.impl.AbstractToolDescriptionImpl#getLabel
 * <em>Label</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.viewpoint.description.tool.impl.AbstractToolDescriptionImpl#getPrecondition
 * <em>Precondition</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.viewpoint.description.tool.impl.AbstractToolDescriptionImpl#isForceRefresh
 * <em>Force Refresh</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.viewpoint.description.tool.impl.AbstractToolDescriptionImpl#getFilters
 * <em>Filters</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractToolDescriptionImpl extends DocumentedElementImpl implements AbstractToolDescription {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getPrecondition()
     * <em>Precondition</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPrecondition()
     * @generated
     * @ordered
     */
    protected static final String PRECONDITION_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPrecondition()
     * @generated
     * @ordered
     */
    protected String precondition = PRECONDITION_EDEFAULT;

    /**
     * The default value of the '{@link #isForceRefresh()
     * <em>Force Refresh</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isForceRefresh()
     * @generated
     * @ordered
     */
    protected static final boolean FORCE_REFRESH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForceRefresh() <em>Force Refresh</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isForceRefresh()
     * @generated
     * @ordered
     */
    protected boolean forceRefresh = FORCE_REFRESH_EDEFAULT;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EList<ToolFilterDescription> filters;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractToolDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ToolPackage.Literals.ABSTRACT_TOOL_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPrecondition() {
        return precondition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPrecondition(String newPrecondition) {
        String oldPrecondition = precondition;
        precondition = newPrecondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION, oldPrecondition, precondition));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isForceRefresh() {
        return forceRefresh;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setForceRefresh(boolean newForceRefresh) {
        boolean oldForceRefresh = forceRefresh;
        forceRefresh = newForceRefresh;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH, oldForceRefresh, forceRefresh));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ToolFilterDescription> getFilters() {
        if (filters == null) {
            filters = new EObjectContainmentEList.Resolving<ToolFilterDescription>(ToolFilterDescription.class, this, ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS);
        }
        return filters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS:
            return ((InternalEList<?>) getFilters()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME:
            return getName();
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL:
            return getLabel();
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION:
            return getPrecondition();
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH:
            return isForceRefresh();
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS:
            return getFilters();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME:
            setName((String) newValue);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL:
            setLabel((String) newValue);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION:
            setPrecondition((String) newValue);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH:
            setForceRefresh((Boolean) newValue);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS:
            getFilters().clear();
            getFilters().addAll((Collection<? extends ToolFilterDescription>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME:
            setName(NAME_EDEFAULT);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL:
            setLabel(LABEL_EDEFAULT);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION:
            setPrecondition(PRECONDITION_EDEFAULT);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH:
            setForceRefresh(FORCE_REFRESH_EDEFAULT);
            return;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS:
            getFilters().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL:
            return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__PRECONDITION:
            return PRECONDITION_EDEFAULT == null ? precondition != null : !PRECONDITION_EDEFAULT.equals(precondition);
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FORCE_REFRESH:
            return forceRefresh != FORCE_REFRESH_EDEFAULT;
        case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__FILTERS:
            return filters != null && !filters.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == IdentifiedElement.class) {
            switch (derivedFeatureID) {
            case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME:
                return DescriptionPackage.IDENTIFIED_ELEMENT__NAME;
            case ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL:
                return DescriptionPackage.IDENTIFIED_ELEMENT__LABEL;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == IdentifiedElement.class) {
            switch (baseFeatureID) {
            case DescriptionPackage.IDENTIFIED_ELEMENT__NAME:
                return ToolPackage.ABSTRACT_TOOL_DESCRIPTION__NAME;
            case DescriptionPackage.IDENTIFIED_ELEMENT__LABEL:
                return ToolPackage.ABSTRACT_TOOL_DESCRIPTION__LABEL;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", label: ");
        result.append(label);
        result.append(", precondition: ");
        result.append(precondition);
        result.append(", forceRefresh: ");
        result.append(forceRefresh);
        result.append(')');
        return result.toString();
    }

} // AbstractToolDescriptionImpl