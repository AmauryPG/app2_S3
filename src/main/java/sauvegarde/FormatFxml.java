package sauvegarde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import enums.eshape;
import etatFleche.FlecheDouble;
import etatFleche.FlecheSimple;
import etatFleche.contextFleche;
import formes.CreationFleche;
import formes.FormeFactory;
import formes.GestionFleche;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class FormatFxml implements StrategySauvegarde {
	   private Line curLine;

	    private Polygon triangleHead;
	    private Polygon triangleBack;
	    private Group arrow;  
	    private FlecheDouble flecheDouble = new FlecheDouble();
	    private FlecheSimple flecheSimple = new FlecheSimple();
	    private contextFleche context = new contextFleche();
	    
	    public FormatFxml(Group arrow, Polygon triangleHead, Polygon triangleBack, Line curLine)
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
			  chooser.setDialogTitle("Sauvegarder (format .xfml)");

		       int returnVal = chooser.showOpenDialog(null);
		       if(returnVal == JFileChooser.APPROVE_OPTION) {

		           String nameFile = chooser.getSelectedFile().toString();
		           String extensionFile = nameFile.substring(nameFile.lastIndexOf(".") + 1,nameFile.length());
		           
		           // open and read file:
		           try { 
		              if(extensionFile.equals("fxml"))
		              {  
		            	  Writer ecrire = new OutputStreamWriter(new FileOutputStream(nameFile), java.nio.charset.StandardCharsets.UTF_8);

		      			for(int i =0; i < tableauTravail.getChildren().size(); i++)
		      			{
		      				if(tableauTravail.getChildren().get(i).toString().charAt(0) == 'G')
		      				{
		      					//fleches
		      					Group g = (Group) tableauTravail.getChildren().get(i);  
		      					Line line = (Line) g.getChildren().get(0); 
		      					
		      					if(g.getChildren().size() == 2)
		      					{
		      						//fleche simple
		      						ecrire.write("<Forme class=\"FlecheSimple\"");
		      					}
		      					else
		      					{
		      						//fleche double
		      						ecrire.write("<Forme class=\"FlecheDouble\"");
		      					}
		      					/*CreationFleche.creation(tableauTravail, context, g, triangleHead, triangleBack, curLine,
		      							line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());*/
		      					ecrire.write("CoordonneeDebutX=\"" + line.getStartX() + "\"CoordonneeDebutY=\"" + line.getStartY() 
		      							+ "\"CoordonneeFinX=\"" + line.getEndX() + "\"CoordonneeFinY=\"" + line.getEndY() 
		      							+ "\">\n");	
		      					
		      				}
		      				else
		      				{
		      					//formes
		      					ecrire.write("<Forme class=\"" + tableauTravail.getChildren().get(i).toString().split("@")[0].substring(1) + "\" CoordonneeX=\""
		      							+ tableauTravail.getChildren().get(i).getTranslateX() + "\"CoordonneY=\"" + tableauTravail.getChildren().get(i).getTranslateY() + "\">\n");				
		      				}
		      			}
		      			
		      			ecrire.close();
		              }
		           }
	              catch (FileNotFoundException e) {
	  					e.printStackTrace();
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
			  chooser.setDialogTitle("Ouvrir (format .xfml)");
			
			   int returnVal = chooser.showOpenDialog(null);
			   if(returnVal == JFileChooser.APPROVE_OPTION) {
			
			       String nameFile = chooser.getSelectedFile().toString();
			       String extensionFile = nameFile.substring(nameFile.lastIndexOf(".") + 1,nameFile.length());
			       	 
				   Scanner lire = new Scanner(new File(nameFile)); 
					
					while(lire.hasNextLine())
					{
						String[] composante = lire.nextLine().split("\"");
	 
						if(composante[1].substring(0, 6).equals("Fleche"))
						{
							System.out.println(composante[1] + ";" + composante[3] + ";" + composante[5] + ";" + composante[7]+ ";" + composante[9]);	
							//fleche
							if(composante[1].substring(6).equals("Simple"))
							{
								//fleche simple
								flecheSimple.assigner(context);
							}
							else
							{
								//fleche double
								flecheDouble.assigner(context);
							}					
							//on cree la fleche
							CreationFleche.creation(tableauTravail, context, arrow, triangleHead, triangleBack, curLine, 
													Double.valueOf(composante[3]), Double.valueOf(composante[5]),
													Double.valueOf(composante[7]), Double.valueOf(composante[9]));
						}
						else
						{
							//composante 
						    Canvas can = FormeFactory.createForme(eshape.valueOf(composante[1])); 
						    tableauTravail.getChildren().add(can);
						    listFormes.add(can); 
						    //on edplace la forme a la bonne place
						    can.setTranslateX(Double.valueOf(composante[3]));
						    can.setTranslateY(Double.valueOf(composante[5]));
						    	
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
