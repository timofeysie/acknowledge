public class StringMemory
{
	private static void endsWithStartsWith(String[] args)
	{
        String m=args[0];
        System.out.println("Does m start with foo? (T/F) "+m.startsWith("foo"));
        System.out.println("Does m end with bar? (T/F) "+m.endsWith("bar"));
        int offset = 3;
		System.out.println("Does m start with foo, offset "+offset+"? (T/F) "+m.startsWith("foo",3));        
        // use an assertion operator
        String ass = m.startsWith("foo")?"m starts with foo":"m doesn't starts with foo";     
        System.out.println(ass);  
        System.out.println("Does m start with foo (ignoring case) (T/F)? "+m.toLowerCase().startsWith("foo"));
        System.out.println("Does m end with bar (ignoring case) (T/F)? "+m.toLowerCase().endsWith("bar"));
	}

	private static void regionMatches(String[] args)
	{
		String str1 = args[0];
		String str2 = args[1];
		String str3 = args[2];
		System.out.print("Result of Test1: " );
       System.out.println(str1.regionMatches(7, str2, 0, 3));
       System.out.print("Result of Test2: " );
       System.out.println(str1.regionMatches(7, str3, 0, 3));
       System.out.print("Result of Test3: " );
       System.out.println(str1.regionMatches(true, 7, str3, 0, 3));
	}

	public static void main(String[] args) 
	{
		endsWithStartsWith(args);
		regionMatches(args);	
	}
}