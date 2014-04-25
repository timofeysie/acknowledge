enum Month {JAN,FEB,MAR,APR,MY}
public class Test10
{
	public static void main(String[] args) {
		Month mon = Month.valueOf("JAN");
		if(mon==Month.JAN)
			System.out.println("Inside JAN");
		if(mon.equals(Month.JAN))
			System.out.println("Inside JAN");
	}
}