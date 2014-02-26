/**
* The output is the same because you can't change the reference to 
* objects in the method.  Or you can but they don't persist.
* The object a still points to the 3 even after the refernces where
* swapped in the method.
*/

public class SwapTest 
{

  public static void main(String[] args) 
  {
    Integer a = new Integer(2);
    Integer b = new Integer(3);
    System.out.println("Before: a = " + a + ", b = " + b);
    swap(a,b);
    System.out.println("After: a = " + a + ", b = " + b);
    swap2(a,b);
    System.out.println("After: a = " + a + ", b = " + b);
    StringBuffer sA = new StringBuffer("2");
    StringBuffer sB = new StringBuffer("3");
    swap3(sA,sB);
    System.out.println("After: a = " + sA + ", b = " + sB);
    StringWrapper s = new StringWrapper("Hello");
    appendWorld(s);
    System.out.println(s.value);
  }

  public static void swap(Integer iA, Integer iB) {
    Integer tmp = iA;
    iA = iB;
    iB = tmp;
  }

  public static void swap2(Integer jA, Integer jB) {
    jA = 3;
    jB = 2;
  }

  public static void swap3(StringBuffer kA, StringBuffer kB)
  {
      kA.append("B");
      kB.append("A");
  }

  /*
  * Wrapper class to make String a mutable object.
  */
  public static class StringWrapper 
  {
    public String value;
    public StringWrapper(String value) 
    {
        this.value = value;
    }
  }

  public static void appendWorld(StringWrapper s)
  {
    s.value = s.value +" World";
  }

}