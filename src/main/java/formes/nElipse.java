package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nElipse extends Canvas {
	static Color couleurFill = Color.DODGERBLUE;
    static Color couleurStroke = Color.BLACK;

    static double rayonX= 50;
    static double rayonY = 35;
    
    static double arcWidth = 70;
    static double arcHeight = 70;

    public nElipse() {
        setWidth(rayonX + 4.0f);
        setHeight(rayonY + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRoundRect((double)2, (double)2, rayonX, rayonY, arcWidth, arcHeight);
        gc.strokeRoundRect((double)2, (double)2, rayonX, rayonY, arcWidth, arcHeight); 
    }
}
