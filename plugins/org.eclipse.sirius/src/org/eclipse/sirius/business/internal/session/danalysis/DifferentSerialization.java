/*******************************************************************************
 * Copyright (c) 2014 Obeo
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.business.internal.session.danalysis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.sirius.common.tools.api.resource.ResourceMigrationMarker;
import org.eclipse.sirius.viewpoint.SiriusPlugin;

import com.google.common.base.Predicate;

/**
 * Class able to tell whether a save operation on a resource can succeed or not,
 * and if the resulting file will change.
 * 
 * Please use with care as we basically save the resource in a temporary
 * resource to know whether it will change the file or not.
 * 
 * @author cbrun
 * 
 */
public class DifferentSerialization implements Predicate<Resource> {

    private Map<?, ?> options;

    /**
     * Create a new diagnose for the given resource.
     * 
     * @param options
     *            the save options to use to compute the new serialization.
     */
    public DifferentSerialization(final Map<?, ?> options) {
        this.options = options;
    }

    /**
     * return true if the resource will get the same serialization than the one
     * on the disk
     * 
     * @return return true if the resource will get the same serialization than
     *         the one on the disk.
     * @throws IOException
     *             on error while saving.
     */
    private boolean hasSameSerialization(Resource resourcetoSave) throws IOException {
        // CHECKSTYLE:OFF : code coming from
        // ResourceImpl.saveOnlyIfChangedWithFileBuffer
        resourcetoSave.eSetDeliver(false);
        final File temporaryFile = File.createTempFile("ResourceSaveHelper", null);
        boolean equal = true;
        try {
            final URI temporaryFileURI = URI.createFileURI(temporaryFile.getPath());

            final URIConverter uriConverter = resourcetoSave.getResourceSet() == null ? new ResourceSetImpl().getURIConverter() : resourcetoSave.getResourceSet().getURIConverter();
            final OutputStream temporaryFileOutputStream = uriConverter.createOutputStream(temporaryFileURI);
            boolean previousIsModified = resourcetoSave.isModified();
            try {
                resourcetoSave.save(temporaryFileOutputStream, options);
            } finally {
                temporaryFileOutputStream.close();
                resourcetoSave.setModified(previousIsModified);
            }

            InputStream oldContents = null;
            try {
                oldContents = uriConverter.createInputStream(resourcetoSave.getURI());
            } catch (final IOException exception) {
                equal = false;
            }
            final byte[] newContentBuffer = new byte[4000];
            if (oldContents != null) {
                try {
                    final InputStream newContents = uriConverter.createInputStream(temporaryFileURI);
                    try {
                        final byte[] oldContentBuffer = new byte[4000];
                        LOOP: for (int oldLength = oldContents.read(oldContentBuffer), newLength = newContents.read(newContentBuffer); (equal = oldLength == newLength) && oldLength > 0; oldLength = oldContents
                                .read(oldContentBuffer), newLength = newContents.read(newContentBuffer)) {
                            for (int i = 0; i < oldLength; ++i) {
                                if (oldContentBuffer[i] != newContentBuffer[i]) {
                                    equal = false;
                                    break LOOP;
                                }
                            }
                        }
                    } finally {
                        newContents.close();
                    }
                } finally {
                    oldContents.close();
                }
            }
        } finally {
            temporaryFile.delete();
            resourcetoSave.eSetDeliver(true);
        }
        // CHECKSTYLE:ON
        if (equal) {
            ResourceMigrationMarker.clearMigrationMarker(resourcetoSave);
        }
        return equal;
    }

    @Override
    public boolean apply(Resource input) {
        boolean hasChangesToSave = false;
        try {
            hasChangesToSave = !hasSameSerialization(input);
        } catch (final IOException e) {
            SiriusPlugin.getDefault().error("Error saving resource", e);
        }
        return hasChangesToSave;
    }

}
