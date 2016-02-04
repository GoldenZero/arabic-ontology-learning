package linguistic;

import util.AraOntoLearnException;


public class AnalyserException extends AraOntoLearnException { 

	public AnalyserException( String sError ){
		super( sError );
	}   
 
	public AnalyserException( Throwable e ){
		super( e ); 
	}

	public AnalyserException( String sError, Throwable e ){
		super( sError, e );
	}
}