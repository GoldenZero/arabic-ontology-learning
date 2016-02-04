package persist;

import util.AraOntoLearnException;


public class PersistenceException extends AraOntoLearnException {

	public PersistenceException( String sError ){
		super( sError );
	}   
 
	public PersistenceException( Throwable e ){
		super( e ); 
	}

	public PersistenceException( String sError, Throwable e ){
		super( sError, e );
	}
}