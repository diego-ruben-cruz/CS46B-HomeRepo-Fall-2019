package func;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts {
	public double fOfXY(int x, int y) {
		return Math.hypot(x, y);
	}

	public String getName() {
		return "Complex Norm";
	}
}