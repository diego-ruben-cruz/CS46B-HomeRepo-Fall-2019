package func;

public class ModFunction implements DoubleFunctionOfTwoInts {
	public double fOfXY(int x, int y) {
		if (y != 0) {
			return x % y;
		} else {
			y = 1;
			return x % y;
		}
	}

	public String getName() {
		return "Modulus";
	}
}