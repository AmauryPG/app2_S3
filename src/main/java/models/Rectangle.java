package models;

public class Rectangle extends Shape {
	public Rectangle(int w, int h) {
		super(w, h);
	};
	public double getArea(){
		double result = this.getHeight() * this.getWidth();
		return result;
	};
}
