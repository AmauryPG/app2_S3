package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nInversionAccumulationElement extends Canvas {
	static Color couleurFill = Color.rgb(135,206,235);
    static Color couleurStroke = Color.rgb(0,0,255); 

    static double cote = 40;  

    public nInversionAccumulationElement() {
        setWidth(1.25 * cote + 4.0f);
        setHeight(1.25 * cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 

        CreationParallelogramme.creationFill(gc, cote, 0, 0);
        CreationParallelogramme.creationStroke(gc, cote, 0, 0); 
        
        gc.strokeLine(cote * 0.25 + 2, 2, cote, cote);
    }

}
