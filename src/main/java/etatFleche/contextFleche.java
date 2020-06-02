package etatFleche;

public class contextFleche {

	private StateFleche state;
	
	public contextFleche()
	{
		state = new FlecheSimple();
	}
	
	public void setState(StateFleche state)
	{
		this.state = state;
	}
	
	public StateFleche getState()
	{
		return state;
	}
}
