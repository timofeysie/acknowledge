import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.text.ParseException;

public class EnlightenedParse
{

private void parsePage(String page)
{
	try (BufferedReader reader = new BufferedReader(
		new InputStreamReader(new URL(page).openStream())))
	{
		String line = reader.readLine();
		//parse
		System.out.println(line);
	} catch (ParseException|IOException e)
	{
		e.printStackTrace();
	}
}

public static void main(String[] args) 
{
	String site = "www.wikipedia.org";	
}

}