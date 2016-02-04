package evidence;

import java.util.List; 
 
import change.*;


public abstract class AbstractEvidenceStore extends Changeable {
   
	protected Change createChange( ChangeRequest changeRequest ) {
        // TODO dummy
        return changeRequest.createChangeWithType( changeRequest.getType() );
    }

    protected void processChangeRequests( List<ChangeRequest> changeRequests ) {
        super.processChangeRequests( changeRequests );
    }

    protected void processChangeRequest( ChangeRequest changeRequest ) {
        super.processChangeRequest( changeRequest );
    }
}

