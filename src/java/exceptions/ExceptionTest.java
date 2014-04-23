import java.util.logging.Handler;
import java.util.logging.*;
import java.io.IOException;

public class ExceptionTest
{
	public static void main(String[] args) {
		try
		{
			String arg0 = args[0];
			System.out.println("arg 0 "+arg0);
		} catch (Exception ne1) 
		{
			try
			{
				String arg1 = args[1];
				System.out.println("arg 1 "+arg1);
			} catch (Exception ne)
			{
				System.out.println("Finally block 1");
			}

		} finally 
		{
			System.out.println("Finally block 2");
		}
		try
		{
			System.out.println("Second try");
		} finally
		{
			System.out.println("Finally 3");
		}
		try 
		{
    		Handler handler = new FileHandler("OutFile.log");
    		Logger.getLogger("").addHandler(handler);    
		} catch (IOException e) 
		{
    		Logger logger = Logger.getLogger("package.name"); 
    		StackTraceElement elements[] = e.getStackTrace();
    		for (int i = 0, n = elements.length; i < n; i++) 
    		{
        		logger.log(Level.WARNING, elements[i].getMethodName());
    		}
		}
	}
}