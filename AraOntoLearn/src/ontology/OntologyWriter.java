package ontology;

import java.net.URI;

import pom.POM;

import reference.ReferenceManager;

import evidence.EvidenceManager;


public interface OntologyWriter { 

	public abstract void write( URI uri ) throws Exception;
	
	public abstract void setEvidenceManager( EvidenceManager em );
	
	public abstract void setReferenceManager( ReferenceManager rm );
}



