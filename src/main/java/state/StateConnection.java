package state;

public class StateConnection implements State {

	public StateConnection() {
		//System.out.println("stateConnection");
	}
	
	@Override
	public boolean DessinerForme() {
		System.out.println("Erreur, vous etes dans le state Connection");
		return false;
		
	}

	@Override
	public boolean Conneter() {
		return true;
		
	}

}
