package hellofx;
  
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
<<<<<<< pro0
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
=======
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
>>>>>>> code fleche

import java.net.URL;
import java.util.ResourceBundle;

<<<<<<< pro0
import com.sun.prism.paint.Color;

import formes.Rectangle;
import formes.Elipse;
import formes.Formes;
import javafx.scene.shape.*;
=======
>>>>>>> code fleche

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
    /*@FXML
    private Label labelMode;*/
    @FXML
    private Label textLabel;
    
    //Menu des tiltedPane sur la gauche de la fenetre
    @FXML
    private TitledPane tiltedPaneEnergy;
    @FXML
    private TitledPane titledPaneInversion;
    @FXML
    private TitledPane titledPaneStrategy;
    @FXML
    private TitledPane titledPaneEstimator;
    
    
    @FXML
    private Pane drawingPane;
    
    //change de travail principal
    @FXML
    private ScrollPane tableauTravail;
    
   
    
    @FXML
    void initialize() {
    	
    }
    
    @FXML
    private Button boutonAjouter;

    @FXML
    void boutonAjouterClicked(ActionEvent event) {
    	textLabel.setText("Mode de l'utilisateur : Bouton Ajouter");
    	
    }
    
    @FXML
    private Button boutonAgrandir;
    
    @FXML
    void boutonAgrandirClicked(ActionEvent event) {
    	textLabel.setText("Mode de l'utilisateur : Bouton Agrandir");
    }
    
    private Circle tempCercle;
    
    @FXML
<<<<<<< pro0
    void formeDragDetected(MouseEvent event) {
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

    @FXML
    void paneDrageDropped(DragEvent event) {  
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
=======
    private Button boutonDessin;
    
    @FXML
    void boutonDessinClicked(ActionEvent event) {
    	textLabel.setText("Mode de l'utilisateur : Dessin");
    
    }
    
    @FXML
    private Button boutonConnection;
    
    @FXML
    void boutonConnectionClicked(ActionEvent event) {
    	textLabel.setText("Mode de l'utilisateur : Connection");
    }
    
    @FXML
    private MenuItem menuItemAbout;
    
    @FXML
    void menuItemAboutClicked(ActionEvent event) {
    	textLabel.setText("Mode de l'utilisateur : menu More.../About");
    }

    @FXML
    private MenuItem menuItemClose;
    
    @FXML
    void menuItemCloseClicked(ActionEvent event) {
    	//Permet de quitter l'application
    	Platform.exit();
    }
>>>>>>> code fleche

    @FXML
    private MenuItem menuItemDelete;
    
    
    @FXML
    void menuItemDeleteClicked(ActionEvent event) {
    	textLabel.setText("Mode de l'utilisateur : menu Edit/Delete");
    }
    
/*************** Ligne/Fleche ***************/
    
    private Line curLine;
    private String flecheStyle;
    
    @FXML
    private Button flecheDouble;
    
    @FXML
    void boutonFlecheDoubleClicked(ActionEvent event) {
    	flecheStyle = "double";
    	
    }
    

    @FXML
<<<<<<< pro0
    void paneDrageOver(DragEvent  event) {
        /* data is dragged over the target */
        System.out.println("onDragOver");
        
        tempCercle.setCenterX(event.getX());
        tempCercle.setCenterY(event.getY());
                
         
        /* accept it only if it is  not dragged from the same node 
         * and if it has a string data */ 
            /* allow for both copying and moving, whatever user chooses */
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE); 
        event.consume();
=======
    private Button flecheSimple;
    
    @FXML
    void boutonFlecheSimpleClicked(ActionEvent event) {
    	flecheStyle = "simple";
>>>>>>> code fleche
    }

    @FXML
    void drawingMouseDragged(MouseEvent event) {
    	if (!event.isPrimaryButtonDown()) {
            return;
        }

        if (curLine == null) {
            return;
        }

        curLine.setEndX(event.getX());
        curLine.setEndY(event.getY());
        
        //Sert pour faire augmenter la taille de la fenêtre si la line est trop grande
        double mx = Math.max(curLine.getStartX(), curLine.getEndX());
        double my = Math.max(curLine.getStartY(), curLine.getEndY());

        if (mx > drawingPane.getMinWidth()) {
            drawingPane.setMinWidth(mx);
        }

        if (my > drawingPane.getMinHeight()) {
            drawingPane.setMinHeight(my);
        }
        //System.out.println(curLine.getEndX() + " " + curLine.getEndY());
    }
    
    @FXML
    void drawingMousePressed(MouseEvent event) {
    	
    	if (!event.isPrimaryButtonDown()) {
            return;
        }
        curLine = new Line(
            event.getX(), event.getY(), 
            event.getX(), event.getY()
        );
        
        if(flecheStyle == "double") {
        	curLine.setStyle("-fx-stroke: black;");
        	}
        
        else if(flecheStyle == "simple") {
        	curLine.setStyle("-fx-stroke: red;");
        	}
        
        drawingPane.getChildren().add(curLine);
        /*System.out.println("Mouse Pressed");
        System.out.println(curLine.getEndX() + " " + curLine.getEndY());*/
    }
<<<<<<< pro0
    
/*************** Ligne/Fleche ***************/
    
    private Line curLine;
    private String flecheStyle;
    
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
    private Button bouton2;
    
    

    @FXML
    void drawingMouseDragged(MouseEvent event) {
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
        //System.out.println(curLine.getEndX() + " " + curLine.getEndY());
    }
    
    @FXML
    void drawingMousePressed(MouseEvent event) {
    	
    	if (!event.isPrimaryButtonDown()) {
            return;
        }
        curLine = new Line(
            event.getX(), event.getY(), 
            event.getX(), event.getY()
        );
        
        if(flecheStyle == "double") {
        	curLine.setStyle("-fx-stroke: black;");
        	}
        
        else if(flecheStyle == "simple") {
        	curLine.setStyle("-fx-stroke: red;");
        	}
        
        tableauTravail.getChildren().add(curLine);
        /*System.out.println("Mouse Pressed");
        System.out.println(curLine.getEndX() + " " + curLine.getEndY());*/
    }
=======
>>>>>>> code fleche

    @FXML
    void drawingMouseReleased(MouseEvent event) {
    	/*System.out.println("Mouse Released");
    	System.out.println(curLine.getEndX() + " " + curLine.getEndY());*/
    	curLine = null;
    }
    
}
