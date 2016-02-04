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
public class MinimumCombiner extends AbstractCombiner {
 
	protected List<ChangeRequest> combine() {
		List<ChangeRequest> changeRequests = getAllChangeRequests();
		List<POMObject> objects = getObjects();
		for( POMObject object: objects )
		{
			Double dMinProb = 0.0;
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
				if( dProb < dMinProb ){
					dMinProb = dProb;
				} 
			} 
			changeRequests.add( new ChangeRequest( new POMChange( Change.Type.MODIFY, this, object, dMinProb, (Change)null ), requests ) ); 
		}
		return changeRequests;
	}
}
