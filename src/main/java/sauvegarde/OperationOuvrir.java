package sauvegarde;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Vector;

import enums.eshape;
import etatFleche.*; 
import formes.CreationFleche;
import formes.GestionFleche;
import formes.ShapeFactory;
import hellofx.FactoryController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class OperationOuvrir implements StrategySauvegarde {

    private Line curLine;

    private Polygon triangleHead;
    private Polygon triangleBack;
    private Group arrow;  
    private FlecheDouble flecheDouble = new FlecheDouble();
    private FlecheSimple flecheSimple = new FlecheSimple();
    private contextFleche context = new contextFleche();
    private FactoryController controller;
    
    public OperationOuvrir(Group arrow, Polygon triangleHead, Polygon triangleBack, Line curLine, FactoryController controller)
    { 
    	this.arrow = arrow;
    	this.triangleHead = triangleHead;
    	this.triangleBack = triangleBack;
    	this.curLine = curLine;
    	this.controller = controller;
    }
    
	public void execute(Pane tableauTravail, ArrayList<Canvas> listFormes)
	{
		try {
			Scanner lire = new Scanner(new File("files/texte.txt"));
			
			while(lire.hasNextLine())
			{
				String[] composante = lire.nextLine().split(";");
			    
			    FlecheDouble flecheDouble = new FlecheDouble();
			    FlecheSimple flecheSimple = new FlecheSimple();
			    contextFleche context = new contextFleche();
				
				if(composante[0].charAt(0) == 'F')
				{ 				     
					//pour les fleches
					System.out.println("fleche");
					if(composante[0].charAt(6) == 'D')
					{ 
						//fleche double 
						flecheDouble.assigner(context); 
					}
					else
					{
						//fleche simple 
						flecheSimple.assigner(context);   
					}   

					CreationFleche.creation(tableauTravail, context, arrow, triangleHead, triangleBack, curLine,
		        			  Double.valueOf(composante[1]), Double.valueOf(composante[2]), 
		        			  Double.valueOf(composante[3]), Double.valueOf(composante[4])); 
					
				}
				else
				{
					//pour les composantes 				    
				    Canvas can = ShapeFactory.createShape(eshape.valueOf(composante[0].toUpperCase())); 
				    can.setTranslateX(Double.valueOf(composante[1]));
				    can.setTranslateY(Double.valueOf(composante[2])); 
				     
				    tableauTravail.getChildren().add(can);
 
				    listFormes.add(can); 	
				    
				  //on fait la gestion des fleches
				    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine, controller); 
				}
			}
			
			lire.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
