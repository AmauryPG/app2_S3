package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nInversionCouplingElement extends Canvas {
	static Color couleurFill = Color.rgb(135,206,235);
    static Color couleurStroke = Color.rgb(0,0,255); 

    static double cote = 40;  

    public nInversionCouplingElement() {
        setWidth(5 * cote + 4.0f);
        setHeight(5 * cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 

        CreationParallelogramme.creationFill(gc, cote, 0, 0);
        CreationParallelogramme.creationFill(gc, cote, cote * 2/3, cote * 2/3);
        
        CreationParallelogramme.creationStroke(gc, cote, 0, 0);        
        CreationParallelogramme.creationStroke(gc, cote, cote * 2/3, cote * 2/3);
    }
}
