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
	 	can = new nPowerSource();
		switch (shape) { 
		case POWER_SOURCE:
			can = new nPowerSource();
		break; 
		case ACCUMULATION_ELEMENT_DROIT:
			can = new nAccumulationElement();
			break;  
		case CONVERSION_ELEMENT_SQUARE:
			can = new nConversionElementSquare();
			break; 
		case CONVERSION_ELEMENT_CIRCLE:
			can = new nConversionElementCircle();
			break; 
		case COUPLING_ELEMENT_SQUARE:
			can = new nCouplingElementSquare();			
		break; 
		case COUPLING_ELEMENT_CIRCLE:
			can = new nCouplingElementCircle();			
		break; 
		case SWITCHING_ELEMENT:
			can = new nSwitchingElement();
			break; 
		case AMPLIFICATION_ELEMENT_GAUCHE:
			can = new nAmplificationElementGauche();
			break; 
		case AMPLIFICATION_ELEMENT_DROIT:
			can = new nAmplificationElementDroit();
			break; 
		case INVERSION_CONVERSION_ELEMENT:
			can = new nInversionConversionElement();
			break;
		case INVERSION_ACCUMULATION_ELEMENT:
			can = new nInversionAccumulationElement();
			break;
		case INVERSION_COUPLING_ELEMENT:
			can = new nInversionCouplingElement();
			break;
		case INVERSION_SWITCHING_ELEMENT:
			can = new nInversionSwitchingElement();
			break;
		case INVERSION_AMPLIFICATION_ELEMENT_GAUCHE:
			can = new nInversionAmplificationElementGauche();
			break;	
		case INVERSION_AMPLIFICATION_ELEMENT_DROIT:
			can = new nInversionAmplificationElementDroit();
			break;	 
		default:
			System.out.println("ERREUR : CREATION DE FORMES");
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