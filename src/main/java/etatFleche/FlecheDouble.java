package etatFleche;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class FlecheDouble implements stateFleche {
	
	public void assigner(contextFleche fleche)
	{
		System.out.println("Fleche double");
		fleche.setState(this);
	}
	
	public String toString()
	{
		return "yes yes zone";
	} 

	public void setTypeFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double xDebut, double yDebut)
	{ 
        double xFin = curLine.getStartX();
        double yFin = curLine.getStartY();
        
        //code pour cree la tete de la fleche
    	triangleHead = new Polygon(xDebut - 5, yDebut + 5,
				   xDebut, yDebut, xDebut - 5, yDebut - 5);  
        
        double angle = Math.atan2(yFin - yDebut, xFin - xDebut);
        angle = Math.toDegrees(angle);
		curLine.setStyle("-fx-stroke: black;");
    	triangleHead.setStyle("-fx-stroke: black;");
    	
    	//un deuxieme triangle pour la fleche double
        triangleBack = new Polygon(xFin - 6, yFin + 6,
				   xFin, yFin, xFin - 6, yFin - 6);   
    	
    	//rotation inverse de la tete 
        triangleBack.setRotate(180);
    	triangleBack.setTranslateX(2.5); 
    	triangleHead.setTranslateX(2.5);  
    	
    	arrow.getChildren().addAll(curLine, triangleHead, triangleBack);
	}
}
