package coinpurse;

/**
 * This class for creating money of other countries.
 * @author Pimwalun Witchawanitchanun
 */
public abstract class MoneyFactory {
	private static MoneyFactory moneyFactory;

	/**
	 * Returns an object of Thai or Malay
	 * @return get an instance of MoneyFactory
	 */
	public static MoneyFactory getInstance() {
		if (moneyFactory == null)
			moneyFactory = new ThaiMoneyFactory();
		return moneyFactory;
	}

	/**
	 * create a new money object in the local currency.
	 * @param value is a new money object in the local currency.
	 * @throws IllegalArgumentException if the value is not a valid currency money.
	 */
	protected abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * Create coin and banknote of Malaysia
	 * @param value is coin and banknote to insert
	 * @return valuable if value >=1, it create banknote of Malaysia
	 * 					if value <1, it create coin of Malaysia
	 */
	protected Valuable createMoney(String value) {
		try {
			Double newValue = Double.parseDouble(value);
			return createMoney(newValue);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Set MoneyFacetory depend on purse.properties
	 */
	protected static void setMoneyFactory(MoneyFactory factory){
		MoneyFactory.moneyFactory = factory;		
	}
}
