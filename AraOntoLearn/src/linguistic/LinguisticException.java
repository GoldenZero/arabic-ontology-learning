package linguistic;

import util.AraOntoLearnException;




public class LinguisticException extends AraOntoLearnException { 

	public LinguisticException( String sError ){
		super( sError );
	}   
 
	public LinguisticException( Throwable e ){
		super( e ); 
	}

	public LinguisticException( String sError, Throwable e ){
		super( sError, e );
	}
}