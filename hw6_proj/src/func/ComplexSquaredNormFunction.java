package func;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts {
	public double fOfXY(int x, int y) {
		double xSquared = Math.pow(x, 2);
		double ySquared = Math.pow(y, 2);
		return xSquared + ySquared;
	}

	public String getName() {
		return "Complex Squared Norm";
	}
}