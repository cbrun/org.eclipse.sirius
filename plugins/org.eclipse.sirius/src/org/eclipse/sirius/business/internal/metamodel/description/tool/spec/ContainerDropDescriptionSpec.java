/*******************************************************************************
 * Copyright (c) 2008 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.metamodel.description.tool.spec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
import org.eclipse.sirius.business.api.componentization.DiagramComponentizationManager;
import org.eclipse.sirius.business.api.componentization.DiagramMappingsManager;
import org.eclipse.sirius.business.api.componentization.DiagramMappingsManagerRegistry;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.internal.metamodel.helper.LayerHelper;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.DDiagramElementContainer;
import org.eclipse.sirius.viewpoint.DNode;
import org.eclipse.sirius.viewpoint.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DragAndDropTarget;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.AbstractNodeMapping;
import org.eclipse.sirius.viewpoint.description.ContainerMapping;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.DiagramDescription;
import org.eclipse.sirius.viewpoint.description.DiagramElementMapping;
import org.eclipse.sirius.viewpoint.description.DragAndDropTargetDescription;
import org.eclipse.sirius.viewpoint.description.EdgeMapping;
import org.eclipse.sirius.viewpoint.description.NodeMapping;
import org.eclipse.sirius.viewpoint.description.tool.impl.ContainerDropDescriptionImpl;

/**
 * Implementation of ContainerDropDescription.
 * 
 * @author ymortier
 */
