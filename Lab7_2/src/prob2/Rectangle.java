package prob2;

public final class Rectangle implements Polygon {
	final private double width;
	final private double length;
	
//	@Override
//	public double computePerimeter() {
//		double area =  width * length;
//		return area;
//	}
	public Rectangle(double width, double length) {	
		this.width = width;
		this.length = length;
	}
	
	@Override
	public double getWidth() {
		return width;
	}
	
	@Override
	public double getLength() {
		return length;
	}
}
