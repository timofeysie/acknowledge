import java.io.*;
class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			File f = new File("first file");
			throw new FileNotFoundException();
		} catch (FileNotFoundException fnfe)
		{
			System.out.println("inside 1");
		} catch (IOException ioe)
		{
			System.out.println("inside 2");
			// warning: unreachable catch clause
		} catch (Exception e)
		{
			System.out.println("inside 3");
		} finally 
		{
			System.out.println("inside 4");
		}
	}
}