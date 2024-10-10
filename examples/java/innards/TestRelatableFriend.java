public class TestRelatableFriend extends RelatableFriend
{	
	
	public static void main(String[] args) 
	{
		RelatableFriend friend = new RelatableFriend();
		RelatableCircle circle = new RelatableCircle(5);
		RectanglePlus rectangle = new RectanglePlus();
		boolean equal = friend.isEqual(circle,rectangle);
		System.out.println("equal? "+equal);
	}

}