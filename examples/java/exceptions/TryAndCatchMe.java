import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Vector;
import java.util.EmptyStackException;

public class TryAndCatchMe
{

    public void writeList(Vector<String> vector) 
    {
        PrintWriter out = null;
        try 
        {
            System.out.println("Entering" + " try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < vector.size(); i++)
                out.println("Value at: " + i + " = " + vector.elementAt(i));
        } catch (ArrayIndexOutOfBoundsException e) 
        {
            System.err.println("Caught aioobe: "+e.getMessage());                             
        } catch (IOException e) 
        {
            System.err.println("Caught IOException: " +  e.getMessage());                             
        } finally 
        {
            if (out != null) 
            {
                System.out.println("Closing PrintWriter");
                out.close();
            } 
            else 
            {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public Object pop() 
    {
        Object obj;
        if (size == 0) 
        {
            throw new EmptyStackException();
        }
        obj = objectAt(size - 1);
        setObjectAt(size - 1, null);
        size--;
        return obj;
    }

    public static void main(String[] args) 
    {
        TryAndCatchMe tacm = new TryAndCatchMe();
        Vector <String> vector = new Vector<>();
        int SIZE = 10;
        for (int i = 0; i < SIZE; i++)
        {
            vector.add("count "+i);
        }       
        tacm.writeList(vector);
        Object popper = pop();
        try
        {
            // code
            // We saw this on the code ranch list of gotchas:
            // "Watch for System.exit() in try-catch-finally blocks."
            System.exit();
        } catch (java.lang.Exception e)
        {
             System.out.println("after exit");
        }
    }
}