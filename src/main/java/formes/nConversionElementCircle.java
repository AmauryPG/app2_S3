package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nConversionElementCircle extends Canvas {
	static Color couleurFill = Color.rgb(255,215,0);
    static Color couleurStroke = Color.rgb(255,0,0); 

    static double cote = 40;  
    static double arc = 40;  

    public nConversionElementCircle() {
        setWidth(cote + 4.0f);
        setHeight(cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRoundRect((double)2, (double)2, cote, cote, arc, arc);
        gc.strokeRoundRect((double)2, (double)2, cote, cote, arc, arc); 
    }
}
