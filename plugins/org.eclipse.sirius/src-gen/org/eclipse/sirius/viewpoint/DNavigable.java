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
package org.eclipse.sirius.viewpoint;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>DNavigable</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> Represents an element that can be navigate. The user
 * can see the details in another editor. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.sirius.viewpoint.DNavigable#getOwnedNavigationLinks
 * <em>Owned Navigation Links</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.sirius.viewpoint.ViewpointPackage#getDNavigable()
 * @model abstract="true"
 * @generated
 */
public interface DNavigable extends EObject {
    /**
     * Returns the value of the '<em><b>Owned Navigation Links</b></em>'
     * containment reference list. The list contents are of type
     * {@link org.eclipse.sirius.viewpoint.DNavigationLink}. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc --> The links of the
     * navigable element. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Owned Navigation Links</em>' containment
     *         reference list.
     * @see org.eclipse.sirius.viewpoint.ViewpointPackage#getDNavigable_OwnedNavigationLinks()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<DNavigationLink> getOwnedNavigationLinks();

} // DNavigable
