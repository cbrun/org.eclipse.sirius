/*******************************************************************************
 * Copyright (c) 2007, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.internal.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.sirius.diagram.internal.edit.commands.DNode2CreateCommand;
import org.eclipse.sirius.diagram.internal.providers.SiriusElementTypes;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * @was-generated
 */
public class DNode3ItemSemanticEditPolicy extends AbstractDNodeItemSemanticEditPolicy {

    /**
     * @was-generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (SiriusElementTypes.DNode_3001 == req.getElementType()) {
            if (req.getContainmentFeature() == null) {
                req.setContainmentFeature(ViewpointPackage.eINSTANCE.getAbstractDNode_OwnedBorderedNodes());
            }
            return getGEFWrapper(new DNode2CreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * @was-generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        CompoundCommand cc = getDestroyEdgesCommand();
        addDestroyChildNodesCommand(cc);
        addDestroyShortcutsCommand(cc);
        cc.add(getGEFWrapper(new DestroyElementCommand(req)));
        return cc.unwrap();
    }
}
