package algorithm;

import java.util.List;

import change.ChangeRequest;

/**
 * @author Moayad al-said-ali
 */
public abstract class AbstractAuxiliaryAlgorithm extends AbstractAlgorithm {

	protected abstract List<ChangeRequest> getEvidenceChanges() throws Exception;
}
