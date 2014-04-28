public class RandomRegex
{
	
	public static void main(String[] args) {
		args = new String[2];
		args[0] = "x7+y8+z9=4P";
		args[1] = "[4789][+-=]";
		// orig: "x7+y8+z9=4P [4789][+-=]"
		testSplit(args);
	}

	private static void testSplit(String[] args)
	{
		System.out.println((args[0].split(args[1])).length);
		System.out.println(args[0].split(args[1]));
	}
}
