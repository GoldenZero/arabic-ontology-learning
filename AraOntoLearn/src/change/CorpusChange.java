package change;
 
import java.util.List;
import java.util.ArrayList;

import corpus.AbstractDocument;

/**
 * @author Moayad Al-said-ali(Moayad@live.com)
 */
public class CorpusChange extends Change { 
  
	public CorpusChange( int iType, Object source, AbstractDocument document ){
		m_iType = iType;
		m_source = source;
		m_object = document; 
	}
    
	public AbstractDocument getDocument(){
		return (AbstractDocument)m_object;
	}
	  
	public String toString(){
		return "CorpusChange( type="+ Type.toString( m_iType ) +", document="+ m_object +" )"; 
	}
}

