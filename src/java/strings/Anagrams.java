public class Anagrams 
{

    public static boolean areAnagrams(String string1,
                                      String string2) {

        String workingCopy1 = removeJunk(string1);
        String workingCopy2 = removeJunk(string2);

	    workingCopy1 = workingCopy1.toLowerCase();
	    workingCopy2 = workingCopy2.toLowerCase();

	    workingCopy1 = sort(workingCopy1);
	    workingCopy2 = sort(workingCopy2);

        return workingCopy1.equals(workingCopy2);
    }

    protected static String removeJunk(String string) {
        int i, len = string.length();
        StringBuilder dest = new StringBuilder(len);
  		char c;

	    for (i = (len - 1); i >= 0; i--) {
	        c = string.charAt(i);
	        if (Character.isLetter(c)) {
		        dest.append(c);
	        }
	    }

        return dest.toString();
    }

    protected static String sort(String string) {
	    char[] charArray = string.toCharArray();

	    java.util.Arrays.sort(charArray);

        return new String(charArray);
    }

    public static void main(String[] args) 
    {
        String string1 = "Cosmo and Laine:";
        String string2 = "Maid, clean soon!";

        System.out.println();
        System.out.println("Testing whether the following "
                         + "strings are anagrams:");
        System.out.println("    String 1: " + string1);
        System.out.println("    String 2: " + string2);
        System.out.println();

        if (areAnagrams(string1, string2)) {
            System.out.println("They ARE anagrams!");
        } else {
            System.out.println("They are NOT anagrams!");
        }
        System.out.println();
        System.out.println("Now for our version");
        String s1 = "parliament";
        String s2 = "partial men";
        boolean yes_or_no = anagram(s1, s2);
        System.out.println("is "+s1+" an anagram of "+s2+"? "+yes_or_no);

        System.out.println("is "+string1+" an anagram of "+string2+"? "+yes_or_no);

    }

    /**
    * Our version is much better!
    */
    private static boolean anagram(String string1, String string2)
    {
        boolean if_its_an_anagram = true;
        for (int i = 0; i < string1.length(); i++)
        {
            Character c = string1.charAt(i);
            if (Character.isWhitespace(c))
            {
                // skip whitespace
            } else if (!string2.contains(string1.substring(i,i+1)))
            {
                return false;
            }
        }
        return if_its_an_anagram;
    }
}