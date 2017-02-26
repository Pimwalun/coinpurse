package coinpurse;

/**
 * A coin with a monetary value and currency.
 * @author Pimwalun Witchawanitchanun
 */
public class Coin extends AbstractValuable{
    
    /**
     * A coin with given value using the default currency.
     * @param value is value for a coin.
     */
    public Coin(double value) {
        super(value, "Baht");
    }
    
    /**
     * A coin with given value and currency.
     * @param value is value of coin.
     * @param currency is currency of coin.
     */
    public Coin(double value, String currency) {
    	super(value, currency);
    }        
    
    /**
     * Get a string representation of Coin.
     * @return string representation of Coin.
     */
    public String toString() { 
    	return this.value + "-" + this.currency; 
    }    
}
