public class TestValueCircle
{	
    public void moveCircle(ValueCircle circle, int deltaX, int deltaY, int radius) 
    {
    	// code to move origin of circle to x+deltaX, y+deltaY
    	circle.setX(circle.getX() + deltaX);
    	circle.setY(circle.getY() + deltaY);
	    // code to assign a new reference to circle
	    circle = new ValueCircle(0, 0);
	    radius = 10;
	}
	public static void main(String[] args) 
	{
		int rad = 0;
		ValueCircle myCircle = new ValueCircle(5,5);
		TestValueCircle test_circle = new TestValueCircle();
		test_circle.moveCircle(myCircle, 23, 56, 5);
		System.out.println("Is the circle broken? "+myCircle.getX()+" rad = "+rad);
		// rad is still 0, but myCircle has been changed.
	}
}