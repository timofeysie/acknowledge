public class MyThread extends Thread
{
	MyThread(int i)
	{
		this.i = i;
	}
	static int i = 0;
	public void run()
	{
		System.out.println(i);
	}
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
		{
			//new Thread().start();
			new MyThread(11).start();
		}
	}
}