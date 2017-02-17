package coinpurse;

/**
 * A banknote with a monetary value and currency
 * @author Pimwalun Witchawanitchanun
 */
public class BankNote implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	private static long nextSerialNumber = 1000000;
	private final double value;
	private final String currency;
	private final long serialNumber;
	
    /**
     * A banknote with given value using the default currency.
     * @param value is value for a banknote.
     */
	public BankNote(double value) {
		this(value,DEFAULT_CURRENCY);
	}
	
    /**
     * A banknote with given value and currency.
     * @param value is value of banknote.
     * @param currency is currency of banknote.
     */
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
    /**
     * Get the value of banknote. 
     * @return the value of banknote.
     */
	public double getValue() {
		return this.value;
	}

    /**
     * Get the currency of banknote.
     * @return the currency of banknote.
     */
	public String getCurrency() {
		return this.currency;
	}
	
    /**
     * Get the serial of banknote.
     * @return the serial of banknote.
     */
	public long getSerial(){
		return this.serialNumber;
	}
	
    /**
     * Compare banknote by currency and value.
     * @param obj is another BankNote to compare to this one.
     * @return true if currency and value is same, false otherwise.
     */
	public boolean equals(Object obj){
		if(obj == null) return false;
    	if(obj.getClass() != this.getClass()) return false;
    	BankNote other = (BankNote) obj;
    	if(this.currency.equalsIgnoreCase(other.currency) && this.value == other.value) return true;
    	return false;
	}
	
    /**
     * Get a string representation of BankNote.
     * @return string representation of BankNote.
     */
	public String toString(){
		return value + "-" + currency + "note [" + serialNumber + "]"; 
	}
}
