package formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color; 

public class CreationParallelogramme { 

	private static void coordonne(double[] xPoints, double[] yPoints, double cote, double translationX, double translationY)
	{
		xPoints[0] = 2 + cote * 0.25 + translationX;
		yPoints[0] = 2 + translationY;

		xPoints[1] = 2 + 1.25 * cote + translationX;
		yPoints[1] = 2 + translationY;

		xPoints[2] = 2 + cote + translationX;
		yPoints[2] = 2 + cote + translationY;

		xPoints[3] = 2 + translationX;
		yPoints[3] = 2 + cote + translationY;
		 
	}
	
	public static void creationFill(GraphicsContext gc, double cote, double translationX, double translationY)
	{
		double [] xPoints = {0,0,0,0};
		double [] yPoints = {0,0,0,0};
		
		coordonne(xPoints, yPoints, cote, translationX, translationY);
        
		gc.fillPolygon(xPoints, yPoints, 4); 
	}

	public static void creationStroke(GraphicsContext gc, double cote, double translationX, double translationY)
	{
		double [] xPoints = {0,0,0,0};
		double [] yPoints = {0,0,0,0};
		
		coordonne(xPoints, yPoints, cote, translationX, translationY);
         
		gc.strokePolygon(xPoints, yPoints, 4);
	}
}
