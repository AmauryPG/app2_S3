package etatFleche;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public interface stateFleche {
	
	public void assigner(contextFleche context);
	public void setTypeFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double xdebut, double ydebut); 
}
