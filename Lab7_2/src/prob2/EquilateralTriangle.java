package prob2;

public class EquilateralTriangle implements ClosedCurve {
	private double side;
	
	public EquilateralTriangle(double side) {
		this.side = side;
	}
	
	public double getSize() {
		return side;
	}

	@Override
	public double computePerimeter() {
		return getSize() * 3;
	}

}
