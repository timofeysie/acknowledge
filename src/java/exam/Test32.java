import java.util.*;
class Test32 implements Comparable
{
	static int index = 0;
	Test32() {index++;}
	public String toString() {
		return "Test32 "+index;
	}
	public static void main(String[] args) {
		Set<Test32> s = new TreeSet<Test32>();
		s.add(new Test32());
		s.add(new Test32());
		s.add(new Test32());
		for (Test32 out: s)
			System.out.println(out);
	}
	public int compareTo(Object test)
    { 
    	if (test == null) return -1;
    	if (test instanceof Test32)
    	{
	    	if ((Test32)test.index > index)
	    	{
	    		return -1;
	    	} else
	    	{
	    		return 1;
	    	}
	    } else
	    {
	    	return 0;
	    }
     }
}