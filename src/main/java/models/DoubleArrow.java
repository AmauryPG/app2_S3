package models;


public class DoubleArrow implements ArrowState{

	Arrow arrow;
	
	public DoubleArrow(Arrow newArrow) {
		arrow = newArrow;
	}
	
	public void afficherType() {
		arrow.setColor("black");
		System.out.println("state -> double");
	}

}
