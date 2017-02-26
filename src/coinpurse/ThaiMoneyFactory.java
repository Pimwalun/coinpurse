package coinpurse;

/**
 * This class create coin and banknote of Thailand.
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
		Valuable valuable = null;
		for (double m : thaiMoney) {
			if (value == m) {
				if (value >= 20) {
					valuable = new BankNote(value, DEFAULT_CURRENCY, ++this.nextSerialNumber);
				} else if (value == 1 || value == 2 || value == 5 || value == 10) {
					valuable = new Coin(value, DEFAULT_CURRENCY);
				} else if (value == 0.25 || value == 0.5) {
					valuable = new Coin(value*100, DIME_CURRENCY);
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
		return valuable;
	}
	
	public static void main(String[] arg) throws IllegalArgumentException{
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
		Valuable m3 = factory.createMoney(500);
		System.out.println(m3.toString());
		Valuable m4 = factory.createMoney(20);
		System.out.println(m4.toString());
	}
}
