package controller;
   
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
import javafx.scene.input.ContextMenuEvent;
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
import sauvegarde.*; 
import state.State;
import state.StateConnection;
import state.StateDessin;
import state.StateStart;

import undoRedo.*;
import enums.eshape;
import formes.*;
import javafx.scene.shape.*;
import etatFleche.*;


public class MainController {
	 
	
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
    private Button flecheDouble;
    
    @FXML
    private Button flecheSimple;
    
    @FXML
    private Button boutonConnect;
    
    @FXML
    private Button boutonDessin;
    
    @FXML
    private Button boutonAgrandir; 

    //menu tool bar
    @FXML
    private MenuItem menuItem1;

    @FXML
    private MenuItem menuItem2; 
    
    @FXML
    private Ellipse formeElipse;

    @FXML
    private Rectangle formeRectangle;

    @FXML
    private Rectangle formeCarre; 
    
    State stateStart = new StateStart();
    State stateDessin = new StateDessin();
    State stateConnection = new StateConnection();
    
    State state = stateStart;
    private ArrayList<Canvas> listFormes = new ArrayList<Canvas>();
 
    private Line curLine;

    private Polygon triangleHead;
    private Polygon triangleBack;
    private Group arrow;
    
    Vector<Node> removedChildren = new Vector<Node>();
    private contextFleche context = new contextFleche(); 
    
    private ContexteSauvegarde contexte;
    
    @FXML
    private MenuItem undo;
    	
    @FXML
    private MenuItem redo;
    
    Redo reDo = new Redo();
    Undo unDo = new Undo();
    Broker broker = new Broker();
   
