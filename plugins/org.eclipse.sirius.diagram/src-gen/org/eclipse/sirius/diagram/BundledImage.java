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
package org.eclipse.sirius.diagram;

import org.eclipse.sirius.viewpoint.RGBValues;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Bundled Image</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> The bundled image style allows to use the default
 * images provide by the ViewPoint editor. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.diagram.BundledImage#getShape <em>Shape</em>}</li>
 * <li>{@link org.eclipse.sirius.diagram.BundledImage#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.diagram.DiagramPackage#getBundledImage()
 * @model
 * @generated
 */
public interface BundledImage extends NodeStyle {
    /**
     * Returns the value of the '<em><b>Shape</b></em>' attribute. The literals
     * are from the enumeration
     * {@link org.eclipse.sirius.diagram.BundledImageShape}. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc --> The shape to use. <!--
     * end-model-doc -->
     * 
     * @return the value of the '<em>Shape</em>' attribute.
     * @see org.eclipse.sirius.diagram.BundledImageShape
     * @see #setShape(BundledImageShape)
     * @see org.eclipse.sirius.diagram.DiagramPackage#getBundledImage_Shape()
     * @model required="true"
     * @generated
     */
    BundledImageShape getShape();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.diagram.BundledImage#getShape <em>Shape</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Shape</em>' attribute.
     * @see org.eclipse.sirius.diagram.BundledImageShape
     * @see #getShape()
     * @generated
     */
    void setShape(BundledImageShape value);

    /**
     * Returns the value of the '<em><b>Color</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Color</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Color</em>' containment reference.
     * @see #setColor(RGBValues)
     * @see org.eclipse.sirius.diagram.DiagramPackage#getBundledImage_Color()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    RGBValues getColor();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.diagram.BundledImage#getColor <em>Color</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Color</em>' containment reference.
     * @see #getColor()
     * @generated
     */
    void setColor(RGBValues value);

} // BundledImage