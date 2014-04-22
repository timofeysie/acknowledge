class PrecedenceDemo
{
  public static void main(String[] args)
  {
	//prePostTest();
	test3();
  }

  static boolean a, b, c; 
  private static void test3()
  {  
    boolean x = (a = true) || (b = true) && (c = true);  
    System.out.print(a + "," + b + "," + c); 
  }

  private static void test2()
  {
  		int x = 5;  
    	int z = ++x * x--; 
    	System.out.print("++x * x--");  
    	System.out.println(" = "+z+" x is now "+x);  
    	x = 5;  
    	z = x++ * --x; 
    	System.out.print("x++ * --x"); 
    	System.out.println(" = "+z+" x is now "+x);  
  }

  private static void prePostTest()
  {
  	int i = 10;  
	int a = i++ + ++i + i--;
	System.out.println("a: " + a);  
	System.out.println("expected: 32");  
	System.out.println("i: " + i);  
	System.out.println("expected: 10"); 
	i = 10; a = 0;
	int b, c, d; 
	a = (b = i++) + (c = ++i) + (d = i--); 
	//    10			12			12
	System.out.println("b " + b + " c " + c + " d " + d); 
	System.out.println("a "+a+" i "+i);
	// output 34 11 10 12 12
  }

  private void argsTest(String[] args)
  {
  	int x = 5; int backup = x;
	if (args.length>0)
	{
		x = Integer.parseInt(args[0]);
		backup = x;
	}  
	System.out.println("x--+--x   "+(x--+--x));
	x = backup;
	System.out.println("x - (--x) "+(x - (--x)));
	x = backup;
	System.out.println("(x--)- x  "+((x--)- x));
  }

  private void randomStuff()
  {
  	int a = 6;
  	int b = 5;
  	int c = 10;
  	float rs = 0;
 	rs = a + (++b)* ((c / a)* b);
  	System.out.println("The result is:" + rs);
  	System.out.println("a = 6");
  	System.out.println("b = 5");
  	System.out.println("c = 10");
  	int b2 = ++b;
  	System.out.println("(++b) = "+b2);
  	int c2 = (c/a);
	System.out.println("(c/a) = "+c2);
	System.out.println("("+c2+")*b = "+(c2 * b));
	System.out.println(a+" + ("+b2+")*(("+c2+")*"+b);
	System.out.println("a +(++b)*((c/a)*b)="+a+(++b)*((c/a)*b));
	System.out.println(a+"+("+b2+")*(("+c2+")*"+b+")");
	System.out.println();
	int x = 5;
	int y = 10;
	int z = ++x * y--;
	System.out.println("z = "+z);
    
        System.out.println();
        int a1 = 1;         
        int x1 = ++a1 + a1++;         
        System.out.println(x1); // Prints 4  

    System.out.println();    
    int i = 0;  
	int j = 0;    
	boolean t = true;  
	boolean r;  
	r = (t & 0<(i+=1));  
	r = (t && 0<(i+=2));  
	r = (t | 0<(j+=1));  
	r = (t || 0<(j+=2)); //<-------  
	System.out.println("i= "+i+" j= "+j);  
	System.out.println("t= "+t+" r= "+r);
  }
}