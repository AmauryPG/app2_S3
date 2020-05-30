package models;

public abstract class Shape {
	private int width;
	private int height;
	
	public Shape(int w, int h) {
		width = w;
		height = h;
	};
	public int getWidth() {
		return width;
	};
	public void setWidth(int w) {
		width = w;
	};
	public int getHeight() {
		return height;
	};
	public void setHeight(int h) {
		height = h;
	};
	public double getArea() {
		return 0;
	};
}
