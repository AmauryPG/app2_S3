package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nAmplificationElement extends Canvas {
	static Color couleurFill = Color.rgb(255,215,0);
    static Color couleurStroke = Color.rgb(255,0,0); 

    static double cote = 40;  

    public nAmplificationElement() {
        setWidth(cote + 4.0f);
        setHeight(cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRect(2, 2, cote, cote);
        gc.strokeRect(2, 2, cote, cote); 
        
        //fait le v
        gc.strokeLine(2, 2, 2 + cote , 2 + cote/2 ); 
        gc.strokeLine(2, 2 + cote, 2 + cote , 2 + cote/2 ); 
    }
}
