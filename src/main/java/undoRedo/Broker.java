package undoRedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javafx.scene.Node;
import javafx.scene.layout.Pane; 

public class Broker { 
	Commande commande;
	
	public void prendreCommande(Commande commande)
	{
		this.commande = commande;
	}	
	
	public void executeCommande(Vector<Node> listeObjet, Pane tableauTravail)
	{
		commande.execute(listeObjet, tableauTravail);
	}
}
