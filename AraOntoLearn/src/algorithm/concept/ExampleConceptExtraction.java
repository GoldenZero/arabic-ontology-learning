package algorithm.concept;

import java.util.List;
 
import evidence.reference.ReferenceStore;
import change.ChangeRequest; 
import pom.POMObject; 

/**
 */
public class ExampleConceptExtraction extends AbstractConceptExtraction {

	protected List<ChangeRequest> normalize( List<ChangeRequest> list ){ 
		return list;
	}
	
	protected void prepareNormalization( Double prob ){
		// TODO
	}
	 
	protected double getProbability( POMObject object, int iReferences ){
		int iFreq = (getEvidenceStore( ReferenceStore.class )).getReferences( object ).size();
		return new Double( (double)iFreq / Math.max( 1.0, (double)iReferences ) ); 
	}	
}
