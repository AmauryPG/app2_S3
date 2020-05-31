package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nRectangle extends Canvas {
	static Color couleurFill = Color.DODGERBLUE;
    static Color couleurStroke = Color.BLACK; 

    static float radiusXEnergySource = 50.0f;
    static float radiusYEnergySource = 25.0f; 

    public nRectangle() {
        setWidth(radiusXEnergySource + 4.0f);
        setHeight(radiusYEnergySource + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRect(2, 2, radiusXEnergySource, radiusYEnergySource);
        gc.strokeRect(2, 2, radiusXEnergySource, radiusYEnergySource); 
    }
}
