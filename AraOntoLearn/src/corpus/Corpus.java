package corpus;

import java.util.List;
import java.util.ArrayList;
import change.Change; 
import change.ChangeRequest;
import change.Changeable;
import change.CorpusChange;

/**
 * @author Moayad Al-said-ali(Moayad@live.com)
 */
public class Corpus extends Changeable {
	
	private List<AbstractDocument> m_documents;

	protected Corpus(){
		super();
		m_documents = new ArrayList<AbstractDocument>(); 
	}

	public void addDocument( AbstractDocument doc ){
		processChangeRequest( new ChangeRequest( new CorpusChange( Change.Type.ADD, this, doc ) ) );
	}

	public void removeDocument( AbstractDocument doc ){
		processChangeRequest( new ChangeRequest( new CorpusChange( Change.Type.REMOVE, this, doc ) ) ); 
	}

	public List<AbstractDocument> getDocuments(){
		return m_documents;
	}

	public int size(){
		return m_documents.size();
	}

	public String toString(){
		return "Corpus: "+ m_documents; 
	}
	 
	/* Changeable */
	 
	protected Change createChange(ChangeRequest changeRequest) {
		Change c;	
		switch( changeRequest.getType() ) {
			case Change.Type.REMOVE:
				c = changeRequest.createChangeWithType( Change.Type.REMOVE );
				break; 
			default:
				c = changeRequest.createChangeWithType( Change.Type.ADD );
				break;
		}
		return c;
	}
	
	protected void executeChange( Change change ){ 
		switch( change.getType() )
		{
			case Change.Type.ADD: 
				m_documents.add( (AbstractDocument)change.getObject() );  
				break;
			case Change.Type.REMOVE: 
				m_documents.remove( (AbstractDocument)change.getObject() );  
				break; 
		} 	
	}
}