package coinpurse;

/**
 * 
 * @author Pimwalun Witchawanitchanun
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory moneyFactory;

	/**
	 * 
	 * @return
	 */
	public static MoneyFactory getInstance() {
		if (moneyFactory == null)
			moneyFactory = new ThaiMoneyFactory();
		return moneyFactory;
	}

	/**
	 * 
	 * @param value
	 */
	protected abstract Valuable createMoney(double value);

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected Valuable createMoney(String value) {
		try {
			Double newValue = Double.parseDouble(value);
			return createMoney(newValue);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	static  void setMoneyFactory(MoneyFactory factory){
		MoneyFactory.moneyFactory = factory;		
	}

}
