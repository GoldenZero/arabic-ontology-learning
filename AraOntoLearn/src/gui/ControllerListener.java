package gui;
 
/**
 * @author Moayad (Moayad@live.com)
 */
public interface ControllerListener {

	public final static int ADD = 0;
	
	public final static int REMOVE = 1;
	
	public final static int COMBINER = 2;
	
	public final static int AUXILIARY = 3;
	

	public void controllerChanged( int iMessage, String sComplex, Class algorithmClass, Class configClass );

}