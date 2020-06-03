package etatFleche;

public class contextFleche {

	private stateFleche state;
	
	public contextFleche()
	{
		state = new FlecheSimple();
	}
	
	public void setState(stateFleche state)
	{
		this.state = state;
	}
	
	public stateFleche getState()
	{
		return state;
	}
}
