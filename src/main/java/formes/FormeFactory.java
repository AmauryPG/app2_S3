package formes;
 
import enums.eshape;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas; 
import javafx.scene.input.MouseEvent;

public class FormeFactory {

	/* Necessaire pour methode des canevas */
	static double SceneX;
	static double SceneY;
	static double TranslateX, TranslateY; 
	static private Canvas can;

	public static Canvas createForme(eshape shape)  { 
	 	can = new nPowerSource();
		switch (shape) { 
		case PowerSource:
			can = new nPowerSource();
		break; 
		case AccumulationElement:
			can = new nAccumulationElement();
			break;  
		case ConversionElementSquare:
			can = new nConversionElementSquare();
			break; 
		case ConversionElementCircle:
			can = new nConversionElementCircle();
			break; 
		case CouplingElementSquare:
			can = new nCouplingElementSquare();			
		break; 
		case CouplingElementCircle:
			can = new nCouplingElementCircle();			
		break; 
		case SwitchingElement:
			can = new nSwitchingElement();
			break; 
		case AmplificationElementGauche:
			can = new nAmplificationElementGauche();
			break; 
		case AmplificationElementDroit:
			can = new nAmplificationElementDroit();
			break; 
		case InversionConversionElement:
			can = new nInversionConversionElement();
			break;
		case InversionAccumulationElement:
			can = new nInversionAccumulationElement();
			break;
		case InversionCouplingElement:
			can = new nInversionCouplingElement();
			break;
		case InversionSwitchingElement:
			can = new nInversionSwitchingElement();
			break;
		case InversionAmplificationElementGauche:
			can = new nInversionAmplificationElementGauche();
			break;	
		case InversionAmplificationElementDroit:
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