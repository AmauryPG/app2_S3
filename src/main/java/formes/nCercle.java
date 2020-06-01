package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nCercle extends Canvas {
	static Color couleurFill = Color.DODGERBLUE;
    static Color couleurStroke = Color.BLACK; 

    static double rayon= 40; 
    
    static double arcWidth = 70;
    static double arcHeight = 70;

    public nCercle() {
        setWidth(rayon + 4.0f);
        setHeight(rayon + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRoundRect((double)2, (double)2, rayon, rayon, arcWidth, arcHeight);
        gc.strokeRoundRect((double)2, (double)2, rayon, rayon, arcWidth, arcHeight);
        gc.setFill(Color.BLACK);
        gc.fillText("source", 6.0, 25.0);
    }
}
