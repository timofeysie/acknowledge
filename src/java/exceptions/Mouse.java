import java.io.File;
import java.io.RandomAccessFile;

public class Mouse
{
    public static void cat(File file) 
    {
        RandomAccessFile input = null;
        String line = null;
        try 
        {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) 
            {
                System.out.println(line);
            }
            return;
        } finally 
        {
            if (input != null) 
            {
                try
                {
                    input.close();
                } catch (java.io.IOException ioe)
                {

                }
            }
        } catch (java.io.FileNotFoundException fnfe)
        {

        } catch (java.io.IOException ioe)
        {

        }
    }
}