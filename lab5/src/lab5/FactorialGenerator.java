package lab5;
/**
 * 
 */

/**
 * @author Work_DCruz
 *
 */
public class FactorialGenerator {

	public FactorialGenerator() {
	}

	public double nthFactorial(int n) {
		return this.computeFactorialRecurse(n);
	}

	private double computeFactorialRecurse(int n) {
		assert n >= 0 : "Illegal n: " + n;
		if (n != 0) {
			return n * this.computeFactorialRecurse(n - 1);
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		FactorialGenerator n = new FactorialGenerator();
		System.out.println("Long Max Value: " + Long.MAX_VALUE);
		System.out.println(n.nthFactorial(-1));
	}
}
