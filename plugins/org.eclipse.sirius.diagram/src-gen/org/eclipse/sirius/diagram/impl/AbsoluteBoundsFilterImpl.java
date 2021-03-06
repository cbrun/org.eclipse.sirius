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
package org.eclipse.sirius.diagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.sirius.diagram.AbsoluteBoundsFilter;
import org.eclipse.sirius.diagram.DiagramPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Absolute Bounds Filter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.sirius.diagram.impl.AbsoluteBoundsFilterImpl#getX <em>
 * X</em>}</li>
 * <li>{@link org.eclipse.sirius.diagram.impl.AbsoluteBoundsFilterImpl#getY <em>
 * Y</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.diagram.impl.AbsoluteBoundsFilterImpl#getHeight
 * <em>Height</em>}</li>
 * <li>{@link org.eclipse.sirius.diagram.impl.AbsoluteBoundsFilterImpl#getWidth
 * <em>Width</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AbsoluteBoundsFilterImpl extends EObjectImpl implements AbsoluteBoundsFilter {
    /**
     * The default value of the '{@link #getX() <em>X</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getX()
     * @generated
     * @ordered
     */
    protected static final Integer X_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getX() <em>X</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getX()
     * @generated
     * @ordered
     */
    protected Integer x = X_EDEFAULT;

    /**
     * The default value of the '{@link #getY() <em>Y</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getY()
     * @generated
     * @ordered
     */
    protected static final Integer Y_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getY() <em>Y</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getY()
     * @generated
     * @ordered
     */
    protected Integer y = Y_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final Integer HEIGHT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected Integer height = HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final Integer WIDTH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected Integer width = WIDTH_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbsoluteBoundsFilterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DiagramPackage.Literals.ABSOLUTE_BOUNDS_FILTER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getX() {
        return x;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setX(Integer newX) {
        Integer oldX = x;
        x = newX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ABSOLUTE_BOUNDS_FILTER__X, oldX, x));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getY() {
        return y;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setY(Integer newY) {
        Integer oldY = y;
        y = newY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ABSOLUTE_BOUNDS_FILTER__Y, oldY, y));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setHeight(Integer newHeight) {
        Integer oldHeight = height;
        height = newHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ABSOLUTE_BOUNDS_FILTER__HEIGHT, oldHeight, height));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setWidth(Integer newWidth) {
        Integer oldWidth = width;
        width = newWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ABSOLUTE_BOUNDS_FILTER__WIDTH, oldWidth, width));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__X:
            return getX();
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__Y:
            return getY();
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__HEIGHT:
            return getHeight();
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__WIDTH:
            return getWidth();
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
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__X:
            setX((Integer) newValue);
            return;
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__Y:
            setY((Integer) newValue);
            return;
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__HEIGHT:
            setHeight((Integer) newValue);
            return;
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__WIDTH:
            setWidth((Integer) newValue);
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
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__X:
            setX(X_EDEFAULT);
            return;
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__Y:
            setY(Y_EDEFAULT);
            return;
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__HEIGHT:
            setHeight(HEIGHT_EDEFAULT);
            return;
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__WIDTH:
            setWidth(WIDTH_EDEFAULT);
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
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__X:
            return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__Y:
            return Y_EDEFAULT == null ? y != null : !Y_EDEFAULT.equals(y);
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__HEIGHT:
            return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
        case DiagramPackage.ABSOLUTE_BOUNDS_FILTER__WIDTH:
            return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
        }
        return super.eIsSet(featureID);
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
        result.append(" (x: ");
        result.append(x);
        result.append(", y: ");
        result.append(y);
        result.append(", height: ");
        result.append(height);
        result.append(", width: ");
        result.append(width);
        result.append(')');
        return result.toString();
    }

} // AbsoluteBoundsFilterImpl
