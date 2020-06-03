package formes;

import etatFleche.contextFleche;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class GestionFleche {
    private static int nbrAnchor = 0;
    private static double [] anchorX = {0,0,0};
    private static double [] anchorY = {0,0,0};  
    private static Canvas tempCanvas;
    
	 public static Canvas gestionFlechesSurComposantes(Canvas can, Pane tableauTravail, contextFleche context, 
				Group arrow, Polygon triangleHead, Polygon triangleBack, Line curLine)
	    {
	    	//on fait la gestion des fleches
	    	can.setOnMouseReleased(new EventHandler<javafx.scene.input.MouseEvent>() { 
	            @Override 
	            public void handle(javafx.scene.input.MouseEvent e) {    
	            	//double click
	            	if(e.getClickCount() > 1)
	            	{
	            		//deux position des canvas
	            		anchorX[nbrAnchor] = can.getTranslateY(); 
	                    anchorY[nbrAnchor] = can.getTranslateX();  
	                    
	                    if(nbrAnchor < 1)
	                    {
	                 	   nbrAnchor++; 
	                 	   tempCanvas = can;
	                    }
	                    else
	                    {
	                 	   nbrAnchor = 0;                   	   
	                 	   
	                 	   //on cree la nouvelle ligne 
	                 	   

	                 	   CreationFleche.creation(tableauTravail, context, arrow, triangleHead, triangleBack, curLine,
	                  			  tempCanvas.getTranslateX() + tempCanvas.getWidth()/2, tempCanvas.getTranslateY() + tempCanvas.getHeight()/2, 
	                  			  can.getTranslateX() + can.getWidth()/2, can.getTranslateY() + can.getHeight()/2, 
	                  			  tempCanvas.getHeight()/2, tempCanvas.getWidth()/2,
	                  			  can.getHeight()/2, can.getWidth()/2);                         
	                    }    
	            	}                              
	            } 
	         });  
	    	return can;
	    }  
}
