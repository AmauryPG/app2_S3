package etatFleche;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class FlecheSimple implements stateFleche {
	
	public void assigner(contextFleche fleche)
	{
		System.out.println("Fleche simple");
		fleche.setState(this);
	}
	
	public String toString()
	{
		return "yes yes zone";
	} 

	public void setTypeFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double xFin, double yFin)
	{  
		double xDebut = curLine.getStartX();
        double yDebut = curLine.getStartY();
		
        //code pour cree la tete de la fleche
        triangleHead = new Polygon(xFin - 5, yFin + 5,
        						   xFin, yFin, xFin - 5, yFin - 5);
        
        double angle = Math.atan2(yFin - yDebut, xFin - xDebut);
        angle = Math.toDegrees(angle);
        
    	curLine.setStroke(Color.RED);
    	triangleHead.setFill(Color.RED);
    	triangleHead.setTranslateX(2.5);
    	triangleHead.setRotate(angle);
    	
        //on ajoute le triangle et la fleche dans un group 
        arrow.getChildren().addAll(curLine, triangleHead);
	}
}
