package algorithm.combiner;

import java.util.List;

import algorithm.AbstractCombiner;

import pom.POMObject;
import change.Change;
import change.ChangeRequest;
import change.POMChange;


public class AverageCombiner extends AbstractCombiner {
 
	protected List<ChangeRequest> combine() {
		List<ChangeRequest> changeRequests = getAllChangeRequests();
		List<POMObject> objects = getObjects();
		for( POMObject object: objects )
		{
			double dAvgProb = 0.0;
			List<ChangeRequest> requests = getLastChangeRequests( object );
			for( ChangeRequest request: requests )
			{
				if( request.getType() == Change.Type.MODIFY ){
					dAvgProb += ((Double)request.getValue()).doubleValue(); 
				}	
				else if( request.getType() == Change.Type.ADD ){
					dAvgProb += ((POMObject)request.getObject()).getProbability(); 
				}
			}
			dAvgProb = dAvgProb / requests.size();
			changeRequests.add( new ChangeRequest( new POMChange( Change.Type.MODIFY, this, object, dAvgProb, (Change)null ), requests ) ); 
		}
		return changeRequests;
	}
}
