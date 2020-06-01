package undoRedo;

import java.util.Vector;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface Commande {
	public void execute(Vector<Node> listeObjet, Pane tableauTravail);
}
