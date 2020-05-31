package models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class Arrow {
	
	ArrowState noArrow;
	ArrowState simpleArrow;
	ArrowState doubleArrow;
	
	ArrowState state;
	
	Line line;
	Polygon head;
	
	public Arrow(Line newLine, Polygon newHead) {
		
		line = newLine;
		head = newHead;
		System.out.println("Arrow creee");
		//noArrow = new NoArrow();
		if(simpleArrow == null) {
			simpleArrow = new SimpleArrow(this);
		}
		if(doubleArrow == null) {
			doubleArrow = new DoubleArrow(this);
		}
		
		state = doubleArrow;
	}
	
	public void setState(String newState) {
		if(newState == "simple") {
			state = simpleArrow;
			System.out.println("setState -> *" + state.toString());
		}
		else if(newState == "double") {
			state = doubleArrow;
			System.out.println("setState -> *" + state.toString());
		}
	}
	
	public ArrowState getState() {
		return state;
	}
	
	public void afficherType() {
		state.afficherType();
	}
	
	void setColor(String color) {
		if(color == "red") {
			line.setStyle("-fx-stroke: red;");
			head.setStyle("-fx-stroke: red;");
		}
		
		else if(color == "black") {
			line.setStyle("-fx-stroke: black;");
			head.setStyle("-fx-stroke: black;");
		}
		else {
			System.out.println("Couleur invalide");
		}
			
	}
	
}
