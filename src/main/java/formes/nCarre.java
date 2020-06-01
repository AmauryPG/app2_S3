package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nCarre extends Canvas {
	static Color couleurFill = Color.DODGERBLUE;
    static Color couleurStroke = Color.BLACK;

    static float cote = 50.0f; 

    public nCarre() {
        setWidth(cote + 4.0f);
        setHeight(cote + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        gc.fillRect(2, 2, cote, cote);
        gc.strokeRect(2, 2, cote, cote); 
    }
}
