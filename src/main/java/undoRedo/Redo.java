package undoRedo;
 
import javafx.scene.layout.Pane;

import java.util.Vector;
import javafx.scene.Node; 

public class Redo implements Commande { 
	
	public Redo()
	{
		
	}

	public void execute(Vector<Node> listeObjet, Pane tableauTravail)
	{		
    	if(listeObjet.size() == 0) {
    		System.out.println("Erreur, il n'y a plus rien a redo");
    	}
    	else 
    	{
    		tableauTravail.getChildren().add(listeObjet.get(listeObjet.size()-1));
    		listeObjet.remove(listeObjet.size()-1);	
    	}
	}
}
