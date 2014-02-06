package generics;

public class NaturalNumber<T extends Integer> 
{

    private T n;

    public NaturalNumber(T n)  { this.n = n; }

    public boolean isEven() 
    {
    	// invokes the intValue method defined in the Integer class
    	// through n.
        return n.intValue() % 2 == 0; 
    }

    // ...

    public static void main(String[] args) 
    {
    	NaturalNumber <Integer>nn1 = new NaturalNumber<>(6);
    	NaturalNumber <Integer>nn2 = new NaturalNumber<>(7);
    	System.out.println("6 is natural? "+nn1.isEven());	
    	System.out.println("7 is natural? "+nn2.isEven());	
    }
}