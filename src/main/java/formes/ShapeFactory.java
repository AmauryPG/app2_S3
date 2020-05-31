package formes;
 
import enums.eshape;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;

public class ShapeFactory {

	/* Necessaire pour methode des canevas */
	static double orgSceneX;
	static double orgSceneY;
	static double orgTranslateX, orgTranslateY;

	public static Canvas createShape(eshape shape)  {

	 	Canvas can = new nRectangle();
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
		can.setOnDragDetected(canvasOnDragDetected); 
		
		return can;
	}

//	private static void drawEnergyAccumulation(GraphicsContext gc) {
//
//		
//	}

	static EventHandler<MouseEvent> canvasOnMousePressed = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			 orgSceneX = mouseEvent.getSceneX();
			orgSceneY = mouseEvent.getSceneY();
			orgTranslateX = ((Canvas) (mouseEvent.getSource())).getTranslateX();
			orgTranslateY = ((Canvas) (mouseEvent.getSource())).getTranslateY();
		}
	};

	static EventHandler<MouseEvent> canvasOnMouseDragged = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			double offsetX = mouseEvent.getSceneX() - orgSceneX;
			double offsetY = mouseEvent.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Canvas) (mouseEvent.getSource())).setTranslateX(newTranslateX); // transform the object
			((Canvas) (mouseEvent.getSource())).setTranslateY(newTranslateY);
		}
	};

	static EventHandler<MouseEvent> canvasOnDragDetected = new EventHandler<MouseEvent>() {
		
		@Override
	    public void handle(MouseEvent event) { 
	    	  /* drag was detected, start drag-and-drop gesture*/
	        System.out.println("onDragDetected"); 
	        event.consume();
	    }
	};	 
}