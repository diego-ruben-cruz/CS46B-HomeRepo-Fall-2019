package func;

public class MyCreativeFunction implements DoubleFunctionOfTwoInts {

	public double fOfXY(int x, int y) {
		if (y != 0) {
			double xSquared = Math.pow(x, 2);
			double ySquared = Math.pow(y, 2);
			return xSquared % ySquared;
		} else {
			y = 1;
			double xSquared = Math.pow(x, 2);
			double ySquared = Math.pow(y, 2);
			return xSquared % ySquared;
		}
	}

	public String getName() {
		return "Squared Modulus";
	}
}