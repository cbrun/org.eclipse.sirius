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
package org.eclipse.sirius.ui.tools.internal.wizards;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.tools.internal.wizards.pages.RepresentationsSelectionWizardPage;
import org.eclipse.sirius.viewpoint.DRepresentation;

/**
 * This wizard ask the user for which viewpoints he wants to externalize and
 * create the new .aird files.
 * 
 * @author cbrun
 * 
 */
public class SelectRepresentationsWizard extends Wizard {

    private Collection<DRepresentation> representations;

    private RepresentationsSelectionWizardPage selectElementPage;

    private final Session session;

    /**
     * Constructor.
     * 
     * @param session
     *            origin session.
     * @param preselection
     *            preselected diagrams
     */
    public SelectRepresentationsWizard(final Session session, final Collection<DRepresentation> preselection) {
        this.session = session;
        this.representations = preselection;
    }

    /**
     * Initialize the wizard.
     */
    public void init() {
        setWindowTitle("Wizard of representations selection");
        setNeedsProgressMonitor(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        representations = selectElementPage.getSelectedElements();
        return true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
        final Collection<String> extensions = new ArrayList<String>();
        extensions.add(SiriusUtil.DESCRIPTION_MODEL_EXTENSION);
        selectElementPage = new RepresentationsSelectionWizardPage(session, representations);
        addPage(selectElementPage);
    }

    public Collection<DRepresentation> getSelectedRepresentations() {
        return representations;
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        super.dispose();
        selectElementPage.dispose();
    }

}
