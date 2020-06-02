package sauvegarde;
 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line; 

public class OperationSauvegarder implements StrategySauvegarde{
	public void execute(Pane tableauTravail, ArrayList<Canvas> listFormes)
	{ 
		try {
			Writer ecrire = new OutputStreamWriter(new FileOutputStream("files/texte.txt"), java.nio.charset.StandardCharsets.UTF_8);

			for(int i = 0;i < tableauTravail.getChildren().size();i++)
			{ 
				if(tableauTravail.getChildren().get(i).getClass().toString().equals("class javafx.scene.Group"))
				{
					//fleche
					Group g = (Group)tableauTravail.getChildren().get(i);

					Line line = (Line)g.getChildren().get(0);
					//get la line					
					
					if(g.getChildren().size() > 2)
					{
						//la fleche est double
						ecrire.write("FlecheDouble;");						
					}
					else
					{
						//la fleche est simple
						ecrire.write("FlecheSimple;");
					}
					ecrire.write(line.getEndX() + ";" + line.getEndY() + ";" + line.getStartX() + ";" + line.getStartY() + ";\n");
				}
				else
				{
					//composantes					
					ecrire.write(tableauTravail.getChildren().get(i).getClass().toString().substring(14) + ";" + 
					tableauTravail.getChildren().get(i).getTranslateX() + ";" + tableauTravail.getChildren().get(i).getTranslateY() + ";;;\n");	
				}
			}
			
			ecrire.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
