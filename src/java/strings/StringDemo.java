import java.util.List;
import java.util.ArrayList;

public class StringDemo 
{

    public static int sumEven(List<Integer> li) {
        int sum = 0;
        for (Integer i: li)
        {
            if (i % 2 == 0)
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) 
    {
        String anotherPalindrome = "Niagara. O roar again!"; 
        System.out.println(anotherPalindrome+" length "+anotherPalindrome.length());
        String regex = ". O ";
        int limit = 1; // limit the size of the returned array
        String[] array_1 = anotherPalindrome.split(regex);
        // The limit makes the last array element the remaining
        // part of the string
        String data = "Tim, Dave, Jeff, Frank, Laura";
        regex = ",";
        String[] array_2 = anotherPalindrome.split(regex, limit);
        System.out.println("array_1 "+array_1.length);
        for (String s:array_1)
            System.out.println(s);
        System.out.println("array_2 "+array_2.length);
        for (String s:array_2)
            System.out.println(s);
        String [] dat = data.split(",", 3);
        System.out.println("data "+dat.length);
        for (String s:dat)
            System.out.println(s.trim());

        String comp1 = "Apple";
        String comp2 = "Able";
        //int compare = anotherPalindrome.compareTo(data); // -6
        int compare1 = comp1.compareTo(comp2); 
        System.out.println(comp1+" compareTo "+comp2+" = "+compare1);
        int compare2 = comp2.compareTo(comp1); 
        System.out.println(comp2+" compareTo "+comp1+" = "+compare2);


        int beginIndex = 5;
        int endIndex = 9;
        CharSequence seq = data.subSequence(beginIndex, endIndex);
        //  Returns a new character sequence constructed from beginIndex index up until endIndex - 1.
        System.out.println("character sequence: "+seq);

        float floatVar = 1.1f; 
        int intVar = 1; 
        String stringVar = "first";
        String fs;
        fs = String.format("float %f, " +
                   " integer %d, " +
                   " string %s",
                   floatVar, intVar, stringVar);
        System.out.println(fs);
        // these values will not be reflected in the fs string.
        floatVar = 1.2f; 
        intVar = 2; 
        stringVar = "second";
        System.out.println(fs);

        System.out.println(calculateInitials("Timothy Curchod"));
        System.out.println(calculateInitials("Timothy Butler Curchod"));
        System.out.println(calculateInitials("Jin Young Park"));

        String myName = "Fred F. Flintstone";
        System.out.println(calculateInitials(myName));
        System.out.println(calculateInitials("JinYoung Park"));

        stringResult();
        String hannah = "Did Hannah see bees? Hannah did.";
        System.out.println(hannah+" len "+hannah.length());
        try
        {
            int arg = Integer.valueOf(args[0]);
            System.out.println("hannah.charAt("+arg+") "+hannah.charAt(arg));
        } catch (java.lang.ArrayIndexOutOfBoundsException aioobe)
        {
            System.out.println("hannah.charAt(12) "+hannah.charAt(12));
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i ++)
            li.add(i);
        System.out.println("The sum of even numbers from 1 to 50 is "+sumEven(li));
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];
        
        // put original string in an 
        // array of chars
        for (int i = 0; i < len; i++) 
        {
            tempCharArray[i] = palindrome.charAt(i);
        } 
        
        // reverse array of chars
        for (int j = 0; j < len; j++) 
        {
            charArray[j] = tempCharArray[len - 1 - j];
        }
        
        String reversePalindrome = new String(charArray);
        System.out.println("Using arrays: "+reversePalindrome);

        StringBuilder sb = new StringBuilder(palindrome);
        sb.reverse();  // reverse it
        System.out.println("Using StringBuilder: "+sb); // calls toString implicitly

        // region matches code
        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0; 
             i <= (searchMeLength - findMeLength);
             i++) {
           if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
              foundIt = true;
              System.out.println(searchMe.substring(i, i + findMeLength));
              break;
           }
        }
        if (!foundIt)
            System.out.println("No match found.");

        // with our own style
        String search_me = "Green Eggs and Ham";
        String find_me = "Eggs";
        int search_me_length = search_me.length(); // 18
        int find_me_length = find_me.length(); // 4
        boolean found_it = false; 
        // from 0 to 14
        for (int i = 0;i <= (search_me_length - find_me_length);i++) 
        {
           if (search_me.regionMatches(i, find_me, 0, find_me_length)) 
           {
              found_it = true;
              System.out.println("found: "+search_me.substring(i, i + find_me_length));
              break;
           }
        }
        if (!found_it)
        {
            System.out.println("No match found.");
        }

        System.out.println("Using our method: "+findMatchingRegion(search_me, find_me));

    }

    /**
    * Returns the index of the find_me substring, or -1 if it is not
    * contained in the search string.
    */
    private static int findMatchingRegion(String search_me, String find_me)
    {
        if (search_me.contains(find_me))
        {
            int search_me_length = search_me.length(); // 18
            int find_me_length = find_me.length(); // 4
            // from 0 to 14
            for (int i = 0;i <= (search_me_length - find_me_length);i++) 
            {
                if (search_me.regionMatches(i, find_me, 0, find_me_length)) 
                {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findPercentageAlike(String correct, String answer)
    {
        int percentage_correct;
        if (correct.equals(answer))
        {
            return 100;
        } else if (correct.contains(answer))
        {
            // the correct answer contains the user answer, find our how much else
            int correct_length = correct.length(); 
            int answer_length = answer.length(); 
            int diff = answer_length - correct_length;
            // get the percentage different
        } else if (answer.contains(correct))
        {
            // the answer is longer than the question, find out how much.
        }
        return 0;
    }

    private static void stringResult() 
    {
        String original = "software";
        StringBuilder result = new StringBuilder("hi");
        int index = original.indexOf('a');
        result.setCharAt(0, original.charAt(0));
        result.setCharAt(1, original.charAt(original.length()-1));
        result.insert(1, original.charAt(4));
        result.append(original.substring(1,4));
        result.insert(3, (original.substring(index, index+2) + " ")); 
        System.out.println(result);
    }

    private static String calculateInitials(String full_name)
    {
        full_name.trim();
        StringBuilder initials = new StringBuilder();
        int space = full_name.indexOf(" ");
        while (space != -1)
        {
            initials.append(full_name.charAt(0));
            full_name = full_name.substring(space+1, full_name.length());
            space = full_name.indexOf(" ");
            if (space == -1 & full_name.length()>0)
            {
                initials.append(full_name.charAt(0));
                break;
            }
            //System.out.println(initials+" "+full_name+" "+space);
        }
        return new String(initials);
    }

    private static String computeInitials(String myName) {
        StringBuffer myInitials = new StringBuffer();
        int length = myName.length();
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(myName.charAt(i))) {
                myInitials.append(myName.charAt(i));
            }
        }
        return new String(myInitials);
    }

    

}