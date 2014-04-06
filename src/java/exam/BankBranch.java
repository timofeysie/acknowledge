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
	public String getBranchName() throws Exception 
	{
		return bankName;
	}
}