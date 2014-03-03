/**
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Obeo - initial API and implementation
 * 
 */
package org.eclipse.sirius.diagram.description.tool.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.sirius.diagram.description.tool.util.ToolAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support
 * Viewers. The adapters generated by this factory convert EMF adapter
 * notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The
 * adapters also support Eclipse property sheets. Note that most of the adapters
 * are shared among multiple instances. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ToolItemProviderAdapterFactory extends ToolAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this
     * adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement
     * {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by
     * {@link #isFactoryForType isFactoryForType}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public ToolItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ToolSection}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ToolSectionItemProvider toolSectionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ToolSection}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createToolSectionAdapter() {
        if (toolSectionItemProvider == null) {
            toolSectionItemProvider = new ToolSectionItemProvider(this);
        }

        return toolSectionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ToolGroup} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ToolGroupItemProvider toolGroupItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ToolGroup}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createToolGroupAdapter() {
        if (toolGroupItemProvider == null) {
            toolGroupItemProvider = new ToolGroupItemProvider(this);
        }

        return toolGroupItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ToolGroupExtension}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ToolGroupExtensionItemProvider toolGroupExtensionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ToolGroupExtension}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createToolGroupExtensionAdapter() {
        if (toolGroupExtensionItemProvider == null) {
            toolGroupExtensionItemProvider = new ToolGroupExtensionItemProvider(this);
        }

        return toolGroupExtensionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.NodeCreationDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NodeCreationDescriptionItemProvider nodeCreationDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.NodeCreationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createNodeCreationDescriptionAdapter() {
        if (nodeCreationDescriptionItemProvider == null) {
            nodeCreationDescriptionItemProvider = new NodeCreationDescriptionItemProvider(this);
        }

        return nodeCreationDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EdgeCreationDescriptionItemProvider edgeCreationDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createEdgeCreationDescriptionAdapter() {
        if (edgeCreationDescriptionItemProvider == null) {
            edgeCreationDescriptionItemProvider = new EdgeCreationDescriptionItemProvider(this);
        }

        return edgeCreationDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ContainerCreationDescriptionItemProvider containerCreationDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createContainerCreationDescriptionAdapter() {
        if (containerCreationDescriptionItemProvider == null) {
            containerCreationDescriptionItemProvider = new ContainerCreationDescriptionItemProvider(this);
        }

        return containerCreationDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DeleteElementDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DeleteElementDescriptionItemProvider deleteElementDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DeleteElementDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDeleteElementDescriptionAdapter() {
        if (deleteElementDescriptionItemProvider == null) {
            deleteElementDescriptionItemProvider = new DeleteElementDescriptionItemProvider(this);
        }

        return deleteElementDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DoubleClickDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DoubleClickDescriptionItemProvider doubleClickDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DoubleClickDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDoubleClickDescriptionAdapter() {
        if (doubleClickDescriptionItemProvider == null) {
            doubleClickDescriptionItemProvider = new DoubleClickDescriptionItemProvider(this);
        }

        return doubleClickDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DeleteHook} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DeleteHookItemProvider deleteHookItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DeleteHook}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDeleteHookAdapter() {
        if (deleteHookItemProvider == null) {
            deleteHookItemProvider = new DeleteHookItemProvider(this);
        }

        return deleteHookItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DeleteHookParameter}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DeleteHookParameterItemProvider deleteHookParameterItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DeleteHookParameter}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDeleteHookParameterAdapter() {
        if (deleteHookParameterItemProvider == null) {
            deleteHookParameterItemProvider = new DeleteHookParameterItemProvider(this);
        }

        return deleteHookParameterItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ReconnectEdgeDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ReconnectEdgeDescriptionItemProvider reconnectEdgeDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ReconnectEdgeDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createReconnectEdgeDescriptionAdapter() {
        if (reconnectEdgeDescriptionItemProvider == null) {
            reconnectEdgeDescriptionItemProvider = new ReconnectEdgeDescriptionItemProvider(this);
        }

        return reconnectEdgeDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.RequestDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RequestDescriptionItemProvider requestDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.RequestDescription}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createRequestDescriptionAdapter() {
        if (requestDescriptionItemProvider == null) {
            requestDescriptionItemProvider = new RequestDescriptionItemProvider(this);
        }

        return requestDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DirectEditLabel}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DirectEditLabelItemProvider directEditLabelItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DirectEditLabel}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDirectEditLabelAdapter() {
        if (directEditLabelItemProvider == null) {
            directEditLabelItemProvider = new DirectEditLabelItemProvider(this);
        }

        return directEditLabelItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.BehaviorTool}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BehaviorToolItemProvider behaviorToolItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.BehaviorTool}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createBehaviorToolAdapter() {
        if (behaviorToolItemProvider == null) {
            behaviorToolItemProvider = new BehaviorToolItemProvider(this);
        }

        return behaviorToolItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.SourceEdgeCreationVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SourceEdgeCreationVariableItemProvider sourceEdgeCreationVariableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.SourceEdgeCreationVariable}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createSourceEdgeCreationVariableAdapter() {
        if (sourceEdgeCreationVariableItemProvider == null) {
            sourceEdgeCreationVariableItemProvider = new SourceEdgeCreationVariableItemProvider(this);
        }

        return sourceEdgeCreationVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.SourceEdgeViewCreationVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SourceEdgeViewCreationVariableItemProvider sourceEdgeViewCreationVariableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.SourceEdgeViewCreationVariable}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createSourceEdgeViewCreationVariableAdapter() {
        if (sourceEdgeViewCreationVariableItemProvider == null) {
            sourceEdgeViewCreationVariableItemProvider = new SourceEdgeViewCreationVariableItemProvider(this);
        }

        return sourceEdgeViewCreationVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.TargetEdgeCreationVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TargetEdgeCreationVariableItemProvider targetEdgeCreationVariableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.TargetEdgeCreationVariable}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTargetEdgeCreationVariableAdapter() {
        if (targetEdgeCreationVariableItemProvider == null) {
            targetEdgeCreationVariableItemProvider = new TargetEdgeCreationVariableItemProvider(this);
        }

        return targetEdgeCreationVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.TargetEdgeViewCreationVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TargetEdgeViewCreationVariableItemProvider targetEdgeViewCreationVariableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.TargetEdgeViewCreationVariable}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTargetEdgeViewCreationVariableAdapter() {
        if (targetEdgeViewCreationVariableItemProvider == null) {
            targetEdgeViewCreationVariableItemProvider = new TargetEdgeViewCreationVariableItemProvider(this);
        }

        return targetEdgeViewCreationVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ElementDoubleClickVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ElementDoubleClickVariableItemProvider elementDoubleClickVariableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ElementDoubleClickVariable}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createElementDoubleClickVariableAdapter() {
        if (elementDoubleClickVariableItemProvider == null) {
            elementDoubleClickVariableItemProvider = new ElementDoubleClickVariableItemProvider(this);
        }

        return elementDoubleClickVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.NodeCreationVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NodeCreationVariableItemProvider nodeCreationVariableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.NodeCreationVariable}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createNodeCreationVariableAdapter() {
        if (nodeCreationVariableItemProvider == null) {
            nodeCreationVariableItemProvider = new NodeCreationVariableItemProvider(this);
        }

        return nodeCreationVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.CreateView} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CreateViewItemProvider createViewItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.CreateView}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createCreateViewAdapter() {
        if (createViewItemProvider == null) {
            createViewItemProvider = new CreateViewItemProvider(this);
        }

        return createViewItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.CreateEdgeView}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CreateEdgeViewItemProvider createEdgeViewItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.CreateEdgeView}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createCreateEdgeViewAdapter() {
        if (createEdgeViewItemProvider == null) {
            createEdgeViewItemProvider = new CreateEdgeViewItemProvider(this);
        }

        return createEdgeViewItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.Navigation} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NavigationItemProvider navigationItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.Navigation}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createNavigationAdapter() {
        if (navigationItemProvider == null) {
            navigationItemProvider = new NavigationItemProvider(this);
        }

        return navigationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DiagramCreationDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DiagramCreationDescriptionItemProvider diagramCreationDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DiagramCreationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDiagramCreationDescriptionAdapter() {
        if (diagramCreationDescriptionItemProvider == null) {
            diagramCreationDescriptionItemProvider = new DiagramCreationDescriptionItemProvider(this);
        }

        return diagramCreationDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.DiagramNavigationDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DiagramNavigationDescriptionItemProvider diagramNavigationDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.DiagramNavigationDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDiagramNavigationDescriptionAdapter() {
        if (diagramNavigationDescriptionItemProvider == null) {
            diagramNavigationDescriptionItemProvider = new DiagramNavigationDescriptionItemProvider(this);
        }

        return diagramNavigationDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.diagram.description.tool.ContainerDropDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ContainerDropDescriptionItemProvider containerDropDescriptionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.diagram.description.tool.ContainerDropDescription}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createContainerDropDescriptionAdapter() {
        if (containerDropDescriptionItemProvider == null) {
            containerDropDescriptionItemProvider = new ContainerDropDescriptionItemProvider(this);
        }

        return containerDropDescriptionItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the
     * adapter. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to
     * {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void dispose() {
        if (toolSectionItemProvider != null)
            toolSectionItemProvider.dispose();
        if (toolGroupItemProvider != null)
            toolGroupItemProvider.dispose();
        if (toolGroupExtensionItemProvider != null)
            toolGroupExtensionItemProvider.dispose();
        if (nodeCreationDescriptionItemProvider != null)
            nodeCreationDescriptionItemProvider.dispose();
        if (edgeCreationDescriptionItemProvider != null)
            edgeCreationDescriptionItemProvider.dispose();
        if (containerCreationDescriptionItemProvider != null)
            containerCreationDescriptionItemProvider.dispose();
        if (deleteElementDescriptionItemProvider != null)
            deleteElementDescriptionItemProvider.dispose();
        if (doubleClickDescriptionItemProvider != null)
            doubleClickDescriptionItemProvider.dispose();
        if (deleteHookItemProvider != null)
            deleteHookItemProvider.dispose();
        if (deleteHookParameterItemProvider != null)
            deleteHookParameterItemProvider.dispose();
        if (reconnectEdgeDescriptionItemProvider != null)
            reconnectEdgeDescriptionItemProvider.dispose();
        if (requestDescriptionItemProvider != null)
            requestDescriptionItemProvider.dispose();
        if (directEditLabelItemProvider != null)
            directEditLabelItemProvider.dispose();
        if (behaviorToolItemProvider != null)
            behaviorToolItemProvider.dispose();
        if (sourceEdgeCreationVariableItemProvider != null)
            sourceEdgeCreationVariableItemProvider.dispose();
        if (sourceEdgeViewCreationVariableItemProvider != null)
            sourceEdgeViewCreationVariableItemProvider.dispose();
        if (targetEdgeCreationVariableItemProvider != null)
            targetEdgeCreationVariableItemProvider.dispose();
        if (targetEdgeViewCreationVariableItemProvider != null)
            targetEdgeViewCreationVariableItemProvider.dispose();
        if (elementDoubleClickVariableItemProvider != null)
            elementDoubleClickVariableItemProvider.dispose();
        if (nodeCreationVariableItemProvider != null)
            nodeCreationVariableItemProvider.dispose();
        if (createViewItemProvider != null)
            createViewItemProvider.dispose();
        if (createEdgeViewItemProvider != null)
            createEdgeViewItemProvider.dispose();
        if (navigationItemProvider != null)
            navigationItemProvider.dispose();
        if (diagramCreationDescriptionItemProvider != null)
            diagramCreationDescriptionItemProvider.dispose();
        if (diagramNavigationDescriptionItemProvider != null)
            diagramNavigationDescriptionItemProvider.dispose();
        if (containerDropDescriptionItemProvider != null)
            containerDropDescriptionItemProvider.dispose();
    }

}