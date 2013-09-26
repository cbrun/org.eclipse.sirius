/*******************************************************************************
 * Copyright (c) 2007-2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.table.metamodel.table.provider;

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
import org.eclipse.sirius.table.metamodel.table.util.TableAdapterFactory;

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
public class TableItemProviderAdapterFactory extends TableAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n   Obeo - initial API and implementation\n";

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
    public TableItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DTable} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DTableItemProvider dTableItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DTable}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDTableAdapter() {
        if (dTableItemProvider == null) {
            dTableItemProvider = new DTableItemProvider(this);
        }

        return dTableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DLine} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DLineItemProvider dLineItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DLine}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDLineAdapter() {
        if (dLineItemProvider == null) {
            dLineItemProvider = new DLineItemProvider(this);
        }

        return dLineItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DCell} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DCellItemProvider dCellItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DCell}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDCellAdapter() {
        if (dCellItemProvider == null) {
            dCellItemProvider = new DCellItemProvider(this);
        }

        return dCellItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DCellStyle} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DCellStyleItemProvider dCellStyleItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DCellStyle}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDCellStyleAdapter() {
        if (dCellStyleItemProvider == null) {
            dCellStyleItemProvider = new DCellStyleItemProvider(this);
        }

        return dCellStyleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DTargetColumn} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DTargetColumnItemProvider dTargetColumnItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DTargetColumn}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDTargetColumnAdapter() {
        if (dTargetColumnItemProvider == null) {
            dTargetColumnItemProvider = new DTargetColumnItemProvider(this);
        }

        return dTargetColumnItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DFeatureColumn}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DFeatureColumnItemProvider dFeatureColumnItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DFeatureColumn}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDFeatureColumnAdapter() {
        if (dFeatureColumnItemProvider == null) {
            dFeatureColumnItemProvider = new DFeatureColumnItemProvider(this);
        }

        return dFeatureColumnItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.table.metamodel.table.DTableElementStyle}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DTableElementStyleItemProvider dTableElementStyleItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.table.metamodel.table.DTableElementStyle}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createDTableElementStyleAdapter() {
        if (dTableElementStyleItemProvider == null) {
            dTableElementStyleItemProvider = new DTableElementStyleItemProvider(this);
        }

        return dTableElementStyleItemProvider;
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
        if (dTableItemProvider != null)
            dTableItemProvider.dispose();
        if (dLineItemProvider != null)
            dLineItemProvider.dispose();
        if (dCellItemProvider != null)
            dCellItemProvider.dispose();
        if (dCellStyleItemProvider != null)
            dCellStyleItemProvider.dispose();
        if (dTargetColumnItemProvider != null)
            dTargetColumnItemProvider.dispose();
        if (dFeatureColumnItemProvider != null)
            dFeatureColumnItemProvider.dispose();
        if (dTableElementStyleItemProvider != null)
            dTableElementStyleItemProvider.dispose();
    }

}
