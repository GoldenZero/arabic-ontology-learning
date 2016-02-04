package algorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import change.ChangeRequest; 

/**
 * @author Moayad Al-said-ali
 */
public abstract class AbstractNormalizer implements Serializable{

	protected abstract List<ChangeRequest> normalize( List<ChangeRequest> changes );
}
