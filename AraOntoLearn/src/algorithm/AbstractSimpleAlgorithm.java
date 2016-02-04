package algorithm;
 
import java.util.List;

import change.ChangeRequest;
import change.POMChange;
import explanation.AbstractExplanation;


/**
 * @author Moayad Al-said-ali(Moayad@live.com)
 */
public abstract class AbstractSimpleAlgorithm extends AbstractAlgorithm {

	protected abstract List<ChangeRequest> getEvidenceChanges() throws Exception;
	 
	protected abstract AbstractExplanation getExplanation( POMChange change ) throws Exception;
	
	protected abstract List<ChangeRequest> getPOMChanges() throws Exception;
	
	protected abstract List<ChangeRequest> getReferenceChanges() throws Exception;	
	
	protected List<ChangeRequest> getNormalizedPOMChanges() throws Exception { 
		return m_normalizer.normalize( getPOMChanges() );	
	}
}
