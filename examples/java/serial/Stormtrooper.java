import java.awt.Button;

public class Stormtrooper
{
	
	public static void main(String[] args) 
	{
		// Create the object to be bound  
		Button b = new Button("Push me");  
		// Perform the bind  
		ctx.bind("cn=Button", b);  
		// You can then read the object back using Context.lookup  
		// Check that it is bound  
		Button b2 = (Button)ctx.lookup("cn=Button");  
		System.out.println(b2); 
	}
}