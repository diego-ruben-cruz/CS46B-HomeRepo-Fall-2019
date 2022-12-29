package cast;

public class Primitives {
	public static void dumpMaxValues() {
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
	}

	public static void main(String[] args) {
		Primitives.dumpMaxValues();
		System.out.println();
		// int to long
		long l1 = Long.MAX_VALUE;
		int i1 = (int) l1;
		System.out.println("Long to Int: " + i1 + ", " + l1);
		// int to long 2
		long l2 = Long.MAX_VALUE - 5;
		int i2 = (int) l2;
		System.out.println("Int to Long: " + i2 + ", " + l2);
		// long to int
		int i3 = Integer.MAX_VALUE;
		long l3 = i3;
		System.out.println("Long to Int: " + l3 + ", " + i3);
		// double to byte
		byte b1 = 100;
		double d1 = b1;
		System.out.println("Double to Byte: " + d1 + ", " + b1);
		// byte to double
		double d2 = 45.67;
		byte b2 = (byte) d2;
		System.out.println("Byte to Double: " + b2 + ", " + d2);
		// byte to double 2
		double d3 = 456.789;
		byte b3 = (byte) d3;
		System.out.println("Byte to Double 2: " + b3 + ", " + d3);
		// long to float
		float f1 = 12345.6789f;
		long l4 = (long) f1;
		System.out.println("Long to Float: " + l1 + ", " + f1);
		// long to float 2
		float f2 = Float.MAX_VALUE;
		long l5 = (long) f2;
		System.out.println("Long to Float 2: " + l5 + ", " + f2);
		// float to long
		long l6 = Long.MAX_VALUE;
		float f3 = l5;
		System.out.println("Float to Long: " + f3 + ", " + l6);

	}
}
