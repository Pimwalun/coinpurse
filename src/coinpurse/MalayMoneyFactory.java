package coinpurse;

/**
 * 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Ringgit";
	private static final String DIME_CURRENCY = "Sen";
	protected long nextSerialNumber = 1000000;
	private double[] malayMoney = { 0.05, 0.1, 0.2, 0.5, 1, 5, 10, 20, 50, 100 };

	@Override
	protected Valuable createMoney(double value) {
		for (double m : malayMoney) {
			if (value == m) {
				if (value >= 1) {
					return new BankNote(value, DEFAULT_CURRENCY, this.nextSerialNumber++);
				} else if (value < 1) {
					value *= 100;
					return new Coin(value, DIME_CURRENCY);
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
		return null;
	}

}
