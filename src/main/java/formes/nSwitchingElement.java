package formes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class nSwitchingElement extends Canvas {
	static Color couleurFill = Color.rgb(255,215,0);
    static Color couleurStroke = Color.rgb(255,0,0); 

    static double coteX = 25;  
    static double coteY = 50;  

    public nSwitchingElement() {
        setWidth(2*coteX + 4.0f);
        setHeight(3*coteY + 4.0f);
        drawEnergySource(super.getGraphicsContext2D());
    }
    public static void drawEnergySource(GraphicsContext gc) {
        gc.setFill(couleurFill);
        gc.setStroke(couleurStroke); 
        
        //rectangle central
        gc.fillRect(2, 2 + coteY, coteX, coteY);  
        gc.strokeRect(2, 2 + coteY, coteX, coteY); 
        
        //rectangle 1
        gc.fillRect(2 + coteX, 2, coteX, coteY);  
        gc.strokeRect(2 + coteX, 2, coteX, coteY); 
        
        //rectangle 2
        gc.fillRect(2 + coteX, 2 + coteY, coteX, coteY);  
        gc.strokeRect(2 + coteX, 2 + coteY, coteX, coteY); 

        //rectangle 3
        gc.fillRect(2 + coteX, 2 + 2*coteY, coteX, coteY);  
        gc.strokeRect(2 + coteX, 2 + 2*coteY, coteX, coteY);  
    }
}
