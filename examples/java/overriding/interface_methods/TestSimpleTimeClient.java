package overriding.interface_methods;
 
import java.time.*;
import java.lang.*;
import java.util.*;

public class TestSimpleTimeClient 
{
    public static void main(String... args) 
    {
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println("Current time: " + myTimeClient.toString());
        System.out.println("Time in California: " +
            myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}