    @FXML
    void initialize() {
        assert toolBarEditor != null : "fx:id=\"toolBarEditor\" was not injected: check your FXML file 'UI.fxml'."; 
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
    
    public State getState() {
    	return state;
    }
    
    @FXML
    void boutonHandler(ActionEvent event) {
    	System.out.println(event.getSource().toString()); 
    }
    
    
    @FXML
    void mouseClickedAccumulation(MouseEvent event) {
    	System.out.println("mouseClickedAccumulation");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.ACCUMULATION_ELEMENT_DROIT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine, this);
    	}
    }

 

    @FXML
    void mouseClickedAmplification1(MouseEvent event) {
    	System.out.println("mouseClickedAmplification1");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.AMPLIFICATION_ELEMENT_DROIT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine, this);
    	}
    }

 

    @FXML
    void mouseClickedAmplification2(MouseEvent event) {
    	System.out.println("mouseClickedAmplification2");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.AMPLIFICATION_ELEMENT_GAUCHE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine, this);
    	}
    }

 

    @FXML
    void mouseClickedConversionCircle(MouseEvent event) {
    	System.out.println("mouseClickedConversionCircle"); 
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.CONVERSION_ELEMENT_CIRCLE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedConversionSquare(MouseEvent event) {
    	System.out.println("mouseClickedConversionSquare");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.CONVERSION_ELEMENT_SQUARE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedCouplingCircles(MouseEvent event) {
    	System.out.println("mouseClickedCouplingCircles"); 
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.COUPLING_ELEMENT_CIRCLE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine, this);
    	}
    }

 

    @FXML
    void mouseClickedCouplingSquares(MouseEvent event) {
    	System.out.println("mouseClickedCouplingSquares");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.COUPLING_ELEMENT_SQUARE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine, this);
    	}
    }

 

    @FXML
    void mouseClickedEstimAccumulation(MouseEvent event) {
    	System.out.println("mouseClickedEstimAccumulation");
    }

 

    @FXML
    void mouseClickedEstimAmplification1(MouseEvent event) {
    	System.out.println("mouseClickedEstimAmplification1");
    }

 

    @FXML
    void mouseClickedEstimAmplification2(MouseEvent event) {
    	System.out.println("mouseClickedEstimAmplification2");
    }

 

    @FXML
    void mouseClickedEstimCircle(MouseEvent event) {
    	System.out.println("mouseClickedEstimCircle");
    }

 

    @FXML
    void mouseClickedEstimCouplingCircles(ContextMenuEvent event) {
    	System.out.println("mouseClickedEstimCouplingCircles");
    }

 

    @FXML
    void mouseClickedEstimCouplingSquare(MouseEvent event) {
    	System.out.println("mouseClickedEstimCouplingSquare");
    }

 

    @FXML
    void mouseClickedEstimSource(MouseEvent event) {
    	System.out.println("mouseClickedEstimSource");
    }

 

    @FXML
    void mouseClickedEstimSwitching(MouseEvent event) {
    	System.out.println("mouseClickedEstimSwitching");
    }

 

    @FXML
    void mouseClickedInvAccumulation(MouseEvent event) {
    	System.out.println("mouseClickedInvAccumulation");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.INVERSION_ACCUMULATION_ELEMENT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedInvAmplification1(MouseEvent event) {
    	System.out.println("mouseClickedInvAmplification1");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.INVERSION_AMPLIFICATION_ELEMENT_GAUCHE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedInvAmplification2(MouseEvent event) {
    	System.out.println("mouseClickedInvAmplification2");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.INVERSION_AMPLIFICATION_ELEMENT_DROIT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedInvConvertion(MouseEvent event) {
    	System.out.println("mouseClickedInvConvertion");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.INVERSION_CONVERSION_ELEMENT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedInvCoupling(MouseEvent event) {
    	System.out.println("mouseClickedInvCoupling");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.INVERSION_COUPLING_ELEMENT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedInvSwitching(MouseEvent event) {
    	System.out.println("mouseClickedInvSwitching");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.INVERSION_SWITCHING_ELEMENT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedSource(MouseEvent event) {
    	System.out.println("mouseClickedSource");
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.POWER_SOURCE); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }

 

    @FXML
    void mouseClickedStrategy(MouseEvent event) {
    	System.out.println("mouseClickedStrategy");

 

    }

 

    @FXML
    void mouseClickedSwitching(MouseEvent event) {
    	System.out.println("mouseClickedSwitching"); 
    	if(state.DessinerForme() == true) {
		    //on ajoute un canvas dans le pane
		    Canvas can = ShapeFactory.createShape(eshape.SWITCHING_ELEMENT); 
		    tableauTravail.getChildren().add(can);
		    listFormes.add(can); 
		    	
		    //la fonction controle les connection entre les elements 
		    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
    	}
    }
    
    @FXML
    void mouseClickedRectangle(MouseEvent event) {
    	if(state.DessinerForme() == true) { 
    	}
    	
    }
    
    @FXML
    void mouseClickedCercle(MouseEvent event) {
    	if(state.DessinerForme() == true) { 
    	}
    } 
        
    @FXML
    void boutonFlecheDoubleClicked(ActionEvent event) {
    	//flecheStyle = "double";
        FlecheDouble fleche = new FlecheDouble();
        fleche.assigner(context);
    	
    }    
    
    @FXML
    void boutonFlecheSimpleClicked(ActionEvent event) {
    	//flecheStyle = "simple";
        FlecheSimple fleche = new FlecheSimple();
        fleche.assigner(context);    	
    }
    
    //section pour le redo et undo    
    //fonction pour executer le redo ou undo
    private void executionCommande(Broker broker)
    { 
    	broker.executeCommande(removedChildren, tableauTravail);
    }
    
    @FXML
    void redoClicked(ActionEvent event) {
		broker.prendreCommande(reDo);
		executionCommande(broker);
    }

    @FXML
    void undoClicked(ActionEvent event) {
		broker.prendreCommande(unDo);
		executionCommande(broker);	  
    }
    
    //section pour l'etat de la fenetre    
    @FXML
    void boutonConnectClicked(ActionEvent event) {
    	state = stateConnection;
    	labelMode.setText("Connection");    	
    }

    @FXML
    void boutonDessinClicked(ActionEvent event) {
    	state = stateDessin;
    	labelMode.setText("Dessin");
    }

    //section pour sauvegarder et ouvrir des fichiers    
    @FXML
    void sauvegarderClicked(ActionEvent event) {
    	contexte = new ContexteSauvegarde(new OperationSauvegarder());
    	contexte.execute(tableauTravail, listFormes);
    	System.out.println("sauve");
    }

    @FXML
    void ouvrirClicked(ActionEvent event) {
    	contexte = new ContexteSauvegarde(new OperationOuvrir(arrow, triangleHead, triangleBack, curLine, this));
    	
    	contexte.execute(tableauTravail, listFormes);
    	System.out.println("ouvrir");
    }
    
}
