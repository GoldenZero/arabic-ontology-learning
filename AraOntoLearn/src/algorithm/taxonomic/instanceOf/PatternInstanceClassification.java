package algorithm.taxonomic.instanceOf;

import java.util.ArrayList;
import java.util.List;

import corpus.AbstractDocument;
import linguistic.AnalyserException;
import linguistic.LinguisticAnalyser;
import pom.POMInstance; 
import pom.POMConcept;
import pom.POMEntity;
import pom.POMAbstractRelation;
import pom.POMTaxonomicRelation;
import pom.POMInstanceOfRelation;
import reference.document.DocumentReference;
import evidence.pattern.InstanceFingerprint;
import evidence.pattern.PatternStore;

import algorithm.taxonomic.AbstractPatternClassification;

/* 
 * @author Moayad (Moayad@live.com)
 */
public class PatternInstanceClassification extends AbstractPatternClassification implements AbstractInstanceClassification {
    
   /**
    * returns subclass-of relations with same domain as relation 
    */
	protected ArrayList getDomainRelations( POMTaxonomicRelation relation ) {
		System.out.println("get Domain Relations: "+relation.toString());
		ArrayList alDomainRelations = new ArrayList();
		POMInstance domain = (POMInstance)relation.getDomain();
		InstanceFingerprint fingerprint = ((PatternStore)getLocalEvidenceStore( PatternStore.class )).getFingerprint( domain );
		List<POMConcept> concepts = (ArrayList)fingerprint.getConcepts();
		for( POMConcept concept: concepts )
		{ 
			POMInstanceOfRelation instanceOfRelation = m_pom.newInstanceOfRelation( domain, concept ); 
			alDomainRelations.add( instanceOfRelation );
		}
		return alDomainRelations;
	}
 
	protected List getRelationReferences( AbstractDocument doc ) {
		System.out.println("get relation References "+doc.toString());
		return m_analyser.getDocumentReferences( doc, LinguisticAnalyser.INSTANCE_OF );
	}
 
	protected List getRelations( DocumentReference reference ) throws AnalyserException {
		System.out.println("get relations "+reference.toString());
		ArrayList alRelations = new ArrayList();
		List alDomainStrings = getDomainStrings( reference );
		List alRangeStrings = getRangeStrings( reference );
		for ( int j = 0; j < alDomainStrings.size(); j++ )
		{
			POMInstance instance = m_pom.newInstance( (String)alDomainStrings.get( j ) );
			for( int k = 0; k < alRangeStrings.size(); k++ )
			{
				POMConcept range = m_pom.newConcept( (String)alRangeStrings.get( k ) );
				POMInstanceOfRelation instanceOfRelation = m_pom.newInstanceOfRelation( instance, range ); 
				alRelations.add( instanceOfRelation );
			}
		}
		return alRelations;
	}
	
	protected List<POMTaxonomicRelation> getRelations( List<POMEntity> domains ){
		System.out.println("get relations (domains)");
		List<POMTaxonomicRelation> relations = new ArrayList<POMTaxonomicRelation>();
		List<POMAbstractRelation> rels = m_pom.getObjects( POMInstanceOfRelation.class );
		for( POMAbstractRelation rel: rels )
		{
			if( domains.contains( rel.getDomain() ) ){
				relations.add( (POMInstanceOfRelation)rel );
			}
		}
		return relations;
	}
	
	protected Double getProbability( int iFreq, int iAllFreq ) {
		System.out.println("get probability "+iFreq+"   "+iAllFreq);
		return new Double( (double)iFreq / (double)iAllFreq );
	}
}