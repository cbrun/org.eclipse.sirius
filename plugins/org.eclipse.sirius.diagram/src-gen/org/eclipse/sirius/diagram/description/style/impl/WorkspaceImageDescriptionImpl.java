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
package org.eclipse.sirius.diagram.description.style.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.sirius.diagram.description.style.ContainerStyleDescription;
import org.eclipse.sirius.diagram.description.style.RoundedCornerStyleDescription;
import org.eclipse.sirius.diagram.description.style.StylePackage;
import org.eclipse.sirius.diagram.description.style.WorkspaceImageDescription;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Workspace Image Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.sirius.diagram.description.style.impl.WorkspaceImageDescriptionImpl#getArcWidth
 * <em>Arc Width</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.diagram.description.style.impl.WorkspaceImageDescriptionImpl#getArcHeight
 * <em>Arc Height</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.diagram.description.style.impl.WorkspaceImageDescriptionImpl#isRoundedCorner
 * <em>Rounded Corner</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.diagram.description.style.impl.WorkspaceImageDescriptionImpl#getWorkspacePath
 * <em>Workspace Path</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkspaceImageDescriptionImpl extends NodeStyleDescriptionImpl implements WorkspaceImageDescription {
    /**
     * The default value of the '{@link #getArcWidth() <em>Arc Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArcWidth()
     * @generated
     * @ordered
     */
    protected static final Integer ARC_WIDTH_EDEFAULT = new Integer(1);

    /**
     * The cached value of the '{@link #getArcWidth() <em>Arc Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArcWidth()
     * @generated
     * @ordered
     */
    protected Integer arcWidth = ARC_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getArcHeight() <em>Arc Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArcHeight()
     * @generated
     * @ordered
     */
    protected static final Integer ARC_HEIGHT_EDEFAULT = new Integer(1);

    /**
     * The cached value of the '{@link #getArcHeight() <em>Arc Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArcHeight()
     * @generated
     * @ordered
     */
    protected Integer arcHeight = ARC_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #isRoundedCorner()
     * <em>Rounded Corner</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isRoundedCorner()
     * @generated
     * @ordered
     */
    protected static final boolean ROUNDED_CORNER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRoundedCorner()
     * <em>Rounded Corner</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isRoundedCorner()
     * @generated
     * @ordered
     */
    protected boolean roundedCorner = ROUNDED_CORNER_EDEFAULT;

    /**
     * The default value of the '{@link #getWorkspacePath()
     * <em>Workspace Path</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWorkspacePath()
     * @generated
     * @ordered
     */
    protected static final String WORKSPACE_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWorkspacePath()
     * <em>Workspace Path</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWorkspacePath()
     * @generated
     * @ordered
     */
    protected String workspacePath = WORKSPACE_PATH_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WorkspaceImageDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StylePackage.Literals.WORKSPACE_IMAGE_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getArcWidth() {
        return arcWidth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setArcWidth(Integer newArcWidth) {
        Integer oldArcWidth = arcWidth;
        arcWidth = newArcWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH, oldArcWidth, arcWidth));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getArcHeight() {
        return arcHeight;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setArcHeight(Integer newArcHeight) {
        Integer oldArcHeight = arcHeight;
        arcHeight = newArcHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT, oldArcHeight, arcHeight));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isRoundedCorner() {
        return roundedCorner;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRoundedCorner(boolean newRoundedCorner) {
        boolean oldRoundedCorner = roundedCorner;
        roundedCorner = newRoundedCorner;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER, oldRoundedCorner, roundedCorner));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getWorkspacePath() {
        return workspacePath;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setWorkspacePath(String newWorkspacePath) {
        String oldWorkspacePath = workspacePath;
        workspacePath = newWorkspacePath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.WORKSPACE_IMAGE_DESCRIPTION__WORKSPACE_PATH, oldWorkspacePath, workspacePath));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH:
            return getArcWidth();
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT:
            return getArcHeight();
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER:
            return isRoundedCorner();
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__WORKSPACE_PATH:
            return getWorkspacePath();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH:
            setArcWidth((Integer) newValue);
            return;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT:
            setArcHeight((Integer) newValue);
            return;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER:
            setRoundedCorner((Boolean) newValue);
            return;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__WORKSPACE_PATH:
            setWorkspacePath((String) newValue);
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
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH:
            setArcWidth(ARC_WIDTH_EDEFAULT);
            return;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT:
            setArcHeight(ARC_HEIGHT_EDEFAULT);
            return;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER:
            setRoundedCorner(ROUNDED_CORNER_EDEFAULT);
            return;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__WORKSPACE_PATH:
            setWorkspacePath(WORKSPACE_PATH_EDEFAULT);
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
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH:
            return ARC_WIDTH_EDEFAULT == null ? arcWidth != null : !ARC_WIDTH_EDEFAULT.equals(arcWidth);
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT:
            return ARC_HEIGHT_EDEFAULT == null ? arcHeight != null : !ARC_HEIGHT_EDEFAULT.equals(arcHeight);
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER:
            return roundedCorner != ROUNDED_CORNER_EDEFAULT;
        case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__WORKSPACE_PATH:
            return WORKSPACE_PATH_EDEFAULT == null ? workspacePath != null : !WORKSPACE_PATH_EDEFAULT.equals(workspacePath);
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
        if (baseClass == RoundedCornerStyleDescription.class) {
            switch (derivedFeatureID) {
            case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH:
                return StylePackage.ROUNDED_CORNER_STYLE_DESCRIPTION__ARC_WIDTH;
            case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT:
                return StylePackage.ROUNDED_CORNER_STYLE_DESCRIPTION__ARC_HEIGHT;
            default:
                return -1;
            }
        }
        if (baseClass == ContainerStyleDescription.class) {
            switch (derivedFeatureID) {
            case StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER:
                return StylePackage.CONTAINER_STYLE_DESCRIPTION__ROUNDED_CORNER;
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
        if (baseClass == RoundedCornerStyleDescription.class) {
            switch (baseFeatureID) {
            case StylePackage.ROUNDED_CORNER_STYLE_DESCRIPTION__ARC_WIDTH:
                return StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_WIDTH;
            case StylePackage.ROUNDED_CORNER_STYLE_DESCRIPTION__ARC_HEIGHT:
                return StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ARC_HEIGHT;
            default:
                return -1;
            }
        }
        if (baseClass == ContainerStyleDescription.class) {
            switch (baseFeatureID) {
            case StylePackage.CONTAINER_STYLE_DESCRIPTION__ROUNDED_CORNER:
                return StylePackage.WORKSPACE_IMAGE_DESCRIPTION__ROUNDED_CORNER;
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
        result.append(" (arcWidth: ");
        result.append(arcWidth);
        result.append(", arcHeight: ");
        result.append(arcHeight);
        result.append(", roundedCorner: ");
        result.append(roundedCorner);
        result.append(", workspacePath: ");
        result.append(workspacePath);
        result.append(')');
        return result.toString();
    }

} // WorkspaceImageDescriptionImpl
