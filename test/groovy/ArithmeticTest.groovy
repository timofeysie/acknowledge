import org.junit.Test
import static org.junit.Assert.assertEquals

class ArithmeticTest 
{
    @Test
    void additionIsWorking() 
    {
        assertEquals 4, 2+2
    }

    @Test(expected=ArithmeticException)
    void divideByZero() 
    {
        println 1/0
    }

    /* Groovy 1.5+ and Java 5+ (a requirement for annotations/Junit 4.x). 
    @Test
    void divideByZeroShouldFail() 
    {
        shouldFail(ArithmeticException) 
        {
            println 1/0
        }
    } */

	public static void main(args) 
	{
		
	}

}
