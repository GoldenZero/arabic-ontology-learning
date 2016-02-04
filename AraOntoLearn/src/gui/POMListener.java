package gui;
 
import java.util.List; 

import pom.POMObject;
 
/**
 * @author Moayad (Moayad@live.com)
 */
public interface POMListener {

	public final static int ADD = 0;
	
	public final static int REMOVE = 1;
	

	public void pomChanged( int iMessage, List<? extends POMObject> objects );

}