package state;

public class StateStart implements State{

	public StateStart() {
		//System.out.println("stateStart");
	}
	
	@Override
	public boolean DessinerForme() {
		System.out.println("Erreur, vous devez choisir un mode");
		return false;
		
	}

	@Override
	public boolean Conneter() {
		System.out.println("Erreur, vous devez choisir un mode");
		return false;
		
	}

}
