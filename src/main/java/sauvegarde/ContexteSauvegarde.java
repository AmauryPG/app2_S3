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
	
	public void setStragtegy(StrategySauvegarde strategy)
	{
		this.strategy = strategy;
	}
	
	public void executeSave(Pane tableauTravail)
	{ 
		strategy.executeSave(tableauTravail);
	}

	public void executeOpen(Pane tableauTravail, ArrayList<Canvas> listFormes)
	{ 
		strategy.executeOpen(tableauTravail, listFormes);
	}
}
