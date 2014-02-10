class MyString implements Copyable<MyString> 
{ 
  private StringBuilder buffer; 
  public MyString(String s) { buffer = new StringBuilder(s); }
  public MyString copy() { return new MyString(buffer.toString()); } 
  //... 
} 

class RawTest 
{ 
  private static void test( Wrapped wrapper) 
  { 
    wrapper. setObject (new MyString("Deutsche Bank"));  // unchecked warning 
    Object s = wrapper. getObject (); 
  }

  public static void main(String[] args) 
  { 
    Wrapped<MyString> wrapper = new Wrapped<MyString>(new MyString("Citibank")); 
    test(wrapper); 
  } 
  
}