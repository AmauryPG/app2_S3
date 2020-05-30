package models;

public class Circle extends Shape {
	private int radius;

	public Circle(int w, int h) {
		super(w, h);
		radius = this.getWidth() / 2;
	};

	public double getArea() {
		double result = 3.1416 * radius * radius;
		return result;
	};
}
