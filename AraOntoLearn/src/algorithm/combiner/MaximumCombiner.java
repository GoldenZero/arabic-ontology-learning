package algorithm.combiner;

import java.util.List;

import algorithm.AbstractCombiner;

import pom.POMObject;
import change.Change;
import change.ChangeRequest;
import change.POMChange;

/*
 * @author Moayad Al-said-ali
 */
public class MaximumCombiner extends AbstractCombiner {
 
	protected List<ChangeRequest> combine() {
		List<ChangeRequest> changeRequests = getAllChangeRequests();
		List<POMObject> objects = getObjects();
		for( POMObject object: objects )
		{
			Double dMaxProb = 0.0;
			List<ChangeRequest> requests = getLastChangeRequests( object );
			for( ChangeRequest request: requests )
			{
				double dProb = 0.0;
				if( request.getType() == Change.Type.MODIFY ){
					dProb = ((Double)request.getValue()).doubleValue();	
				}	
				else if( request.getType() == Change.Type.ADD ){
					dProb = ((POMObject)request.getObject()).getProbability();  
				}
				if( dProb > dMaxProb ){
					dMaxProb = dProb;
				} 
			} 
			changeRequests.add( new ChangeRequest( new POMChange( Change.Type.MODIFY, this, object, dMaxProb, (Change)null ), requests ) ); 
		}
		return changeRequests;
	}
}
