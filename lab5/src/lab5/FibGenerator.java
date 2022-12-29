/**
 * 
 */
package lab5;

/**
 * @author Work_DCruz
 *
 */
public class FibGenerator {
	private int[] callCounter;

	public int nthFib(int n) {
		callCounter = new int[n + 1];
		return this.computeFibRecurse(n);
	}

	private int computeFibRecurse(int n) {
		callCounter[n] = callCounter[n] + 1;
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return this.computeFibRecurse(n - 1) + this.computeFibRecurse(n - 2);
		}
	}

	private void printCallCounter() {
		for (int i = 0; i < callCounter.length; i++) {
			System.out.println(callCounter[i] + " calls to fib(" + i + ")");
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting...");
		FibGenerator gen = new FibGenerator();
		for (int s = 1; s <= 20; s++) {
			System.out.println("fib(" + s + ") = " + gen.nthFib(s));
		}
		System.out.println();
		gen.printCallCounter();
		System.out.println("Done.");
	}
}
