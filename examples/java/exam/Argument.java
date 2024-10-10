import java.io.IOError;

public class Argument
{
	public static void main(String[] args) {
		if (args.length < 1)
		{
			throw new IOError("error");
		}
	}
}