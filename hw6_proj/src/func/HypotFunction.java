package func;

public class HypotFunction implements DoubleFunctionOfTwoInts {
	public double fOfXY(int x, int y) {
		return Math.hypot(x, y);
	}

	public String getName() {
		return "Hypotenuse";
	}
}