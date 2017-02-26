package coinpurse;

/**
 * 
 * @author Pimwalun Witchawanitchanun
 *
 */
public abstract class AbstractValuable implements Valuable{
	double value;
	String currency;
	public AbstractValuable(double value,String currency) {
		super();
	}

	/**
	 * Compare coin and banknote by currency and value.
	 * @param obj is another Coin to compare to this one.
	 * @return true if currency and value is same, false otherwise.
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Valuable other = (Valuable) obj;
		if(this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue()) return true;
		return false;
	}
	
	/**
     * Compare coin and banknote by value.
     * @param valuable is Valuable objects we want to compare. 
     * @return -1 if this valuable has greater value.
     */
	
	@Override
	public int compareTo( Valuable valuable ){
		if (this.currency.equalsIgnoreCase(valuable.getCurrency())){
			return (int) Math.signum(this.value - valuable.getValue());
		}
		if (this.currency == null && valuable.getCurrency() == null){
			return (int) Math.signum(this.value - valuable.getValue());
		}
		return -1;
	}
	
	/**
     * Get the value of coin and banknote. 
     * @return the value of coin and banknote.
     */
	@Override
	public double getValue(){
		return this.value;
	}
	
    /**
     * Get the currency of coin and banknote.
     * @return the currency of coin and banknote.
     */
	@Override
	public String getCurrency(){
		return this.currency;
	}

}