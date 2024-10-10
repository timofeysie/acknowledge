import java.util.*;
public class Primes 
{
	public static void main(String[] args) 
	{
		List p = new ArrayList();
		p.add(7);
		p.add(2);
		p.add(5);
		p.add(2);
		// p.sort(); no such method in ArrayList!
		// method is in the Collections implementation:
		Collections.sort(p);
		System.out.println(p);
	}
}