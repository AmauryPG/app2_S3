package formes;

import javafx.scene.shape.*;

public class Formes extends Shape {

	protected float x;
	protected float y;
	
	public Formes(float x, float y)
	{ 
		if(x >= 0 && y >= 0)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public Formes()
	{ 
		x = 0;
		y = 0; 
	}
	
	//fonction get et set de la fonction vituelle
	public float getX()
	{
		return x;
	}
	
	public void setX(float nouveauX)
	{
		if(nouveauX >= 0)
		{
			x = nouveauX;
		}
	}
	
	public float getY()
	{
		return y;
	}
	
	public void setY(float nouveauY)
	{
		if(nouveauY >= 0)
		{
			y = nouveauY;
		}
	}
	
	public void setPosition(float nouveauX, float nouveauY)
	{
		if(nouveauX >= 0 && nouveauY >= 0)
		{
			x = nouveauX;
			y = nouveauY;
		}
	}
}
