Java Seven

- Initializer blocks get called everytime the class is constructed. The static block only gets called once, no matter how many objects of that type you create.

Shadowing
public class ShadowTest 
{
    public int x = 0;  
    class FirstLevel 
    {
        public int x = 1;  // member variable of the inner class
        void methodInFirstLevel(int x) 
        {
            System.out.println("parameter   x "+x      +" shadows all other xs");
            System.out.println("inner class x "+this.x+" shadows outer class x"); 
            System.out.println("Outer class x "+ShadowTest.this.x              );
        }

* overriding.interface)methods contians code that needs Java 8.


Special non-capturing contructs like (?<=X) mean X, via zero-width positive lookbehind.
