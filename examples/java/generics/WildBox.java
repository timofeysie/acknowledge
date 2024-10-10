package generics;

class WildBox <T> 
{ 
  private T t; 
  public WildBox(T t) {this.t = t;}
  public WildBox(WildBox<? extends T > box) { t = box.t;} 
  //... 
  public boolean equalTo(WildBox< T > other) { return this.t.equals(other.t); } 
  public WildBox< T > copy() { return new WildBox<T>(t); }
  public Pair< T , T > makePair() { return new Pair<T,T>(t,t);} 
  public Class<? extends T > getContentType() {box.getClass();} 
  public int compareTo( Comparable<? super T > other) { return other.compareTo(t); } 

  public static void main(String[] args) 
  { 
    WildBox<?> box = new WildBox<String>("abc");
    box.put("xyz");     // error 
    box.put(null);     // ok

    String s = box.take();  // error 
    Object o = box.take();  // ok

    boolean equal = box.equalTo(box);  // error 
    equal = box.equalTo(new WildBox<String>("abc")); // error

    WildBox<?> box1 = box.copy();   // ok 
    WildBox<String> box2 = box.copy();  // error 
  } 
}