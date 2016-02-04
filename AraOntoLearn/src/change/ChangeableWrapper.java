package change;

import java.io.Serializable;
import java.util.List;


/**
 * @author Moayad al-said-ali
 */
public interface ChangeableWrapper extends Serializable {

    public Changeable getChangeable();

    public void processChangeRequest( ChangeRequest changeRequest );

    public void processChangeRequests( List<ChangeRequest> changeRequests );
    
	public int getId();
	
	public String getName();
}
