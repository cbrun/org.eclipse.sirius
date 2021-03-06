/*******************************************************************************
 * Copyright (c) 2008, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.table.ui.tools.internal.editor.action;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.google.common.collect.Lists;

/**
 * This implementation is used to create the structure viewer's "Create Line"
 * action.
 * 
 * @param <T>
 *            the {@link AbstractToolAction} type to create.
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public abstract class AbstractEditorCreateMenuAction<T extends AbstractToolAction> extends Action implements IMenuCreator {

    /** Menu manager for this action. */
    private final MenuManager menuManager = new MenuManager();

    /** The last action launch from this menu. */
    private T lastCreateAction;

    private final List<T> createActionsForTable = Lists.newArrayList();

    // menu item selection listener: listens to selection events
    private final Listener menuItemListener = new Listener() {
        public void handleEvent(final Event event) {
            if (SWT.Selection == event.type && !event.widget.isDisposed()) {
                final ActionContributionItem item = (ActionContributionItem) event.widget.getData();
                setLastAction((T) item.getAction());
            }
        }
    };

    /**
     * This default constructor will instantiate an action given the
     * {@link #BUNDLE bundle} resources prefixed by &quot;action.save&quot;.
     * 
     * * Creates a new action with the given text and image. Calls the zero-arg
     * constructor, then <code>setText</code> and
     * <code>setImageDescriptor</code>.
     * 
     * @param text
     *            the action's text, or <code>null</code> if there is no text
     * @param image
     *            the action's image, or <code>null</code> if there is no image
     * @see #setText
     * @see #setImageDescriptor
     */
    protected AbstractEditorCreateMenuAction(String text, ImageDescriptor image) {
        super(text, image);
        setMenuCreator(this);
        setEnabled(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
        if (lastCreateAction != null && lastCreateAction.isEnabled()) {
            lastCreateAction.run();
        }
    }

    /**
     * This will add the given action to this action's menu.
     * 
     * @param action
     *            {@link Action} to add to this action's menu.
     */
    public void addActionToMenu(final Action action) {
        final ActionContributionItem contribution = new ActionContributionItem(action);
        menuManager.add(contribution);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.action.IMenuCreator#dispose()
     */
    public void dispose() {
        if (menuManager.getMenu() != null) {
            final MenuItem[] menuItems = menuManager.getMenu().getItems();
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getStyle() == SWT.SEPARATOR) {
                    continue;
                }
                menuItem.removeListener(SWT.Selection, menuItemListener);
            }
            menuManager.getMenu().dispose();
        }
        menuManager.dispose();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Control)
     */
    public Menu getMenu(final Control parent) {
        // Creates the menu if needed, or removes all elements except for the
        // save action
        if (menuManager.getMenu() == null) {
            menuManager.createContextMenu(parent);
            update();
        }

        final MenuItem[] menuItems = menuManager.getMenu().getItems();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getStyle() == SWT.SEPARATOR) {
                continue;
            }
            menuItem.addListener(SWT.Selection, menuItemListener);
        }

        return menuManager.getMenu();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Menu)
     */
    public Menu getMenu(final Menu parent) {
        return null;
    }

    /**
     * The change is applied on the next getMenu.
     * 
     * @param actions
     *            List of <{@link AbstractToolAction}
     */
    public void update(final List<AbstractToolAction> actions) {
        getCreateActionsForTable().clear();
        menuManager.removeAll();
        // Add all create line tool
        for (final T toolAction : filter(actions)) {
            getCreateActionsForTable().add(toolAction);
        }
        update();
    }

    /**
     * Filter the actions.
     * 
     * @param createActionsForTable
     *            all the candidate actions.
     * @return the sub-set of actions to use.
     */
    protected abstract List<T> filter(List<AbstractToolAction> createActionsForTable);

    /**
     * The change is applied on the next getMenu.
     */
    protected void update() {
        setEnabled(!getCreateActionsForTable().isEmpty());

        menuManager.removeAll();
        // Add all create line tool on the table
        for (final T createAction : getCreateActionsForTable()) {
            if (createAction.canExecute()) {
                menuManager.add(createAction);
            }
        }
    }

    public void setLastAction(final T createAction) {
        lastCreateAction = createAction;
    }

    /**
     * Return the available createLine actions.
     * 
     * @return the createLineActionsForTable
     */
    protected List<T> getCreateActionsForTable() {
        return createActionsForTable;
    }
}
