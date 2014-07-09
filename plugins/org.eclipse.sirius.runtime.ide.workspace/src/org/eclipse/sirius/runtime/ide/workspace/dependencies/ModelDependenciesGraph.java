package org.eclipse.sirius.runtime.ide.workspace.dependencies;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class ModelDependenciesGraph {

	/**
	 * The roots have no parent dependency which are files (it doesn't mean they
	 * have no dependency at all, they might have dependencies coming from
	 * bundled plugins for instance.
	 */
	private Set<URI> roots = Sets.newLinkedHashSet();
	private Set<URI> known = Sets.newLinkedHashSet();

	/**
	 * key path requires paths in values.
	 */
	private Multimap<URI, URI> requires = HashMultimap.create();

	/**
	 * key path is required by paths in values.
	 */
	private Multimap<URI, URI> invRequires = HashMultimap.create();

	private Function<URI, Collection<URI>> requireFunction;

	public ModelDependenciesGraph(
			Function<URI, Collection<URI>> computeRequirement) {
		this.requireFunction = computeRequirement;
	}

	/**
	 * Add a new dependency to the graph.
	 * 
	 * @param modelRequiring
	 *            uri of the model requiring the other model.
	 * @param requirement
	 *            uri of the model which is required.
	 */
	private void requires(URI modelRequiring, URI requirement) {
		requires.put(modelRequiring, requirement);
		invRequires.put(requirement, modelRequiring);
		if (roots.contains(modelRequiring)) {
			roots.remove(modelRequiring);
		}

	}

	/**
	 * Register a path which have not been registered already.
	 * 
	 * @param modelURI
	 *            a model uri to consider in the dependency graph.
	 */
	public void registerModel(URI modelURI) {
		known.add(modelURI);
		if (modelURI.isPlatformResource()) {
			roots.add(modelURI);
			for (URI uri : requireFunction.apply(modelURI)) {
				requires(modelURI, uri);
				if (!known.contains(uri)) {
					registerModel(uri);
				}
			}
		}
	}

	/**
	 * return the list of uris known by the DepedencyGraph in an order suitable
	 * for processing. Processing them in the order of the list gives the
	 * guarantee that any file required by another will always be processed
	 * before.
	 * 
	 * @return the list of path known by the DepedencyGraph in an order suitable
	 *         for processing. Processing them in the order of the list gives
	 *         the guarantee that any uri required by another will always be
	 *         processed before.
	 */
	public List<URI> topologicalOrder() {
		Set<URI> visited = Sets.newLinkedHashSet();
		Stack<URI> stack = new Stack<URI>();

		for (URI root : roots) {
			stackNodes(root, visited, stack);
		}

		List<URI> result = Lists.newArrayList();
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;
	}

	/**
	 * Stack the nodes in depth first order.
	 * 
	 * @param v
	 *            the current node.
	 * @param visited
	 *            the set of nodes already visited.
	 * @param stack
	 *            the stack to update.
	 */
	private void stackNodes(URI v, Set<URI> visited, Stack<URI> stack) {
		visited.add(v);
		for (URI invRequire : invRequires.get(v)) {
			if (!visited.contains(invRequire)) {
				stackNodes(invRequire, visited, stack);
			}

		}
		stack.push(v);
	}

	/**
	 * Return the list of paths which are required by the given other path.
	 * 
	 * @param absolutePath
	 *            a path.
	 * @return the list of paths which are required by the given other path.
	 */
	public Collection<URI> getRequirements(URI absolutePath) {
		return requires.get(absolutePath);
	}

	/**
	 * Return the list of paths which are required by the given other path.
	 * 
	 * @param absolutePath
	 *            a path.
	 * @return the list of paths which are required by the given other path.
	 */
	public Collection<URI> getInverseRequirements(URI absolutePath) {
		return invRequires.get(absolutePath);
	}

}
