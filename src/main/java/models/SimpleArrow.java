package models;



public class SimpleArrow implements ArrowState{
	
	Arrow arrow;
	
	public SimpleArrow(Arrow newArrow) {
		arrow = newArrow;
		System.out.println("state -> simple");
	}
	
	public void afficherType() {
		arrow.setColor("red");
		System.out.println("afficher type");
	}

}
