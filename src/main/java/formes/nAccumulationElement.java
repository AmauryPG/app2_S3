package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nAccumulationElement extends Canvas {
	static Color couleurFill = Color.rgb(255,215,0);
    static Color couleurStroke = Color.rgb(255,0,0); 

    static double coteX = 25; 
    static double coteY = 50;  
    
    private double [] PositionX = {coteX /3, coteX*2/3, coteX /3, coteX*2/3};
    private double [] PositionY = {2, 2, coteX/3 + 2, coteX*2/3};

    public nAccumulationElement() {
        setWidth(coteX + 4.0f);
        setHeight(coteY + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRect((double)2, (double)2, coteX, coteY);
        gc.strokeRect((double)2, (double)2, coteX, coteY);
        gc.strokeLine(2, coteY + 2, coteX + 2, 2);
    }
}
