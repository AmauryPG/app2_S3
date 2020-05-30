package formes;

public class Rectangle extends Formes {

	protected float dimensionX;
	protected float dimensionY;
	
	public Rectangle(float nouveauDimensionX, float nouveauDimensionY)
	{
		if(nouveauDimensionY > 0 && nouveauDimensionX > 0)
		{
			dimensionY = nouveauDimensionY;
			dimensionX = nouveauDimensionX;
		}
	}

	public Rectangle(float nouveauDimensionX, float nouveauDimensionY, float nouveauX, float nouveauY)
	{
		if(nouveauDimensionY > 0 && nouveauDimensionX > 0 && nouveauX >= 0 && nouveauY >= 0)
		{
			dimensionY = nouveauDimensionY;
			dimensionX = nouveauDimensionX;
			x = nouveauX;
			y = nouveauY;
		}
	}
	
	public Rectangle()
	{
		dimensionY = 1;
		dimensionX = 1;
		x = 0;
		y = 0;
	} 
	
	//fonction 
	public float getDimensionX()
	{
		return dimensionX;
	}
	
	public void setDimensionX(float nouveauDimensionX)
	{
		if(nouveauDimensionX > 0)
		{
			dimensionX = nouveauDimensionX;
		}
	}
	

	public float getDimensionY()
	{
		return dimensionY;
	}
	
	public void setDimensionY(float nouveauDimensionY)
	{
		if(nouveauDimensionY > 0)
		{
			dimensionY = nouveauDimensionY;
		}
	}
	
	public void setDimension(float nouveauDimensionX, float nouveauDimensionY)
	{
		if(nouveauDimensionY > 0 && nouveauDimensionX > 0)
		{
			dimensionY = nouveauDimensionY;
			dimensionX = nouveauDimensionX;
		}
	}
}
