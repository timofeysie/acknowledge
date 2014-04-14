import packages.*;

public class SilverAccount extends Account
{
	public static void main(String[] args) 
	{
		Account gold = new Account();
		SilverAccount silver = new SilverAccount();
		// System.out.println(gold.number); <- protected access!
		System.out.println(silver.number);
	}	
}