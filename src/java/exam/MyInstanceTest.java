interface MyInterface
{
}
public class MyInstanceTest implements MyInterface
{
    static String s;
    public static void main(String args[])
    {
        MyInstanceTest t = new MyInstanceTest();
        // s = "hi"; This will result in s being an instanceof String
        if(t instanceof MyInterface)
        {
            System.out.println("I am true interface");
        }
        else 
        {
            System.out.println("I am false interface");
        }
        if(s instanceof String)
        {
            System.out.println("I am true String");
            // This will be false since s is null (unassigned)
        }
        else 
        {
            System.out.println("I am false String");
        }
        //System.out.println(s.getClass().getSimpleName());
        System.out.println(s);

    }    
}