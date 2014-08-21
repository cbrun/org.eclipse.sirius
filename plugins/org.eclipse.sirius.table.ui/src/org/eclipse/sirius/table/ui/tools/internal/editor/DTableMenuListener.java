/*******************************************************************************
 * Copyright (c) 2007, 2014 THALES GLOBAL SERVICES and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.table.ui.tools.internal.editor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.task.InitInterpreterVariablesTask;
import org.eclipse.sirius.business.api.logger.RuntimeLoggerInterpreter;
import org.eclipse.sirius.business.api.logger.RuntimeLoggerManager;
import org.eclipse.sirius.business.api.query.IdentifiedElementQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.table.business.api.helper.TableHelper;
import org.eclipse.sirius.table.metamodel.table.DCell;
import org.eclipse.sirius.table.metamodel.table.DColumn;
import org.eclipse.sirius.table.metamodel.table.DLine;
import org.eclipse.sirius.table.metamodel.table.DTable;
import org.eclipse.sirius.table.metamodel.table.DTableElement;
import org.eclipse.sirius.table.metamodel.table.DTargetColumn;
import org.eclipse.sirius.table.metamodel.table.description.TableMapping;
import org.eclipse.sirius.table.ui.tools.internal.command.EMFCommandFactoryUI;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.AbstractLineAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.AbstractTargetColumnAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.AbstractToolAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.CreateLineAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.CreateRepresentationFromRepresentationCreationDescription;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.CreateTargetColumnAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.DeleteLinesAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.DeleteTargetColumnAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.HideColumnAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.HideLinesAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.HideRevealColumnsAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.HideRevealLinesAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.RefreshAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.ShowAllColumnsAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.ShowAllLinesAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.ShowPropertiesViewAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.SortColumnsByLineAction;
import org.eclipse.sirius.table.ui.tools.internal.editor.action.SortLinesByColumnAction;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.description.tool.AbstractVariable;
import org.eclipse.sirius.viewpoint.description.tool.RepresentationCreationDescription;
import org.eclipse.sirius.viewpoint.description.tool.RepresentationNavigationDescription;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.handlers.IHandlerService;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A menu listener which show or hide the menu according to :
 * <UL>
 * <LI>the current selection</LI>
 * <LI>and the tool precondition.
 * </UL>
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 * 
 */
public class DTableMenuListener implements IMenuListener {
    private static final String MENU_NAVIGATE_ID = "popup.navigate";

    private static final String MENU_HIDEREVEAL_ID = "popup.hidereveal";

    private static final String MENU_EXPORT_ID = "popup.export";

    private static final String NEW_REPRESENTATION_GROUP_SEPARATOR = "newRepresentation";

    private static final String EXISTING_REPRESENTATION_GROUP_SEPARATOR = "existingRepresentation";

    private static final String NAVIGATE_REPRESENTATION_GROUP_SEPARATOR = "navigateRepresentationGroup";

    private static final String VIEWPOINT_GROUP_SEPARATOR = "viewpoint";

    private static final String PROPERTIES_SEPARATOR = "properties";

    private static final String HIDE_SEPARATOR = "hideGroup";

    private final AdapterFactory adapterFactory;

    private final DTable dTable;

    private final DTableViewerManager treeViewManager;

    private Map<TableMapping, DeleteTargetColumnAction> mappingToDeleteColumnActions;

    private final DeleteLinesAction deleteLinesAction;

    private Map<TableMapping, List<AbstractToolAction>> mappingToCreateActions;

    private List<AbstractToolAction> createActionsForTable;

    private final HideLinesAction hideLineAction;

    private final ShowAllLinesAction showAllLinesAction;

    private final HideColumnAction hideColumnAction;

    private final ShowAllColumnsAction showAllColumnsAction;

    private final RefreshAction refreshAction;

    private final ShowPropertiesViewAction showPropertiesViewAction;

    private final SortLinesByColumnAction sortLinesByColumnAction;

    private final SortColumnsByLineAction sortColumnsByLineAction;

    private final HideRevealColumnsAction hideRevealColumnsAction;

