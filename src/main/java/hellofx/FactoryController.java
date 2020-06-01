package hellofx;
   
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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

import enums.eshape;
import formes.ShapeFactory;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import state.State;
import state.StateConnection;
import state.StateDessin;
import state.StateStart;
import enums.eshape;
import formes.*;
import javafx.scene.shape.*;
import etatFleche.*;


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
  
    //bouton 


    @FXML
    private Button bouton1;
    
    @FXML
    private Button bouton2;
    
    @FXML
    private Button bouton3;
    
    @FXML
    private Button bouton4;
    
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
    private Ellipse formeElipse;

    @FXML
    private Rectangle formeRectangle;

    @FXML
    private Rectangle formeCarre; 
    
    @FXML
    void boutonHandler(ActionEvent event) {
    	System.out.println(event.getSource().toString()); 
    }
    
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

    State stateStart = new StateStart();
    State stateDessin = new StateDessin();
    State stateConnection = new StateConnection();
    
    State state = stateStart;
    private ArrayList<Canvas> listFormes = new ArrayList<Canvas>();
 
    private int nbrAnchor = 0;
    private double [] anchorX = {0,0,0};
    private double [] anchorY = {0,0,0};  
    private Canvas tempCanvas;
    private Line curLine;

    private Polygon triangleHead;
    private Polygon triangleBack;
    private Group arrow;
    
    Vector<Node> removedChildren = new Vector<Node>();
    private contextFleche context = new contextFleche(); 
    
    private Canvas gestionFlechesSurComposantes(Canvas can)
    {
    	//on fait la gestion des fleches
    	can.setOnMouseReleased(new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override 
            public void handle(javafx.scene.input.MouseEvent e) {    
            	if(e.getClickCount() > 1)
            	{
            		anchorX[nbrAnchor] = can.getTranslateY();
                    anchorY[nbrAnchor] = can.getTranslateX();  
                    
                    if(nbrAnchor < 1)
                    {
                 	   nbrAnchor++; 
                 	   tempCanvas = can;
                    }
                    else
                    {
                 	   nbrAnchor = 0;                   	   
                 	   
                 	   //on cree la nouvelle ligne 
                 	   
                 	   //premier forme selectionner
                 	   double [] tempCenterX = {tempCanvas.getTranslateX() + tempCanvas.getWidth()/2, 0, 0};
                 	   double [] tempCenterY = {tempCanvas.getTranslateY() + tempCanvas.getHeight()/2, 0, 0};
                 	   
                 	   //seconde forme selectionner
                 	   double [] centerX = {can.getTranslateX() + can.getWidth()/2, 0, 0};
                 	   double [] centerY = {can.getTranslateY() + can.getHeight()/2, 0, 0};
                 	   
                 	   //pour l'axe des X
                 	   if(tempCenterX[0] < centerX[0])
                 	   {
                 		  tempCenterX[1] = tempCenterX[0] + tempCanvas.getWidth()/2;
                 		  centerX[1] = centerX[0] - can.getWidth()/2;
                  		  tempCenterY[1] = tempCenterY[0];
                  		  centerY[1] = centerY[0];
                 	   }
                 	   else
                 	   {
                 		  tempCenterX[1] = tempCenterX[0] - tempCanvas.getWidth()/2;
                 		  centerX[1] = centerX[0] + can.getWidth()/2;
                  		  tempCenterY[1] = tempCenterY[0];
                  		  centerY[1] = centerY[0];
                 	   }
                 	    
                 	   //pour l'axe des Y
                 	   if(tempCenterY[0] < centerY[0])
                 	   {
                 		  tempCenterY[2] = tempCenterY[0] + tempCanvas.getHeight()/2;
                 		  centerY[2] = centerY[0] - can.getHeight()/2;
                  		  tempCenterX[2] = tempCenterX[0];
                  		  centerX[2] = centerX[0];
                 	   }
                 	   else
                 	   {
                 		   tempCenterY[2] = tempCenterY[0] - tempCanvas.getHeight()/2;
                 			centerY[2] = centerY[0] + can.getHeight()/2;
                 			tempCenterX[2] = tempCenterX[0];
                		   	centerX[2] = centerX[0];
                 	   }
                 	   
                 	   //on fait pythagore entre les pointes les plus proches
                 	   //des deux formes
					 	double ligne1 = Math.sqrt(Math.pow((tempCenterY[1] - centerY[1]), 2) + Math.pow((tempCenterX[1] - centerX[1]), 2));
					 	double ligne2 = Math.sqrt(Math.pow((tempCenterY[2] - centerY[2]), 2) + Math.pow((tempCenterX[2] - centerX[2]), 2)); 
					 	 
					 	//on choisit quel ligne est la plus courte 
					 	//de deux ligne construit auparavant
					 	 if(ligne1 < ligne2)
					 	 {
					 		centerX[0] = centerX[1];
					 		centerY[0] = centerY[1];
					 		tempCenterY[0] = tempCenterY[1];
					 		tempCenterX[0] = tempCenterX[1];
					 	 }
					 	 else
					 	 {
					 		centerX[0] = centerX[2];
					 		centerY[0] = centerY[2];
					 		tempCenterY[0] = tempCenterY[2];
					 		tempCenterX[0] = tempCenterX[2];
					 	 }
                 	   
					 	 //on dessine la ligne choisit auparavant
                        curLine = new Line(
                     		   tempCenterX[0], tempCenterY[0],
                     		   centerX[0], centerY[0]
                            );  
                                                
                        //Couleur de fleche et style de fleche
                        arrow = new Group();                        
                        context.getState().setTypeFleche(curLine, triangleBack, triangleHead, arrow, centerX[0], centerY[0]);
                        
                        //Affichage de la fleche dans le tableau de travail
                        tableauTravail.getChildren().add(arrow);
                        //on ajoute la ligne au Pane
                        tableauTravail.getChildren().add(curLine); 
                         
                    }    
            	}                              
            } 
         });  
    	return can;
    }  

    
    
    @FXML
    void mouseClickedElipse(MouseEvent event) {
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.ELIPSE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements
		    gestionFlechesSurComposantes(can);
    	}
    	
    }  

    @FXML
    void mouseClickedCarre(MouseEvent event) {
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.CARRE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    gestionFlechesSurComposantes(can);
    	}
    }
    
    @FXML
    void mouseClickedRectangle(MouseEvent event) {
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.RECTANGLE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements
		    gestionFlechesSurComposantes(can);
    	}
    	
    }
    
    @FXML
    void mouseClickedCercle(MouseEvent event) {
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.CERCLE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements
		    gestionFlechesSurComposantes(can);
    	}
    } 
    
    @FXML
    private Button flecheDouble;
    
    @FXML
    void boutonFlecheDoubleClicked(ActionEvent event) {
    	//flecheStyle = "double";
        FlecheDouble fleche = new FlecheDouble();
        fleche.assigner(context);
    	
    }
    

    @FXML
    private Button flecheSimple;
    
    @FXML
    void boutonFlecheSimpleClicked(ActionEvent event) {
    	//flecheStyle = "simple";
        FlecheSimple fleche = new FlecheSimple();
        fleche.assigner(context);
    	
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
 
    
}
