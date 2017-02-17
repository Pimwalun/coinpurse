package coinpurse;

import java.util.Comparator;

/**
 * this class is compare currency of Valuable.
 * @author Pimwalun Witchawanitchanun
 */
public class CompareByCurrency implements Comparator<Valuable>{
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}
}
