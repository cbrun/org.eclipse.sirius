/*******************************************************************************
 * Copyright (c) 2009 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.business.api.componentization;

import java.util.Collection;

import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * A listener to know {@link DiagramDescriptionMappingsManager} recompute
 * mappings.
 * 
 * The implementation does not use this interface anymore. It was not intended
 * to be used by other implementations and will be deleted.
 * 
 * @author mchauvin
 * @since 0.9.0
 */
@Deprecated
public interface DiagramDescriptionMappingsManagerListener {

    /**
     * This method is called when mappings have been computed.
     * 
     * @param enabledViewpoints 
     */
    void mappingsComputed(Collection<Viewpoint> enabledViewpoints);

    /**
     * This method is called when the description mappings manager will be
     * disposed.
     */
    void dispose();

}
