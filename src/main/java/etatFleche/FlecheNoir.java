package etatFleche;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class FlecheNoir implements stateFleche {
	
	public void assigner(contextFleche fleche)
	{
		System.out.println("Fleche noir");
		fleche.setState(this);
	}
	
	public String toString()
	{
		return "yes yes zone";
	} 

	public void setCouleurFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double x, double y)
	{
    	curLine.setStyle("-fx-stroke: black;");
    	triangleHead.setStyle("-fx-stroke: black;");
    	
    	triangleBack = new Polygon(x-6, y+6,
        		x,y,x-6,y-6);
    	
    	arrow.getChildren().addAll(curLine, triangleHead, triangleBack);
	}
}