public class ContainerDropDescriptionSpec extends ContainerDropDescriptionImpl {

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.viewpoint.description.tool.impl.ContainerDropDescriptionImpl#getBestMapping(org.eclipse.sirius.viewpoint.DragAndDropTarget,
     *      org.eclipse.emf.ecore.EObject)
     */
    @Override
    public DiagramElementMapping getBestMapping(final DragAndDropTarget targetContainer, final EObject droppedElement) {
        DiagramElementMapping bestMapping = null;
        Iterator<DiagramElementMapping> iterCandidates = null;
        if (targetContainer instanceof DDiagram) {
            final DDiagram diagram = (DDiagram) targetContainer;
            final DiagramDescription desc = diagram.getDescription();

            Session session = null;
            if (diagram instanceof DSemanticDiagram) {
                session = SessionManager.INSTANCE.getSession(((DSemanticDiagram) diagram).getTarget());
            }

            final Collection<DiagramElementMapping> allMappings = new LinkedList<DiagramElementMapping>(new DiagramComponentizationManager().getAllContainerMappings(session.getSelectedSiriuss(false), desc));
            allMappings.addAll(getAllMappingsWithSuperMappings(session, desc));
            allMappings.addAll(new DiagramComponentizationManager().getAllEdgeMappings(session.getSelectedSiriuss(false), desc));
            iterCandidates = allMappings.iterator();

        } else if (targetContainer instanceof DDiagramElementContainer) {
            final DDiagramElementContainer elementContainer = (DDiagramElementContainer) targetContainer;
            if (elementContainer.getMapping() instanceof ContainerMapping) {
                final ContainerMapping containerMapping = (ContainerMapping) elementContainer.getMapping();
                final Collection<DiagramElementMapping> allMappings = new LinkedList<DiagramElementMapping>(containerMapping.getAllContainerMappings());
                allMappings.addAll(getAllMappingsWithSuperMappings(containerMapping));
                allMappings.addAll(containerMapping.getAllBorderedNodeMappings());
                final DDiagram diagram = elementContainer.getParentDiagram();
                final DiagramDescription desc = diagram.getDescription();
                allMappings.addAll(desc.getAllEdgeMappings());
                iterCandidates = allMappings.iterator();
            }
        } else if (targetContainer instanceof DNode) {
            final DNode viewNode = (DNode) targetContainer;
            final NodeMapping nodeMapping = viewNode.getActualMapping();
            final Collection<DiagramElementMapping> allMappings = new LinkedList<DiagramElementMapping>(nodeMapping.getAllBorderedNodeMappings());
            iterCandidates = allMappings.iterator();
        }
        if (iterCandidates == null) {
            SiriusPlugin.getDefault().error("Unknown drag&drop target : " + targetContainer, new RuntimeException());
            return null;
        }
        Session session = SessionManager.INSTANCE.getSession(droppedElement);
        
        final ModelAccessor extendedPackage = session.getModelAccessor();
        while (iterCandidates.hasNext()) {
            final DiagramElementMapping currentMapping = iterCandidates.next();
            final String domainClass = ContainerDropDescriptionSpec.getDomainClass(currentMapping);
            if (this.getMappings().contains(currentMapping) && domainClass != null && !StringUtil.isEmpty(domainClass.trim())) {
                if (extendedPackage.eInstanceOf(droppedElement, domainClass)) {
                    final DDiagram diagram = ContainerDropDescriptionSpec.getDiagram(targetContainer);
                    if (diagram != null) {
                        DiagramMappingsManager mappingManager = DiagramMappingsManagerRegistry.INSTANCE.getDiagramMappingsManager(session, diagram);
                        if (LayerHelper.isInActivatedLayer(mappingManager, diagram, currentMapping)) {
                            bestMapping = currentMapping;
                            break;
                        }
                    }
                }
            }
        }
        return bestMapping;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.viewpoint.description.tool.impl.ContainerDropDescriptionImpl#getContainers()
     */
    @Override
    public EList<DragAndDropTargetDescription> getContainers() {
        if (this.eResource() == null) {
            throw new UnsupportedOperationException();
        }
        ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(this.eResource());
        if (crossReferencer == null) {
            throw new UnsupportedOperationException();
        }
        final List<DragAndDropTargetDescription> dndTargetDescriptions = new LinkedList<DragAndDropTargetDescription>();
        final Collection<Setting> settings = crossReferencer.getInverseReferences(this, true);
        for (final Setting setting : settings) {
            final EObject eReferencer = setting.getEObject();
            final EStructuralFeature eFeature = setting.getEStructuralFeature();
            if (eReferencer instanceof DragAndDropTargetDescription && eFeature.equals(DescriptionPackage.eINSTANCE.getDragAndDropTargetDescription_DropDescriptions())) {
                dndTargetDescriptions.add((DragAndDropTargetDescription) eReferencer);
            }
        }
        return new BasicEList<DragAndDropTargetDescription>(dndTargetDescriptions);
    }

    private static DDiagram getDiagram(final DragAndDropTarget target) {
        DDiagram diagram = null;
        if (target instanceof DDiagramElement) {
            diagram = ((DDiagramElement) target).getParentDiagram();
        } else if (target instanceof DDiagram) {
            diagram = (DDiagram) target;
        }

        return diagram;
    }

    private Collection<DiagramElementMapping> getAllMappingsWithSuperMappings(final ContainerMapping containerMapping) {
        final Collection<DiagramElementMapping> result = new ArrayList<DiagramElementMapping>();
        final Iterator<NodeMapping> it = containerMapping.getAllNodeMappings().iterator();
        while (it.hasNext()) {
            final NodeMapping nM = it.next();
            result.add(nM);
        }
        return result;
    }

    private Collection<DiagramElementMapping> getAllMappingsWithSuperMappings(final Session session, final DiagramDescription desc) {
        final Collection<DiagramElementMapping> result = new ArrayList<DiagramElementMapping>();
        final Iterator<NodeMapping> it = new DiagramComponentizationManager().getAllNodeMappings(session.getSelectedSiriuss(false), desc).iterator();
        while (it.hasNext()) {
            final NodeMapping nM = it.next();
            result.add(nM);
        }
        return result;
    }

    private static String getDomainClass(final DiagramElementMapping mapping) {
        String domainClass = null;
        if (mapping instanceof EdgeMapping) {
            final EdgeMapping edgeMapping = (EdgeMapping) mapping;
            if (edgeMapping.isUseDomainElement()) {
                domainClass = edgeMapping.getDomainClass();
            }
        } else if (mapping instanceof AbstractNodeMapping) {
            domainClass = ((AbstractNodeMapping) mapping).getDomainClass();
        }
        return domainClass;
    }

}
