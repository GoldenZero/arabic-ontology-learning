package algorithm;

import util.AraOntoLearnException;


public class ControllerException extends AraOntoLearnException { 

	public ControllerException( String sError ){
		super( sError );
	}   
 
	public ControllerException( Throwable e ){
		super( e ); 
	}

	public ControllerException( String sError, Throwable e ){
		super( sError, e );
	}
}

