import java.util.List;
import java.util.ArrayList;

public class BoxDemo 
{

  public static <U> void addBox(U u, List<Box<U>> boxes) 
  {
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
  }

  public static <U> void outputBoxes(List<Box<U>> boxes) 
  {
    int counter = 0;
    for (Box<U> box: boxes) 
    {
      U boxContents = box.get();
      System.out.println("Box #" + counter + " contains [" +
             boxContents.toString() + "]");
      counter++;
    }
  }

  public static void main(String[] args) 
  {
    ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
    BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
    BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
    BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
    BoxDemo.outputBoxes(listOfIntegerBoxes);

    List<String> live = new ArrayList<String>();
    liveTest(live, "one");
    liveTest(live, "two");
    liveTest(live, "three");
    for (String s:live)
      System.out.println(s);

    // Generics restriction #2 example
    List<String> ls = new ArrayList<>();
    try
    {
      append(ls, String.class);
    } catch (Exception e)
    {
      // thems the breaks.
    }

    // Restrication #4
    //S = { ArrayList<Integer>, ArrayList<String> LinkedList<Character>, ... }
    // The runtime does not keep track of type parameters, so it cannot tell
    // the difference between an ArrayList<Integer> and an ArrayList<String>. 

    // Typically, you cannot cast to a parameterized type unless it is parameterized by unbounded wildcards. For example:
    List<Integer> li = new ArrayList<>();
    //List<Number>  ln = (List<Number>) li;  // compile-time error
    
    // However, in some cases the compiler knows that a type parameter is always
    // valid and allows the cast. For example:
    //List<String> l1 = ...; // <-- illegal start of expression compile time error.
    //ArrayList<String> l2 = (ArrayList<String>)l1;  // OK
  }

  public static void liveTest(List al, String item)
  {
      al.add(item);  // unchecked call to add(E) as a memer of the raw type list
  }

  /**
  * You Cannot Create Instances of Type Parameters
  *
  public static <E> void append(List<E> list) 
  {
    E elem = new E();  // compile-time error
    list.add(elem);
  }
  */

  /** 
  * As a workaround, you can create an object of a type parameter through reflection:
  */
  public static <E> void append(List<E> list, Class<E> cls) throws Exception 
  {
    E elem = cls.newInstance();   // OK
    list.add(elem);
  }

  /**
  *Cannot Use Casts or instanceof with Parameterized Types
  * Because the Java compiler erases all type parameters in generic code,
  * you cannot verify which parameterized type for a generic type is being used at runtime:
  */
  public static <E> void rtti1(List<E> list) 
  {
    //if (list instanceof ArrayList<Integer>) 
    {  // compile-time error
        // ...
    }
  }

  /**
  *  The most you can do is to use an unbounded wildcard to verify that the list
  * is an ArrayList:
  */
  public static void rtti2(List<?> list) 
  {
    if (list instanceof ArrayList<?>) 
    {  // OK; instanceof requires a reifiable type
        // ...
    }
  }

  /**
  * Cannot Create, Catch, or Throw Objects of Parameterized Types
  * A generic class cannot extend the Throwable class directly or indirectly. 
  * You can, however, use a type parameter in a throws clause:
  */
  class Parser<T extends Exception> 
  {
    public void parse(java.io.File file) throws T 
    {     // OK
        // ...
    }
  }

}