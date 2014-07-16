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
package org.eclipse.sirius.diagram.business.api.refresh;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Factory for {@link CanonicalSynchronizer}.
 * 
 * @author edugueperoux
 * 
 * @since 0.9.0
 * @noimplement This interface is not intended to be implemented by clients,
 *              only used for internal implementation.
 */
public interface CanonicalSynchronizerFactory {

    /**
     * The shared default implementation of the validator factory interface.
     */
    CanonicalSynchronizerFactory INSTANCE = new CanonicalSynchronizerFactory() {
        
        @Override
        public CanonicalSynchronizer createCanonicalSynchronizer(Diagram gmfDiagram) {
            return new CanonicalSynchronizer() {
                
                @Override
                public void synchronize() {
                    /*
                     * no-op
                     */
                    
                }
                
                @Override
                public void storeViewsToArrange(boolean storeViewsToArrange) {
                    /*
                     * no-op
                     */
                    
                }

                @Override
                public void postCreation() {
                    /*
                     * no-op
                     */
                    
                }
            };
        }
    };

    /**
     * Operation to create a new {@link CanonicalSynchronizer}.
     * 
     * @param gmfDiagram
     *            a {@link Diagram} to synchronize.
     * 
     * @return the newly created {@link CanonicalSynchronizer}
     */
    CanonicalSynchronizer createCanonicalSynchronizer(Diagram gmfDiagram);
}
