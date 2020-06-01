package etatFleche;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class FlecheRouge implements stateFleche {
	
	public void assigner(contextFleche fleche)
	{
		System.out.println("Fleche rouge");
		fleche.setState(this);
	}
	
	public String toString()
	{
		return "no no zone";
	} 
	
	public void setCouleurFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double x, double y)
	{
    	curLine.setStyle("-fx-stroke: red;");
    	triangleHead.setStyle("-fx-stroke: red;");
    	triangleHead.setFill(Color.RED);
    	
    	triangleBack = new Polygon(x-6, y+6,
        		x,y,x-6,y-6);
    	
    	arrow.getChildren().addAll(curLine, triangleHead, triangleBack);
	}
}
