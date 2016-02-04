package change;

import java.io.Serializable;
import java.util.List;

/**
 * @author Moayad Al-said-ali(Moayad@live.com)
 */
public interface ChangeStrategy extends Serializable {

	public List processChanges( List changes );

	public Object clone();
}


