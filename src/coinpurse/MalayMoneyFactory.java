package coinpurse;

/**
 * This class create coin and banknote of Malaysia.
 * @author Pimwalun Witchawanitchanun
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Ringgit";
	private static final String DIME_CURRENCY = "Sen";
	protected long nextSerialNumber = 1000000;
	private double[] malayMoney = { 0.05, 0.1, 0.2, 0.5, 1, 5, 10, 20, 50, 100 };

	@Override
	protected Valuable createMoney(double value) {
		Valuable valuable = null;
		for (double m : malayMoney) {
			if (value == m) {
				if (value >= 1) {
					valuable = new BankNote(value, DEFAULT_CURRENCY, ++nextSerialNumber);
				} else if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5) {
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
//		Valuable m2 = factory.createMoney("1000.0");
//		System.out.println(m2.toString());
//		Valuable m3 = factory.createMoney(500);
//		System.out.println(m3.toString());
		Valuable m4 = factory.createMoney(20);
		System.out.println(m4.toString());
	}
}
