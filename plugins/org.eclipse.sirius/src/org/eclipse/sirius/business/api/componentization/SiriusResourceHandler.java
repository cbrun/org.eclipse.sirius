/*******************************************************************************
 * Copyright (c) 2011 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.api.componentization;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * Represents a type of resource which can contain Sirius definitions, and
 * thus should be monitored. The basic example is <code>*.odesign</code>
 * resources, but others can be contributed.
 * 
 * @author pierre-charles.david@obeo.fr
 */
public interface SiriusResourceHandler {
    /**
     * Tests whether this collector can handle the specified resource, i.e. it
     * is able to detect viewpoint definitions contained inside the resource.
     * 
     * @param uri
     *            the URI of a resource which may contain Sirius definitions.
     * @return <code>true</code> if this handler is able to find Sirius
     *         definitions (if there are any) inside the specified resource.
     */
    boolean handles(URI uri);

    /**
     * Finds all the Sirius definitions inside the specified resource. The
     * resource must be loaded, but need not be resolved.
     * 
     * @param res
     *            the resource in which to look for Siriuss.
     * @return all the Sirius definitions inside the resource.
     */
    Set<Viewpoint> collectSiriusDefinitions(Resource res);
}
