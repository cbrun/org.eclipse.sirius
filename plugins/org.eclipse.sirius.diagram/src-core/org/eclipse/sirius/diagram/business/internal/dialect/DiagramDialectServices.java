/*******************************************************************************
 * Copyright (c) 2007, 2014 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.business.internal.dialect;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.business.api.dialect.AbstractRepresentationDialectServices;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.description.IInterpretedExpressionQuery;
import org.eclipse.sirius.business.api.dialect.identifier.RepresentationElementIdentifier;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.helper.task.AbstractCommandTask;
import org.eclipse.sirius.business.api.query.IdentifiedElementQuery;
import org.eclipse.sirius.business.api.session.CustomDataConstants;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.internal.metamodel.helper.ComponentizationHelper;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.listener.NotificationUtil;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.NodeStyle;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramDescriptionMappingsRegistry;
import org.eclipse.sirius.diagram.business.api.helper.display.DisplayMode;
import org.eclipse.sirius.diagram.business.api.helper.display.DisplayServiceManager;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.business.api.refresh.DiagramCreationUtil;
import org.eclipse.sirius.diagram.business.internal.dialect.identifier.DiagramIdentifier;
import org.eclipse.sirius.diagram.business.internal.dialect.identifier.EdgeIdentifier;
import org.eclipse.sirius.diagram.business.internal.dialect.identifier.NodeContainerIdentifier;
import org.eclipse.sirius.diagram.business.internal.dialect.identifier.NodeIdentifier;
import org.eclipse.sirius.diagram.business.internal.dialect.identifier.NodeStyleIdentifier;
import org.eclipse.sirius.diagram.business.internal.helper.task.operations.CreateViewTask;
import org.eclipse.sirius.diagram.business.internal.helper.task.operations.NavigationTask;
import org.eclipse.sirius.diagram.business.internal.sync.DDiagramSynchronizer;
import org.eclipse.sirius.diagram.description.AdditionalLayer;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramExtensionDescription;
import org.eclipse.sirius.diagram.description.DiagramImportDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.tool.CreateView;
import org.eclipse.sirius.diagram.description.tool.Navigation;
import org.eclipse.sirius.diagram.tools.api.command.DiagramCommandFactoryService;
import org.eclipse.sirius.diagram.tools.internal.command.ChangeLayerActivationCommand;
import org.eclipse.sirius.diagram.ui.business.internal.dialect.description.DiagramInterpretedExpressionQuery;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.sirius.tools.api.command.CommandContext;
import org.eclipse.sirius.tools.api.command.DCommand;
import org.eclipse.sirius.tools.api.command.ui.UICallBack;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.RepresentationExtensionDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.description.style.StyleDescription;
import org.eclipse.sirius.viewpoint.description.tool.ModelOperation;

/**
 * Services for diagram.
 * 
 * @author cbrun
 */