    private final HideRevealLinesAction hideRevealLinesAction;

    /**
     * Default constructor.
     * 
     * @param table
     *            The table associates with this menu
     * @param treeViewManager
     *            The manager of the TreeView
     * @param mappingToCreateActions
     *            A map which associates {@link TableMapping} with the
     *            corresponding list of {@link AbstractToolAction} (
     *            {@link org.eclipse.sirius.table.ui.tools.internal.editor.action.CreateLineAction}
     *            or
     *            {@link org.eclipse.sirius.table.ui.tools.internal.editor.action.CreateTargetColumnAction}
     *            )
     * @param mappingToDeleteColumnActions
     *            A map which associates {@link TableMapping} with the
     *            corresponding
     *            {@link org.eclipse.sirius.table.ui.tools.internal.editor.action.DeleteTargetColumnAction}
     * @param createActionsForTable
     *            A list of the actions for create lines under the table.
     */
    public DTableMenuListener(final DTable table, final DTableViewerManager treeViewManager, final Map<TableMapping, List<AbstractToolAction>> mappingToCreateActions,
            final Map<TableMapping, DeleteTargetColumnAction> mappingToDeleteColumnActions, final List<AbstractToolAction> createActionsForTable) {
        super();
        adapterFactory = DialectUIManager.INSTANCE.createAdapterFactory();
        this.dTable = table;
        this.treeViewManager = treeViewManager;
        setMappingToCreateActions(mappingToCreateActions);
        setMappingToDeleteActions(mappingToDeleteColumnActions);
        setCreateActionsForTable(createActionsForTable);
        deleteLinesAction = new DeleteLinesAction(treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory());

        hideLineAction = new HideLinesAction(dTable, treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory());
        showAllLinesAction = new ShowAllLinesAction(dTable, treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory());
        hideColumnAction = new HideColumnAction(dTable, treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory());
        showAllColumnsAction = new ShowAllColumnsAction(dTable, treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory());
        refreshAction = new RefreshAction(treeViewManager.getEditor());
        showPropertiesViewAction = new ShowPropertiesViewAction();
        sortLinesByColumnAction = new SortLinesByColumnAction(treeViewManager.getEditingDomain());
        sortColumnsByLineAction = new SortColumnsByLineAction(treeViewManager.getEditingDomain());
        hideRevealColumnsAction = new HideRevealColumnsAction(dTable, treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory());
        hideRevealLinesAction = new HideRevealLinesAction(dTable, treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory(), treeViewManager.getTreeViewer());
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
     */
    public void menuAboutToShow(final IMenuManager manager) {
        // Refresh the cached actions if needed
        treeViewManager.fillMenu();
        // Add navigate menus
        addNavigateMenu(manager);
        manager.add(new Separator());
        // Add viewpoint menus
        addRefreshMenu(manager);
        manager.add(new Separator());
        addSortMenu(manager);
        manager.add(new Separator());
        addHideRevealMenu(manager);
        manager.add(new Separator(DTableMenuListener.HIDE_SEPARATOR));
        manager.add(new Separator());
        // Add column menus
        addColumnMenus(manager);
        // Add line menus
        addLineMenus(manager);
        manager.add(new Separator());
        // Add table menus
        addTableMenus(manager);
        addExportMenu(manager);
        // Add show properties view
        manager.add(new Separator(DTableMenuListener.PROPERTIES_SEPARATOR));
        manager.appendToGroup(DTableMenuListener.PROPERTIES_SEPARATOR, showPropertiesViewAction);
        //
        manager.add(new Separator());
        manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

    }

    /**
     * Add the table menus if any line is selected.<BR>
     * 
     * @param manager
     *            the menu manager
     */
    private void addTableMenus(final IMenuManager manager) {
        final Collection<DLine> selectedLines = treeViewManager.getSelectedLines();
        if (selectedLines != null && !selectedLines.isEmpty()) {
            for (final AbstractToolAction abstractToolAction : getCreateActionsForTable()) {
                if (abstractToolAction instanceof CreateLineAction) {
                    final CreateLineAction createLineAction = (CreateLineAction) abstractToolAction;
                    createLineAction.setTable(dTable);
                    if (createLineAction.canExecute()) {
                        manager.add(createLineAction);
                    }
                } else if (abstractToolAction instanceof CreateTargetColumnAction) {
                    final CreateTargetColumnAction createTargetColumnAction = (CreateTargetColumnAction) abstractToolAction;
                    createTargetColumnAction.setTable(dTable);
                    if (createTargetColumnAction.canExecute()) {
                        manager.add(createTargetColumnAction);
                    }
                }
            }
            manager.add(new Separator());
        }
    }

    /**
     * Add the navigate sub menu and its actions if needed.
     * 
     * @param manager
     *            The menu manager
     */
    private void addNavigateMenu(final IMenuManager manager) {
        // Create a new sub-menu manager
        final MenuManager navigateMenuManager = new MenuManager("Navigate", DTableMenuListener.MENU_NAVIGATE_ID);
        // Create the item to add to the main manager
        final SubContributionItem navigateMenuItem = new SubContributionItem(navigateMenuManager);
        manager.add(navigateMenuItem);
        // Add menus to navigate through existing representations (created by
        // RepresentationCreationDescription)
        final Separator existingGroup = new Separator(DTableMenuListener.EXISTING_REPRESENTATION_GROUP_SEPARATOR);
        navigateMenuManager.add(existingGroup);
        // Add menus to navigate through existing representations (corresponding
        // to the RepresentationNavigationDescription)
        final Separator navigateRepresentationGroup = new Separator(NAVIGATE_REPRESENTATION_GROUP_SEPARATOR);
        navigateMenuManager.add(navigateRepresentationGroup);
        // Add menus to navigate through new representations (corresponding to
        // the RepresentationCreationDescription)
        final Separator createGroup = new Separator(DTableMenuListener.NEW_REPRESENTATION_GROUP_SEPARATOR);
        navigateMenuManager.add(createGroup);
        final DTableElement currentTableElement = getCurrentTableElement();
        if (currentTableElement != null) {
            // Add actions to navigate to existing representation
            createNavigationAction(navigateMenuItem, currentTableElement);
            // Add actions to navigate to new representation
            if (currentTableElement instanceof DCell) {
                createDetailsActions(currentTableElement, navigateMenuItem);
            } else if (currentTableElement instanceof DLine) {
                createDetailsActions(currentTableElement, navigateMenuItem);
            }
        } else {
            // Add actions to navigate to existing representation
            createNavigationAction(navigateMenuItem, dTable);
        }
    }

    /**
     * @param navigateMenuItem
     * @param semanticElement
     */
    private void createNavigationAction(final SubContributionItem navigate, final DSemanticDecorator decorator) {
        final EObject semanticElement = decorator.getTarget();
        final Session session = SessionManager.INSTANCE.getSession(semanticElement);
        if (session != null) {
            final Collection<DRepresentation> otherRepresentations = DialectManager.INSTANCE.getRepresentations(semanticElement, session);
            for (final DRepresentation representation : otherRepresentations) {
                if (!EcoreUtil.equals(dTable, representation) && isFromActiveViewpoint(session, representation)) {
                    navigate.setVisible(true);
                    ((IMenuManager) navigate.getInnerItem()).appendToGroup(EXISTING_REPRESENTATION_GROUP_SEPARATOR, buildOpenRepresentationAction(session, representation));
                }
            }
            if (decorator instanceof DRepresentationElement) {
                if (buildNavigableRepresentationsMenu((IMenuManager) navigate.getInnerItem(), decorator, session)) {
                    // If at least one navigable representation menu
                    // has been created, we have to make the navigate menu
                    // visible
                    navigate.setVisible(true);
                }
            }
        }
    }

    private boolean buildNavigableRepresentationsMenu(final IMenuManager navigate, final EObject designerObj, final Session session) {
        final DRepresentationElement element = (DRepresentationElement) designerObj;
        if (element.getMapping() != null) {

            for (final RepresentationNavigationDescription navDesc : element.getMapping().getNavigationDescriptions()) {
                boolean append = true;
                if (!isFromActiveViewpoint(session, navDesc.getRepresentationDescription())) {
                    append = false;
                }

                final IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(element.getTarget());

                final Map<AbstractVariable, Object> variables = new HashMap<AbstractVariable, Object>();
                variables.put(navDesc.getContainerVariable(), element.getTarget());
                variables.put(navDesc.getContainerViewVariable(), element);

                final InitInterpreterVariablesTask init = new InitInterpreterVariablesTask(variables, interpreter, new EMFCommandFactoryUI());
                init.execute();

                final String precondition = navDesc.getPrecondition();
                if (append && !StringUtil.isEmpty(precondition)) {
                    append = false;

                    try {
                        append = interpreter.evaluateBoolean(element.getTarget(), navDesc.getPrecondition());
                    } catch (final EvaluationException e) {
                        RuntimeLoggerManager.INSTANCE.error(navDesc, ToolPackage.eINSTANCE.getAbstractToolDescription_Precondition(), e);
                    }
                }

                if (append) {
                    // We return true if at least one action has been
                    // added in the menu to make it visible
                    return buildOpenRepresentationActions(navigate, interpreter, navDesc, element, session);
                }
            }
        }
        return false;
    }

    private boolean buildOpenRepresentationActions(final IMenuManager navigate, final IInterpreter interpreter, final RepresentationNavigationDescription navDesc,
            final DRepresentationElement element, final Session session) {
        boolean atLeastOneRepresentationActionsWasCreated = false;
        Set<EObject> candidates;
        if (!StringUtil.isEmpty(navDesc.getBrowseExpression())) {
            final RuntimeLoggerInterpreter safeInterpreter = RuntimeLoggerManager.INSTANCE.decorate(interpreter);
            candidates = Sets.newLinkedHashSet(safeInterpreter.evaluateCollection(element.getTarget(), navDesc, ToolPackage.eINSTANCE.getRepresentationNavigationDescription_BrowseExpression()));
        } else {
            candidates = Sets.newLinkedHashSet();
            final Iterator<EObject> it = SiriusPlugin.getDefault().getModelAccessorRegistry().getModelAccessor(element.getTarget()).eAllContents(element.getTarget());
            while (it.hasNext()) {
                candidates.add(it.next());
            }
        }
        final Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(navDesc.getRepresentationDescription(), session);
        for (final DRepresentation representation : representations) {
            if (representation instanceof DSemanticDecorator && candidates.contains(((DSemanticDecorator) representation).getTarget())) {
                interpreter.setVariable(navDesc.getRepresentationNameVariable().getName(), representation.getName());
                String label = new StringBuffer("Open ").append(navDesc.getName()).append(" : ").append(representation.getName()).toString();
                if (!StringUtil.isEmpty(navDesc.getNavigationNameExpression())) {
                    try {
                        label = interpreter.evaluateString(element.getTarget(), navDesc.getNavigationNameExpression());
                    } catch (final EvaluationException e) {
                        RuntimeLoggerManager.INSTANCE.error(navDesc, ToolPackage.eINSTANCE.getRepresentationNavigationDescription_NavigationNameExpression(), e);
                    }
                }
                navigate.appendToGroup(NAVIGATE_REPRESENTATION_GROUP_SEPARATOR, buildOpenRepresentationAction(session, representation, label));
                atLeastOneRepresentationActionsWasCreated = true;
            }
        }
        return atLeastOneRepresentationActionsWasCreated;
    }

    private IAction buildOpenRepresentationAction(final Session session, final DRepresentation representation) {
        String representationName = representation.getName();
        if (StringUtil.isEmpty(representationName)) {
            representationName = "(unnamed)";
            if (representation instanceof DTable) {
                representationName += " " + new IdentifiedElementQuery(((DTable) representation).getDescription()).getLabel();
            }
        }
        return buildOpenRepresentationAction(session, representation, "Open " + representationName);
    }

    private IAction buildOpenRepresentationAction(final Session session, final DRepresentation representation, final String label) {

        ImageDescriptor imageDescriptor = null;
        final IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(representation, IItemLabelProvider.class);
        if (labelProvider != null) {
            imageDescriptor = ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(representation));
        }
        return new Action(label, imageDescriptor) {

            @Override
            public void run() {
                super.run();
                treeViewManager.getEditingDomain().getCommandStack().execute(new AttachEditorRecordingCommand(treeViewManager.getEditingDomain(), session, representation));
            }
        };

    }

