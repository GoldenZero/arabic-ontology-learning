package corpus;

import util.AraOntoLearnException;


public class CorpusException extends AraOntoLearnException {

	public CorpusException( String sError ){
		super( sError );
	}   
 
	public CorpusException( Throwable e ){
		super( e ); 
	} 

	public CorpusException( String sError, Throwable e ){
		super( sError, e );
	}
}