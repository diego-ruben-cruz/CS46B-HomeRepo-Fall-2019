package transport;

public class Vehicle {
	private int nWheels = 0;
	private double xPosition = 0;
	private double yPosition = 0;

	Vehicle(int nWheels) {
		this.nWheels = nWheels;
	}

	public void setPosition(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;

	}

	public double getXPosition() {
		return xPosition;
	}

	public double getYPosition() {
		return yPosition;
	}

	public void changePositionBy(double xDelta, double yDelta) {
		xPosition += xDelta;
		yPosition += yDelta;
	}
}
