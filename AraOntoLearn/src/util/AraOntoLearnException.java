package util;


public class AraOntoLearnException extends Exception {

	private Throwable m_exception;


	public AraOntoLearnException( String sError ){
		super( sError );
	}   
 
	public AraOntoLearnException( Throwable e ){
		super( e.toString() );
		m_exception = e;
	}

	public AraOntoLearnException( String sError, Throwable e ){
		super( sError );
		m_exception = e;
	}
 
	public void printStackTrace(){
		super.printStackTrace();
		if( m_exception != null )
		{
			System.err.println( "Source:" );
			m_exception.printStackTrace();
		}
	}
}