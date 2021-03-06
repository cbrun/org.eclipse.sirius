/*******************************************************************************
 * Copyright (c) 2012, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar.contributions;

import org.eclipse.gmf.runtime.diagram.ui.actions.internal.FontDialogAction;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.FontStyleAction;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.diagram.ui.tools.api.image.DiagramImagesPath;
import org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar.actions.TabbarColorPropertyContributionItem;
import org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar.contributions.expressions.DDiagramElementTabbarExpression;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

/**
 * ExtensionContributionFactory responsible for font actions tabbar item
 * creation.
 * 
 * @author fbarbin
 */
public class DiagramElementFontExtensionContributionFactory extends SiriusTabbarExtensionContributionFactory {

    @Override
    public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {

        super.createContributionItems(serviceLocator, additions);
        FontStyleAction fontStyleBoldAction = FontStyleAction.createBoldFontStyleAction(getPage());
        FontStyleAction fontStyleItalicAction = FontStyleAction.createItalicFontStyleAction(getPage());
        additions.addContributionItem(new ActionContributionItem(fontStyleBoldAction), new DDiagramElementTabbarExpression());
        additions.addContributionItem(new ActionContributionItem(fontStyleItalicAction), new DDiagramElementTabbarExpression());

        createFontColorMenu(additions);

        IAction fontDialogAction = new FontDialogAction(getPage());
        fontDialogAction.setImageDescriptor(DiagramUIPlugin.Implementation.getBundledImageDescriptor(DiagramImagesPath.FONT_WIZARD));

        additions.addContributionItem(new ActionContributionItem(fontDialogAction), new DDiagramElementTabbarExpression());

    }

    private void createFontColorMenu(IContributionRoot additions) {
        TabbarColorPropertyContributionItem fontColorMenu = TabbarColorPropertyContributionItem.createFontColorContributionItem(getPage());
        fontColorMenu.setActionWorkbenchPart(getPart());
        additions.addContributionItem(fontColorMenu, new DDiagramElementTabbarExpression());
    }

}
