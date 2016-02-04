package evidence.wordnet;

import java.util.HashMap;

import change.Change;
import evidence.AbstractEvidenceStore;


public class WordNetStore extends AbstractEvidenceStore {

	private HashMap m_hmEntity2SynsetContext;
	
	private HashMap m_hmEntity2ContextSimilarity;
	
	
	protected void executeChange( Change change ){
		switch( change.getType() ){
			case Change.Type.ADD: 
				executeAdd( change );
				break;
			case Change.Type.REMOVE:
				executeRemove( change );
				break;
			case Change.Type.MODIFY:
				executeModify( change );
				break;
		}
	}

	protected void executeAdd( Change change ){
		// TODO 
	} 

	protected void executeRemove( Change change ){
		// TODO 
	}
 
	protected void executeModify( Change change ){
		// TODO   
	}
}