    /**
     * Return the current selection ({@link DCell} or {@link DLine}.
     * 
     * @return the current selection
     */
    private DTableElement getCurrentTableElement() {
        DTableElement result = null;
        final Collection<DLine> selectedLines = treeViewManager.getSelectedLines();
        if (selectedLines != null && selectedLines.size() == 1) {
            DLine firstSelectedLine = selectedLines.iterator().next();
            if (treeViewManager.getActiveColumn() > 0) {
                final DColumn column = dTable.getColumns().get(treeViewManager.getActiveColumn() - 1);
                Option<DCell> optionalCell = TableHelper.getCell(firstSelectedLine, column);
                if (optionalCell.some()) {
                    result = optionalCell.get();
                }
            } else {
                result = firstSelectedLine;
            }
        }
        return result;
    }

    private void addRefreshMenu(final IMenuManager manager) {
        manager.add(refreshAction);
    }

    private void addSortMenu(final IMenuManager manager) {
        DColumn activeColumn = null;
        if (treeViewManager.getActiveColumn() > 0) {
            activeColumn = dTable.getColumns().get(treeViewManager.getActiveColumn() - 1);
        }
        sortLinesByColumnAction.setColumn(activeColumn);
        if (activeColumn == null) {
            sortLinesByColumnAction.setTable(dTable);
        }
        if (sortLinesByColumnAction.isEnabled()) {
            manager.add(sortLinesByColumnAction);
        }

        final Collection<DLine> selectedLines = treeViewManager.getSelectedLines();
        if (selectedLines != null && !selectedLines.isEmpty()) {
            DLine firstSelectedLine = selectedLines.iterator().next();
            sortColumnsByLineAction.setLine(firstSelectedLine);
            if (sortColumnsByLineAction.isEnabled()) {
                manager.add(sortColumnsByLineAction);
            }
        }
    }

