package etatFleche;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class FlecheDouble implements StateFleche {
	
	public void assigner(contextFleche fleche)
	{
		System.out.println("Fleche double");
		fleche.setState(this);
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
		curLine.setStyle("-fx-stroke: black;");
    	triangleHead.setStyle("-fx-stroke: black;");
    	triangleHead.setRotate(angle);
    	
    	//un deuxieme triangle pour la fleche double
        triangleBack = new Polygon(xDebut - 6, yDebut + 6,
				   xDebut, yDebut, xDebut - 6, yDebut - 6);   
    	
    	//rotation inverse de la tete 
        triangleBack.setRotate(angle-180);
    	triangleBack.setTranslateX(2.5); 
    	triangleHead.setTranslateX(2.5);  
    	
    	arrow.getChildren().addAll(curLine, triangleHead, triangleBack);
	}
}
