import java.util.regex.*;
import java.util.Arrays;
public class PatternExample 
{

	public static void main(String[] args) 
	{
		String pat = ".XX.";
		Pattern pattern = Pattern.compile(".xx.");
		Matcher matcher = pattern.matcher("MxxY");
		System.out.println("Input String matches regex - "+matcher.matches());
		String quote = pattern.quote(pat);
		System.out.println("quote "+quote);
		pattern = Pattern.compile(quote);
		matcher = pattern.matcher("MxxY");
		System.out.println("Input String matches regex - "+matcher.matches());
		// bad regular expression
		//pattern = Pattern.compile('*xx*');
		String statement = "Java is great";
		System.out.println(Arrays.toString(statement.split("\\s")));
	}

}