package algorithm.normalizer;

import java.util.List;
import java.util.ArrayList;

import algorithm.AbstractNormalizer;
import change.ChangeRequest;


public class DefaultNormalizer extends AbstractNormalizer {
 
	protected List<ChangeRequest> normalize( List<ChangeRequest> changes ) {
		ArrayList<ChangeRequest> changeRequests = new ArrayList<ChangeRequest>();
		for( ChangeRequest change: changes ){
			changeRequests.add( change );
		}
		return changeRequests;
	}
}
