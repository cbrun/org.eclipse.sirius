/*******************************************************************************
 * Copyright (c) 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.common.tools.internal.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterContext;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterStatus;
import org.eclipse.sirius.common.tools.api.interpreter.IVariableStatusListener;
import org.eclipse.sirius.ecore.extender.business.api.accessor.MetamodelDescriptor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

/**
 * Abstract base class for implementations of {@link IInterpreter}.
 * 
 * @author pcdavid
 */
public abstract class AbstractInterpreter implements IInterpreter {

    /** The separator between EPackage name and EClass name for domain class.*/
    protected static final String SEPARATOR = ".";

    /**
     * {@inheritDoc}
     */
    public boolean provides(String expression) {
        return expression != null && expression.startsWith(getPrefix());
    }

    /**
     * {@inheritDoc}
     */
    public Collection<EObject> evaluateCollection(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        final Collection<EObject> result;
        if (raw instanceof Collection<?>) {
            result = Lists.newArrayList(Iterables.filter((Collection<?>) raw, EObject.class));
        } else if (raw instanceof EObject) {
            result = Collections.singleton((EObject) raw);
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean evaluateBoolean(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        final boolean result;
        if (raw == null) {
            result = false;
        } else if (raw instanceof Boolean) {
            result = ((Boolean) raw).booleanValue();
        } else {
            result = Boolean.valueOf(raw.toString());
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public EObject evaluateEObject(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        if (raw instanceof EObject) {
            return (EObject) raw;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String evaluateString(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        if (raw != null) {
            return String.valueOf(raw);
        } else {
            return "";
        }
    }

    /**
     * {@inheritDoc}
     */
    public Integer evaluateInteger(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        try {
            return Integer.parseInt(String.valueOf(raw));
        } catch (NumberFormatException e) {
            return Integer.valueOf(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void clearImports() {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void addImport(String dependency) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void setProperty(Object key, Object value) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void setVariable(String name, Object value) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void unSetVariable(String name) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public Object getVariable(String name) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void clearVariables() {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void dispose() {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void addVariableStatusListener(IVariableStatusListener newListener) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public void removeVariableStatusListener(IVariableStatusListener listener) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, ?> getVariables() {
        return Collections.emptyMap();
    }

    /**
     * {@inheritDoc}
     */
    public void setModelAccessor(ModelAccessor modelAccessor) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public String getVariablePrefix() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    public void setCrossReferencer(ECrossReferenceAdapter crossReferencer) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public Collection<String> getImports() {
        return Collections.emptySet();
    }

    /**
     * {@inheritDoc}
     */
    public void removeImport(String dependency) {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     */
    public boolean supportsValidation() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Collection<IInterpreterStatus> validateExpression(IInterpreterContext context, String expression) {
        return Collections.emptySet();
    }

    /**
     * {@inheritDoc}
     */
    public void activateMetamodels(Collection<MetamodelDescriptor> metamodels) {
        // Nothing to do.
    }
}
