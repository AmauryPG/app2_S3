package state;



public class StateDessin implements State {
	

	
	public StateDessin() {
		//System.out.println("stateDessin");
	}
	
	@Override
	public boolean DessinerForme() {
		return true;
		
	}

	@Override
	public boolean Conneter() {
		System.out.println("Erreur, vous etes dans le state Dessin");
		return false;
	}

}
