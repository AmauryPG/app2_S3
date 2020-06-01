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

	public void setTypeFleche(Line curLine, Polygon triangleBack, Polygon triangleHead, Group arrow, double xdebut, double ydebut)
	{ 
        //code pour cree la tete de la fleche
        triangleHead = new Polygon(xdebut - 5, ydebut + 5,
        						   xdebut, ydebut, xdebut - 5, ydebut - 5);
        
    	curLine.setStroke(Color.RED);
    	triangleHead.setFill(Color.RED);

        //on ajoute le triangle et la fleche dans un group 
        arrow.getChildren().addAll(curLine, triangleHead);
	}
}
