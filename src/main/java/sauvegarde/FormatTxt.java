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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import enums.eshape;
import etatFleche.*; 
import formes.CreationFleche;
import formes.GestionFleche;
import formes.FormeFactory;
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

public class FormatTxt implements StrategySauvegarde {

    private Line curLine;

    private Polygon triangleHead;
    private Polygon triangleBack;
    private Group arrow;  
    private FlecheDouble flecheDouble = new FlecheDouble();
    private FlecheSimple flecheSimple = new FlecheSimple();
    private contextFleche context = new contextFleche();
    
    public FormatTxt(Group arrow, Polygon triangleHead, Polygon triangleBack, Line curLine)
    { 
    	this.arrow = arrow;
    	this.triangleHead = triangleHead;
    	this.triangleBack = triangleBack;
    	this.curLine = curLine;
    }
    
    public void executeSave(Pane tableauTravail)
    {
    	try {
		  JFileChooser chooser = new JFileChooser(".");

	       int returnVal = chooser.showOpenDialog(null);
	       if(returnVal == JFileChooser.APPROVE_OPTION) {
	           System.out.println("You chose to open this file: " +
	              chooser.getSelectedFile().toString());
	           String nameFile = chooser.getSelectedFile().toString();
	           String extensionFile = nameFile.substring(nameFile.lastIndexOf(".") + 1,nameFile.length());
	           
	           // open and read file:
	           try { 
	              if(extensionFile.equals("txt"))
	              { 
	            	  System.out.println(nameFile);
	            	  System.out.println(chooser.getSelectedFile());
	            	  Writer ecrire = new OutputStreamWriter(new FileOutputStream("files/texte.txt"), java.nio.charset.StandardCharsets.UTF_8);

		      			for(int i = 0; i < tableauTravail.getChildren().size(); i++)
		      			{
		      				if(tableauTravail.getChildren().get(i).toString().charAt(0) == 'G')
		      				{
		      					//fleches
		      					Group g = (Group) tableauTravail.getChildren().get(i);  
		      					Line line = (Line) g.getChildren().get(0); 
		      					
		      					if(g.getChildren().size() == 2)
		      					{
		      						//fleche simple
		      						ecrire.write("FlecheSimple");
		      					}
		      					else
		      					{
		      						//fleche double
		      						ecrire.write("FlecheDouble");
		      					}
		      					/*CreationFleche.creation(tableauTravail, context, g, triangleHead, triangleBack, curLine,
		      							line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());*/
		      					ecrire.write(";" + line.getStartX() + ";" + line.getStartY() 
		      							+ ";" + line.getEndX() + ";" + line.getEndY() 
		      							+ ";\n");	
		      					
		      				}
		      				else
		      				{
		      					//formes
		      					ecrire.write(tableauTravail.getChildren().get(i).toString().split("@")[0].substring(1) + ";"
		      							+ tableauTravail.getChildren().get(i).getTranslateX() + ";" + tableauTravail.getChildren().get(i).getTranslateY() + ";\n");				
		      				} 
		      			}
		      		ecrire.close();  
	              }
	           }
	              catch (FileNotFoundException e) {
	                 JOptionPane.showMessageDialog(null, "File not found.");
	              } 
	        }			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void executeOpen(Pane tableauTravail, ArrayList<Canvas> listFormes)
	{
		try {
		  JFileChooser chooser = new JFileChooser(".");
		
		   int returnVal = chooser.showOpenDialog(null);
		   if(returnVal == JFileChooser.APPROVE_OPTION) {
		
		       String nameFile = chooser.getSelectedFile().toString();
		       String extensionFile = nameFile.substring(nameFile.lastIndexOf(".") + 1,nameFile.length());
		       	 
			   Scanner lire = new Scanner(new File(nameFile));
	   			
	   			while(lire.hasNextLine())
	   			{
	   				String[] composante = lire.nextLine().split(";");
	   			 				
	   				if(composante[0].substring(0, 6).equals("Fleche"))
	   				{
	   					//fleche
	   					if(composante[0].substring(6).equals("Simple"))
	   					{
	   						//fleche simple
	   						flecheSimple.assigner(context);
	   					}
	   					else
	   					{
	   						//fleche double
	   						flecheDouble.assigner(context);
	   					}					
	   					CreationFleche.creation(tableauTravail, context, arrow, triangleHead, triangleBack, curLine, 
	   											Double.valueOf(composante[1]), Double.valueOf(composante[2]),
	   											Double.valueOf(composante[3]), Double.valueOf(composante[4]));
	   				}
	   				else
	   				{
	   					//composante 
	   				    Canvas can = FormeFactory.createForme(eshape.valueOf(composante[0])); 
	   				    tableauTravail.getChildren().add(can);
	   				    listFormes.add(can); 
	   				    //on edplace la forme a la bonne place
	   				    can.setTranslateX(Double.valueOf(composante[1]));
	   				    can.setTranslateY(Double.valueOf(composante[2]));
	   				    	
	   				    //la fonction controle les connection entre les elements 
	   				    GestionFleche.gestionFlechesSurComposantes(can, tableauTravail, context, arrow, triangleHead, triangleBack, curLine);
	   				}    	
	   			}	   			
	   			lire.close();  
		   }			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
