/*******************************************************************************
 * Copyright (c) 2010 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.api.requests;

/**
 * Constants.
 * 
 * @author mchauvin
 */
public interface RequestConstants extends org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants {

    /** Refresh a viewpoint. */
    String REQ_REFRESH_VIEWPOINT = "refreshSirius";

    /** Hide a given element. */
    String REQ_HIDE_ELEMENT = "hideElement";

    /** Reveal all hidden elements. */
    String REQ_REVEAL_ALLS = "revealAllElements";

    /** Reveal selected hidden elements. */
    String REQ_REVEAL_SELECTED = "revealSelectedElements";

    /** Launch all rules. */
    String REQ_LAUNCH_RULE_TOOL = "launchRuleTools";

    /** Delete this element from the diagram. */
    String REQ_DELETE_FROM_DIAGRAM = "deleteFromDiagram";

    /** Launch tool on diagram. */
    String REQ_LAUNCH_TOOL = "launchTool";

    /** request type for quotation rotation. */
    String REQ_ROTATE_BENDPOINT = "rotateBendpoint";

}
