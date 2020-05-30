package models;

public class ShapeFactory {
	public enum eShape{CIRCLE, RECTANGLE};
	
	public Shape GetShape(eShape shape, int w, int h) {
		Shape result = null;
		switch(shape) {
			case CIRCLE:
				result = new Circle(w, h);
				break;
			case RECTANGLE:
				result = new Rectangle(w, h);
				break;
			default:
				result = new Rectangle(0,0);
		}
		return result;
	};
}
