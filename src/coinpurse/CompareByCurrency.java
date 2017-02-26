package coinpurse;

import java.util.Comparator;

/**
 * This class is compare currency of Valuable.
 * @author Pimwalun Witchawanitchanun
 */
public class CompareByCurrency implements Comparator<Valuable>{
	
	/**
	 * Compare 2 Valuable by currency
	 * @param o1 is the first comparator
	 * @param o2 is the second comparator
	 * @return -1 if o1's currency come first<br>
	 *         0 if both of 2 have same currency<br>
	 *         1 if o1's currency come after
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}
}
