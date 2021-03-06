/******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *    Maxime Porhel (Obeo) <maxime.porhel@obeo.fr> - Trac bug #1502 : Print / PrintPreview freezes Eclipse : use of SiriusRenderedDiagramPrinter.
 *    Maxime Porhel (Obeo) <maxime.porhel@obeo.fr> - Trac bug #1502 : Renaming and checkstyle.
 ****************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.internal.print;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.common.ui.action.actions.IPrintActionHelper;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.printing.actions.DefaultPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.internal.DiagramUIPrintingRenderDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.internal.DiagramUIPrintingRenderPlugin;
import org.eclipse.gmf.runtime.diagram.ui.printing.util.DiagramPrinterUtil;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Enhanced printing. The doPrint() method will invoke a dialog prompting the
 * user to choose options for printing. The user will be able to choose from
 * printing diagrams of the current type. If possible, the IFile path of the
 * appicable diagrams will be displayed to the user, when prompting the user to
 * select a diagram for printing. If the diagram does not correspond to an
 * IFile, its part name will be used as the next choice.
 * 
 * This class implements the IPrintActionHelper interface that can be passed
 * into Print Preview, enabling the print action from there.
 * 
 * @author Wayne Diu, wdiu
 */
public class SiriusEnhancedPrintActionHelper implements IPrintActionHelper {

    /**
     * {@inheritDoc}
     */
    public void doPrint(final IWorkbenchPart workbenchPart) {
        DiagramEditor diagramEditor = null;

        if (workbenchPart instanceof DiagramEditor) {
            diagramEditor = (DiagramEditor) workbenchPart;
        } else {
            Log.error(DiagramUIPrintingRenderPlugin.getInstance(), IStatus.ERROR, "Invalid IWorkbenchPart"); //$NON-NLS-1$
            final IllegalArgumentException e = new IllegalArgumentException("Invalid IWorkbenchPart."); //$NON-NLS-1$
            Trace.throwing(DiagramUIPrintingRenderPlugin.getInstance(), DiagramUIPrintingRenderDebugOptions.EXCEPTIONS_THROWING, EnhancedPrintActionHelper.class, "doPrint()", e); //$NON-NLS-1$
            throw e;
        }

        final IDiagramGraphicalViewer viewer = diagramEditor.getDiagramGraphicalViewer();
        final RootEditPart rootEP = (viewer == null) ? null : viewer.getRootEditPart();

        // splitting the instanceof checks for readability, DiagramRootEditPart
        // implements IDiagramPreferenceSupport

        // try to get actual preferences, if not then use default of
        // PreferencesHint.USE_DEFAULTS
        final PreferencesHint preferencesHint = (rootEP instanceof IDiagramPreferenceSupport) ? ((IDiagramPreferenceSupport) rootEP).getPreferencesHint() : PreferencesHint.USE_DEFAULTS;

        // get actual map mode, default is MapModeUtil.getMapMode()
        final IMapMode mapMode = (rootEP instanceof DiagramRootEditPart) ? ((DiagramRootEditPart) rootEP).getMapMode() : MapModeUtil.getMapMode();

        if (Platform.getOS().startsWith(Platform.OS_WIN32) && Platform.getOSArch().equals(Platform.ARCH_X86)) {
            DiagramPrinterUtil.printWithSettings(diagramEditor, createDiagramMap(), new SiriusRenderedDiagramPrinter(preferencesHint, mapMode));
        } else {
            // do default action when OS is not a Windows 32 bits or a Windows
            // 64 bits with a 32 bits JVM.
            DefaultPrintActionHelper.doRun(diagramEditor, new SiriusRenderedDiagramPrinter(preferencesHint, mapMode));
        }
    }

    /**
     * Return a Map with diagram name String as key and Diagram as value All
     * entries in the map correspond to open editors.
     * 
     * @return Map with diagram name String as key and Diagram as value All
     *         entries in the map correspond to open editors with the
     *         diagramEditor's id.
     */
    private Map<String, Diagram> createDiagramMap() {
        final Map<String, Diagram> diagramMap = new HashMap<String, Diagram>();
        // get all diagram editors with the matching id
        final List diagramEditors = EditorService.getInstance().getRegisteredEditorParts();
        final Iterator it = diagramEditors.iterator();
        while (it.hasNext()) {
            final Object obj = it.next();
            if (obj instanceof DiagramEditor) { // DiagramDocumentEditor
                final DiagramEditor dEditor = (DiagramEditor) obj;
                String diagramName = null;
                final IEditorInput editorInput = dEditor.getEditorInput();

                // Get the editor title or part name
                diagramName = dEditor.getPartName();
                if (diagramName == null) {
                    diagramName = dEditor.getTitle();
                }
                // try to be more descriptive and get the IFile path which
                // includes the project
                final IFile file = (IFile) (editorInput.getAdapter(IFile.class));
                if (file != null) {
                    diagramName = file.getFullPath().toOSString() + "#" + diagramName;
                }

                if (diagramName == null) {
                    // the last choice is to use the actual name of the diagram
                    // this has to exist!
                    diagramName = dEditor.getDiagram().getName();
                }
                diagramName = makeNameUnique(diagramName, diagramMap.keySet());
                diagramMap.put(diagramName, dEditor.getDiagram());
            }
        }
        return diagramMap;
    }

    /**
     * Make the <code>name</code> unique. If this name exists in the
     * <code>existingNames</code> list, a digit is added at the end to make it
     * unique.
     * 
     * @param name
     *            The name to make unique
     * @param existingNames
     *            The list of existing names
     * @return A unique name.
     */
    private String makeNameUnique(String name, Set<String> existingNames) {
        String result = name;
        if (existingNames.contains(result)) {
            result = makeNameUnique(result, existingNames, 1);
        }
        return result;
    }

    /**
     * Make the <code>name</code> unique. If this name exists in the
     * <code>existingNames</code> list, a digit is added at the end to make it
     * unique.
     * 
     * @param name
     *            The name to make unique
     * @param existingNames
     *            The list of existing names
     * @param nbIteration
     *            The current iteration
     * @return A unique name.
     */
    private String makeNameUnique(String name, Set<String> existingNames, int nbIteration) {
        String result = name + " (" + nbIteration + ")";
        if (existingNames.contains(result)) {
            result = makeNameUnique(name, existingNames, nbIteration + 1);
        }
        return result;
    }
}
