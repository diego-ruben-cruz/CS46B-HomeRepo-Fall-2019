package func;

public class Complex {
	private double real;
	private double imaginary;

	// Constructs an instance, given its real and imaginary components.
	public Complex(double real, double imaginary) {

		this.real = real;
		this.imaginary = imaginary;

	}

	// Constructs an instance that duplicates source.
	// Complete this constructor, then remove this comment line.
	public Complex(Complex source) {
		this.real = source.getReal();
		this.imaginary = source.getImaginary();
	}

	// Getter method.
	public double getReal() {
		return this.real;

	}

	// Getter method.
	public double getImaginary() {
		return this.imaginary;
	}

	//
	// Constructs and returns a new instance of Complex that represents the sum of
	// its inputs,
	// according to the following formula:
	//
	// (a+bi) plus (c+di) = (a+c) + (b+d)i
	//
	//
	public static Complex add(Complex c1, Complex c2) {
		return new Complex(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
	}

	//
	// Constructs and returns a new instance of Complex that represents the product
	// of its inputs,
	// according to the following formula:
	//
	// (a+bi) times (c+di) = a*c + a*di + bi*c + bi*di = ac + (ad+bc)i + bd*ii
	// Since ii is -1 by definition, the last term is -bd ==> the result is ac-bd +
	// (ad+bc)i
	//
	//
	public static Complex multiply(Complex c1, Complex c2) {
		double ac = c1.getReal() * c2.getReal();
		double bd = c1.getImaginary() * c2.getImaginary();
		double ad = c1.getReal() * c2.getImaginary();
		double bc = c2.getReal() * c1.getImaginary();
		return new Complex(ac - bd, ad + bc);

	}

	//
	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	//
	public double norm() {
		return Math.hypot(real, imaginary);
	}
}
