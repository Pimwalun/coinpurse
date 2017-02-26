package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Pimwalun Witchawanitchanun
 */
public class CoinUtil{

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param valuelist is a List of Valuable objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuelist that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuelist, String currency) {
		List<Valuable> filterCurrency = new ArrayList<>();
		for (Valuable c : valuelist) {
			if (c.getCurrency().equals(currency)) {
				filterCurrency.add(c);
			} 
		}
		return filterCurrency; // return a list of coin references copied from coinlist
	}
	
	/**
	 * Method to sort a list of values by currency.
	 * On return, the list (values) will be ordered by currency.
	 * @param values is a List of Valuable objects we want to sort. 
	 */
	public static void sortByCurrency(List<? extends Valuable> values) {
		Collections.sort(values, new CompareByCurrency());
	}
	
	/**
	 * Sum values by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * @param values is a List of Valuable objects we want to sum. 
	 */
	public static void sumByCurrency(List<? extends Valuable> values) {
		Map <String , Double> map = new HashMap<>();
		for (Valuable v : values) {
			map.put(v.getCurrency(), map.getOrDefault(v.getCurrency(), 0.0) + v.getValue());
		}
		for (String c : map.keySet()){
			System.out.println(map.get(c) + " " + c);
		}
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> values = makeInternationalCoins();
		int size = values.size();
		System.out.print("INPUT: "); printList(values," ");
		List<Valuable> rupees = filterByCurrency(values, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (values.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		values = makeInternationalCoins();
		System.out.print("INPUT: "); printList(values," ");
		sortByCurrency(values);
		System.out.print("RESULT: "); printList(values," ");
		
		System.out.println("\nSum coins by currency");
		values = makeInternationalCoins();
		System.out.print("monetary objects = "); printList(values," ");
		sumByCurrency(values);
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
		}
		System.out.println(); // end the line
	}
}