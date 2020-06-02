package formes;
 
import enums.eshape;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas; 
import javafx.scene.input.MouseEvent;

public class ShapeFactory {

	/* Necessaire pour methode des canevas */
	static double SceneX;
	static double SceneY;
	static double TranslateX, TranslateY; 
	static private Canvas can;

	public static Canvas createShape(eshape shape)  { 
	 	can = new nRectangle();
		switch (shape) { 
		case RECTANGLE:
			can = new nRectangle(); 
			break; 
		case CARRE:
			can = new nCarre();
			break; 
		case ELIPSE:
			can = new nElipse();
			break; 
		case CERCLE:
			can = new nCercle();
			break; 
		default:
			System.out.println("Le code est tout croche pis y bug");
			break;
		}
		can.setOnMousePressed(canvasOnMousePressed);
		can.setOnMouseDragged(canvasOnMouseDragged);  
		 
		return can;
	}

//	private static void drawEnergyAccumulation(GraphicsContext gc) {
//
//		
//	}

	static EventHandler<MouseEvent> canvasOnMousePressed = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			SceneX = mouseEvent.getSceneX();
			SceneY = mouseEvent.getSceneY();
			TranslateX = ((Canvas) (mouseEvent.getSource())).getTranslateX();
			TranslateY = ((Canvas) (mouseEvent.getSource())).getTranslateY();
		} 
	};

	static EventHandler<MouseEvent> canvasOnMouseDragged = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			double offsetX = mouseEvent.getSceneX() - SceneX;
			double offsetY = mouseEvent.getSceneY() - SceneY;
			double newTranslateX = TranslateX + offsetX;
			double newTranslateY = TranslateY + offsetY;

			((Canvas) (mouseEvent.getSource())).setTranslateX(newTranslateX); // transform the object
			((Canvas) (mouseEvent.getSource())).setTranslateY(newTranslateY); 
		}
	};
}