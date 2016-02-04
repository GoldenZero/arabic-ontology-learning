package algorithm.concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
 
import pom.POMConcept;
import pom.POMEntity;
import pom.POMSubclassOfRelation;
import corpus.AbstractDocument;
import reference.document.DocumentReference;
import util.Settings;
import linguistic.AnalyserException;
import linguistic.LinguisticAnalyser;
import algorithm.AbstractEntityExtraction;

// import com.sun.media.sound.AlawCodec;

/**
 * @author Günter Ladwig
 */
public abstract class AbstractConceptExtraction extends AbstractEntityExtraction {

	protected HashMap<POMEntity,List<DocumentReference>> getEntity2References( AbstractDocument doc ){
		HashMap<POMEntity,List<DocumentReference>> hmEntity2References = new HashMap<POMEntity,List<DocumentReference>>();
		List allReferences =  m_analyser.getDocumentReferences( doc, LinguisticAnalyser.CONCEPT );
		for( Iterator pIter = allReferences.iterator(); pIter.hasNext(); )
		{
			DocumentReference entityReference = (DocumentReference)pIter.next();
			String sEntity = getEntity( entityReference );
			if( sEntity == null ){
				continue;
			}
			POMEntity entity = m_pom.newConcept( sEntity );
			List<DocumentReference> references = hmEntity2References.get( entity );
			if( references == null )
			{
				references = new ArrayList<DocumentReference>();
				hmEntity2References.put( entity, references );
			}
			references.add( entityReference ); 
		}
		return hmEntity2References;
	}
	
	
	
	private String getWords( ArrayList<String> heads, String prepositionalPhrase, String adjectives ) throws AnalyserException {
		String sDomain = "";
		for ( int iIndex = 1; iIndex < heads.size(); iIndex += 2 ) {
			sDomain = sDomain + heads.get( iIndex ) + " ";
		}
		if ( prepositionalPhrase != null ) {
			sDomain = sDomain + prepositionalPhrase;
		}
		else if ( adjectives != null ) {
			sDomain = sDomain + adjectives;
		}
		else {
			return null;
		}
		return sDomain;
	}
	
	private POMConcept getConcept( ArrayList<String> heads, String prepositionalPhrase, String adjectives ) throws AnalyserException {
		String sDomain = "";
		for ( int iIndex = 0; iIndex < heads.size(); iIndex += 2 ) {
			sDomain = sDomain + heads.get( iIndex ) + " ";
		}
		if ( prepositionalPhrase != null ) {
			sDomain = sDomain + prepositionalPhrase;
		}
		else if ( adjectives != null ) {
			sDomain = sDomain + adjectives;
		}
		else {
			return null;
		}
		POMConcept domain = m_pom.newConcept( sDomain );
		return domain;
	}
	
	private ArrayList getAdjectives(DocumentReference reference, long endOffsetHeads) {
		ArrayList alResults = new ArrayList();
		List<DocumentReference> lAdjectiveReferences = m_analyser.getDocumentReferences( reference, LinguisticAnalyser.ADJECTIVE );
		String sAdjectivesLemma = null;
		String sAdjectives = null;
		long lAdjectiveEndOffset = -1;
		try {
			if ( lAdjectiveReferences.size() > 0 ) {
				for( DocumentReference adjectiveReference: lAdjectiveReferences ) {
					if ( adjectiveReference.getStartOffset() == endOffsetHeads + 1 ) {
						sAdjectivesLemma = m_analyser.getStemmedText( adjectiveReference );
						sAdjectives = adjectiveReference.getText();
						lAdjectiveEndOffset = adjectiveReference.getEndOffset();
					}
					else if ( adjectiveReference.getStartOffset() == lAdjectiveEndOffset + 1 ) {
						sAdjectivesLemma = sAdjectivesLemma + " " + m_analyser.getStemmedText( adjectiveReference );
						sAdjectives = sAdjectivesLemma + " " + adjectiveReference.getText();
						lAdjectiveEndOffset = adjectiveReference.getEndOffset();
					}
					else {
						return alResults;
					}
				}
				alResults.add( sAdjectivesLemma );
				alResults.add( lAdjectiveEndOffset );			
				alResults.add( sAdjectives );
			
				//alResults.add
			}
		} catch ( AnalyserException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alResults;
	}

	
}
