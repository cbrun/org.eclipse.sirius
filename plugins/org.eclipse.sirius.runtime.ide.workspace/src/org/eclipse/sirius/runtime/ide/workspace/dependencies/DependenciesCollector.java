package org.eclipse.sirius.runtime.ide.workspace.dependencies;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class DependenciesCollector implements Function<URI, Collection<URI>> {
	/**
	 * This resourceSet is used to retrieve the URI resolvers and
	 * ResourceFactories registered in EMF.
	 */
	private ResourceSet set = new ResourceSetImpl();

	/**
	 * Predicate returning true if the EObject is a proxy.
	 */
	private static final Predicate<EObject> IS_PROXY = new Predicate<EObject>() {

		public boolean apply(EObject arg0) {
			return arg0.eIsProxy();
		}
	};

	/**
	 * Predicate returning true if the EReference should be cross referenced.
	 */
	private static final Predicate<EReference> TO_BE_CROSSREFERENCED = new Predicate<EReference>() {

		public boolean apply(EReference arg0) {
			return !arg0.isDerived();
		}

	};

	/**
	 * Function transforming a complete EMF EObject into a string representing
	 * just the Resource path (trimming any present fragment).
	 */
	private static final Function<InternalEObject, URI> URI_TO_RESOURCE = new Function<InternalEObject, URI>() {

		public URI apply(InternalEObject eObj) {
			final URI from = eObj.eProxyURI();
			if (from.hasFragment()) {
				return from.trimFragment();
			}
			return from;
		}
	};

	@Override
	public Collection<URI> apply(URI uri) {
		if (isXMI(uri)) {
			try {
				return collectDependenciesFromXMI(uri);
			} catch (UnsupportedEncodingException e) {
				return collectDependenciesFromEMFResource(uri);
			} catch (IOException e) {
				return collectDependenciesFromEMFResource(uri);
			} catch (SAXException e) {
				return collectDependenciesFromEMFResource(uri);
			} catch (ParserConfigurationException e) {
				return collectDependenciesFromEMFResource(uri);
			}
		} else {
			return collectDependenciesFromEMFResource(uri);
		}
	}

	private boolean isXMI(URI uri) {
//		Set<String> knownXMIFiles = Sets.newHashSet("xmi", "ecore", "aird",
//				"genmodel");
//		return knownXMIFiles.contains(uri.fileExtension());
		return false;
	}

	private Set<URI> collectDependenciesFromXMI(final URI modelURI)
			throws UnsupportedEncodingException, IOException, SAXException,
			ParserConfigurationException {
		// CHECKSTYLE:ON
		final Set<URI> foundDependencies = Sets.newLinkedHashSet();

		Map<?, ?> options = Maps.newHashMap();
		URIConverter uriConverter = set.getURIConverter();
		Map<?, ?> response = options == null ? null : (Map<?, ?>) options
				.get(URIConverter.OPTION_RESPONSE);
		if (response == null) {
			response = new HashMap<Object, Object>();
		}

		// If an input stream can't be created, ensure that the resource is
		// still considered loaded after the failure,
		// and do all the same processing we'd do if we actually were able to
		// create a valid input stream.
		//
		InputStream inputStream = null;

		try {
			inputStream = uriConverter.createInputStream(modelURI, options);

			final SAXParserFactory factory = SAXParserFactory.newInstance();
			final InputSource input = new InputSource(inputStream);
			final SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(input, new DefaultHandler() {

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					super.startElement(uri, localName, qName, attributes);
					final int length = attributes.getLength();
					// Each attribute
					for (int i = 0; i < length; i++) {
						// a dependency looks like this :
						// href="SimpleMM1I%20/my/othernstance2.xmi#/
						final String value = attributes.getValue(i);
						if (value != null && value.indexOf('#') != -1
								&& value.indexOf('#') > 0) {
							final String baseURI = value.substring(0,
									value.indexOf('#'));
							foundDependencies.add(URI.createURI(baseURI)
									.resolve(modelURI));
						}

					}
				}

			});
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return foundDependencies;
	}

	/**
	 * Collect the cross resources dependencies from an XMIResource.
	 * 
	 * @param xmiRes
	 *            resource to process.
	 * @return the list of resource URI which the given resource depend on.
	 * @throws UnsupportedEncodingException
	 *             if the encoding is not supported
	 * @throws IOException
	 *             on error accessing the file.
	 */
	private Set<URI> collectDependenciesFromEMFResource(final URI modelURI) {
		final Set<EObject> proxyToOtherResource = Sets.newLinkedHashSet();
		try {
			collectAllProxies(modelURI, proxyToOtherResource);
		} catch (Throwable e) {
			/*
			 * anything might happen here, it could be a good idea to keep the
			 * errors around though.
			 */
		}
		return Sets.newLinkedHashSet(Collections2.transform(Collections2
				.transform(Sets.newHashSet(Iterables.filter(
						proxyToOtherResource, InternalEObject.class)),
						URI_TO_RESOURCE), new Function<URI, URI>() {

			@Override
			public URI apply(URI arg0) {
				return arg0.resolve(modelURI);
			}
		}));

	}

	public Resource collectAllProxies(final URI modelURI,
			Set<EObject> proxyToOtherResource) {

		Resource res = set.getResource(modelURI, true);
		try {
			res.load(Collections.EMPTY_MAP);
			final Iterator<EObject> it = EcoreUtil.getAllProperContents(res,
					false);

			while (it.hasNext()) {
				final EObject next = it.next();
				proxyToOtherResource.addAll(Collections2.filter(allRefs(next),
						IS_PROXY));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Method returning all the referenced objects which should be considered
	 * for the cross referencing.
	 * 
	 * @param from
	 *            the source object.
	 * @return all the referenced objects which should be cross referenced.
	 */
	private Collection<EObject> allRefs(EObject from) {
		final List<EObject> referencedObjects = Lists.newArrayList();

		for (final EReference ref : Iterables.filter(from.eClass()
				.getEAllReferences(), TO_BE_CROSSREFERENCED)) {
			if (ref.isMany()) {
				final Collection<EObject> referenced = (Collection<EObject>) from
						.eGet(ref, false);
				referencedObjects.addAll(referenced);
			} else {
				final EObject referenced = (EObject) from.eGet(ref, false);
				if (referenced != null) {
					referencedObjects.add(referenced);
				}
			}
		}
		return referencedObjects;
	}

}
