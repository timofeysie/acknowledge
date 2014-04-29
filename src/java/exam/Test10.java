enum Month {JAN,FEB,MAR,APR,MAY}
public class Test10
{
	public static void main(String[] args) {
		Month mon = Month.valueOf("JAN");
		if(mon==Month.JAN)
			System.out.println("Inside JAN 1");
		if(mon.equals(Month.JAN))
			System.out.println("Inside JAN 2");
	}
}