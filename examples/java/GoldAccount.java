import packages.*;

public class GoldAccount extends Account
{
	public static void main(String[] args) 
	{
			Account acc = new Account();
			// number has protected access in account.
			System.out.println(acc.number);
	}	
}