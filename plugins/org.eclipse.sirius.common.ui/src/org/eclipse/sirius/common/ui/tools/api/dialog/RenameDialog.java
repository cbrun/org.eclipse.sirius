/*******************************************************************************
 * Copyright (c) 2000, 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.common.ui.tools.api.dialog;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

import org.eclipse.sirius.common.ui.SiriusTransPlugin;

/**
 * A generic rename dialog.
 * 
 * @author mchauvin
 */
public class RenameDialog extends SelectionStatusDialog {
    private ArrayList<String> oldNames;

    private String oldName;

    private String newName;

    private Text text;

    private IStatus status;

    private boolean isCaseSensitive;

    private IInputValidator fValidator;

    /**
     * Create a new rename dialog instance for the given window.
     * 
     * @param shell
     *            The parent of the dialog
     * @param oldName
     *            Current name of the item being renamed
     */
    public RenameDialog(final Shell shell, final String oldName) {
        this(shell, false, null, oldName);
    }

    /**
     * Create a new rename dialog instance for the given window.
     * 
     * @param shell
     *            The parent of the dialog
     * @param isCaseSensitive
     *            Flags whether dialog will perform case sensitive checks
     *            against old names
     * @param oldName
     *            Current name of the item being renamed
     */
    public RenameDialog(final Shell shell, final boolean isCaseSensitive, final String oldName) {
        this(shell, isCaseSensitive, null, oldName);
    }

    /**
     * Create a new rename dialog instance for the given window.
     * 
     * @param shell
     *            The parent of the dialog
     * @param isCaseSensitive
     *            Flags whether dialog will perform case sensitive checks
     *            against old names
     * @param names
     *            Set of names which the user should not be allowed to rename to
     * @param oldName
     *            Current name of the item being renamed
     */
    public RenameDialog(final Shell shell, final boolean isCaseSensitive, final String[] names, final String oldName) {
        super(shell);
        this.isCaseSensitive = isCaseSensitive;
        initialize();
        if (names != null) {
            for (String name : names) {
                addOldName(name);
            }
        }
        setOldName(oldName);
        setHelpAvailable(false);
    }

    /**
     * Init the old name list.
     */
    public void initialize() {
        oldNames = new ArrayList<String>();
        setStatusLineAboveButtons(true);
    }

    /**
     * Add an old name.
     * 
     * @param name
     *            the name to add to the old name set
     */
    public void addOldName(final String name) {
        if (!oldNames.contains(name)) {
            oldNames.add(name);
        }

    }

    /**
     * Set the old name.
     * 
     * @param oldName
     *            the name to set as old name
     */
    public void setOldName(final String oldName) {
        this.oldName = oldName;
        addOldName(oldName);
        if (text != null) {
            text.setText(oldName);
        }
        this.newName = oldName;
    }

    /**
     * Set the text value, without adding at old name.
     * 
     * @param value
     *            the value to set
     * @since 0.9.0
     */
    public void setText(final String value) {
        if (text != null) {
            text.setText(value);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(final Composite parent) {
        final Composite container = new Composite(parent, SWT.NULL);
        final GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        layout.marginHeight = 9;
        layout.marginWidth = 9;

        container.setLayout(layout);

        GridData gd = new GridData(GridData.FILL_BOTH);
        container.setLayoutData(gd);

        final Label label = new Label(container, SWT.NULL);
        String labelText = "New diagram name (";
        if (isCaseSensitive) {
            labelText += "case sensitive";
        } else {
            labelText += "case insensitive";
        }
        labelText += "):";
        label.setText(labelText);

        text = new Text(container, SWT.SINGLE | SWT.BORDER);
        text.addModifyListener(new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                textChanged(text.getText());
            }
        });
        gd = new GridData(GridData.FILL_HORIZONTAL);
        text.setLayoutData(gd);
        Dialog.applyDialogFont(container);
        return container;
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.window.Window#open()
     */
    @Override
    public int open() {
        setTitle("Rename diagram");
        text.setText(oldName);
        text.selectAll();
        final Button okButton = getButton(IDialogConstants.OK_ID);

        status = new Status(IStatus.OK, SiriusTransPlugin.PLUGIN_ID, IStatus.OK, "", //$NON-NLS-1$
                null);
        updateStatus(status);
        okButton.setEnabled(false);
        return super.open();
    }

    private void textChanged(final String newText) {
        final Button okButton = getButton(IDialogConstants.OK_ID);
        if (fValidator != null) {
            final String message = fValidator.isValid(newText);
            if (message != null) {
                status = new Status(IStatus.ERROR, SiriusTransPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
                updateStatus(status);
                okButton.setEnabled(false);
                return;
            }
        }
        for (int i = 0; i < oldNames.size(); i++) {
            if ((isCaseSensitive && newText.equals(oldNames.get(i))) || (!isCaseSensitive && newText.equalsIgnoreCase(oldNames.get(i).toString()))) {
                status = new Status(IStatus.ERROR, SiriusTransPlugin.PLUGIN_ID, IStatus.ERROR, "New name must be different", null);
                updateStatus(status);
                okButton.setEnabled(false);
                break;
            }
            okButton.setEnabled(true);
            status = new Status(IStatus.OK, SiriusTransPlugin.PLUGIN_ID, IStatus.OK, "", //$NON-NLS-1$
                    null);
            updateStatus(status);
        }
    }

    /**
     * Get the new entered name.
     * 
     * @return the new name.
     */
    public String getNewName() {
        return newName;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
     */
    @Override
    protected void okPressed() {
        newName = text.getText().trim();
        super.okPressed();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.dialogs.SelectionStatusDialog#computeResult()
     */
    @Override
    protected void computeResult() {
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.ui.dialogs.SelectionDialog#setTitle(java.lang.String)
     */
    @Override
    public void setTitle(final String title) {
        getShell().setText(title);
    }

    /**
     * Set an input validator.
     * 
     * @param validator
     *            the input validator.
     */
    public void setInputValidator(final IInputValidator validator) {
        fValidator = validator;
    }
}
