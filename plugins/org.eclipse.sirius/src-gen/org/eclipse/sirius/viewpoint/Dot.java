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
package org.eclipse.sirius.viewpoint;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Dot</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> The dot style. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.viewpoint.Dot#getBackgroundColor <em>Background
 * Color</em>}</li>
 * <li>
 * {@link org.eclipse.sirius.viewpoint.Dot#getStrokeSizeComputationExpression
 * <em>Stroke Size Computation Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.viewpoint.ViewpointPackage#getDot()
 * @model
 * @generated
 */
public interface Dot extends NodeStyle {

    /**
     * Returns the value of the '<em><b>Background Color</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> The background color. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Background Color</em>' containment
     *         reference.
     * @see #setBackgroundColor(RGBValues)
     * @see org.eclipse.sirius.viewpoint.SiriusPackage#getDot_BackgroundColor()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    RGBValues getBackgroundColor();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.viewpoint.Dot#getBackgroundColor
     * <em>Background Color</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Background Color</em>' containment
     *            reference.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor(RGBValues value);

    /**
     * Returns the value of the '
     * <em><b>Stroke Size Computation Expression</b></em>' attribute. The
     * default value is <code>"2"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stroke Size Computation Expression</em>'
     * attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The acceleo expression
     * that allows to compute the size of a stroke. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Stroke Size Computation Expression</em>'
     *         attribute.
     * @see #setStrokeSizeComputationExpression(String)
     * @see org.eclipse.sirius.viewpoint.SiriusPackage#getDot_StrokeSizeComputationExpression()
     * @model default="2"
     * @generated
     */
    String getStrokeSizeComputationExpression();

    /**
     * Sets the value of the '
     * {@link org.eclipse.sirius.viewpoint.Dot#getStrokeSizeComputationExpression
     * <em>Stroke Size Computation Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Stroke Size Computation Expression</em>' attribute.
     * @see #getStrokeSizeComputationExpression()
     * @generated
     */
    void setStrokeSizeComputationExpression(String value);
} // Dot