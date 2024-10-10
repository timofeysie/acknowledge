public class ValueCircle
{
	
	private int x;
	private int y;

	public ValueCircle(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}

	public void setX(int _x)
	{
		this.x = _x;
	}

	public int getX()
	{
		return x;
	}


	public void setY(int _y)
	{
		this.y = _y;
	}

	public int getY()
	{
		return y;
	}

	public String toString()
	{
		//System.out.println("X = "+x+" Y = "+y);
		return "X = "+x+" Y = "+y;
	}

}