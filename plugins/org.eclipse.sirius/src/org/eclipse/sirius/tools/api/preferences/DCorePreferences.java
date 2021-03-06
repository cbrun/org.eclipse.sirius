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
package org.eclipse.sirius.tools.api.preferences;

/**
 * Core preferences.
 * 
 * @author mchauvin
 * @noimplement
 * @noextend
 */
public interface DCorePreferences {

    /** Key for viewpoint registry initial size preference. */
    String VIEWPOINT_REGISTRY_INITIAL_SIZE = "SiriusRegistryInitialSize";

    /** Default value for viewpoint registry initial size preference. */
    int VIEWPOINT_REGISTRY_INITIAL_SIZE_DEFAULT_VALUE = 10;

    /** Key for color registry max size preference. */
    String COLOR_REGISTRY_MAX_SIZE = "ColorRegistryMaxSize";

    /** Default value for color registry max size preference. */
    int COLOR_REGISTRY_MAX_SIZE_DEFAULT_VALUE = 2048;

    /** Key for font registry max size preference. */
    String FONT_REGISTRY_MAX_SIZE = "FontRegistryMaxSize";

    /** Default value for font registry max size preference. */
    int FONT_REGISTRY_MAX_SIZE_DEFAULT_VALUE = 256;

}
