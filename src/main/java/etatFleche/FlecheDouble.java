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
	 

	public void setTypeFleche(Line curLine, Polygon triangleHead2, Polygon triangleHead, Group arrow, double xFin, double yFin)
	{ 
		curLine.setTranslateY(5);
		
		
        double xDebut = curLine.getStartX();
        double yDebut = curLine.getStartY();
        
        Line curLine2 = new Line(xDebut, yDebut-5, xFin, yFin-5);
        
        //code pour cree la tete de la fleche
    	triangleHead = new Polygon(xFin - 5, yFin + 5,
				   xFin, yFin, xFin - 5, yFin - 5);  
        
    	double angle1 = Math.atan2(yFin - yDebut, xFin - xDebut);
        angle1 = Math.toDegrees(angle1);
		curLine.setStyle("-fx-stroke: black;");
    	triangleHead.setStyle("-fx-stroke: black;");
    	triangleHead.setRotate(angle1);
    	triangleHead.setTranslateY(5);
    	
    	//un deuxieme triangle pour la fleche double
        triangleHead2 = new Polygon(xDebut - 5, yDebut + 5,
				   xDebut, yDebut, xDebut - 5, yDebut - 5);
        
        double angle2 = Math.atan2(curLine2.getEndY()-curLine2.getStartY(), curLine2.getEndX()-curLine2.getScaleX());
        angle2 = Math.toDegrees(angle2);
		curLine2.setStyle("-fx-stroke: black;");
    	triangleHead2.setStyle("-fx-stroke: black;");
    	triangleHead2.setRotate(angle1-180);
    	triangleHead2.setTranslateY(-5);
    	//rotation inverse de la tete 
        
    	triangleHead2.setTranslateX(2.5); 
    	triangleHead.setTranslateX(2.5);
    	
    	arrow.getChildren().addAll(curLine, triangleHead, curLine2, triangleHead2);
	}
}
