import java.io.*;

public class FinalizeFOS extends OutputStream
{
	public FinalizeFOS() throws IOException
	{
		super("Timothy");
	}

	public static void main(String[] args) throws IOException
	{
		FinalizeFOS fos = new FinalizeFOS();
		fos.finalize();
		System.out.println("Stream closed");	
	}
}
