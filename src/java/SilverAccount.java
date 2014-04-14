import packages.*;

public class SilverAccount extends Account
{
	public static void main(String[] args) 
	{
		Account gold = new Account();
		// System.out.println(gold.number); <- protected access!
		SilverAccount silver = new SilverAccount();
		System.out.println(silver.number);
	}	
}