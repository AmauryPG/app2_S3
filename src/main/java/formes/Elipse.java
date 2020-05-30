package formes;

public class Elipse extends Formes {
	protected float rayonX;
	protected float rayonY;
	
	public Elipse(float nouveauDimensionX, float nouveauDimensionY)
	{
		if(nouveauDimensionY > 0 && nouveauDimensionX > 0)
		{
			rayonX = nouveauDimensionY;
			rayonY = nouveauDimensionX;
		}
	}

	public Elipse(float nouveauDimensionX, float nouveauDimensionY, float nouveauX, float nouveauY)
	{
		if(nouveauDimensionY > 0 && nouveauDimensionX > 0 && nouveauX >= 0 && nouveauY >= 0)
		{
			rayonX = nouveauDimensionY;
			rayonY = nouveauDimensionX;
			x = nouveauX;
			y = nouveauY;
		}
	}
	
	public Elipse()
	{
		rayonX = 1;
		rayonY = 1;
		x = 0;
		y = 0;
	} 
	
	//fonction 
	public float getRayonX()
	{
		return rayonX;
	}
	
	public void setRayonX(float nouveauDimensionX)
	{
		if(nouveauDimensionX > 0)
		{
			rayonX = nouveauDimensionX;
		}
	}
	

	public float getRayonY()
	{
		return rayonY;
	}
	
	public void setRayonY(float nouveauDimensionY)
	{
		if(nouveauDimensionY > 0)
		{
			rayonY = nouveauDimensionY;
		}
	}
	
	public void setRayon(float nouveauDimensionX, float nouveauDimensionY)
	{
		if(nouveauDimensionY > 0 && nouveauDimensionX > 0)
		{
			rayonY = nouveauDimensionY;
			rayonX = nouveauDimensionX;
		}
	}
}
