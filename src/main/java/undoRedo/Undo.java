package undoRedo;

import java.util.Vector;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Undo implements Commande { 
	
	public Undo()
	{
		
	}
	
	public void execute(Vector<Node> listeObjet, Pane tableauTravail)
	{ 	
    	if(tableauTravail.getChildren().size() == 0) {
    		System.out.println("Erreur, il n'y a plus rien a undo");
    	} 
    	else 
    	{
			listeObjet.add(tableauTravail.getChildren().remove(tableauTravail.getChildren().size()-1));	
    	}
	}
}
