/*******************************************************************************
 * Copyright (c) 2011, 2012 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.common.acceleo.mtl.business.internal.interpreter;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.acceleo.common.IAcceleoConstants;
import org.eclipse.acceleo.common.interpreter.CompilationResult;
import org.eclipse.acceleo.common.interpreter.EvaluationResult;
import org.eclipse.acceleo.common.utils.AcceleoCollections;
import org.eclipse.acceleo.engine.service.EvaluationContext;
import org.eclipse.acceleo.model.mtl.MtlPackage;
import org.eclipse.acceleo.model.mtl.resource.EMtlBinaryResourceFactoryImpl;
import org.eclipse.acceleo.model.mtl.resource.EMtlResourceFactoryImpl;
import org.eclipse.acceleo.parser.interpreter.CompilationContext;
import org.eclipse.acceleo.parser.interpreter.ModuleDescriptor;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.util.Bag;
import org.eclipse.sirius.common.acceleo.mtl.AcceleoMTLInterpreterPlugin;
import org.eclipse.sirius.common.acceleo.mtl.business.api.ResourceFinder;
import org.eclipse.sirius.common.acceleo.mtl.business.api.extension.AbstractImportHandler;
import org.eclipse.sirius.common.acceleo.mtl.business.internal.extension.ImportHandlerRegistry;
import org.eclipse.sirius.common.acceleo.mtl.business.internal.interpreter.DynamicAcceleoModule.QueryIdentifier;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterContext;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterStatus;
import org.eclipse.sirius.common.tools.api.interpreter.IVariableStatusListener;
import org.eclipse.sirius.common.tools.api.interpreter.InterpreterStatusFactory;
import org.eclipse.sirius.ecore.extender.business.api.accessor.EcoreMetamodelDescriptor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.MetamodelDescriptor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.osgi.framework.Bundle;

/**
 * This interpreter will allow for the use of Acceleo 3 expressions.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class AcceleoMTLInterpreter implements IInterpreter {
    /**
     * This represents the prefix of an Acceleo 3 expression.
     * 
     * @see IAcceleoConstants#DEFAULT_BEGIN
     */
    private static final String ACCELEO_EXPRESSION_PREFIX = IAcceleoConstants.DEFAULT_BEGIN;

    /**
     * This represents the suffix of an Acceleo 3 expression.
     * 
     * @see IAcceleoConstants#INVOCATION_END
     */
    private static final String ACCELEO_EXPRESSION_SUFFIX = IAcceleoConstants.DEFAULT_END_BODY_CHAR + IAcceleoConstants.DEFAULT_END;

    /** This will be used whenever we need to split a path around its separator. */
    private static final String FILE_SEPARATOR_REGEX = "/|\\\\"; //$NON-NLS-1$

    /**
     * This will hold all dependencies added to this interpreter through import
     * handlers. Keys are the Java class name in the form
     * <code>my.package.MyClass</code>, values are the Modules returned by the
     * handlers.
     */
    protected final Set<ModuleDescriptor> extendedDependencies = Sets.newLinkedHashSet();

    /**
     * This will hold all dependencies added to this interpreter. Keys are the
     * dependencies path in the form <code>my::package::myModule</code>, values
     * are the actual URIs of the modules.
     */
    protected final Multimap<String, URI> mtlDependencies = LinkedHashMultimap.create();

    /** Keeps a reference to the workspace files we are using as imports. */
    private final Map<String, URI> javaFiles = Maps.newHashMap();

    /**
     * This will contain the "dummy" module we use for the compilation. All
     * queries present in an VSM file will have a corresponding [query] block in
     * this dummy.
     */
    private final DynamicAcceleoModule module = new DynamicAcceleoModule();

    /**
     * This map will hold the values associated to given variable names. Note
     * that even if this is a multimap, the variables are considered as a stack
     * in order to be coherent with other interpreters : evaluation will
     * consider the value to be a Collection, but setting/unsetting will only
     * work one object by one object.
     */
    private final ListMultimap<String, Object> variables = AcceleoCollections.newCircularArrayDequeMultimap();

    private final Map<String, String> compilationVariables = Maps.newLinkedHashMap();

    private final Set<String> variableNsURIs = Sets.newLinkedHashSet();

    /** This will contain the listeners interested in our variables' status. */
    private final Set<IVariableStatusListener> variableStatusListeners = Sets.newHashSet();

    /**
     * This will be updated with the list of accessible viewpoint plugins, if
     * any.
     */
    private final Set<String> viewpointPlugins = Sets.newLinkedHashSet();

    /**
     * This will be updated with the list of accessible viewpoint projects
     * present in the workspace, if any.
     */
    private final Set<String> viewpointProjects = Sets.newLinkedHashSet();

    /**
     * This will be used in order to provide our own CrossReferencer to Acceleo.
     */
    private CrossReferencerProviderAdapterFactory adapterFactory;

    /**
     * Default constructor, will be called from the extension point's registry.
     */
    public AcceleoMTLInterpreter() {
        // Nothing to do
    }

    /**
     * Tries and coerce the given <em>object</em> to an instance of the given
     * class.
     * 
     * @param <T>
     *            Type to which we need to coerce <em>object</em>.
     * @param object
     *            The object we need to coerce to a given {@link Class}.
     * @param clazz
     *            Class to which we are to cast <em>object</em>.
     * @return <em>object</em> cast to type <em>T</em> if possible,
     *         <code>null</code> if not.
     */
    @SuppressWarnings("unchecked")
    private static <T> T coerceValue(Object object, Class<T> clazz) {
        if (object == null) {
            return null;
        }

        T result = null;
        if (clazz.isInstance(object)) {
            result = (T) object;
        } else if (object instanceof IAdaptable) {
            result = (T) ((IAdaptable) object).getAdapter(clazz);
        }

        if (result == null) {
            result = (T) Platform.getAdapterManager().getAdapter(object, clazz);
        }

        return result;
    }

    /**
     * This will be used to convert a Java-style qualified name
     * (my.package.Type) to an OCL-style qualified name (my::package::Type).
     * <p>
     * Note that this will make no effort to try and check whether the given
     * type is indeed a Java qualified name.
     * </p>
     * 
     * @param type
     *            The type we are to convert.
     * @return The OCL qualified name corresponding to the given type.
     */
    private static String convertToOCLQualifiedName(String type) {
        if (type != null && type.length() > 0) {
            return type.replace(".", IAcceleoConstants.NAMESPACE_SEPARATOR); //$NON-NLS-1$
        }
        return type;
    }

    /**
     * Checks whether the given path exists in the plugins.
     * 
     * @param path
     *            The path we need to check.
     * @return <code>true</code> if <em>path</em> denotes an existing plugin
     *         resource, <code>false</code> otherwise.
     */
    private static boolean existsInPlugins(String path) {
        try {
            URL url = new URL(path);
            return FileLocator.find(url) != null;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /**
     * Checks whether the given path exists in the workspace.
     * 
     * @param path
     *            The path we need to check.
     * @return <code>true</code> if <em>path</em> denotes an existing workspace
     *         resource, <code>false</code> otherwise.
     */
    private static boolean existsInWorkspace(String path) {
        if (path == null || path.length() == 0) {
            return false;
        }

        return ResourcesPlugin.getWorkspace().getRoot().exists(new Path(path));
    }

    /**
     * Extracts the NsURI of the given EObject's metamodel.
     * 
     * @param object
     *            The EObject for which we need the metamodel URI.
     * @return The NsURI of the given EObject's metamodel, <code>null</code> if
     *         we could not retrieve it.
     */
    private static String extractNsURI(EObject object) {
        final EPackage pack = object.eClass().getEPackage();
        if (pack != null) {
            final String uri = pack.getNsURI();
            if (uri != null && uri.length() > 0) {
                return uri;
            }
        }
        return null;
    }

    /**
     * Tries and extract the NsURIs of the given object if it is an EObject, or
     * of its children if it is a Collection.
     * 
     * @param object
     *            The object from which to try and detect metamodel URIs.
     * @return The extracted URIs.
     */
    private static Set<String> extractNsURIs(Object object) {
        Set<String> uris = Sets.newLinkedHashSet();

        if (object instanceof EObject) {
            final String uri = extractNsURI((EObject) object);
            if (uri != null) {
                uris = Collections.singleton(uri);
            }
        } else if (object instanceof Collection<?>) {
            for (Object child : (Collection<?>) object) {
                final Set<String> childURIs = extractNsURIs(child);
                if (!childURIs.isEmpty()) {
                    uris = Sets.union(uris, childURIs);
                }
            }
        }

        return uris;
    }

    /**
     * Returns the last value of the given list.
     * <p>
     * Makes no effort to try and check whether the argument is valid.
     * </p>
     * 
     * @param values
     *            List from which we need the last value.
     * @param <V>
     *            Type of the list's values.
     * @return The last value of the given list.
     */
    private static <V> V getLast(List<V> values) {
        final ListIterator<V> iterator = values.listIterator(values.size());
        return iterator.previous();
    }

    /**
     * Returns the qualified name of the given eObject's EClass, OCL style.
     * <p>
     * For example, passing an instance of "eClass" to this would yield
     * <code>ecore::EClass</code>.
     * </p>
     * 
     * @param eObject
     *            The EObject for which we need the qualified type name.
     * @return The qualified name of the given eObject's EClass.
     */
    private static String getQualifiedType(EObject eObject) {
        return getQualifiedName(eObject.eClass());
    }

    /**
     * Returns the qualified name of the given EClassifier, OCL style.
     * 
     * @param classifier
     *            The classifier for which we need the qualified type name.
     * @return The qualified name of the given EClassifier.
     */
    private static String getQualifiedName(EClassifier classifier) {
        final List<String> ancestors = Lists.newArrayList();

        EObject current = classifier;
        // this will allow us to break the loop as soon as we encounter a "root"
        // EPackage : an EPackage which NsURI is set
        boolean rootEncountered = false;
        while (current instanceof ENamedElement && !rootEncountered) {
            ancestors.add(((ENamedElement) current).getName());
            if (current instanceof EPackage && ((EPackage) current).getNsURI() != null) {
                rootEncountered = true;
            }
            current = current.eContainer();
        }

        Iterable<String> reversed = Lists.reverse(ancestors);
        return Joiner.on(IAcceleoConstants.NAMESPACE_SEPARATOR).join(reversed);
    }

    /**
     * Tries and infer the OCL type of the given Object.
     * 
     * @param obj
     *            Object for which we need an OCL type.
     * @return The inferred OCL type. OCLAny if we could not infer anything more
     *         sensible.
     */
    private static String inferOCLType(Object obj) {
        String oclType = "OCLAny"; //$NON-NLS-1$
        final EcoreEnvironment env = (EcoreEnvironment) new EcoreEnvironmentFactory().createEnvironment();
        if (obj instanceof Collection<?>) {
            EClassifier elementType = DynamicAcceleoModule.inferCollectionContentOCLType(env, (Collection<?>) obj);
            oclType = "Sequence("; //$NON-NLS-1$
            if (obj instanceof LinkedHashSet<?>) {
                oclType = "OrderedSet("; //$NON-NLS-1$
            } else if (obj instanceof Set<?>) {
                oclType = "Set("; //$NON-NLS-1$
            } else if (obj instanceof Bag<?>) {
                oclType = "Bag("; //$NON-NLS-1$
            }
            oclType += getQualifiedName(elementType) + ')';
        } else {
            oclType = getQualifiedName(DynamicAcceleoModule.getOCLType(env, obj));
        }
        return oclType;
    }

    /**
     * Checks whether the given <em>candidatePath</em> ends with the given
     * <em>suffix</em>.
     * 
     * @param candidatePath
     *            Path for which we need to check the suffix.
     * @param suffix
     *            Suffix we need <em>candidatePath</em> to have.
     * @return <code>true</code> if <em>candidatePath</em> ends with
     *         <em>suffix</em>, <code>false</code> otherwise.
     */
    private static boolean pathEndsWith(String candidatePath, String suffix) {
        final String[] candidateSegments = candidatePath.split(FILE_SEPARATOR_REGEX);
        final String[] suffixSegments = suffix.split(FILE_SEPARATOR_REGEX);

        int candidateIndex = candidateSegments.length - 1;
        int suffixIndex = suffixSegments.length - 1;
        boolean match = suffixIndex <= candidateIndex;

        while (candidateIndex >= 0 && suffixIndex >= 0 && match) {
            match = suffixSegments[suffixIndex].equals(candidateSegments[candidateIndex]);

            candidateIndex--;
            suffixIndex--;
        }

        return match;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#activateMetamodels(java.util.Collection)
     */
    public void activateMetamodels(Collection<MetamodelDescriptor> metamodels) {
        Set<EPackage> additionalEPackages = Sets.newLinkedHashSet();
        for (MetamodelDescriptor descriptor : metamodels) {
            if (descriptor instanceof EcoreMetamodelDescriptor) {
                EPackage pkg = ((EcoreMetamodelDescriptor) descriptor).resolve();
                if (pkg != null) {
                    additionalEPackages.add(pkg);
                }
            }
        }
        module.registerAdditionalEPackages(additionalEPackages);
    }

    /**
     * {@inheritDoc}
     * 
     * @param dependency
     *            Acceleo 3 dependencies should be of the form
     *            <em>my::package::myModule</em>. Java dependencies should be in
     *            the form <em>my.package.MyClass</em>.
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#addImport(java.lang.String)
     */
    public void addImport(String dependency) {
        if (dependency != null && dependency.length() > 0) {
            boolean added = addExtendedImport(dependency);
            if (!added) {
                added = addMTLImport(dependency);
            }
            if (added) {
                invalidateModule();
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#addVariableStatusListener(org.eclipse.sirius.common.tools.api.interpreter.IVariableStatusListener)
     */
    public void addVariableStatusListener(IVariableStatusListener newListener) {
        variableStatusListeners.add(newListener);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#clearImports()
     */
    public void clearImports() {
        mtlDependencies.clear();
        extendedDependencies.clear();
        javaFiles.clear();
        invalidateModule();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#clearVariables()
     */
    public void clearVariables() {
        variables.clear();
        variableNsURIs.clear();
        compilationVariables.clear();
        notifyVariableListeners();
    }

    /**
     * Creates an Acceleo compilation context for the current variables and the
     * given contextual information.
     * 
     * @param context
     *            The target EObject of this compilation.
     * @param expression
     *            The expression for which we need a compilation context.
     * @return The newly created context.
     */
    public CompilationContext createCompilationContext(EObject context, String expression) {
        final String targetType = getQualifiedType(context);

        String targetNsURI = null;
        final EObject root = EcoreUtil.getRootContainer(context);
        if (root != null) {
            targetNsURI = extractNsURI(root);
        }

        /*
         * We will only iterate once on all variables, registering their nsURI
         * and determining their OCL type along the way.
         */
        if (compilationVariables.isEmpty() && !variables.isEmpty()) {
            for (Map.Entry<String, Collection<Object>> entry : variables.asMap().entrySet()) {
                final char[] chars = entry.getKey().toCharArray();
                boolean isDigit = chars.length > 0;
                for (int i = 0; i < chars.length && isDigit; i++) {
                    isDigit = Character.isDigit(chars[i]);
                }
                if (isDigit) {
                    continue;
                }
                List<Object> values = (List<Object>) entry.getValue();
                if (!values.isEmpty()) {
                    final Object actualValue = getLast(values);
                    compilationVariables.put(entry.getKey(), inferOCLType(actualValue));
                    variableNsURIs.addAll(extractNsURIs(actualValue));
                }
            }
        }

        final Set<String> nsURIs;
        if (targetNsURI != null) {
            nsURIs = Sets.union(Collections.singleton(targetNsURI), variableNsURIs);
        } else {
            nsURIs = variableNsURIs;
        }

        return new CompilationContext(expression, targetType, compilationVariables, nsURIs, mtlDependencies, Collections.unmodifiableSet(extendedDependencies));
    }

    /**
     * Creates an Acceleo compilation context for the current variables and the
     * given contextual information.
     * 
     * @param context
     *            Context of the current compilation.
     * @param expression
     *            The expression for which we need a compilation context.
     * @param targetType
     *            The target EObject type for this expression.
     * @param variableTypes
     *            Set of all accessible variables.
     * @return The newly created context.
     */
    public CompilationContext createCompilationContext(IInterpreterContext context, String expression, String targetType, Map<String, String> variableTypes) {
        addContextImports(context);

        final Set<String> nsURIs = Sets.newLinkedHashSet();
        for (EPackage pack : context.getAvailableEPackages()) {
            nsURIs.add(pack.getNsURI());
        }

        return new CompilationContext(expression, targetType, variableTypes, nsURIs, mtlDependencies, Sets.newLinkedHashSet(extendedDependencies));
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#dispose()
     */
    public void dispose() {
        mtlDependencies.clear();
        extendedDependencies.clear();
        javaFiles.clear();
        module.invalidate();
        variables.clear();
        variableNsURIs.clear();
        compilationVariables.clear();
        variableStatusListeners.clear();
        viewpointPlugins.clear();
        viewpointProjects.clear();
        if (adapterFactory != null) {
            Platform.getAdapterManager().unregisterAdapters(adapterFactory);
            adapterFactory = null;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#evaluate(org.eclipse.emf.ecore.EObject,
     *      java.lang.String)
     */
    public Object evaluate(EObject target, String expression) throws EvaluationException {
        EvaluationResult evaluationResult = internalEvaluate(target, expression);
        // Ignore potential problems for now
        return evaluationResult.getEvaluationResult();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#evaluateBoolean(org.eclipse.emf.ecore.EObject,
     *      java.lang.String)
     */
    public boolean evaluateBoolean(EObject context, String expression) throws EvaluationException {
        EvaluationResult evaluationResult = internalEvaluate(context, expression);
        // Ignore potential problems for now
        Object result = evaluationResult.getEvaluationResult();

        final Boolean coerced;
        if (result instanceof Boolean) {
            coerced = (Boolean) result;
        } else {
            coerced = coerceValue(result, Boolean.class);
        }

        if (coerced != null) {
            return coerced.booleanValue();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#evaluateCollection(org.eclipse.emf.ecore.EObject,
     *      java.lang.String)
     */
    public Collection<EObject> evaluateCollection(EObject context, String expression) throws EvaluationException {
        EvaluationResult evaluationResult = internalEvaluate(context, expression);
        Object result = evaluationResult.getEvaluationResult();

        Collection<EObject> coercedResult = Lists.newArrayList();
        if (result instanceof Collection<?>) {
            Iterables.addAll(coercedResult, Iterables.filter((Collection<?>) result, EObject.class));
        } else {
            EObject coerced = coerceValue(result, EObject.class);
            if (coerced != null) {
                coercedResult.add(coerced);
            }
        }

        return coercedResult;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#evaluateEObject(org.eclipse.emf.ecore.EObject,
     *      java.lang.String)
     */
    public EObject evaluateEObject(EObject context, String expression) throws EvaluationException {
        EvaluationResult evaluationResult = internalEvaluate(context, expression);
        // Ignore potential problems for now
        Object result = evaluationResult.getEvaluationResult();

        EObject coerced = coerceValue(result, EObject.class);

        return coerced;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#evaluateInteger(org.eclipse.emf.ecore.EObject,
     *      java.lang.String)
     */
    public Integer evaluateInteger(EObject context, String expression) throws EvaluationException {
        EvaluationResult evaluationResult = internalEvaluate(context, expression);
        // Ignore potential problems for now
        Object result = evaluationResult.getEvaluationResult();

        Integer coerced = coerceValue(result, Integer.class);

        return coerced;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#evaluateString(org.eclipse.emf.ecore.EObject,
     *      java.lang.String)
     */
    public String evaluateString(EObject context, String expression) throws EvaluationException {
        EvaluationResult evaluationResult = internalEvaluate(context, expression);
        // Ignore potential problems for now
        Object result = evaluationResult.getEvaluationResult();

        if (result != null) {
            return result.toString();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#getImports()
     */
    public Collection<String> getImports() {
        Set<String> extendedImports = Sets.newLinkedHashSet();
        for (ModuleDescriptor moduleDescriptor : extendedDependencies) {
            extendedImports.add(moduleDescriptor.getQualifiedName().replace(IAcceleoConstants.NAMESPACE_SEPARATOR, ".")); //$NON-NLS-1$
        }

        return Sets.union(mtlDependencies.keySet(), extendedImports);
    }

    /**
     * Gives access to the current module maintained by this interpreter. Mainly
     * used to provide completion without re-compiling.
     * 
     * @return The current in-memory module maintained by this interpreter.
     */
    public DynamicAcceleoModule getModule() {
        return module;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#getPrefix()
     */
    public String getPrefix() {
        return ACCELEO_EXPRESSION_PREFIX;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#getVariable(java.lang.String)
     */
    public Object getVariable(String name) {
        if (variables.containsKey(name)) {
            final List<Object> values = variables.get(name);
            if (!values.isEmpty()) {
                return getLast(values);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#getVariablePrefix()
     */
    public String getVariablePrefix() {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#getVariables()
     */
    public Map<String, ?> getVariables() {
        return variables.asMap();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#provides(java.lang.String)
     */
    public boolean provides(String expression) {
        if (expression != null) {
            return expression.startsWith(ACCELEO_EXPRESSION_PREFIX) && expression.endsWith(ACCELEO_EXPRESSION_SUFFIX);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#removeImport(java.lang.String)
     */
    public void removeImport(String dependency) {
        boolean removed = false;
        if (mtlDependencies.containsKey(dependency)) {
            mtlDependencies.removeAll(dependency);
            removed = true;
        } else if (javaFiles.containsKey(dependency)) {
            javaFiles.remove(dependency);
            extendedDependencies.remove(dependency);
            removed = true;
        }
        if (removed) {
            invalidateModule();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#removeVariableStatusListener(org.eclipse.sirius.common.tools.api.interpreter.IVariableStatusListener)
     */
    public void removeVariableStatusListener(IVariableStatusListener listener) {
        variableStatusListeners.remove(listener);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#setCrossReferencer(org.eclipse.emf.ecore.util.ECrossReferenceAdapter)
     */
    public void setCrossReferencer(ECrossReferenceAdapter crossReferencer) {
        if (adapterFactory == null) {
            adapterFactory = new CrossReferencerProviderAdapterFactory(crossReferencer);
            Platform.getAdapterManager().registerAdapters(adapterFactory, EObject.class);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#setModelAccessor(org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor)
     */
    public void setModelAccessor(ModelAccessor modelAccessor) {
        // Nothing to do
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#setProperty(java.lang.Object,
     *      java.lang.Object)
     */
    public void setProperty(Object key, Object value) {
        /*
         * This is called by the framework with the FILES key in order to pass
         * us all the VSM files as a Collection.
         */
        if (FILES.equals(key)) {
            if (value == null) {
                viewpointProjects.clear();
                viewpointPlugins.clear();
            } else if (value instanceof Collection<?>) {
                for (final String odesignPath : Iterables.filter((Collection<?>) value, String.class)) {
                    final URI workspaceCandidate = URI.createPlatformResourceURI(odesignPath, true);
                    final URI pluginCandidate = URI.createPlatformPluginURI(odesignPath, true);
                    if (existsInWorkspace(workspaceCandidate.toPlatformString(true))) {
                        viewpointProjects.add(workspaceCandidate.segment(1));
                    } else if (existsInPlugins(URI.decode(pluginCandidate.toString()))) {
                        viewpointPlugins.add(pluginCandidate.segment(1));
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#setVariable(java.lang.String,
     *      java.lang.Object)
     */
    public void setVariable(String name, Object value) {
        variables.put(name, value);
        variableNsURIs.clear();
        compilationVariables.clear();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#supportsValidation()
     */
    public boolean supportsValidation() {
        return true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#unSetVariable(java.lang.String)
     */
    public void unSetVariable(String name) {
        if (variables.containsKey(name)) {
            final List<Object> values = variables.get(name);
            if (!values.isEmpty()) {
                final ListIterator<?> iterator = values.listIterator(values.size());
                iterator.previous();
                iterator.remove();
                notifyVariableListeners();
            }
            variableNsURIs.clear();
            compilationVariables.clear();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.sirius.common.tools.api.interpreter.IInterpreter#validateExpression(org.eclipse.sirius.common.tools.api.interpreter.IInterpreterContext,
     *      java.lang.String)
     */
    public Collection<IInterpreterStatus> validateExpression(IInterpreterContext context, String expression) {
        /*
         * The interpreter is created as a global singleton : one single
         * interpreter for all operations, whatever the number of VSM or
         * representation files. Validation is called on expression granularity,
         * and we are never warned of the validation "start" or "end" events. We
         * thus cannot keep any state for the in-memory module as it could be
         * reflecting operations located on other VSM files.
         */
        invalidateModule();

        final Set<IInterpreterStatus> validationStatus = Sets.newLinkedHashSet();

        final Map<String, String> validationVariables = Maps.newLinkedHashMap();
        for (Map.Entry<String, String> contextVariable : context.getVariables().entrySet()) {
            final String varName = contextVariable.getKey();
            final String varType = contextVariable.getValue();
            boolean isVarNameValid = varName != null && varName.length() > 0 && !varName.matches("[0-9]+"); //$NON-NLS-1$
            boolean isVarTypeValid = varType != null && varType.length() > 0;
            if (isVarNameValid && isVarTypeValid) {
                validationVariables.put(varName, convertToOCLQualifiedName(varType));
            }
        }

        if (!context.requiresTargetType()) {
            final CompilationContext compilationContext = createCompilationContext(context, expression, "ecore::EObject", validationVariables); //$NON-NLS-1$
            validationStatus.addAll(doValidateExpression(context, compilationContext));
        } else {
            final Collection<String> actualTargetTypes = Lists.newArrayListWithCapacity(context.getTargetTypes().size());
            for (String candidateType : context.getTargetTypes()) {
                if (!Strings.isNullOrEmpty(candidateType)) {
                    actualTargetTypes.add(candidateType);
                }
            }
            if (actualTargetTypes.isEmpty()) {
                validationStatus.add(InterpreterStatusFactory.createInterpreterStatus(context.getTargetTypes(), context.getField(), IInterpreterStatus.WARNING, "Cannot find Domain Class for " //$NON-NLS-1$
                        + context.getField().getName() + " - Expression cannot be validated.")); //$NON-NLS-1$
            } else {
                for (String candidateTargetType : actualTargetTypes) {
                    final String expressionType = convertToOCLQualifiedName(candidateTargetType);

                    final CompilationContext compilationContext = createCompilationContext(context, expression, expressionType, validationVariables);
                    validationStatus.addAll(doValidateExpression(context, compilationContext));
                }
            }
        }

        return validationStatus;
    }

    /**
     * Invalidate the current module, then rebuild and recompile it.
     */
    protected void invalidateModule() {
        module.invalidate();
    }

    /**
     * Retrieves the list of imports from the given interpreter context.
     * 
     * @param context
     *            The context from which to retrieve a list of dependencies.
     */
    private void addContextImports(IInterpreterContext context) {
        final EObject element = context.getElement();
        if (element != null) {
            Resource resource = element.eResource();
            if (resource != null) {
                final URI uri = element.eResource().getURI();
                if (existsInWorkspace(uri.toPlatformString(true))) {
                    viewpointProjects.add(uri.segment(1));
                } else if (existsInPlugins(uri.toPlatformString(true))) {
                    viewpointPlugins.add(uri.segment(1));
                }
            }
        }

        for (String dependency : context.getDependencies()) {
            addImport(dependency);
        }
    }

    /**
     * Asks the registered import handlers whether they know about the given
     * dependency.
     * 
     * @param dependency
     *            The dependency to try and add to this context.
     * @return <code>true</code> if we found a corresponding import handler and
     *         managed to create the dependency, <code>false</code> otherwise.
     */
    private boolean addExtendedImport(String dependency) {
        // Consider that this will always change the dependency if it previously
        // existed in the context
        boolean changedDependencies = false;
        final Iterator<ModuleDescriptor> currentDescriptors = extendedDependencies.iterator();
        while (currentDescriptors.hasNext() && !changedDependencies) {
            if (currentDescriptors.next().getQualifiedName().equals(dependency)) {
                changedDependencies = true;
                currentDescriptors.remove();
            }
        }

        final List<AbstractImportHandler> handlers = ImportHandlerRegistry.getRegisteredHandlers();
        boolean foundHandler = false;
        for (int i = 0; i < handlers.size() && !foundHandler; i++) {
            AbstractImportHandler importHandler = handlers.get(i);
            if (importHandler.canImport(viewpointPlugins, viewpointProjects, dependency)) {
                final ModuleDescriptor extendedModule = importHandler.createImport(viewpointPlugins, viewpointProjects, dependency);
                if (extendedModule != null) {
                    extendedDependencies.add(extendedModule);
                    foundHandler = true;
                }
            }
        }

        return changedDependencies || foundHandler;
    }

    /**
     * Tries and add the given dependency to the context, considering that it is
     * an MTL file.
     * 
     * @param dependency
     *            The dependency to try and add.
     * @return <code>true</code> if we found a corresponding Acceleo module and
     *         added the dependency, <code>false</code> otherwise.
     */
    private boolean addMTLImport(String dependency) {
        String actualDependency = dependency;
        final int dotIndex = actualDependency.lastIndexOf('.');
        // Whatever the extension, get rid of it. We only consider EMTL as valid
        // imports.
        if (dotIndex >= 0 && !actualDependency.substring(dotIndex).contains(IAcceleoConstants.NAMESPACE_SEPARATOR)) {
            actualDependency = actualDependency.substring(0, dotIndex);
        }
        String emtlPath = actualDependency.replaceAll(IAcceleoConstants.NAMESPACE_SEPARATOR, "/"); //$NON-NLS-1$
        emtlPath += '.' + IAcceleoConstants.EMTL_FILE_EXTENSION;

        Set<URI> candidates = Sets.union(findProjectCandidates(emtlPath), findPluginCandidates(emtlPath));

        /*
         * We may have multiple candidates for a single emtl path. Candidates
         * located in the workspace will be considered before candidates located
         * in the plugins but, other than that, we let Acceleo do its
         * resolution.
         */
        if (!candidates.isEmpty()) {
            return mtlDependencies.putAll(actualDependency, candidates);
        }
        return false;
    }

    /**
     * Validates that the given expression compiles in the given context.
     * 
     * @param context
     *            Context of the current compilation.
     * @param compilationContext
     *            The Acceleo compilation context for this validation.
     * @return The compilation status as can be understood by viewpoint.
     */
    private Collection<IInterpreterStatus> doValidateExpression(IInterpreterContext context, CompilationContext compilationContext) {
        final QueryIdentifier query = module.ensureQueryExists(compilationContext);
        final CompilationResult compilationResult = module.compile(compilationContext, query);

        final Set<IInterpreterStatus> validationStatus = Sets.newLinkedHashSet();

        if (compilationResult.getStatus() != null && compilationResult.getStatus().getSeverity() != IStatus.OK) {
            if (compilationResult.getStatus() instanceof MultiStatus) {
                for (IStatus child : ((MultiStatus) compilationResult.getStatus()).getChildren()) {
                    final String type = compilationContext.getTargetType();
                    final String severity;
                    if (child.getSeverity() == IStatus.ERROR) {
                        severity = IInterpreterStatus.ERROR;
                    } else {
                        /*
                         * IInterpreterStatus only understand "ERROR" and
                         * "WARNING". Log infos as warnings.
                         */
                        severity = IInterpreterStatus.WARNING;
                    }

                    validationStatus.add(InterpreterStatusFactory.createInterpreterStatus(Collections.singleton(type), context.getField(), severity, child.getMessage(), 0, 0, 0));
                }
            }
        }

        return validationStatus;
    }

    /**
     * Checks whether a viewpoint specification plugin contains an emtl
     * corresponding to the given path.
     * 
     * @param emtlPath
     *            Path of the emtl for which we need potential URIs.
     * @return
     */
    private Set<URI> findPluginCandidates(String emtlPath) {
        Set<URI> result = Sets.newLinkedHashSet();

        for (String viewpointPluginSymbolicName : viewpointPlugins) {
            final Bundle viewpointPlugin = Platform.getBundle(viewpointPluginSymbolicName);
            if (viewpointPlugin != null) {
                final String fileSeparator = "/"; //$NON-NLS-1$
                final String fileName = emtlPath.substring(emtlPath.lastIndexOf(fileSeparator) + 1);
                // "fileSeparator" is also the bundle root.
                final Enumeration<URL> emtlEntries = viewpointPlugin.findEntries(fileSeparator, fileName, true);
                if (emtlEntries != null) {
                    while (emtlEntries.hasMoreElements()) {
                        final String candidatePath = emtlEntries.nextElement().getPath();

                        if (pathEndsWith(candidatePath, emtlPath)) {
                            final StringBuilder fullPath = new StringBuilder(viewpointPluginSymbolicName);
                            fullPath.append('/').append(candidatePath);

                            result.add(URI.createPlatformPluginURI(fullPath.toString(), true));
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * Checks if the workspace contains an IProject that could hold an emtl file
     * located at the given path.
     * 
     * @param emtlPath
     *            Path of the emtl for which we need potential URIs.
     * @return The list of all projects that could hold a file at the given
     *         path.
     */
    private Set<URI> findProjectCandidates(String emtlPath) {
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final Set<URI> result = Sets.newLinkedHashSet();

        for (String viewpointProjectPath : viewpointProjects) {
            if (workspace.getRoot().exists(new Path(viewpointProjectPath))) {
                final IProject viewpointProject = workspace.getRoot().getProject(viewpointProjectPath);

                try {
                    final ResourceFinder emtlFinder = new ResourceFinder(emtlPath);
                    viewpointProject.accept(emtlFinder);

                    for (IResource candidate : emtlFinder.getMatches()) {
                        result.add(URI.createPlatformResourceURI(candidate.getFullPath().toString(), true));
                    }
                } catch (CoreException e) {
                    AcceleoMTLInterpreterPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, AcceleoMTLInterpreterPlugin.PLUGIN_ID, e.getMessage(), e));
                }
            }
        }

        return result;
    }

    /**
     * Evaluates the given expression and return the evaluation result and
     * potential issues.
     * 
     * @param context
     *            Target EObject of this evaluation.
     * @param expression
     *            Expression we are to evaluate.
     * @return The evaluation result along with all problems that may have
     *         occurred during evaluation.
     */
    private EvaluationResult internalEvaluate(EObject context, String expression) {
        final CompilationContext compilationContext = createCompilationContext(context, expression);

        final QueryIdentifier identifier = module.ensureQueryExists(compilationContext);
        CompilationResult compilationResult = module.compile(compilationContext, identifier);

        if (compilationResult.getStatus() == null || compilationResult.getStatus().getSeverity() == IStatus.OK) {
            EvaluationContext evaluationContext = new EvaluationContext(context, variables, compilationResult);
            return module.evaluate(evaluationContext);
        }
        return new EvaluationResult(null, compilationResult.getStatus());
    }

    /**
     * Notifies all of the registered variable status listener of our current
     * variable status. This will be called internally whenever we change the
     * variable map.
     */
    private void notifyVariableListeners() {
        for (IVariableStatusListener variableStatusListener : variableStatusListeners) {
            variableStatusListener.notifyChanged(getVariables());
        }
    }

    /**
     * Create a new IIntepreter preparing the environment by registering the
     * required EPackages and resource factories in EMF.
     * 
     * @return an {@link AcceleoMTLInterpreter} suitable for querying in a
     *         standalone environment.
     */
    public static AcceleoMTLInterpreter createStandaloneInterpreter() {
        registerPackages(EPackage.Registry.INSTANCE);
        registerResourceFactories(Resource.Factory.Registry.INSTANCE);
        registerLibraries();
        return new AcceleoMTLInterpreter();

    }

    private static void registerPackages(EPackage.Registry registry) {
        registry.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);

        registry.put(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.getNsURI(), org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
        registry.put(ExpressionsPackage.eINSTANCE.getNsURI(), ExpressionsPackage.eINSTANCE);

        registry.put(MtlPackage.eINSTANCE.getNsURI(), MtlPackage.eINSTANCE);

        registry.put("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore", //$NON-NLS-1$
                getOCLStdLibPackage());
    }

    private static void registerResourceFactories(Resource.Factory.Registry registry) {
        registry.getExtensionToFactoryMap().put("ecore", //$NON-NLS-1$
                new EcoreResourceFactoryImpl());
        registry.getContentTypeToFactoryMap().put(IAcceleoConstants.BINARY_CONTENT_TYPE, new EMtlBinaryResourceFactoryImpl());
        registry.getContentTypeToFactoryMap().put(IAcceleoConstants.XMI_CONTENT_TYPE, new EMtlResourceFactoryImpl());
        registry.getExtensionToFactoryMap().put("emtl", new EMtlResourceFactoryImpl());
    }

    private static EPackage getOCLStdLibPackage() {
        EcoreEnvironmentFactory factory = new EcoreEnvironmentFactory();
        EcoreEnvironment environment = (EcoreEnvironment) factory.createEnvironment();
        EPackage oclStdLibPackage = (EPackage) EcoreUtil.getRootContainer(environment.getOCLStandardLibrary().getBag());
        environment.dispose();
        return oclStdLibPackage;
    }

    private static void registerLibraries() {
        CodeSource acceleoModel = MtlPackage.class.getProtectionDomain().getCodeSource();
        if (acceleoModel != null) {
            String libraryLocation = acceleoModel.getLocation().toString();
            if (libraryLocation.endsWith(".jar")) {
                libraryLocation = "jar:" + libraryLocation + '!';
            }

            URIConverter.URI_MAP.put(URI.createURI("http://www.eclipse.org/acceleo/mtl/3.0/mtlstdlib.ecore"), URI.createURI(libraryLocation + "/model/mtlstdlib.ecore"));
            URIConverter.URI_MAP.put(URI.createURI("http://www.eclipse.org/acceleo/mtl/3.0/mtlnonstdlib.ecore"), URI.createURI(libraryLocation + "/model/mtlnonstdlib.ecore"));
        } else {
            throw new RuntimeException("Coudln't retrieve location of plugin 'org.eclipse.acceleo.model'.");
        }
    }

}
