package prob2;

public interface Polygon extends ClosedCurve { //inherit closedcurve so List<> don't have to pick between polygon or closedcurve type
	abstract double getWidth();
	abstract double getLength();
	default double computePerimeter() {
		return (getLength() + getWidth()) * 2;
	}
}
