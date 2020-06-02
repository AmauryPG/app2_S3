package sauvegarde;

import java.util.ArrayList;
import java.util.Vector;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class ContexteSauvegarde {
	private StrategySauvegarde strategy;
	
	public ContexteSauvegarde(StrategySauvegarde strategy)
	{ 
		this.strategy = strategy;
	}
	
	public void execute(Pane tableauTravail, ArrayList<Canvas> listFormes)
	{ 
		strategy.execute(tableauTravail, listFormes);
	}
}
