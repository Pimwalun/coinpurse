package coinpurse;

/**
 * A coin with a monetary value and currency.
 * @author Pimwalun Witchawanitchanun
 */
public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value is value for a coin.
     */
    public Coin(double value) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value is value of coin.
     * @param currency is currency of coin.
     */
    public Coin(double value, String currency) {
    	this.value = value;
    	this.currency = currency;
    }

    /**
     * Get the value of coin. 
     * @return the value of coin.
     */
    public double getValue() { 
    	return this.value;
    } 
    
    /**
     * Get the currency of coin.
     * @return the currency of coin.
     */
    public String getCurrency() { 
    	return currency;
    }
        
    /**
     * Compare coin by currency and value.
     * @param obj is another Coin to compare to this one.
     * @return true if currency and value is same, false otherwise.
     */
    public boolean equals(Object obj) {
    	if(obj == null) return false;
    	if(obj.getClass() != this.getClass()) return false;
    	Coin other = (Coin) obj;
    	if(this.currency.equalsIgnoreCase(other.currency) && this.value == other.value) return true;
    	return false;    	
    }
    
    /**
     * Compare coin by value.
     * @param coins is Coin objects we want to compare. 
     * @return 1 if this coin has greater value.
	 *         0 if both have same value.
	 *         -1 if this coin has lesser value.
     */
    public int compareTo( Coin c ) {
    	if (c == null) return -1;
    		return (int) Math.signum(this.value - c.value);
    }
    
    /**
     * Get a string representation of Coin.
     * @return string representation of Coin.
     */
    public String toString() { 
    	return this.value + "-" + this.currency; 
    }    
}
