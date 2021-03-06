/*******************************************************************************
 * Copyright (c) 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.HideFilter;

import com.google.common.base.Preconditions;

/**
 * Queries on EMF Notifications to identify what they are about.
 * 
 * @author pcdavid
 */
public class NotificationQuery extends org.eclipse.sirius.common.tools.api.query.NotificationQuery {
    private final Notification notif;

    /**
     * Constructor.
     * 
     * @param notif
     *            the notification to query.
     */
    public NotificationQuery(Notification notif) {
        super(notif);
        this.notif = Preconditions.checkNotNull(notif);
    }

    /**
     * Tests whether the notification concerns a GMF Notation element.
     * 
     * @return <code>true</code> if the notification concerns a GMF Notation
     *         element.
     */
    public boolean isNotationChange() {
        Object feature = notif.getFeature();
        return (feature instanceof EStructuralFeature) && ((EStructuralFeature) feature).getEContainingClass().getEPackage().equals(NotationPackage.eINSTANCE);
    }

    /**
     * Tests whether the notification is a GMF view becoming invisible.
     * 
     * @return <code>true</code> if the notification is a GMF view becoming
     *         invisible.
     */
    public boolean isViewBecomingInvisibleEvent() {
        Object feature = notif.getFeature();
        boolean isViewVisibleFalseEvent = NotationPackage.eINSTANCE.getView_Visible().equals(feature);
        isViewVisibleFalseEvent = isViewVisibleFalseEvent && !notif.getNewBooleanValue();
        isViewVisibleFalseEvent = isViewVisibleFalseEvent && Notification.SET == notif.getEventType();
        return isViewVisibleFalseEvent;

    }

    /**
     * Tests whether the notification is about the addition of a "Hide" filter
     * on a diagram element (which would make the element invisible).
     * 
     * @return <code>true</code> if the notification is about the addition of a
     *         "Hide" filter on a diagram element (which would make the element
     *         invisible).
     */
    public boolean isHideFilterAddEvent() {
        Object feature = notif.getFeature();
        boolean isHideFilterAddEvent = DiagramPackage.eINSTANCE.getDDiagramElement_GraphicalFilters().equals(feature);
        isHideFilterAddEvent = isHideFilterAddEvent && notif.getNewValue() instanceof HideFilter;
        isHideFilterAddEvent = isHideFilterAddEvent && Notification.ADD == notif.getEventType();
        return isHideFilterAddEvent;
    }
}