public class DiagramDialectServices extends AbstractRepresentationDialectServices {
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isSupported(DRepresentation representation) {
        return representation instanceof DDiagram;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isSupported(RepresentationDescription description) {
        return description instanceof DiagramDescription;
    }

    /**
     * {@inheritDoc}
     */
    public boolean canCreate(final EObject semantic, final RepresentationDescription desc) {
        boolean result = false;
        if (semantic != null && isSupported(desc)) {
            DiagramDescription diagDesc = (DiagramDescription) desc;
            ModelAccessor accessor = SiriusPlugin.getDefault().getModelAccessorRegistry().getModelAccessor(semantic);
            if (accessor != null) {
                result = checkDomainClass(accessor, semantic, diagDesc.getDomainClass());

                // If the representation is a diagram description
                boolean needsToCheckSemanticElement = true;
                // We first check if the diagram description has a non null
                // initial operation
                if ((diagDesc.getInit() == null) || (diagDesc.getInit().getInitialOperation() == null) || (diagDesc.getInit().getInitialOperation().getFirstModelOperations() == null)) {
                    // If the diagram description has no initial operation
                    // we do not need to check the semantic element
                    // => true will be returned
                    needsToCheckSemanticElement = false;
                }

                if (needsToCheckSemanticElement) {
                    result = result && checkSemanticElementCanBeFilled(accessor, semantic);
                }
            }
            result = result && checkPrecondition(semantic, diagDesc.getPreconditionExpression());
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public DRepresentation createRepresentation(final String name, final EObject semantic, final RepresentationDescription description, final IProgressMonitor monitor) {
        // TODO ensure that the given description is contained in the same
        // resource set as the given semantic element
        final DiagramDescription diagDesc = (DiagramDescription) description;
        final IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(semantic);
        final ModelAccessor accessor = SiriusPlugin.getDefault().getModelAccessorRegistry().getModelAccessor(semantic);
        final DDiagramSynchronizer sync = new DDiagramSynchronizer(interpreter, diagDesc, accessor);

        sync.initDiagram(name, semantic, monitor);
        return sync.getDiagram();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRepresentation createRepresentation(final String name, final EObject semantic, final RepresentationDescription description, final Session session, final IProgressMonitor monitor) {
        DRepresentation diagram = null;
        try {
            monitor.beginTask("Create diagram : " + name, 6);
            monitor.subTask("Create diagram : " + name);
            diagram = createRepresentation(name, semantic, description, new SubProgressMonitor(monitor, 2));
            if (diagram != null) {
                refresh(diagram, new SubProgressMonitor(monitor, 26));
                if (DisplayMode.NORMAL.equals(DisplayServiceManager.INSTANCE.getMode())) {
                    DisplayServiceManager.INSTANCE.getDisplayService().refreshAllElementsVisibility((DDiagram) diagram);
                    monitor.worked(1);
                }

                session.getServices().putCustomData(CustomDataConstants.DREPRESENTATION, semantic, diagram);
                monitor.worked(1);
                Diagram gmfDiag = DiagramDialectServices.createAndStoreGMFDiagram(session, (DSemanticDiagram) diagram);
                monitor.worked(1);
                // Synchronizes the GMF diagram model according to the viewpoint
                // DSemanticDiagram model.
                CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(gmfDiag);
                canonicalSynchronizer.storeViewsToArrange(true);
                canonicalSynchronizer.synchronize();
                canonicalSynchronizer.postCreation();
                monitor.worked(10);
                
            }
        } finally {
            monitor.done();
        }
        return diagram;
    }

    /**
     * Create and store a gmf diagram from a Sirius one.
     * 
     * @param session
     *            the session
     * @param diagram
     *            the Sirius diagram
     * @return gmfDiagram created
     */
    public static Diagram createAndStoreGMFDiagram(final Session session, final DSemanticDiagram diagram) {
        final DiagramCreationUtil util = new DiagramCreationUtil(diagram);
        if (!util.findAssociatedGMFDiagram()) {
            util.createNewGMFDiagram();
        }
        final Diagram gmfDiag = util.getAssociatedGMFDiagram();
        if (gmfDiag != null) {
            session.getServices().putCustomData(CustomDataConstants.GMF_DIAGRAMS, diagram, gmfDiag);
        }
        NotYetOpenedDiagramAdapter.markAsToArrange(diagram);
        return gmfDiag;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRepresentation copyRepresentation(final DRepresentation representation, final String name, final Session session, final IProgressMonitor monitor) {

        final DRepresentation newRepresentation = super.copyRepresentation(representation, name, session, monitor);

        /* associate the one */
        session.getServices().putCustomData(CustomDataConstants.DREPRESENTATION, ((DSemanticDecorator) representation).getTarget(), newRepresentation);

        return newRepresentation;
    }

    /**
     * {@inheritDoc}
     */
    public void refresh(final DRepresentation representation, final IProgressMonitor monitor) {
        try {
            monitor.beginTask("Refresh diagram", 10);
            final DSemanticDiagram diagram = (DSemanticDiagram) representation;
            if (diagram.getDescription() != null) {
                final IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(representation);
                final ModelAccessor accessor = SiriusPlugin.getDefault().getModelAccessorRegistry().getModelAccessor(representation);
                final DDiagramSynchronizer sync = new DDiagramSynchronizer(interpreter, diagram.getDescription(), accessor);
                sync.setDiagram(diagram);
                monitor.worked(1);
                sync.refresh(new SubProgressMonitor(monitor, 7));
                DisplayServiceManager.INSTANCE.getDisplayService().refreshAllElementsVisibility(diagram);
                monitor.worked(1);
                NotificationUtil.sendNotification(diagram, org.eclipse.sirius.common.tools.api.listener.Notification.Kind.START,
                        org.eclipse.sirius.common.tools.api.listener.Notification.VISIBILITY_UPDATE);
                monitor.worked(1);
            }
        } finally {
            monitor.done();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteRepresentation(final DRepresentation representation, final Session session) {
        if (representation instanceof DDiagram) {
            session.getServices().clearCustomData(CustomDataConstants.GMF_DIAGRAMS, representation);
            SiriusUtil.delete(representation, session);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public RepresentationDescription getDescription(final DRepresentation representation) {
        if (representation instanceof DDiagram) {
            return ((DDiagram) representation).getDescription();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void initRepresentations(final Viewpoint vp, final EObject semantic) {
        super.initRepresentations(semantic, vp, DiagramDescription.class);
    }

    /**
     * {@inheritDoc}
     */
    public void initRepresentations(final Viewpoint vp, final EObject semantic, IProgressMonitor monitor) {
        super.initRepresentations(semantic, vp, DiagramDescription.class, monitor);
    }

    /**
     * {@inheritDoc}
     */
    protected <T extends RepresentationDescription> void initRepresentationForElement(T representationDescription, EObject semanticElement, IProgressMonitor monitor) {
        if (representationDescription instanceof DiagramDescription) {
            DiagramDescription diagramDescription = (DiagramDescription) representationDescription;
            if (shouldInitializeRepresentation(semanticElement, diagramDescription, diagramDescription.getDomainClass())) {

                if (DialectManager.INSTANCE.canCreate(semanticElement, diagramDescription)) {
                    TransactionalEditingDomain transactionalEditingDomain = TransactionUtil.getEditingDomain(semanticElement);

                    if (transactionalEditingDomain != null) {
                        try {
                            monitor.beginTask("Initialize diagram of type " + new IdentifiedElementQuery(representationDescription).getLabel(), 1);
                            DCommand command = DiagramCommandFactoryService.getInstance().getNewProvider().getCommandFactory(transactionalEditingDomain)
                                    .buildCreateDiagramFromDescription(diagramDescription, semanticElement, new SubProgressMonitor(monitor, 1));
                            TransactionUtil.getEditingDomain(semanticElement).getCommandStack().execute(command);
                        } finally {
                            monitor.done();
                        }
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreateIdentifier(final EObject representationElement) {
        return representationElement instanceof DDiagram || representationElement instanceof DDiagramElement || representationElement instanceof NodeStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepresentationElementIdentifier createIdentifier(final EObject representationElement, final Map<EObject, RepresentationElementIdentifier> elementToIdentifier) {

        RepresentationElementIdentifier identifier = null;

        if (representationElement instanceof DSemanticDiagram) {

            identifier = new DiagramIdentifier((DSemanticDiagram) representationElement);

        } else if (representationElement instanceof AbstractDNode) {

            final AbstractDNode node = (AbstractDNode) representationElement;
            final EObject container = node.eContainer();
            final RepresentationElementIdentifier containerIdentifier = getOrCreateIdentifier(container, elementToIdentifier);
            if (containerIdentifier != null) {
                identifier = new NodeIdentifier(node, (NodeContainerIdentifier) containerIdentifier);
            }

        } else if (representationElement instanceof DEdge) {

            final DEdge edge = (DEdge) representationElement;
            if (edge.getSourceNode() instanceof AbstractDNode && edge.getTargetNode() instanceof AbstractDNode) {
                final AbstractDNode source = (AbstractDNode) edge.getSourceNode();
                final AbstractDNode target = (AbstractDNode) edge.getTargetNode();
                final RepresentationElementIdentifier sourceIdentifier = getOrCreateIdentifier(source, elementToIdentifier);
                final RepresentationElementIdentifier targetIdentifier = getOrCreateIdentifier(target, elementToIdentifier);
                if (sourceIdentifier != null && targetIdentifier != null) {
                    identifier = new EdgeIdentifier(edge, (NodeIdentifier) sourceIdentifier, (NodeIdentifier) targetIdentifier);
                }
            }

        } else if (representationElement instanceof NodeStyle) {

            final NodeStyle node = (NodeStyle) representationElement;
            final EObject container = node.eContainer();
            final RepresentationElementIdentifier containerIdentifier = getOrCreateIdentifier(container, elementToIdentifier);
            if (containerIdentifier != null) {
                identifier = new NodeStyleIdentifier(node, (NodeIdentifier) containerIdentifier);
            }
        }

        if (identifier != null) {
            elementToIdentifier.put(representationElement, identifier);
        }

        return identifier;
    }

    private RepresentationElementIdentifier getOrCreateIdentifier(final EObject key, final Map<EObject, RepresentationElementIdentifier> elementToIdentifier) {
        return elementToIdentifier.containsKey(key) ? elementToIdentifier.get(key) : createIdentifier(key, elementToIdentifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateRepresentationsExtendedBy(final Session session, final Viewpoint viewpoint, final boolean activated) {
        final EList<RepresentationExtensionDescription> extensions = viewpoint.getOwnedRepresentationExtensions();

        for (final DView view : session.getOwnedViews()) {
            for (final DRepresentation representation : view.getAllRepresentations()) {
                if (representation instanceof DSemanticDiagram) {
                    for (final RepresentationExtensionDescription ext : extensions) {
                        if (ComponentizationHelper.extensionAppliesTo(ext, representation) && ext instanceof DiagramExtensionDescription) {
                            updateDiagram((DSemanticDiagram) representation, (DiagramExtensionDescription) ext, activated, session);
                        }
                    }
                }
            }
        }
    }

    /**
     * Update an existing diagram using a newly activated diagram extension.
     * 
     * @param diagram
     *            the diagram to update
     * @param ext
     *            the newly activated extension which applies to the diagram.
     */
    private void updateDiagram(final DSemanticDiagram diagram, final DiagramExtensionDescription ext, final boolean activated, final Session session) {
        for (final Layer layer : ext.getLayers()) {
            if (layer instanceof AdditionalLayer) {
                AdditionalLayer additionalLayer = (AdditionalLayer) layer;

                // Change Layer Activation if the Sirius is activated and
                // layer deactivated
                Boolean shouldChangeLayerActivation = activated && !diagram.getActivatedLayers().contains(additionalLayer);
                // Change Layer Activation if the Sirius is deactivated and
                // layer activated
                shouldChangeLayerActivation = shouldChangeLayerActivation || (!activated && diagram.getActivatedLayers().contains(additionalLayer));
                // Change Layer Activation if the layer is mandatory or active
                // by default
                shouldChangeLayerActivation = shouldChangeLayerActivation && (!additionalLayer.isOptional() || additionalLayer.isActiveByDefault());

                if (shouldChangeLayerActivation) {
                    new ChangeLayerActivationCommand(session.getTransactionalEditingDomain(), diagram, additionalLayer, new NullProgressMonitor()).execute();
                }
            }
        }
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.dialect.DialectServices#createInterpretedExpressionQuery(org.eclipse.emf.ecore.EObject,
     *      org.eclipse.emf.ecore.EStructuralFeature)
     */
    public IInterpretedExpressionQuery createInterpretedExpressionQuery(EObject target, EStructuralFeature feature) {
        return new DiagramInterpretedExpressionQuery(target, feature);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.dialect.DialectServices#handles(org.eclipse.sirius.viewpoint.description.RepresentationDescription)
     */
    @Override
    public boolean handles(RepresentationDescription representationDescription) {
        return (representationDescription instanceof DiagramDescription) || (representationDescription instanceof DiagramImportDescription);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.business.api.dialect.DialectServices#handles(org.eclipse.sirius.viewpoint.description.RepresentationExtensionDescription)
     */
    @Override
    public boolean handles(RepresentationExtensionDescription representationExtensionDescription) {
        return representationExtensionDescription instanceof DiagramExtensionDescription;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void invalidateMappingCache() {
        DiagramDescriptionMappingsRegistry.INSTANCE.computeMappings();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Option<? extends AbstractCommandTask> createTask(CommandContext context, ModelAccessor extPackage, ModelOperation op, Session session, UICallBack uiCallback) {
        Option<? extends AbstractCommandTask> task = Options.newNone();
        if (op instanceof CreateView) {
            final CreateView createView = (CreateView) op;
            task = Options.newSome(new CreateViewTask(context, extPackage, createView, session.getInterpreter()));
        } else if (op instanceof Navigation) {
            final Navigation doubleClickNavigation = (Navigation) op;
            task = Options.newSome(new NavigationTask(context, extPackage, doubleClickNavigation, session.getInterpreter(), uiCallback));
        }
        return task;
    }

    /**
     * {@inheritDoc}
     * 
     * The diagram dialect allows the feature customizations on style
     * descriptions.
     */
    @Override
    public boolean allowsEStructuralFeatureCustomization(EObject element) {
        if (element instanceof StyleDescription || element.eContainer() instanceof StyleDescription) {
            EPackage ePackage = element.eClass().getEPackage();
            return ePackage == org.eclipse.sirius.viewpoint.description.style.StylePackage.eINSTANCE || ePackage == org.eclipse.sirius.diagram.description.style.StylePackage.eINSTANCE;
        }
        return false;

    }
}
