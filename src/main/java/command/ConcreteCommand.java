package command;

import javafx.scene.layout.Pane;

public class ConcreteCommand implements Command {

	private Pane pane;
	private int index;
	
	public ConcreteCommand(Pane pane) {
		this.pane = pane;
		index = pane.getChildren().size()-1;
	}
	
	@Override
	public void unDo() {
		pane.getChildren().remove(pane.getChildren().size()-1);
	}

	@Override
	public void reDo() {
		
		
	}

}
