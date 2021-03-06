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
package org.eclipse.sirius.business.internal.migration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.sirius.business.api.migration.IMigrationParticipant;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.osgi.framework.Version;

/**
 * Abstract migration service. Provides services to load and delegate to
 * migration participants.
 * 
 * @author fbarbin
 * 
 */
public abstract class AbstractSiriusMigrationService {

    // This migration way was introduced with 6.5.0.201208161001 version
    // for both VSM and representations files.
    private static final Version FIRST_VERSION = new Version("6.5.0.201208161001");

    /**
     * loaded delegates contributions.
     */
    private List<IMigrationParticipant> delegatesParticipants = new ArrayList<IMigrationParticipant>();

    /**
     * The last Sirius version where a migration participant is added (computed
     * from the delegatesParticipants list).
     */
    private Version lastMigrationVersion;

    /**
     * Loads contributions {@link IMigrationParticipant} from extension point
     * <code>org.eclipse.sirius.migration</code>.
     */
    protected void loadContributions() {
        delegatesParticipants.clear();
        IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.sirius.migrationParticipant");
        for (IConfigurationElement configurationElement : config) {
            try {
                String kind = configurationElement.getAttribute("kind");
                if (kind.equals(getKind())) {
                    Object contribution = configurationElement.createExecutableExtension("class");
                    if (contribution instanceof IMigrationParticipant) {
                        delegatesParticipants.add((IMigrationParticipant) contribution);
                    }
                }

            } catch (CoreException e) {
                SiriusPlugin.getDefault().getLog().log(new Status(Status.WARNING, SiriusPlugin.ID, "Cannot instanciate migration contribution", e));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public EStructuralFeature getAttribute(EClass eClass, String name, String loadedVersion) {
        EStructuralFeature structuralFeature = null;
        for (IMigrationParticipant contribution : delegatesParticipants) {
            structuralFeature = contribution.getAttribute(eClass, name, loadedVersion);
            if (structuralFeature != null) {
                break;
            }
        }
        return structuralFeature;
    }

    /**
     * {@inheritDoc}
     */
    public EStructuralFeature getLocalElement(EClass eClass, String name, String loadedVersion) {
        EStructuralFeature structuralFeature = null;
        for (IMigrationParticipant contribution : delegatesParticipants) {
            structuralFeature = contribution.getLocalElement(eClass, name, loadedVersion);
            if (structuralFeature != null) {
                break;
            }
        }
        return structuralFeature;
    }

    /**
     * {@inheritDoc}
     */
    public EClassifier getType(EPackage ePackage, String name, String loadedVersion) {
        EClassifier classifier = null;
        for (IMigrationParticipant contribution : delegatesParticipants) {
            classifier = contribution.getType(ePackage, name, loadedVersion);
            if (classifier != null) {
                break;
            }
        }
        return classifier;
    }

    /**
     * {@inheritDoc}
     */
    public Object getValue(EObject object, EStructuralFeature feature, Object value, String loadedVersion) {
        Object returnedValue = null;
        for (IMigrationParticipant contribution : delegatesParticipants) {
            returnedValue = contribution.getValue(object, feature, value, loadedVersion);
            if (returnedValue != null) {
                break;
            }
        }
        return returnedValue;
    }

    /**
     * Returns the new fragment if the corresponding reference has changed.
     * 
     * @param uriFragment
     *            the current fragment.
     * @return the optional new uri fragment (none if no changes).
     */
    public Option<String> getNewFragment(String uriFragment) {
        Option<String> optionalNewFragment = Options.newNone();
        for (IMigrationParticipant contribution : delegatesParticipants) {
            optionalNewFragment = contribution.getNewFragment(uriFragment);
            if (optionalNewFragment.some()) {
                break;
            }
        }
        return optionalNewFragment;
    }

    /**
     * {@inheritDoc}
     */
    public void postLoad(XMLResource resource, String loadedVersion) {
        for (IMigrationParticipant contribution : delegatesParticipants) {
            contribution.postLoad(resource, loadedVersion);
        }
        removeUnknownData(resource);
    }

    /**
     * Clear the unknown elements of the resource.
     * 
     * NOTE: does not remove proxies.
     * 
     * @param resource
     *            the resource
     */
    private void removeUnknownData(XMLResource resource) {
        Map<EObject, AnyType> eObjectToExtensionMap = resource.getEObjectToExtensionMap();
        Iterator<java.util.Map.Entry<EObject, AnyType>> eObjectToExtensionMapEntriesIterator = eObjectToExtensionMap.entrySet().iterator();
        while (eObjectToExtensionMapEntriesIterator.hasNext()) {
            Map.Entry<EObject, AnyType> entry = eObjectToExtensionMapEntriesIterator.next();
            AnyType unknownData = entry.getValue();
            FeatureMap mixedFeatureMap = unknownData.getMixed();
            Iterator<Entry> mixedFeatureMapEntriesIterator = mixedFeatureMap.iterator();
            while (mixedFeatureMapEntriesIterator.hasNext()) {
                FeatureMap.Entry featureMapEntry = mixedFeatureMapEntriesIterator.next();
                Object value = featureMapEntry.getValue();
                if (value instanceof AnyType) {
                    AnyType anyType = (AnyType) value;
                    if (!anyType.eIsProxy()) {
                        mixedFeatureMapEntriesIterator.remove();
                    }
                }
            }
            FeatureMap anyAttributeFeatureMap = unknownData.getAnyAttribute();
            Iterator<Entry> anyAttributeFeatureMapEntriesIterator = anyAttributeFeatureMap.iterator();
            while (anyAttributeFeatureMapEntriesIterator.hasNext()) {
                FeatureMap.Entry featureMapEntry = anyAttributeFeatureMapEntriesIterator.next();
                Object value = featureMapEntry.getValue();
                if (value instanceof AnyType) {
                    AnyType anyType = (AnyType) value;
                    if (!anyType.eIsProxy()) {
                        anyAttributeFeatureMapEntriesIterator.remove();
                    }
                }
            }
            if (mixedFeatureMap.isEmpty() && anyAttributeFeatureMap.isEmpty()) {
                eObjectToExtensionMapEntriesIterator.remove();
            }
        }
    }

    /**
     * Returns the meta-model kind concerned by that migration service.
     * 
     * @return the string corresponding to {@link IMigrationParticipant}.
     */
    protected abstract String getKind();

    // /**
    // * Provides {@link IMigrationContribution} out of extension point. Those
    // * contributions will be added by loadContributions().
    // *
    // * @return a list of contribution implementing
    // * {@link IMigrationContribution}.
    // */
    // protected abstract List<? extends IMigrationContribution>
    // getAdditionnalContributions();

    /**
     * Provides the last Sirius version where a migration participant is added.
     * 
     * @return the version as a <code>major.minor.micro.qualifier</code> format.
     */
    public Version getLastMigrationVersion() {
        if (lastMigrationVersion == null) {
            // Initialized here to do the initialization only once.
            lastMigrationVersion = FIRST_VERSION;
            for (IMigrationParticipant contribution : delegatesParticipants) {
                if (lastMigrationVersion.compareTo(contribution.getMigrationVersion()) < 0) {
                    lastMigrationVersion = contribution.getMigrationVersion();
                }
            }
        }
        return lastMigrationVersion;
    }

    /**
     * Returns whether the given version need a migration.
     * 
     * @param loadedVersion
     *            the version of current loading model.
     * @return true if loaded version is less than the last Sirius version with
     *         migration, false otherwise.
     */
    public boolean isMigrationNeeded(Version loadedVersion) {
        return getLastMigrationVersion().compareTo(loadedVersion) > 0;
    }

    /**
     * Return the EPackage to use for the given namespace found in the given
     * version, by asking to the migration participants.
     * 
     * @param namespace
     *            the nsURI of the package we are looking for.
     * @param version
     *            the version of current loading model
     * @return an EPackage if some mapping exists, null otherwise.
     */
    public EPackage getPackage(String namespace, String version) {
        EPackage returnedValue = null;
        for (IMigrationParticipant contribution : delegatesParticipants) {
            returnedValue = contribution.getPackage(namespace, version);
            if (returnedValue != null) {
                break;
            }
        }
        return returnedValue;
    }
}
