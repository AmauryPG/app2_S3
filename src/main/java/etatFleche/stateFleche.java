package etatFleche;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public interface stateFleche {
	
	public abstract void assigner(contextFleche context);
	public void setCouleurFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double x, double y);
}
