package hellofx;
   
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.scene.shape.*;
import state.State;
import state.StateConnection;
import state.StateDessin;
import state.StateStart;


public class FactoryController {
	
	//code de base --pas touche--
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    //--pas touche--
    
    

    //variable pour le MenuBar
    @FXML
    private Menu menuFile;
    @FXML
    private Menu menuEdit;
    @FXML
    private Menu menuMore;
    
    //label du bas de page
    @FXML
    private Label labelMode;
    
    //Menu des tiltedPane sur la gauche de la fenetre
    @FXML
    private TitledPane tiltedPaneEnergy;
    @FXML
    private TitledPane titledPaneInversion;
    @FXML
    private TitledPane titledPaneStrategy;
    @FXML
    private TitledPane titledPaneEstimator;
    
    //zone de travail principal
    @FXML
    private Pane tableauTravail;
     

    @FXML
    private Circle formeCercle;

    @FXML
    private Button boutonAjouter;
    
    @FXML
    private ToolBar toolBarEditor;
  
    
    @FXML
    void initialize() {
        assert toolBarEditor != null : "fx:id=\"toolBarEditor\" was not injected: check your FXML file 'UI.fxml'.";
        assert formeCercle != null : "fx:id=\"formeCercle\" was not injected: check your FXML file 'UI.fxml'.";
        assert labelMode != null : "fx:id=\"labelMode\" was not injected: check your FXML file 'UI.fxml'.";
        assert boutonAjouter != null : "fx:id=\"boutonAjouter\" was not injected: check your FXML file 'UI.fxml'.";
        assert titledPaneInversion != null : "fx:id=\"titledPaneInversion\" was not injected: check your FXML file 'UI.fxml'.";
        assert titledPaneStrategy != null : "fx:id=\"titledPaneStrategy\" was not injected: check your FXML file 'UI.fxml'.";
        assert menuEdit != null : "fx:id=\"menuEdit\" was not injected: check your FXML file 'UI.fxml'.";
        assert menuFile != null : "fx:id=\"menuFile\" was not injected: check your FXML file 'UI.fxml'.";
        assert titledPaneEstimator != null : "fx:id=\"titledPaneEstimator\" was not injected: check your FXML file 'UI.fxml'.";
        assert tableauTravail != null : "fx:id=\"tableauTravail\" was not injected: check your FXML file 'UI.fxml'.";
        assert tiltedPaneEnergy != null : "fx:id=\"tiltedPaneEnergy\" was not injected: check your FXML file 'UI.fxml'.";
        assert menuMore != null : "fx:id=\"menuMore\" was not injected: check your FXML file 'UI.fxml'.";

    } 
    /*private String stateVariable;
    
    public String getStateVariable() {
    	return stateVariable;
    }
    
    public void setStateVariable(String newStateVar) {
    	stateVariable = newStateVar;
    }*/
    State stateStart = new StateStart();
    State stateDessin = new StateDessin();
    State stateConnection = new StateConnection();
    
    State state = stateStart;
    
    Vector<Node> removedChildren = new Vector<Node>();

    private Circle tempCercle;
    
    @FXML
    void formeDragDetected(MouseEvent event) {
    	
    	if(state.DessinerForme() == true) {
	    	  /* drag was detected, start drag-and-drop gesture*/
	        System.out.println("onDragDetected");
	        
	        /* allow any transfer mode */
	        Dragboard db = formeCercle.startDragAndDrop(TransferMode.ANY);
	        
	        /* put a string on dragboard */
	        ClipboardContent cb = new ClipboardContent();
	        cb.putString("mamaCOCO");
	        db.setContent(cb);
	        
	        tempCercle = new Circle(event.getX(), event.getY(), formeCercle.getRadius());
	        tableauTravail.getChildren().add(tempCercle);
	        
	        event.consume();
    	}
    }

