import java.awt.Point;

public class RelatableCircle implements Relatable
{
	
	public double radius = 0;
    public Point origin;

    // four constructors
    public RelatableCircle() 
    {
        origin = new Point(0, 0);
    }
    public RelatableCircle(Point p) 
    {
        origin = p;
    }

    public RelatableCircle(double r) 
    {
        radius = r;
    }


    public RelatableCircle(Point p, double r) 
    {
        origin = p;
        radius = r;
    }

    // a method for moving the rectangle
    public void move(int x, int y) 
    {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() 
    {
        return radius * radius * Math.PI;
    }
    
    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Relatable other) 
    {
        RelatableCircle otherRelatableCircle 
            = (RelatableCircle)other;
        if (this.getArea() < otherRelatableCircle.getArea())
            return -1;
        else if (this.getArea() > otherRelatableCircle.getArea())
            return 1;
        else
            return 0;               
    }	

    public void moveCircle(Circle circle, int deltaX, int deltaY) 
    {
    	// code to move origin of circle to x+deltaX, y+deltaY
    	circle.setX(circle.getX() + deltaX);
    	circle.setY(circle.getY() + deltaY);
	    // code to assign a new reference to circle
	    circle = new Circle(0, 0);
	}

	public static void main(String[] args) 
	{
		RelatableCircle myCirlce = new RelatableCircle(5,5,5);
		moveCircle(myCircle, 23, 56);
		System.out.println(myCircle.toString());
	}

}