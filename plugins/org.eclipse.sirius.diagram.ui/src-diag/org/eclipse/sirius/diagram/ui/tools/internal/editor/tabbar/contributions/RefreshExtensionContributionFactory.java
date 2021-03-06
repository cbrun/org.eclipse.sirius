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
package org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar.contributions;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.sirius.diagram.ui.part.SiriusDiagramActionBarContributor;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.diagram.ui.tools.api.image.DiagramImagesPath;
import org.eclipse.sirius.diagram.ui.tools.internal.actions.refresh.RefreshDiagramAction;
import org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar.contributions.expressions.DDiagramTabbarExpression;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

/**
 * 
 * ExtensionContributionFactory responsible for "refresh action" tabbar item
 * creation.
 * 
 * @author fbarbin
 */
public class RefreshExtensionContributionFactory extends SiriusTabbarExtensionContributionFactory {

    @Override
    public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {

        super.createContributionItems(serviceLocator, additions);
        RefreshDiagramAction action = new RefreshDiagramAction(SiriusDiagramActionBarContributor.REFRESH_DIAGRAM, DiagramUIPlugin.Implementation.getBundledImageDescriptor(DiagramImagesPath.REFRESH_IMG));

        additions.addContributionItem(new ActionContributionItem(action), new DDiagramTabbarExpression());
    }

}
