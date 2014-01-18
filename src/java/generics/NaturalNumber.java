packacge generics;

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
}