    private void addExportMenu(final IMenuManager manager) {
        // Create a new sub-menu manager
        final MenuManager exportMenuManager = new MenuManager("Export", DTableMenuListener.MENU_EXPORT_ID);
        // Create the item to add to the main manager
        final SubContributionItem menuItem = new SubContributionItem(exportMenuManager);
        menuItem.setVisible(true);
        manager.add(menuItem);
        exportMenuManager.add(new Separator(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR));
        final IAction action = new Action("CSV", DTableViewerManager.getImageRegistry().getDescriptor(DTableViewerManager.EXPORT_IMG)) {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.action.Action#run()
             */
            @Override
            public void run() {
                final IHandlerService handlerService = (IHandlerService) treeViewManager.getEditor().getSite().getService(IHandlerService.class);
                try {
                    handlerService.executeCommand("org.eclipse.sirius.table.ui.exportToCsv", null); //$NON-NLS-1$
                } catch (final CommandException ex) {
                    throw new RuntimeException("export to csv command not found");
                }
            }
        };
        exportMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, action);
    }

    /**
     * Add the viewpoint sub menu and its actions if needed.
     * 
     * @param manager
     *            The menu manager
     */
    private void addHideRevealMenu(final IMenuManager manager) {
        // Create a new sub-menu manager
        final MenuManager hideRevealMenuManager = new MenuManager("Show/Hide", DTableMenuListener.MENU_HIDEREVEAL_ID);
        // Create the item to add to the main manager
        final SubContributionItem viewpointMenuItem = new SubContributionItem(hideRevealMenuManager);
        viewpointMenuItem.setVisible(true);
        manager.add(viewpointMenuItem);
        hideRevealMenuManager.add(new Separator(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR));

        // Columns visibility
        DColumn activeColumn = null;
        if (treeViewManager.getActiveColumn() > 0) {
            activeColumn = dTable.getColumns().get(treeViewManager.getActiveColumn() - 1);
        }

        if (activeColumn != null && activeColumn.isVisible()) {
            hideColumnAction.setColumn(activeColumn);
            if (hideColumnAction.isEnabled()) {
                hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, hideColumnAction);
            }
        }

        hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, showAllColumnsAction);

        hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, hideRevealColumnsAction);

        hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, new Separator());

        // Lines visibility
        final Collection<DLine> selectedLines = treeViewManager.getSelectedLines();
        if (selectedLines != null && !selectedLines.isEmpty()) {
            Predicate<DLine> isVisible = new Predicate<DLine>() {
                public boolean apply(DLine input) {
                    return input.isVisible();
                }
            };
            Iterable<DLine> visibleSelection = Iterables.filter(selectedLines, isVisible);

            hideLineAction.setLines(Lists.newArrayList(visibleSelection));
            if (hideLineAction.isEnabled()) {
                hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, hideLineAction);
            }
        }
        hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, showAllLinesAction);

        hideRevealMenuManager.appendToGroup(DTableMenuListener.VIEWPOINT_GROUP_SEPARATOR, hideRevealLinesAction);
    }

    /**
     * Add the column menus.<BR>
     * 
     * @param manager
     *            the menu manager
     */
    private void addColumnMenus(final IMenuManager manager) {
        if (treeViewManager.getActiveColumn() > 0) {
            final DColumn column = dTable.getColumns().get(treeViewManager.getActiveColumn() - 1);
            // Tools only available for column of type DTargetColumn
            if (column instanceof DTargetColumn && ((DTargetColumn) column).getOriginMapping() != null) {
                final DTargetColumn targetColumn = (DTargetColumn) column;
                final AbstractTargetColumnAction deleteAction = getMappingToDeleteActions().get(targetColumn.getOriginMapping());
                deleteAction.setColumn(targetColumn);
                if (deleteAction.canExecute()) {
                    manager.add(deleteAction);
                }
                final List<AbstractToolAction> createActions = getMappingToCreateActions().get(targetColumn.getOriginMapping());
                if (createActions != null) {
                    for (final AbstractToolAction createAction : createActions) {
                        ((AbstractTargetColumnAction) createAction).setColumn(targetColumn);
                        if (createAction.canExecute()) {
                            manager.add(createAction);
                        }
                    }
                }
                manager.add(new Separator());
            }
        }
    }

    /**
     * Add the line menus.<BR>
     * 
     * @param manager
     *            the menu manager
     */
    private void addLineMenus(final IMenuManager manager) {
        final Collection<DLine> selectedLines = treeViewManager.getSelectedLines();
        if (selectedLines != null && !selectedLines.isEmpty()) {
            addDeleteLinesAction(manager, selectedLines);

            // Expose create actions if there is only one selected line.
            if (selectedLines.size() == 1) {
                DLine firstSelectedLine = selectedLines.iterator().next();
                addCreateActions(manager, firstSelectedLine);
            }

            manager.add(new Separator());
        }
    }

    private void addCreateActions(final IMenuManager manager, DLine singleSelectedLine) {
        final List<AbstractToolAction> createActions = getMappingToCreateActions().get(singleSelectedLine.getOriginMapping());
        if (createActions != null && !createActions.isEmpty()) {
            for (final AbstractToolAction createAction : createActions) {
                ((AbstractLineAction) createAction).setLine(singleSelectedLine);
                if (createAction.canExecute()) {
                    manager.add(createAction);
                }
            }
        }
    }

    private void addDeleteLinesAction(final IMenuManager manager, Collection<DLine> selectedLines) {
        deleteLinesAction.setLines(selectedLines);
        if (deleteLinesAction.canExecute()) {
            manager.add(deleteLinesAction);
        }
    }

    private void createDetailsActions(final DTableElement currentElement, final SubContributionItem navigate) {
        if (currentElement.getMapping() != null) {
            final Session session = currentElement.getTarget() != null ? SessionManager.INSTANCE.getSession(currentElement.getTarget()) : null;
            if (session != null) {
                for (RepresentationCreationDescription desc : currentElement.getMapping().getDetailDescriptions()) {
                    boolean append = true;
                    if (!isFromActiveViewpoint(session, desc.getRepresentationDescription())) {
                        append = false;
                    }

                    final String precondition = desc.getPrecondition();
                    if (append && !StringUtil.isEmpty(precondition)) {
                        append = false;
                        final IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(currentElement.getTarget());
                        try {
                            append = interpreter.evaluateBoolean(currentElement.getTarget(), precondition);
                        } catch (final EvaluationException e) {
                            // do nothing
                        }
                    }
                    if (append) {
                        navigate.setVisible(true);
                        ((IMenuManager) navigate.getInnerItem()).appendToGroup(NEW_REPRESENTATION_GROUP_SEPARATOR, new CreateRepresentationFromRepresentationCreationDescription(desc, currentElement,
                                treeViewManager.getEditingDomain(), treeViewManager.getTableCommandFactory()));
                    }
                }
            }
        }
    }

    /**
     * Tests whether a representation description belongs to a viewpoint which
     * is currently active in the session.
     * 
     * @param session
     *            the current session.
     * @param representationDescription
     *            the representation description to check.
     * @return <code>true</code> if the representation description belongs to a
     *         viewpoint which is currently active in the session.
     */
    private boolean isFromActiveViewpoint(final Session session, final RepresentationDescription representationDescription) {
        final Viewpoint vp = ViewpointRegistry.getInstance().getViewpoint(representationDescription);
        return vp != null && session.getSelectedViewpoints(false).contains(vp);
    }

    /**
     * Tests whether a representation belongs to a viewpoint which is currently
     * active in the session.
     * 
     * @param session
     *            the current session.
     * @param representation
     *            the representation to check.
     * @return <code>true</code> if the representation belongs to a viewpoint
     *         which is currently active in the session.
     */
    private boolean isFromActiveViewpoint(final Session session, final DRepresentation representation) {
        final RepresentationDescription description = DialectManager.INSTANCE.getDescription(representation);
        return isFromActiveViewpoint(session, description);
    }

    protected Map<TableMapping, DeleteTargetColumnAction> getMappingToDeleteActions() {
        return mappingToDeleteColumnActions;
    }

    public void setMappingToDeleteActions(final Map<TableMapping, DeleteTargetColumnAction> mappingToDeleteActions) {
        this.mappingToDeleteColumnActions = mappingToDeleteActions;
    }

    protected Map<TableMapping, List<AbstractToolAction>> getMappingToCreateActions() {
        return mappingToCreateActions;
    }

    public void setMappingToCreateActions(final Map<TableMapping, List<AbstractToolAction>> mappingToCreateActions) {
        this.mappingToCreateActions = mappingToCreateActions;
    }

    protected List<AbstractToolAction> getCreateActionsForTable() {
        return createActionsForTable;
    }

    public void setCreateActionsForTable(final List<AbstractToolAction> createActionsForTable) {
        this.createActionsForTable = createActionsForTable;
    }

    private static class AttachEditorRecordingCommand extends RecordingCommand {

        private Session session;

        private DRepresentation representation;

        public AttachEditorRecordingCommand(TransactionalEditingDomain domain, Session session, DRepresentation representation) {
            super(domain);
            this.session = session;
            this.representation = representation;
        }

        @Override
        protected void doExecute() {
            final IEditingSession ui = SessionUIManager.INSTANCE.getUISession(session);
            DialectManager.INSTANCE.refresh(representation, new NullProgressMonitor());
            final IEditorPart part = DialectUIManager.INSTANCE.openEditor(session, representation, new NullProgressMonitor());
            if (part != null && ui != null) {
                ui.attachEditor((DialectEditor) part);
            }
        }

    }
}
