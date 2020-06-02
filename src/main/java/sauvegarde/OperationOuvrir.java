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
import formes.ShapeFactory;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class OperationOuvrir implements StrategySauvegarde {	
	public void execute(Pane tableauTravail, ArrayList<Canvas> listFormes)
	{
		try {
			Scanner lire = new Scanner(new File("files/texte.txt"));
			
			while(lire.hasNextLine())
			{
				String[] composante = lire.nextLine().split(";");
				
				if(composante[0].charAt(0) == 'F')
				{
					//pour les fleches
					System.out.println("fleche");
				}
				else
				{
					//pour les composantes
				    Canvas can = ShapeFactory.createShape(eshape.valueOf(composante[0].toUpperCase())); 
				    tableauTravail.getChildren().add(can);
				    can.setLayoutX(Double.valueOf(composante[1]));
				    can.setLayoutY(Double.valueOf(composante[2])); 
				    listFormes.add(can); 	
				}
			}
			
			lire.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
