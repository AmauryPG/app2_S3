package etatFleche;

public class contextFleche {

	private stateFleche state;
	
	public contextFleche()
	{
		state = null;
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