    @FXML
    void paneDrageDropped(DragEvent event) {  
    	if(state.DessinerForme() == true) {
	    	 /* data dropped */
	        System.out.println("onDragDropped"); 
	        /* if there is a string data on dragboard, read it and use it */
	        Dragboard db = event.getDragboard();
	        boolean success = false;
	        if (db.hasString()) { 
	        	System.out.println("true");
	            success = true;
	
	            tempCercle = null;
	            
	            Circle nouveauCercle = new Circle(event.getX(), event.getY(), formeCercle.getRadius());
	            nouveauCercle.setFill(Paint.valueOf("BLUE"));
	            nouveauCercle.setStroke(Paint.valueOf("BLACK"));
	            nouveauCercle.setStrokeType(StrokeType.valueOf("INSIDE"));
	            System.out.println(event.getX() + " " + event.getY() + " " + formeCercle.getRadius());
	
	            tableauTravail.getChildren().add(nouveauCercle);
	           
	        }
	        /* let the source know whether the string was successfully 
	         * transferred and used */
	        event.setDropCompleted(success);
	        
	        event.consume();
    	}
    	
    }

    @FXML
    void paneDrageOver(DragEvent  event) {
    	if(state.DessinerForme() == true) {
	        /* data is dragged over the target */
	        System.out.println("onDragOver");
	        
	        tempCercle.setCenterX(event.getX());
	        tempCercle.setCenterY(event.getY());
	                
	         
	        /* accept it only if it is  not dragged from the same node 
	         * and if it has a string data */ 
	            /* allow for both copying and moving, whatever user chooses */
	        event.acceptTransferModes(TransferMode.COPY_OR_MOVE); 
	        event.consume();
    	}
    }


    @FXML
    void paneDragEntered(DragEvent event) {
    	if(state.DessinerForme() == true) {
	    	 /* the drag-and-drop gesture entered the target */
	        System.out.println("onDragEntered");
	        /* show to the user that it is an actual gesture target */
	        if (event.getGestureSource() != tableauTravail &&
	                event.getDragboard().hasString()) {
	        	System.out.println("dropp succes");
	        }
	        
	        event.consume();
    	}
    }
    
/*************** Fleche ***************/
    
    private Line curLine;
    private Polygon triangleHead;
    private Polygon triangleBack;
    private Group arrow;
    private String flecheStyle = "simple";
    
    
    
      
    @FXML
    void drawingMouseDragged(MouseEvent event) {
    	if(state.Conneter() == true) {
	    	//Code pour la ligne 
	    	
	    	if (!event.isPrimaryButtonDown()) {
	            return;
	        }
	
	        if (curLine == null) {
	            return;
	        }
	
	        curLine.setEndX(event.getX());
	        curLine.setEndY(event.getY());
	        
	        //Sert pour faire augmenter la taille de la fenï¿½tre si la line est trop grande
	        double mx = Math.max(curLine.getStartX(), curLine.getEndX());
	        double my = Math.max(curLine.getStartY(), curLine.getEndY());
	
	        if (mx > tableauTravail.getMinWidth()) {
	        	tableauTravail.setMinWidth(mx);
	        }
	
	        if (my > tableauTravail.getMinHeight()) {
	        	tableauTravail.setMinHeight(my);
	        }
	        
	        //Code pour la tete de la fleche
	        
	        //Rotation de la tete de la fleche en fonction de l'angle entre le fin et le debut de la ligne
	        double angle;
	        angle = Math.atan2(curLine.getEndY()-curLine.getStartY(), curLine.getEndX()-curLine.getStartX());
	        angle = Math.toDegrees(angle);
	        
	        if(flecheStyle == "double") {
	        	//Fleche double
	        	triangleBack.setRotate(angle-180);
	        	triangleBack.setTranslateX(2.5);
	        	}
	        
	        //Translation de la tête de la fleche avec le mouvement de la souris
	        triangleHead.setTranslateX(curLine.getEndX()-curLine.getStartX()+2);
	        triangleHead.setTranslateY(curLine.getEndY()-curLine.getStartY());
	        
	        triangleHead.setRotate(angle);
    	}
        
        
    }
    
