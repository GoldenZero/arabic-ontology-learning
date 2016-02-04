package gui;
 
/**
 * @author Moayad (Moayad@live.com)
 */
public interface CorpusListener {

	public final static int ADD = 0;
	
	public final static int REMOVE = 1;
	

	public void corpusChanged( int iMessage, String sFile );

}