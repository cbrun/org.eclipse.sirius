package org.eclipse.sirius.runtime.ide.workspace.refactoring;

import org.eclipse.emf.common.util.URI;

public class URIChange {
	private URI oldURI;
	private URI newURI;

	public URIChange(URI oldURI, URI newURI) {
		super();
		this.oldURI = oldURI;
		this.newURI = newURI;
	}

	public URI getOldURI() {
		return oldURI;
	}

	public URI getNewURI() {
		return newURI;
	}

	public URIChange inverse() {
		return new URIChange(newURI,oldURI);
	}
	
	@Override
	public String toString() {
		return oldURI.toString() + " => " + newURI.toString();
	}

}