    @FXML
    void drawingMousePressed(MouseEvent event) {
    	if(state.Conneter() == true) {
	    	
	    	if (!event.isPrimaryButtonDown()) {
	            return;
	        }
	    	
	    	/* Instanciation de la fleche */
	    	
	        curLine = new Line(
	            event.getX(), event.getY(), 
	            event.getX(), event.getY()
	        );
	        
	        triangleHead = new Polygon(event.getX()-5, event.getY()+5,
	        		event.getX(),event.getY(),event.getX()-5,event.getY()-5);
	    
	        arrow = new Group();
	        
	        /* Couleur de fleche et style de fleche */
	        
	        /* Fleche double */
	        if(flecheStyle == "double") {
	        	
	        	curLine.setStyle("-fx-stroke: black;");
	        	triangleHead.setStyle("-fx-stroke: black;");
	        	
	        	triangleBack = new Polygon(event.getX()-6, event.getY()+6,
	            		event.getX(),event.getY(),event.getX()-6,event.getY()-6);
	        	
	        	arrow.getChildren().addAll(curLine, triangleHead, triangleBack);
	        	
	        	}
	        
	        /* Fleche simple */
	        else if(flecheStyle == "simple") {
	        	curLine.setStyle("-fx-stroke: red;");
	        	triangleHead.setStyle("-fx-stroke: red;");
	        	triangleHead.setFill(Color.RED);
	        	
	        	arrow.getChildren().addAll(curLine, triangleHead);
	        	}

	        /* Affichage de la fleche dans le tableau de travail */
	        
	        tableauTravail.getChildren().add(arrow);

    	}
        
    }

    @FXML
    void drawingMouseReleased(MouseEvent event) {
    	if(state.Conneter() == true) {
	    	curLine = null;
	    	triangleHead = null;
    	}
    }
    

    
    @FXML
    private Button flecheDouble;
    
    @FXML
    void boutonFlecheDoubleClicked(ActionEvent event) {
    	flecheStyle = "double";

    }
    

    @FXML
    private Button flecheSimple;
    
    @FXML
    void boutonFlecheSimpleClicked(ActionEvent event) {
    	flecheStyle = "simple";
    	
    }
    
    @FXML
    private MenuItem undo;
    	
    @FXML
    private MenuItem redo;
    
    
    
    @FXML
    void redoClicked(ActionEvent event) {
    	if(removedChildren.size() == 0) {
    		System.out.println("Erreur, il n'y a plus rien a redo");
    	}
    	else {
    		tableauTravail.getChildren().add(removedChildren.get(removedChildren.size()-1));
    		removedChildren.remove(removedChildren.size()-1);
    	}
    }

    @FXML
    void undoClicked(ActionEvent event) {
    	
    	if(tableauTravail.getChildren().size() == 0) {
    		System.out.println("Erreur, il n'y a plus rien a undo");
    	}
    	else if(state.Conneter() == true) {
    		removedChildren.add(tableauTravail.getChildren().remove(tableauTravail.getChildren().size()-1));
    	}
    	else if(state.DessinerForme() == true) {
    		removedChildren.add(tableauTravail.getChildren().remove(tableauTravail.getChildren().size()-1));	
    	}
    	
    }
    
    @FXML
    private Button boutonConnect;
    
    @FXML
    private Button boutonDessin;
    
    @FXML
    void boutonConnectClicked(ActionEvent event) {
    	state = stateConnection;
    }

    @FXML
    void boutonDessinClicked(ActionEvent event) {
    	state = stateDessin;
    }
    
    @FXML
    private Button bouton5;
    
    @FXML
    private Button bouton6;
    
    @FXML
    private Button bouton7;
    
    @FXML
    private Button bouton8;
    
    @FXML
    private Button bouton9;

    @FXML
    private MenuItem menuItem1;

    @FXML
    private MenuItem menuItem2;
    
    @FXML
    private Button boutonAgrandir;    

    @FXML
    void boutonHandler(ActionEvent event) {
    	System.out.println(event.getSource().toString());
    }
    
}
