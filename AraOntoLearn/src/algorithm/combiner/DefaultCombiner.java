package algorithm.combiner;

import java.util.List;
import java.util.ArrayList;

import algorithm.AbstractCombiner;
import change.ChangeRequest;


public class DefaultCombiner extends AbstractCombiner {
 
	protected List<ChangeRequest> combine() {
		ArrayList changeRequests = new ArrayList();
		for( List changeList: m_changeLists ){
			changeRequests.addAll( changeList );
		}
		return changeRequests;
	}
}
