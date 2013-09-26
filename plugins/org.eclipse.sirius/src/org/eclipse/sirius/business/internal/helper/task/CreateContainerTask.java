/*******************************************************************************
 * Copyright (c) 2007, 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.helper.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.Option;
import org.eclipse.sirius.business.api.componentization.DiagramMappingsManager;
import org.eclipse.sirius.business.api.componentization.DiagramMappingsManagerRegistry;
import org.eclipse.sirius.business.api.helper.task.AbstractCommandTask;
import org.eclipse.sirius.business.api.helper.task.ICreationTask;
import org.eclipse.sirius.business.api.preferences.DesignerPreferencesKeys;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.internal.experimental.sync.AbstractDNodeCandidate;
import org.eclipse.sirius.business.internal.experimental.sync.DDiagramElementSynchronizer;
import org.eclipse.sirius.business.internal.metamodel.description.operations.AbstractNodeMappingSpecOperations;
import org.eclipse.sirius.tools.api.command.DCommand;
import org.eclipse.sirius.tools.api.refresh.BestMappingGetter;
import org.eclipse.sirius.viewpoint.AbstractDNode;
import org.eclipse.sirius.viewpoint.ArrangeConstraint;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DragAndDropTarget;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.ContainerMapping;
import org.eclipse.sirius.viewpoint.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

/**
 * A Task to create {@link org.eclipse.sirius.viewpoint.DDiagramElementContainer}.
 * 
 * @author mchauvin
 */
public class CreateContainerTask extends AbstractCommandTask implements ICreationTask {

    private final DCommand cmd;

    private final ContainerCreationDescription tool;

    private final ModelAccessor modelAccessor;

    private DragAndDropTarget containerView;

    /** The created containers. */
    private Collection<AbstractDNode> createdAbstractDNodes = new ArrayList<AbstractDNode>();

    /**
     * Default constructor.
     * 
     * @param tool
     *            the tool
     * @param cmd
     *            the command
     * @param modelAccessor
     *            the {@link ModelAccessor}
     * @param containerView
     *            the container view
     */
    public CreateContainerTask(final ContainerCreationDescription tool, final DCommand cmd, final ModelAccessor modelAccessor, final DragAndDropTarget containerView) {
        this.tool = tool;
        this.cmd = cmd;
        this.modelAccessor = modelAccessor;
        this.containerView = containerView;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#execute()
     */
    public void execute() {
        EObjectQuery eObjectQuery = new EObjectQuery(containerView);
        Session session = eObjectQuery.getSession();
        Option<DDiagram> parentDiagramOption = eObjectQuery.getParentDiagram();
        if (parentDiagramOption.some() && parentDiagramOption.get() instanceof DSemanticDiagram) {
            DSemanticDiagram dSemanticDiagram = (DSemanticDiagram) parentDiagramOption.get();
            createContainers(session, dSemanticDiagram);
        }
    }

    private void createContainers(Session session, DSemanticDiagram dSemanticDiagram) {
        IInterpreter interpreter = session.getInterpreter();
        DDiagramElementSynchronizer dDiagramElementSynchronizer = new DDiagramElementSynchronizer(dSemanticDiagram, interpreter, modelAccessor);
        Collection<EObject> createdObjects = cmd.getCreatedObjects();
        DiagramMappingsManager mappingManager = DiagramMappingsManagerRegistry.INSTANCE.getDiagramMappingsManager(session, dSemanticDiagram);
        for (EObject semanticElt : createdObjects) {
            BestMappingGetter bestMappingGetter = new BestMappingGetter((DSemanticDecorator) containerView, semanticElt);
            ContainerMapping bestMapping = bestMappingGetter.getBestContainerMapping(tool.getContainerMappings());
            if (bestMapping != null) {
                    AbstractDNodeCandidate abstractDNodeCandidate = new AbstractDNodeCandidate(bestMapping, semanticElt, containerView);
                    AbstractDNode createdAbstractDNode = dDiagramElementSynchronizer.createNewNode(mappingManager, abstractDNodeCandidate, false);
                    if (createdAbstractDNode != null) {
                        AbstractNodeMappingSpecOperations.createBorderingNodes(bestMapping, semanticElt, createdAbstractDNode, Collections.emptyList(), dSemanticDiagram);

                        if (isAutoPinOnCreateEnabled()) {
                            createdAbstractDNode.getArrangeConstraints().add(ArrangeConstraint.KEEP_LOCATION);
                            createdAbstractDNode.getArrangeConstraints().add(ArrangeConstraint.KEEP_RATIO);
                            createdAbstractDNode.getArrangeConstraints().add(ArrangeConstraint.KEEP_SIZE);
                        }
                        AbstractNodeMappingSpecOperations.setInitialVisibility(createdAbstractDNode, dSemanticDiagram, session);
                        createdAbstractDNodes.add(createdAbstractDNode);
                    }
            }
        }
    }

    private boolean isAutoPinOnCreateEnabled() {
        return Platform.getPreferencesService().getBoolean(SiriusPlugin.ID, DesignerPreferencesKeys.PREF_AUTO_PIN_ON_CREATE.name(), false, null);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICommandTask#getLabel()
     */
    public String getLabel() {
        return "create a container";
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.helper.task.ICreationTask#getCreatedElements()
     */
    public Collection<EObject> getCreatedElements() {
        // not applicable
        return Collections.emptySet();
    }

    /**
     * {@inheritDoc}
     */
    public Collection<DRepresentationElement> getCreatedRepresentationElements() {
        return new ArrayList<DRepresentationElement>(createdAbstractDNodes);
    }

    /**
     * {@inheritDoc}
     */
    public Collection<EObject> getAffectedElements() {
        // not applicable
        return Collections.emptySet();
    }

    /**
     * {@inheritDoc}
     */
    public Collection<EObject> getCreatedReferences() {
        // not applicable
        return Collections.emptySet();
    }
}
