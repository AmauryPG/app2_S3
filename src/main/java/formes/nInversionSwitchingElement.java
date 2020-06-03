package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nInversionSwitchingElement extends Canvas {
	static Color couleurFill = Color.rgb(135,206,235);
    static Color couleurStroke = Color.rgb(0,0,255); 

    static double cote = 40;  

    public nInversionSwitchingElement() {
        setWidth(5 * cote + 4.0f);
        setHeight(5 * cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
  

        //parallelogramme 2
        CreationParallelogramme.creationFill(gc, cote, cote, cote);         
        CreationParallelogramme.creationStroke(gc, cote, cote, cote);         

        //parallelogramme centrale
        CreationParallelogramme.creationFill(gc, cote, 0, cote);         
        CreationParallelogramme.creationStroke(gc, cote, 0, cote);     
    }
}
