class Bank
{
	String bankName;
	public String getBranchName()
	{
		return bankName;
	}
}
public class BankBranch extends Bank
{
	public static void main(String[] argv)
	{}
	/* This will compile if you change the exception to an unchecked exception
	like RuntimeException*/
	public String getBranchName() throws Exception 
	{
		return bankName;
	}
}