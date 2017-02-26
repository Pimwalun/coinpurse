package coinpurse;

/**
 * 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Baht";
	private static final String DIME_CURRENCY = "Satang";
	protected long nextSerialNumber = 1000000;
	private double[] thaiMoney = { 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	@Override
	protected Valuable createMoney(double value) {
		for (double m : thaiMoney) {
			if (value == m) {
				if (value >= 20) {
					return new BankNote(value, DEFAULT_CURRENCY, ++this.nextSerialNumber);
				} else if (value == 1 || value == 2 || value == 5 || value == 10) {
					return new Coin(value, DEFAULT_CURRENCY);
				} else if (value == 0.25 || value == 0.5) {
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
