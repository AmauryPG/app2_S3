package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nInversionSwitchingElement extends Canvas {
	static Color couleurFill = Color.rgb(135,206,235);
    static Color couleurStroke = Color.rgb(0,0,255); 

    static double cote = 40;  

    public nInversionSwitchingElement() {
        setWidth(3 * cote + 4.0f);
        setHeight(3 * cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
  

        //parallelogramme 1
        CreationParallelogramme.creationFill(gc, cote, cote + cote/3 - 3, 0);         
        CreationParallelogramme.creationStroke(gc, cote, cote + cote/3 - 3, 0); 
        
        //parallelogramme 2
        CreationParallelogramme.creationFill(gc, cote, cote, cote);         
        CreationParallelogramme.creationStroke(gc, cote, cote, cote);   

        //parallelogramme 1
        CreationParallelogramme.creationFill(gc, cote, cote * 2/3 + 3, 2*cote);         
        CreationParallelogramme.creationStroke(gc, cote, cote * 2/3 + 3, 2*cote); 

        //parallelogramme centrale
        CreationParallelogramme.creationFill(gc, cote, 0, cote);         
        CreationParallelogramme.creationStroke(gc, cote, 0, cote);     
    }
}
