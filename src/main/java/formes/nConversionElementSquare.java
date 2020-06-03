package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nConversionElementSquare extends Canvas {
	static Color couleurFill = Color.rgb(255,215,0);
    static Color couleurStroke = Color.rgb(255,0,0); 

    static double cote = 40;  

    public nConversionElementSquare() {
        setWidth(cote + 4.0f);
        setHeight(cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRect((double)2, (double)2, cote, cote);
        gc.strokeRect((double)2, (double)2, cote, cote); 
    }
}
