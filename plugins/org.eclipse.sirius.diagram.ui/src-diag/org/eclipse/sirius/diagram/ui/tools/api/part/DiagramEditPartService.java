/******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *    Obeo - Renamed, completed and adapted for Sirius.
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.api.part;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.common.core.command.FileModificationValidator;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.ui.internal.refresh.layout.SiriusCanonicalLayoutHandler;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.diagram.ui.tools.internal.part.OffscreenEditPartFactory;
import org.eclipse.sirius.diagram.ui.tools.internal.part.SiriusImageLoader;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;

/**
 * Utility class to render a diagram to an image file (with the use of specific
 * OffscreenEditPartFactory). This class is overridden for a problem in the
 * default
 * {@link org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer} used
 * by OffscreenEditPartFactory so we therefore use our
 * {@link OffscreenEditPartFactory} in place.
 * 
 * Many methods are duplicated from {@link CopyToImageUtil} (version
 * org.eclipse.gmf.runtime.diagram.ui.render_1.4.1.v20100909-1300).
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class DiagramEditPartService extends org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil {

    private static Class<?> exportToHtmlClass;

    private static Boolean canExportToHtml;

    private boolean exportToHtml;

    /**
     * Check if GMF is able to export in HTML.
     * 
     * @return <code>true</code> if it is, <code>false</code> otherwise
     */
    public static boolean canExportToHtml() {
        if (canExportToHtml == null) {
            try {
                exportToHtmlClass = Class.forName("org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToHTMLImageUtil");
                canExportToHtml = true;
            } catch (ClassNotFoundException e) {
                canExportToHtml = false;
            }
        }
        return canExportToHtml;
    }

    /**
     * Creates a <code>DiagramEditPart</code> given the <code>Diagram</code>
     * without opening an editor.
     * 
     * NOTE : to avoid post-commit canonical refresh, execute
     * DDiagramCanonicalSynchronizer#synchronize() on the GMF model before.
     * 
     * @param diagram
     *            the <code>Diagram</code>
     * @param shell
     *            An out parameter for the shell that must be disposed after the
     *            copy to image operation has completed.
     * @param preferencesHint
     *            The preference hint that is to be used to find the appropriate
     *            preference store from which to retrieve diagram preference
     *            values. The preference hint is mapped to a preference store in
     *            the preference registry <@link DiagramPreferencesRegistry>.
     * @return the new populated <code>DiagramEditPart</code>
     */
    @Override
    public DiagramEditPart createDiagramEditPart(final Diagram diagram, final Shell shell, final PreferencesHint preferencesHint) {
        return OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell, preferencesHint);
    }

    /**
     * Layout GMF views created by a
     * {@link org.eclipse.sirius.diagram.business.api.refresh.view.refresh.CanonicalSynchronizer#synchronize()}
     * .
     * 
     * NOTE : a set of
     * {@link org.eclipse.emf.common.command.AbstractCommand.NonDirtying}
     * commands will be executed.
     * 
     * @param diagramEditPart
     *            the <code>DiagramEditPart</code> to layout.
     */
    public void arrangeCreatedViews(DiagramEditPart diagramEditPart) {
        SiriusCanonicalLayoutHandler.launchArrangeCommand(diagramEditPart);
    }

    /**
     * Set export to html to true.
     */
    public void exportToHtml() {
        this.exportToHtml = true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil#copyToImage(org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart,
     *      org.eclipse.core.runtime.IPath,
     *      org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat,
     *      org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public DiagramGenerator copyToImage(DiagramEditPart diagramEP, IPath destination, org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat format, IProgressMonitor monitor) throws CoreException {
        if (exportToHtml && DiagramEditPartService.canExportToHtml()) {
            try {
                CopyToImageUtil copyToHmlUtil = (CopyToImageUtil) exportToHtmlClass.newInstance();
                return copyToHmlUtil.copyToImage(diagramEP, destination, format, monitor);
            } catch (InstantiationException e) {
                throw new CoreException(new Status(IStatus.ERROR, SiriusPlugin.ID, -1, " Cannot export image (InstanciationException)", e));
            } catch (IllegalAccessException e) {
                throw new CoreException(new Status(IStatus.ERROR, SiriusPlugin.ID, -1, " Cannot export image (IllegalAccessException)", e));
            } catch (OutOfMemoryError e) {
                throw new CoreException(new Status(IStatus.ERROR, SiriusPlugin.ID, -1, " Cannot export image (OutofMemoryError)", e));
            }
        }
        // Retrieve swt image for knows size.
        DiagramGenerator gen = getDiagramGenerator(diagramEP, format);
        List<?> editParts = diagramEP.getPrimaryEditParts();
        org.eclipse.swt.graphics.Rectangle imageRect = gen.calculateImageRectangle(editParts);
        // Define max size in properties file.
        int maxSize = Integer.parseInt(DiagramUIPlugin.INSTANCE.getString("_Pref_DiagramExportSizeMax"));
        if (imageRect.height * imageRect.width > maxSize && format != ImageFileFormat.SVG) {
            String representationName = ((DSemanticDiagram) ((Diagram) diagramEP.getModel()).getElement()).getName();
            throw new SizeTooLargeException(new Status(IStatus.ERROR, SiriusPlugin.ID, representationName));
        }
        return super.copyToImage(diagramEP, destination, format, monitor);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil#saveToFile(org.eclipse.core.runtime.IPath,
     *      org.eclipse.swt.graphics.Image,
     *      org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat,
     *      org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    protected void saveToFile(IPath destination, Image image, ImageFileFormat imageFormat, IProgressMonitor monitor) throws CoreException {
        // super.saveToFile(destination, image, imageFormat, monitor);
        IStatus fileModificationStatus = createFile(destination);
        if (!fileModificationStatus.isOK()) {
            // can't write to the file
            return;
        }

        // CHECKSTYLE:OFF (duplicate code from GMF)
        try {
            FileOutputStream stream = new FileOutputStream(destination.toOSString());
            saveToOutputStream(stream, image, imageFormat, monitor);
            stream.close();
        } catch (Exception e) {
            SiriusPlugin.getDefault().error(e.getMessage(), e);
            IStatus status = new Status(IStatus.ERROR, "exportToFile", IStatus.OK, //$NON-NLS-1$
                    e.getMessage(), null);
            throw new CoreException(status);
        }
        // CHECKSTYLE:ON

        refreshLocal(destination);
    }

    /**
     * create a file in the workspace if the destination is in a project in the
     * workspace.
     * 
     * @param destination
     *            the destination file.
     * @return the status from validating the file for editing
     * @exception CoreException
     *                if this method fails
     */
    private IStatus createFile(IPath destination) throws CoreException {
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(destination);
        if (file != null && !file.exists()) {
            File osFile = new File(destination.toOSString());
            if (osFile.exists()) {
                file.refreshLocal(IResource.DEPTH_ZERO, null);
            } else {
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
                InputStream input = new ByteArrayInputStream(new byte[0]);
                file.create(input, false, null);
            }
        }

        if (file != null) {
            return FileModificationValidator.approveFileModification(new IFile[] { file });
        }
        return Status.OK_STATUS;
    }

    /**
     * refresh the file in the workspace if the destination is in a project in
     * the workspace.
     * 
     * @param destination
     *            the destination file.
     * @exception CoreException
     *                if this method fails
     */
    private void refreshLocal(IPath destination) throws CoreException {
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(destination);
        if (file != null) {
            file.refreshLocal(IResource.DEPTH_ZERO, null);
        }
    }

    private void saveToOutputStream(OutputStream stream, Image image, ImageFileFormat imageFormat, IProgressMonitor monitor) {
        monitor.worked(1);

        ImageData imageData = image.getImageData();

        if (imageFormat.equals(ImageFileFormat.GIF) || imageFormat.equals(ImageFileFormat.BMP))
            imageData = createImageData(image);

        monitor.worked(1);

        SiriusImageLoader imageLoader = new SiriusImageLoader();
        imageLoader.data = new ImageData[] { imageData };
        imageLoader.logicalScreenHeight = image.getBounds().width;
        imageLoader.logicalScreenHeight = image.getBounds().height;
        imageLoader.save(stream, imageFormat.getOrdinal());

        monitor.worked(1);
    }

    /**
     * Retrieve the image data for the image, using a palette of at most 256
     * colours.
     * 
     * @param image
     *            the SWT image.
     * @return new image data.
     */
    private ImageData createImageData(Image image) {

        ImageData imageData = image.getImageData();

        /**
         * If the image depth is 8 bits or less, then we can use the existing
         * image data.
         */
        if (imageData.depth <= 8) {
            return imageData;
        }

        /**
         * get an 8 bit imageData for the image
         */
        ImageData newImageData = get8BitPaletteImageData(imageData);

        /**
         * if newImageData is null, it has more than 256 colours. Use the web
         * safe pallette to get an 8 bit image data for the image.
         */
        if (newImageData == null) {
            newImageData = getWebSafePalletteImageData(imageData);
        }

        return newImageData;
    }

    /**
     * Retrieve an image data with an 8 bit palette for an image. We assume that
     * the image has less than 256 colours.
     * 
     * @param imageData
     *            the imageData for the image.
     * @return the new 8 bit imageData or null if the image has more than 256
     *         colours.
     */
    private ImageData get8BitPaletteImageData(ImageData imageData) {
        PaletteData palette = imageData.palette;
        RGB[] colours = new RGB[256];
        PaletteData newPaletteData = new PaletteData(colours);
        ImageData newImageData = new ImageData(imageData.width, imageData.height, 8, newPaletteData);

        int lastPixel = -1;
        int newPixel = -1;
        for (int i = 0; i < imageData.width; ++i) {
            for (int j = 0; j < imageData.height; ++j) {
                int pixel = imageData.getPixel(i, j);

                if (pixel != lastPixel) {
                    lastPixel = pixel;

                    RGB colour = palette.getRGB(pixel);
                    for (newPixel = 0; newPixel < 256; ++newPixel) {
                        if (colours[newPixel] == null) {
                            colours[newPixel] = colour;
                            break;
                        }
                        if (colours[newPixel].equals(colour))
                            break;
                    }

                    if (newPixel >= 256) {
                        /**
                         * Diagram has more than 256 colors, return null
                         */
                        return null;
                    }
                }

                newImageData.setPixel(i, j, newPixel);
            }
        }

        RGB colour = new RGB(0, 0, 0);
        for (int k = 0; k < 256; ++k) {
            if (colours[k] == null)
                colours[k] = colour;
        }

        return newImageData;
    }

    /**
     * If the image has less than 256 colours, simply create a new 8 bit palette
     * and map the colours to the new palatte.
     */
    private ImageData getWebSafePalletteImageData(ImageData imageData) {
        PaletteData palette = imageData.palette;
        RGB[] webSafePallette = getWebSafePallette();
        PaletteData newPaletteData = new PaletteData(webSafePallette);
        ImageData newImageData = new ImageData(imageData.width, imageData.height, 8, newPaletteData);

        int lastPixel = -1;
        int newPixel = -1;
        for (int i = 0; i < imageData.width; ++i) {
            for (int j = 0; j < imageData.height; ++j) {
                int pixel = imageData.getPixel(i, j);

                if (pixel != lastPixel) {
                    lastPixel = pixel;

                    RGB colour = palette.getRGB(pixel);
                    RGB webSafeColour = getWebSafeColour(colour);
                    for (newPixel = 0; newPixel < 256; ++newPixel) {
                        if (webSafePallette[newPixel].equals(webSafeColour))
                            break;
                    }

                    Assert.isTrue(newPixel < 216);
                }
                newImageData.setPixel(i, j, newPixel);
            }
        }

        return newImageData;
    }

    /**
     * Retrieves a web safe pallette. Our palette will be 216 web safe colours
     * and the remaining filled with white.
     * 
     * @return array of 256 colours.
     */
    private RGB[] getWebSafePallette() {
        RGB[] colours = new RGB[256];
        int i = 0;
        for (int red = 0; red <= 255; red = red + 51) {
            for (int green = 0; green <= 255; green = green + 51) {
                for (int blue = 0; blue <= 255; blue = blue + 51) {
                    RGB colour = new RGB(red, green, blue);
                    colours[i++] = colour;
                }
            }
        }

        RGB colour = new RGB(0, 0, 0);
        for (int k = 0; k < 256; ++k) {
            if (colours[k] == null)
                colours[k] = colour;
        }

        return colours;
    }

    /**
     * Retrieves a web safe colour that closely matches the provided colour.
     * 
     * @param colour
     *            a colour.
     * @return the web safe colour.
     */
    private RGB getWebSafeColour(RGB colour) {
        int red = Math.round((colour.red + 25) / 51) * 51;
        int green = Math.round((colour.green + 25) / 51) * 51;
        int blue = Math.round((colour.blue + 25) / 51) * 51;
        return new RGB(red, green, blue);
    }
}
