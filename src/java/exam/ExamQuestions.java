import java.lang.StringBuffer;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.io.*;

// private class De {} // modifier private not allowed here.

public class ExamQuestions
{
	ExamQuestions () {
		this("ExamQuestions");
	}

	ExamQuestions (String name)
	{
		//this();
		//super();
		System.out.println("Started :"+name);
	}

	private static void testNan()
	{
		Double d1 = new Double(-1.0/0.0);
		Double d2 = new Double(0.0/0.0); 
     	System.out.println("A. "+(d1 + " = " + d1.isNaN()));
     	System.out.println("B. "+(d2 + " = " + d2.isNaN())); 
		Byte b1 = 1;
		byte b2 = 1;
		System.out.println("C. "+(b1==b2)); 
		double num1 = 0.2;
		float num2 = 0.2f;
		System.out.println("D. "+(num1+" == "+num2));
		System.out.println("E. "+(num1 == num2)); 
		System.out.println("F. "+(num1 == (double)num2)); 
		System.out.println("G. "+((float)num1 == num2)); 
		num1 = 0.5;
		num2 = 0.5f;
		System.out.println("H. "+(num1+" == "+num2));
		System.out.println("I. "+(num1 == num2)); 
		System.out.println("J. "+(num1 == (double)num2)); 
		System.out.println("K. "+((float)num1 == num2)); 
	}

/*
This is a very good question to test the concepts of execution flow 
in case of if conditions. The rule for attaching else statements with 
if conditions is the same as attaching close brackets with open brackets. 
A close bracket attaches with the closest open bracket, which is not already 
closed. Similarly an else statement attaches with the closest if statement,
which doesn't have an else statement already, attached to it. So the else 
statement at line 7 attaches to the if statement at line 6. The else statement 
at line 8 attaches to the if statement at line 5. The else statement at line 9 
attaches to the if statement at line 8. Now let's look at the execution. 
At line 4 since a is equal to true the execution falls to line 5. At line 5 
since b is not true the execution goes to the corresponding else statement at 
line 8. Now it evaluates the condition inside the if statement. Please note 
here that an assignment statement also has a value equal to the value being 
assigned, hence (b = c) evaluates to true and subsequently a 
(b = c) evaluates to true and &quot;It's too confusing to tell what is true 
and what is false&quot; will be printed. Hence the correct answer is choice D.
*/
private void trueOrFalse()
{
boolean a = true;  // 1
boolean b = false; // 2
boolean c = true;  // 3
if (a == true)
if (b == true)
if (c == true)            System.out.println("Some things are true in this world");
else                      System.out.println("Nothing is true in this world!");
else if (a && (b = c))    System.out.println("It's too confusing to tell what is true and what is false");
else                      System.out.println("Hey this won't compile");
}

private void trueOrFalse2()
{
boolean a = true;
boolean b = false;
boolean c = true;
if (a == true)  // line 4
	if (b == true) // line 5
		if (c == true) // line 6
			System.out.println("Some things are true in this world"); // 6
		else                      
			System.out.println("Nothing is true in this world!"); // 7
	else if (a && (b = c))    
		System.out.println("It's too confusing to tell what is true and what is false"); //8
	else                      
		System.out.println("Hey this won't compile"); // 9
}

private void StringBuilderQuestion()
{
	StringBuilder sb = new StringBuilder();
	//Which of the following are valid uses of the sb variable?
	sb.append(34.5);
	//sb.deleteCharAt(34.5);
	//c. sb.toInteger(3);
	sb.toString();
	System.out.println("String Builder");
	StringBuilder sb11 = new StringBuilder("34.5");
	assert sb11.equals(sb): "StringBuilders are not equal";
	int i = 5;
	int j = 10;
	while((i = 12)!=5) {break;};  // how does this work?  ahh, (12 != 5)
	//Given the following declaration of an array, which statement will display
	//each element of the array?
	int arr[] = {1,2,3,4,5};
	//for(int n : arr[]) { System.out.println(n); }System.out.println(n);
	System.out.println("b.");
	for(int n : arr) { System.out.print(n); }
		System.out.println();
	System.out.println("c.");
	//for(int n=1; n < 6; n++) { System.out.println(arr[n]);}
	//System.out.print("d.");	
	//for(int n=1; n <= 5; n++) { System.out.println(arr[n]);}
}


private void testLoop()
{
	int i = 1;
	do {
		System.out.println(i);
	} while (i>10);
}

private void initDataTypes()
{
	boolean bo1 = true;
	Boolean bo2 = new Boolean("true");  
byte by1 = 1;
Byte by2 = new Byte("1");  
char ch1 = '\u0001';
Character ch2 = new Character('1');  
short sh1 = (short)1;
Short sh2 = new Short((short)1);  
long lo1 = 1L;
Long lo2 = new Long(1l);  
float fl1 = 1.1f;
Float fl2 = new Float(1.1f);  
double do1 = 1.1d;
Double do2 = new Double(1.1d);  
String str = "1";
System.out.println("byte  "+by1+" "+by2);
System.out.println("char  "+ch1+" "+ch2);
System.out.println("short "+sh1+" "+sh2);
System.out.println("float "+fl1+" "+fl2); 
System.out.println("doubl "+do1+" "+do2);
}

private static void testEquals()
{
	Integer n1 = new Integer(0);
	Byte n2 = new Byte((byte)0);
	System.out.println("Integer: "+n1);
	System.out.println("Byte: "+n2);
	System.out.println("n1.equals(n2)?");
	System.out.println(n1.equals(n2));

	StringBuffer s1 = new StringBuffer("JAVA".toLowerCase());
	StringBuffer s2 = new StringBuffer("java");
	System.out.println(s1+".equals("+s2+")?");
	System.out.println(s1.equals(s2));
	StringBuilder sb1 = new StringBuilder("JAVA".toLowerCase());
	StringBuilder sb2 = new StringBuilder("java");
	System.out.println("StringBuilder: "+sb1+".equals("+sb2+")?"+sb1.equals(sb2));
	System.out.println("The StringBuffer equals method returns true only for two reference variables referring to the same StringBuffer object as it uses mutable strings");
	String s3 = "java";
	String s4 = "java";
	System.out.println("For Strings: "+s3+".equals("+s4+") "+s3.equals(s4));
	System.out.println("smaller than byte");
	Integer i1 = 1;
	Integer i2 = 1;
	if (i1 == i2) System.out.println("same");
	if (i1 != i2) System.out.println("not same");
	System.out.println("larger than byte");
	Integer i3 = 128;
	Integer i4 = 128;
	if (i3 == i4) System.out.println("same");
	if (i3 != i4) System.out.println("not same");
}



private static void testBitwise()
{
	boolean b1 = true;
	boolean b2 = false;
	boolean b3 = false;
	boolean b4 = true;
	System.out.println(b1+"^"+b2+" = "+(b1^b2));
	System.out.println(b2+"^"+b3+" = "+(b2^b3));
	System.out.println(b1+"^"+b4+" = "+(b1^b4));
}

int subTotal;
static int total;
public void calculate()
{
	int local;
	// local = this.total; 
	// this is ok but unsafe: static var should be qualified by type name
	// ExamQuestions instead of by an expression, as such:
	local = ExamQuestions.total; // not local = this.total;
	local = this.subTotal;
	// this.total = total; // same for this one.
	ExamQuestions.total = total;  // not this.total = total;
	//this.local = 4; Cannot find symbol
	//this = new ExamQuestions();
	// cannot assing a value to a final veriable this

}

static void aMethod() throws RuntimeException
{
	throw new NullPointerException();
}

static void unorthadoxUnary()
{
	int x = 2; 
	x += x++ * x++ * x++;
	System.out.println("Unary test 1: "+x);
	int a = -1;
	int b = -a;
	System.out.println(a+" "+b);
}

private static void testExamQuestions()
{
	ExamQuestions qs = new ExamQuestions();
	qs.trueOrFalse();	
	qs.trueOrFalse2();
	qs.StringBuilderQuestion();	
	qs.testLoop();
	qs.initDataTypes();
}

private static void defualtValue()
	{

	}

	private static void randomCode()
	{
		Number Float = 99.455f;
	System.out.println("Float "+Float);
	/* This causese the error" ';' expected 
	with an arrow pointing between the Float 
	and the num_flo variable:
	Number Float num_flo = 99.455f;
	So then how can this value be assigned to a value?
	float is a reserved word, Float and other class names are not.
	*/
	Number f = 99.455f;
	Number Object = 99.455f;
	/* Here there is no coloring on the Float word.*/

	String str = "10"; 
	Integer a = 10;
	//boolean b=str==a; Incomparable types: String and Integer 

	Integer number = 145;
	//StringBuffer sb = "buff";
	// Not OK because it reuqires a constructor.

	// the toArray method returns an Object[], 
	// which in this case must be cast to a String[]
	Vector<String> set = new Vector<String>();
	//String[] arr = (String[])set.toArray();

	Integer e;
	//System.out.println(e); // compile time error is here not in the previous line.

	Integer num1 = 0;
	Float num2 = -0.0F;
	if (num1.intValue() == num2)
	{
		System.out.println("0 == -0.0F returns true");
	}

	Boolean b1 = new Boolean("TRUE");
	boolean b2 = true;
	if (b1==b2)
	{
		System.out.println("b1==b2");
	}
	if (b1.equals(b2))
	{
		System.out.println("b1.equals(b2)");
	}
	if (b1.booleanValue()==b2)
	{
		System.out.println("b1.booleanValue()==b2");
	}

	Vector <String>v = new Vector<>();
	v.add("A");
	for (String s:v)
	{
		System.out.println(s);
	}

	Map <String,String> m = new HashMap<>();
	m.put("B","b");
	for(Map.Entry<String, String> entry : m.entrySet())
	{
    	System.out.println(entry.getKey() + ": "+entry.getValue());
	}
	
	//Integer num_123L = Integer.parseInt(123);
	Integer num_123S = Integer.parseInt("123L");
	//System.out.println("num_123 "+num_123S);

	try
	{
		//aMethod();
	} catch (ClassCastException cce)
	{
		System.out.println("cce");
	} finally
	{
		System.out.println("finally");
	}

	byte b1a = ~5+1;
	int b2a = +b1a;
	System.out.println(b1a);
	System.out.println(b2a);

	System.out.println(4<5 && true);
	System.out.println(6<5 && false);	

	Boolean string1=new Boolean("TrUe");
	boolean character1=true;
	assert string1.booleanValue()==character1;
	assert string1==character1;
	assert string1.equals(character1);
	//assert !string1.booleanValue()=="true";
	assert !string1.equals("true");
	//assert !character1=="true";

	//System.out.println(new Integer(0).booleanValue());
	Character ch1 = 65;
	char ch2 = 65;
	System.out.println(ch2 == ch1);

	Float value1 = 39.0F;
	float value2 = (float)39.0;
	//System.out.println(value2.equals(value1)); // float caoonot be dereferenced
	}

	private static void basicFailedQuestions()
	{
		String str = "10";
		int a = new Integer(10);
		//boolean b = str == a;
		String one = Integer.toBinaryString(010)+"";
		String two = ""+Integer.toBinaryString(4);
		System.out.println(one+"|"+two);
		//System.out.println(one|two);
		double num1 = 0.2;
		float num2 = 0.2f;
		Integer num3 = 123;
		float num4 = 123f;
		double num5 = 123;
		float num6 = 123;
		Integer num7 = new Integer("123");
		byte num8 = 123;
		long num10 = 99;
		//int num11 = num10;
		System.out.println("int = long: possible loss of precision ");
		int num12 = 99;
		long num13 = num12;
		System.out.println("long = int: "+num13);
		System.out.println("Integer == float "+(num3 == num4));
		System.out.println("float   == Integer "+(num4 == num3));
		System.out.println("double == float "+(num5 == num4));
		System.out.println("float == int "+(num6 == num7));
		System.out.println("int == byte? "+(num7 == num8));
		//System.out.println("double == float "+num1 == num2); // false
		System.out.println(num1 == (double)num2); // false
		System.out.println((float)num1 == num2); // true
		Object obj = 99;
		System.out.println(obj);
		Character c = 65;
		System.out.println("cha "+c);
		Character obj1 = 65;
		char c1 = 65;
		System.out.println(c1==obj1);
		// List list2 = new ArrayList<String>();
		// list2.add(new StringBuilder("123"));
		// the above is OK as long as list2 is of raw type.  If it were not, this
		// would cause a compile time error:
		// List<String> list2 = new ArrayList<String>();
		// when we try to add the string builder.
		//String sbu = list2.get(0);
		//System.out.println(sbu);
		String name = "Java Tiger";
		System.out.println(name+" "+name.hashCode());
		change(name);
		System.out.println(name+" "+name.hashCode());
		StringBuffer name2 = new StringBuffer("Java Tiger");
		System.out.println("name1.equals(name2)? "+name.equals(name2));
		System.out.println(name2+" "+name2.hashCode());
		change(name2);
		System.out.println(name2+" "+name2.hashCode());
		
		Integer numm1 = 0;
		Float numm2 = -0.0F;
		System.out.println("Integer.intvalue == - Float? "+(numm1.intValue() == numm2));
		Float numm3 = 0.0F;
		System.out.println("Integer.intvalue == Float? "+(numm1.intValue() == numm3));
		double d = 123.45;  
		d++;
		System.out.println(d);  
	}

	public static void change(String in)
	{
		in = in.substring(0,in.length()-3);
		System.out.println(in+" "+in.hashCode());
	}

	public static void change(StringBuffer in)
	{
		in = in.append(" Milk");
		System.out.println(in+" "+in.hashCode());
	}

	public static void assertions()
	{
		assert(-0.0f == 0);
		boolean a = true; 
		boolean b = false;
		boolean c = true; 
		assert(a && (b = c));
	}

	private static void failedRegex()
	{
		String str = "Java*JSP*EJB*J2EE";
		//System.out.println(Arrays.toString(str.split("*",-2)));
		System.out.println(Arrays.toString(str.split("[*]",-2)));
		System.out.println(Arrays.toString(str.split("\\*",-2)));
		
		String str2 = "Java-JSP-EJB-J2EE";
		//System.out.println(Arrays.toString(str.split("*",-2)));
		System.out.println(Arrays.toString(str2.split("\\-",-2)));

		String search = "boo:and:foo";
		System.out.println(Arrays.toString(search.split("\\:",-2)));
		/* java.util.regex.PatternSyntaxException:
		Dangling meta character * near index 0.
		PatternSysntaxException occurs if the regular expressions's
		syntx is invalid.  Note that to use "*" as a delimiter,
		we have to specify "\\*" as the regular expression.
		Given that, we would split the string into
		[Java, JSP, EJB, J2EE]
		Also, the -2 is not needed; the same output is got without it.
		*/
		char c = search.charAt(search.length()-1);
		System.out.println(c);
		for (int i = 0; i < 65; i++)
		{
			String s1 = Character.toString((char)i);
			//System.out.println(i+" "+s1);
		}
		String c2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char c3 = c2.charAt('!');
		System.out.println(c3);

		String string = "TimbreakJinyoungbreakHenrybreakCheriebreakDonbreakWilliambreakRob";
		//System.out.println(Arrays.toString(str.split("*",-2)));
		System.out.println(Arrays.toString(string.split("break",-2)));
	}

	/**
	* All instances of a generic class have the same runtime class,
	* regardless of their actual type parameters.  So the getClass()
	* method returns a java.util.Vector for both x and y.  Since no
	* data has been added to both Vector objects, they are also
	* meaningfully equal.  So the equals method returns true here
	* and the output is true, true, true, true.
	*/
	private static void payRollExample()
	{
		Vector<String> employeeList = new Vector<String>();
		Vector<Integer> employeeIdList = new Vector<Integer>();
		Vector<Object> employeeProfileList = new Vector<Object>();
		System.out.println(employeeList.getClass() == employeeIdList.getClass());
		System.out.println(employeeList.equals(employeeProfileList));
		System.out.println(employeeList.getClass() == employeeProfileList.getClass());
		System.out.println(employeeIdList.equals(employeeProfileList));
	}

	private static void arrayWork()
	{
		int []a = {1,2,3,4,5,6};
		int i = a.length -1;
		while(i>=0)
		{System.out.print(a[i]);i--;}

		Vector<String> set = new Vector<String>();
		//String[] arr = set.toArray();
		String[] arr1 = (String [])set.toArray();
		String[] arr2 = set.toArray(new String[0]);

		ArrayList<String> al =new ArrayList<String>();
		al.add("one");
		al.add("two");
		al.add("three");
		//String[] s = a.toArray();
		String[] s3 = (String[])al.toArray();
		String[] s4 = set.toArray(new String[al.size()]);

		//ArrayList<int> ai = new ArrayList<int>();
	}

	static void aMethod(Byte ob) {System.out.println("Byte");}
	static void aMethod(byte ob) {System.out.println("byte");}
	static void aMethod(Character ob) {System.out.println("Character");}
	static void aMethod(char ob) {System.out.println("char");}
	static void aMethod(Short ob) {System.out.println("Short");}
	static void aMethod(short ob) {System.out.println("short");}
	static void aMethod(Integer ob) {System.out.println("Interger");}
	static void aMethod(int ob) {System.out.println("int");}
	static void aMethod(Float ob) {System.out.println("Float");}
	static void aMethod(float ob) {System.out.println("float");}
	static void aMethod(Long ob) {System.out.println("Long");}
	static void aMethod(long ob) {System.out.println("long");}
	static void aMethod(Double ob) {System.out.println("Double");}
	static void aMethod(double ob) {System.out.println("double");}
	static void aMethod(Object ob) {System.out.println("Object");}
	static void aMethod(String ob) {System.out.println("String");}

	private static void testIO()
	{
		try
		{
			Writer w = new BufferedWriter(new FileWriter("example"));
		} catch (java.io.IOException ioe)
		{
			System.out.println(ioe.toString());
		}
	}

	static void bMethod() throws RuntimeException
	{
		throw new NullPointerException(); // Exception cannot go here.
	}

	private static void testException()
	{
		try
		{
			bMethod();
		} catch (ClassCastException cce)
		{
			System.out.println("cce");
		} finally
		{
			System.out.println("finally");
		}
	}


	private static void testBooleans()
	{
		Boolean string1=new Boolean("TrUe");
		boolean character1=true;
		System.out.println(string1.booleanValue()==character1);
		System.out.println(string1==character1);
		System.out.println(string1.equals(character1));
		//System.out.println(string1.booleanValue()=="true"); // error
		System.out.println(string1.equals("true"));
		//System.out.println(character1=="true"); // ditto
		// incompatible types, boolean and String
	}

// private synchronized int e;

	private static void testNumbers()
	{
		byte b1 = 1;
		byte b2 = 1;
		System.out.println((b1==b2)); // true
		b1 = (byte)(b1 + b2);
		b1 += b2;
		short a1 =10;
 		byte b7=20;
 		short c1 = (short)(a1+b7);
 		int i7 = b1 + b2;
		double num1 = 0.2;
		float num2 = 0.2f;
		System.out.println(num1+" == "+num2);
		System.out.println(num1 == num2); // false
		System.out.println(num1 == (double)num2); // false
		System.out.println((float)num1 == num2); // true
		num1 = 0.5;
		num2 = 0.5f;
		System.out.println(num1+" == "+num2);
		System.out.println(num1 == num2); // true
		System.out.println(num1 == (double)num2); // true
		System.out.println((float)num1 == num2); // true
		Integer num3 = 123;
		float num4 = 123.0f;
		double num5 = 123.0;
		float num6 = 123;
		Integer num7 = new Integer("123");
		byte num8 = 123;
		System.out.println("Integer == float "+(num3 == num4)); //true
		System.out.println("double == float "+(num5 == num4));  // true
		System.out.println("float == int "+(num6 == num7));     // true
		System.out.println("int == byte? "+(num7 == num8));     // true
	}

	private static void testOperators()
	{
		byte b1 = 3;
		byte b2 = 4;
		System.out.println(b1+" += "+b2+" = ");
		// b1 = b1 + b2; // 1
		b1 += b2; // compilation successful
		System.out.println(b1);
		/* 1 compilation fails due to error: possible loss of precision.
		*/
		int x = 5;
		int y = 6;
		x += y += x += y;  
		System.out.println("A. x += y += x += y is x = "+x+" y = "+y);

		y = 7;
		y = ++y +y++; 
		System.out.println("B. y = ++y +y++ is "+y);

		y = 8;
		y = y + ++y +y++;
		System.out.println("C. y = y + ++y +y++ is "+y);

		y = 9;
		y = y + (++y + y++); // ?
		System.out.println("D. y = y + (++y + y++) is "+y);

		y = 10;		
		y = y++ + (y + y++);  // y=1 + 2 + 2 
		System.out.println("E. y++ + (y + y++) is "+y);

		x = 11;  
		int z = ++x * x * x--; // Prints 216  
		System.out.println("F. ++x * x * x-- is "+z);

		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		int i = 10;
		a = (b = i++) + (c = ++i) + (d = i--); 
		//    10			12			12
		System.out.println("G. a = (b = i++) + (c = ++i) + (d = i--) is a = "+a+" b = "+b+" c = "+c+" d "+d+" i "+i);

		x = 2;
    	z = ++x * x--;   // The output is 36 because x is incremented first.
    	System.out.println("H. z = ++x * x-- is x = "+x+" y = "+y+" z = "+z);
		x = 4;
		z = x++ * --x;
		System.out.println("I. x++ * --x is "+z);
		//This is 25.

	}

	private static void testOperators2()
	{
		byte b1 = 3;
		byte b2 = 4;
		System.out.println(b1+" += "+b2+" = ");
		// b1 = b1 + b2; // 1
		b1 += b2; // compilation successful
		System.out.println(b1);
		/* 1 compilation fails due to error: possible loss of precision.
		*/
		int x = 1;
		int y = 1;
		x += y += x += y;  
		System.out.println("A. x += y += x += y is x = "+x+" y = "+y);

		y = 1;
		y = ++y +y++; 
		System.out.println("B. y = ++y +y++ is "+y);

		y = 1;
		y = y + ++y +y++;
		System.out.println("C. y = y + ++y +y++ is "+y);

		y = 1;
		y = y + (++y + y++); // ?
		System.out.println("D. y = y + (++y + y++) is "+y);

		y = 1;		
		y = y++ + (y + y++);  // y=1 + 2 + 2 
		System.out.println("E. y++ + (y + y++) is "+y);

		x = 5;  
		int z = ++x * x * x--; // Prints 216  
		System.out.println("F. ++x * x * x-- is "+z);

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int i = 10;
		a = (b = i++) + (c = ++i) + (d = i--); 
		System.out.println("G. a = (b = i++) + (c = ++i) + (d = i--) is a = "+a+" b = "+b+" c = "+c+" d "+d+" i "+i);

		x = 5;
    	z = ++x * x--;   // The output is 36 because x is incremented first.
    	System.out.println("H. z = ++x * x-- is x = "+x+" y = "+y+" z = "+z);
		x = 5;
		z = x++ * --x;
		System.out.println("I. x++ * --x is "+z);
		
		x = 1;
		z = ++x + ++x + ++x;
		System.out.println("J. ++x + ++x + ++x is "+z);

		x = 1;
		z = x++ + x++ + x++;
		System.out.println("K. x++ + x++ + x++ is "+z);

		y = 1;		
		y = y++ + y++ + y++; 
		System.out.println("L. y++ + y++ + y++ is "+y);		
	}

	private static void testErrors()
	{
		//int and long operations / and % can throw an ArithmeticException, while float and double / and % never will (even in case of division by zero).
		//int i = 0/0; // / by zero runtime error:
		float l = -0.0f/0.0f; // no error		
		double d1 = 1.0;
		Double d2 = 1.0;
		System.out.println(d1 == d2);
		int num = -50;
		Object obj = num % 25.0;
		boolean b = obj instanceof Double;
		System.out.println(b); // true!
	}

	void testMethodVars()
	{
		final int a = 1;
		//static int b = 2; illegal start of expression.
		//a = 2; cannot assign a value to final variable.
		//float f = 3.1415; error: possible loss of precision.
		float f = 3.14f;
	}

	static void testExceptions() throws Exception
	{
		int i = 0;
		//int j = 1/i; java.lang.ArithmaticExcpetion: / by zero
		try {
			throw new Exception();
		} catch (Exception ne) {
			throw ne;
			//System.out.println("Inside Exception"); // unreachable
			//System.exit();
		} finally {
			System.out.println("Inside Finally");
		}
	}

	private static void testRuntimeErrors()
	{
		List list2 = new ArrayList<String>();
		list2.add(new StringBuilder("123"));
		//String sbu = list2.get(0); compile time error.
	}

	private static void testSubstring1()
	{
		StringBuilder b1 = new StringBuilder("snorkler");
		StringBuilder b2 = new StringBuilder("yoodler");
		b1.append(b2.substring(2,5).toUpperCase());
		System.out.println("b1 "+b1.toString());
		System.out.println("b2 "+b2);
	}

	private static void testSubstring2()
	{
		StringBuilder b1 = new StringBuilder("snorkler");
		StringBuilder b2 = new StringBuilder("yoodler");
		b2.insert(3,b1.append("a"));
		System.out.println("b1 "+b1.toString());
		System.out.println("b2 "+b2);
	}

	private static void testSubstring3()
	{
		System.out.println("testSubstring3---");
		StringBuilder b1 = new StringBuilder("snorkler");
		StringBuilder b2 = new StringBuilder("yoodler");
		b1.replace(3,4,b2.substring(4)).append(b2.append(false));
		System.out.println("b1 "+b1.toString());
	}

	private static void testSubstring4()
	{
		System.out.println("testSubstring3---");
		StringBuilder b1 = new StringBuilder("snorkler");
		StringBuilder b2 = new StringBuilder("yoodler");
		b1.replace(3,4,b2.substring(4)).append(b2.append(false));
		StringBuilder b1e = b1;
		StringBuilder b2e = b2;

		StringBuilder b2a = new StringBuilder("yoodler");
		String b2a1 = b2a.substring(4);
		System.out.println("b2.substring(4) "+b2a1);

		StringBuilder b1a = new StringBuilder("snorkler");
		StringBuilder b1a1 = b1a.replace(3,4,b2a1);
		System.out.println("b1.replace(3,4,"+b2a1+") "+b1a1);

		StringBuilder b2b = new StringBuilder("yoodler");
		StringBuilder b2b1 = b2b.append(false);
		System.out.println("b2.append(false) "+b2b1);
		
		System.out.println("answers: ---");
		System.out.println("b1 "+b1e);
		System.out.println("b2 "+b2e);

		//b2b.append("a").substring(0, 4).insert(2, "asdf");
		// not leagal as substring returns a String which has no insert method.
	}

	/**
	* With no break statement, counter goes to 27.
	* With a break inner statement, counter will be 18
	* With a break middle, it is only 3.
	* With a break outer statement, the counter will be 1. 
	*/
	private static void testLoops()
	{
		int counter = 0;
        outer:
        for (int i = 0; i < 3; i++) {
            middle:
            for (int j = 0; j < 3; j++) {
                inner:
                for (int k = 0; k < 3; k++) {
                	System.out.println("i="+i+" j="+j+" k="+k+" counter "+counter);
                    if (k - j > 0) {
                        break middle;
                    }
                    counter++;
                }
            }
        }
        System.out.println("counter "+counter);
	}

	private static void testStringBuilder()
	{
		StringBuilder sb = new StringBuilder("Hello ");
		byte b = 1;
		sb.append(b);
		int [] i = {1,2,3};
		sb.append(i);
		int hash_code = i.hashCode();
		sb.append(" "+hash_code);
		System.out.println(sb);
	}

	private static void testCharValues()
	{
		char retChar1 = 'x';
		char retChar2 = '\0'; 
		char retChar3 = (char) 0;
		char retChar4 = 65; //Which will give you an empty value of character
		Character g; 
		char s = 'a'; 
		char c = '\u0064';
		System.out.println("'\u0064' "+c);
		g = new Character(s); 
		s = g.charValue();
		System.out.println("s "+s);
		System.out.println("retChar1 "+retChar1);
		System.out.println("retChar2 "+retChar2);
		System.out.println("retChar3 "+retChar3);
		System.out.println("retChar4 "+retChar4);
	}

	private static void testInstanceof()
	{
		Object o1 = new Object();
		Object o2 = new Object();
		//System.out.println(o1 instanceof o2);
		System.out.println("o1 is an Object? "+(o1 instanceof Object));
		int x = 0;
		// while (false) { x=3; } x=3 is unreachable.
		short s = 9;
		Short sh = 9;
		Boolean b = sh instanceof Number;
		System.out.println(b);
		Integer in = 9;
		System.out.println(s == in);
		float f = 9f;
		System.out.println(s == f);
		char c = 9;
		System.out.println(s == c);
		int i = 9;
		Double d = 9.0;
		System.out.println(d == i); // if one is a primitive and the other a wrapper class, that's OK.
		//System.out.println(sh == i); // incomparable types if they are both wrapper classes.
	}

	private static void testLoop2()
	{
      boolean b = false;
      int i = 1;
      do{
      	System.out.println(b+" "+i);
         i++ ;
      } while (b = !b);
      System.out.println( i );
      float f = 3.0f;
      if (i==f)
      {
      	System.out.println(i+" == "+f);
      }
	}

	private static void testPromotion()
	{
		int i = 5;
		float f = 5.5f;
		double d = 3.8;
		char c = 'a';
		if (i == f) c++;
		if (((int) (f + d)) == ((int) f + (int) d)) c += 2;
		c += 2;
		System.out.println(c);
		int g = ((int) (f + d)); // 9
		int h = ((int) f + (int) d); // 8
		System.out.println(g+" "+h);
		int _100 = 100; 
		int bin = 0b01001110_00100000;
		int two = 0b100111000100000;
		System.out.println(bin);
		System.out.println(Integer.toBinaryString(bin));
		System.out.println(two);
		System.out.println(Integer.toBinaryString(two));
		int x = 5;
		int y = 10;
		int z = ++x * y--;
		System.out.println("x "+x+" y "+y+" z "+z);
	}

	private static void testFloat()
	{
		Float f1 = new Float(1.9);
		int i1 = f1.intValue();
		System.out.println("1.9 int value: "+i1);
		int i2 = 1_234_567_890;
		float f2 = i2;
		System.out.println("Before cast: "+f2);
		System.out.println(i2 - (int)f2);
	} 

	private static void testOrder()
	{
		System.out.println(getArray()[getIndex()]++);
	}

	private static int getIndex()
	{
		System.out.println("getIndex()");
		return 1;
	}

	private static int [] getArray()
	{
		System.out.println("getArray()");
		int [] s = {2,3};
		return s;
	}

	private static void testByte()
	{
		byte b = (byte)128;
		System.out.println(b);
		short s = 10;
		//char c = s;
		//s = c;
	}

	private static void testIntern()
	{
		String t = "Timothy";
		System.out.println(t.intern());
	}

	private static void testForSwitch()
	{
		char i;
        LOOP: for (i=0;i<5;i++){
            switch(i++){
                case '0': System.out.println("A");
                case 1: System.out.println("B"); break LOOP;
                case 2: System.out.println("C"); break;
                case 3: System.out.println("D"); break;
                case 4: System.out.println("E");
                case 'E' : System.out.println("F");
            }
        }

        int j = 0;
        switch (j++)
        {
        	default: System.out.println("j "+j); break;
        }

        int k = 0;
        switch (k++)
        {
        	case 0: System.out.println("k is 0 "+k); break;
        	case 1: System.out.println("k is 1 "+k); break;
        }
	}

	public static void switchTest(byte x)
	{
		switch(x){
      	case -2: System.out.println("case -1"); break;
      	default : System.out.println("default"); break;
      	case 80: System.out.println("case80"); break;
   		}
	}

	private static void testInitialization()
	{
		// int a = b = c = 100;  cannot find symbols b and c.
		int b , c; //Not initializing b and c here.   
		int a = b = c = 100; //declaring a and initializing c, b, and a at the same time.
	}

	public static void ifTest(boolean flag){
   		if (flag)   //1
   		if (flag)   //2
   		if (flag)   //3
   		System.out.println("False True");
   		else        //4
   		System.out.println("True False");
   		else        //5
   		System.out.println("True True");
   		else        //6
   		System.out.println("False False");
	}

	private static void testStrings()
	{
		System.out.println("a"+'b'+63);
		System.out.println("a"+63);
		System.out.println('b'+new Integer(63));
		String s = 'b'+63+"a";
		System.out.println(s);
		//String s2 = 63 + new Integer(10);
		//System.out.println(s2);
	}

	private static void testDoubleAndFloat()
	{
		double num = 0.2;
		if (num == 0.2f)
			System.out.println("true");
		else
			System.out.println("false");

		float num2 = 0.2f;
		if (num == num2)
			System.out.println("true");
		else
			System.out.println("false");
		System.out.println("num :"+num);
		System.out.println("num2:"+num2);
	}

	public static void testNumbers2()
	{
		byte num_byt = 2;
		char num_cha = 2;
		short num_sho = 2;
		int num_int = 2;
		float num_flo = 2.0f;
		long num_lon = 2;
		double num_dou= 2;

		final byte f_num_byt = 2;
		final char f_num_cha = 2;
		final short f_num_sho = 2;
		final int f_num_int = 2;
		final float f_num_flo = 2.0f;
		final long f_num_lon = 2;
		final double f_num_dou= 2;

		System.out.println("plop = possible loss of precision");
		System.out.println("byte = byte   "+(num_byt = num_byt));
		System.out.println("byte = char   plop");//+(num_byt = num_cha));
		System.out.println("byte = short  plop");//+(num_byt = num_sho));
		System.out.println("byte = int    plop");//+(num_byt = num_int));
		System.out.println("byte = float  plop");//+(num_byt = num_flo));
		System.out.println("byte = long   plop");//+(num_byt = num_lon));
		System.out.println("byte = double plop");//+(num_byt = num_dou));
		System.out.println("with finals");
		System.out.println("byte = final byte   "+(num_byt = f_num_byt));
		System.out.println("byte = final char   "+(num_byt = f_num_cha));
		System.out.println("byte = final short  "+(num_byt = f_num_sho));
		System.out.println("byte = final int    "+(num_byt = f_num_int));
		System.out.println("byte = final float  plop");//+(num_byt = f_num_flo));
		System.out.println("byte = final long   plop");//+(num_byt = f_num_lon));
		System.out.println("byte = final double plop");//+(num_byt = f_num_dou));
		
		System.out.println("");
		System.out.println("char = byte   plop");//"+(num_cha = num_byt));
		System.out.println("char = char   "+(num_cha = num_cha));
		System.out.println("char = short  plop");//"+(num_cha = num_sho));
		System.out.println("char = int    plop");//"+(num_cha = num_int));
		System.out.println("char = float  plop");//"+(num_cha = num_flo));
		System.out.println("char = long   plop");//"+(num_cha = num_lon));
		System.out.println("char = double plop");//"+(num_cha = num_dou));
		System.out.println("with finals");
		System.out.println("char = final byte   "+(num_cha = f_num_byt));
		System.out.println("char = final char   "+(num_cha = f_num_cha));
		System.out.println("char = final short  "+(num_cha = f_num_sho));
		System.out.println("char = final int    "+(num_cha = f_num_int));
		System.out.println("char = final float  plop");//+(num_cha = f_num_flo));
		System.out.println("char = final long   plop");//+(num_cha = f_num_lon));
		System.out.println("char = final double plop");//+(num_cha = f_num_dou));

		System.out.println("");
		System.out.println("short = byte   "+(num_sho = num_byt));
		System.out.println("short = char   plop");//"+(num_sho = num_cha));
		System.out.println("short = short  "+(num_sho = num_sho));
		System.out.println("short = int    plop");//"+(num_sho = num_int));
		System.out.println("short = float  plop");//"+(num_sho = num_flo));
		System.out.println("short = long   plop");//"+(num_sho = num_lon));
		System.out.println("short = double plop");//"+(num_sho = num_dou));
		System.out.println("with finals");
		System.out.println("short = final byte   "+(num_sho = f_num_byt));
		System.out.println("short = final char   "+(num_sho = f_num_cha));
		System.out.println("short = final short  "+(num_sho = f_num_sho));
		System.out.println("short = final int    "+(num_sho = f_num_int));
		System.out.println("short = final float  plop");//+(num_sho = f_num_flo));
		System.out.println("short = final long   plop");//+(num_sho = f_num_lon));
		System.out.println("short = final double plop");//+(num_sho = f_num_dou));

		System.out.println("");
		System.out.println("int = byte   "+(num_int = num_byt));
		System.out.println("int = char   "+(num_int = num_cha));
		System.out.println("int = short  "+(num_int = num_sho));
		System.out.println("int = int    "+(num_int = num_int));
		System.out.println("int = float  plop");//"+(num_int = num_flo));
		System.out.println("int = long   plop");//"+(num_int = num_lon));
		System.out.println("int = double plop");//"+(num_int = num_dou));
		System.out.println("with finals");
		System.out.println("int = byte   "+(num_int = f_num_byt));
		System.out.println("int = char   "+(num_int = f_num_cha));
		System.out.println("int = short  "+(num_int = f_num_sho));
		System.out.println("int = int    "+(num_int = f_num_int));
		System.out.println("int = float  ");//+(num_int = f_num_flo));
		System.out.println("int = long   ");//+(num_int = f_num_lon));
		System.out.println("int = double ");//+(num_int = f_num_dou));

		System.out.println("");
		System.out.println("float = byte   "+(num_flo = num_byt));
		System.out.println("float = char   "+(num_flo = num_cha));
		System.out.println("float = short  "+(num_flo = num_sho));
		System.out.println("float = int    "+(num_flo = num_int));
		System.out.println("float = float  "+(num_flo = num_flo));
		System.out.println("float = long   "+(num_flo = num_lon));
		System.out.println("float = double ");//"+(num_flo = num_dou));
		System.out.println("with finals");
		System.out.println("float = final double plop");//+(num_flo = f_num_dou));

		System.out.println("");
		System.out.println("long = byte   "+(num_lon = num_byt));
		System.out.println("long = char   "+(num_lon = num_cha));
		System.out.println("long = short  "+(num_lon = num_sho));
		System.out.println("long = int    "+(num_lon = num_int));
		System.out.println("long = float   plop");//"+(num_lon = num_flo));
		System.out.println("long = long   "+(num_lon = num_lon));
		System.out.println("long = double  plop");//"+(num_lon = num_dou));

		System.out.println("");
		System.out.println("double = byte   "+(num_dou = num_byt));
		System.out.println("double = char   "+(num_dou = num_cha));
		System.out.println("double = short  "+(num_dou = num_sho));
		System.out.println("double = int    "+(num_dou = num_int));
		System.out.println("double = float  "+(num_dou = num_flo));
		System.out.println("double = long   "+(num_dou = num_lon));
		System.out.println("double = double "+(num_dou = num_dou));
		System.out.println("");	
		System.out.println("double == float "+(num_dou == num_flo));
		System.out.println("--------------- ");
	}

	public static void testNumbers2_5()
	{
		final byte x = 64;
		final byte y = 63;
		byte z = x / y;// Compilation error it no longer fits in byte
		System.out.println("z "+z);	

		byte num_byt = 2;
		char num_cha = 2;
		short num_sho = 2;
		int num_int = 2;
		float num_flo = 2.0f;
		long num_lon = 2;
		double num_dou= 2;
		Byte wrapper_byt = 2;
		Character wrapper_cha = 2;
		Short wrapper_sho = 2;
		Integer wrapper_int = 2;
		Float wrapper_flo = 2.0f;
		Long wrapper_lon = 2L;
		Double wrapper_dou = 2D;
		
		System.out.println("");
		System.out.println("byte == byte   "+(num_byt == num_byt));
		System.out.println("byte == char   "+(num_byt == num_cha));
		System.out.println("byte == short  "+(num_byt == num_sho));
		System.out.println("byte == int    "+(num_byt == num_int));
		System.out.println("byte == float  "+(num_byt == num_flo));
		System.out.println("byte == long   "+(num_byt == num_lon));
		System.out.println("byte == double "+(num_byt == num_dou));
		System.out.println("");
		System.out.println("byte == Byte   		"+(num_byt == wrapper_byt));
		System.out.println("byte == Character   "+(num_byt == wrapper_cha));
		System.out.println("byte == Short  		"+(num_byt == wrapper_sho));
		System.out.println("byte == Integer    	"+(num_byt == wrapper_int));
		System.out.println("byte == Float  		"+(num_byt == wrapper_flo));
		System.out.println("byte == Long   		"+(num_byt == wrapper_lon));
		System.out.println("byte == Double 		"+(num_byt == wrapper_dou));
		System.out.println("");
		System.out.println("Byte.equals(byte)   "+(wrapper_byt.equals(num_byt)));
		System.out.println("byte.equals(char)   "+(wrapper_byt.equals(num_cha)));
		System.out.println("byte.equals(short)  "+(wrapper_byt.equals(num_sho)));
		System.out.println("byte.equals(int)    "+(wrapper_byt.equals(num_int)));
		System.out.println("byte.equals(float)  "+(wrapper_byt.equals(num_flo)));
		System.out.println("byte.equals(long)  	"+(wrapper_byt.equals(num_lon)));
		System.out.println("byte.equals(double) "+(wrapper_byt.equals(num_dou)));


		System.out.println("");
		System.out.println("char == byte   "+(num_cha == num_byt));
		System.out.println("char == char   "+(num_cha == num_cha));
		System.out.println("char == short  "+(num_cha == num_sho));
		System.out.println("char == int    "+(num_cha == num_int));
		System.out.println("char == float  "+(num_cha == num_flo));
		System.out.println("char == long   "+(num_cha == num_lon));
		System.out.println("char == double "+(num_cha == num_dou));
		System.out.println("");
		System.out.println("char == Byte   		"+(num_cha == wrapper_byt));
		System.out.println("char == Character   "+(num_cha == wrapper_cha));
		System.out.println("char == Short  		"+(num_cha == wrapper_sho));
		System.out.println("char == Integer    	"+(num_cha == wrapper_int));
		System.out.println("char == Float  		"+(num_cha == wrapper_flo));
		System.out.println("char == Long   		"+(num_cha == wrapper_lon));
		System.out.println("char == Double 		"+(num_cha == wrapper_dou));
	}

	public static void testNumbers3()
	{
		byte num_byt = 2;
		char num_cha = 2;
		short num_sho = 2;
		int num_int = 2;
		float num_flo = 2.0f;
		long num_lon = 2;
		double num_dou= 2;

		Byte wrapper_byt = 2;
		Character wrapper_cha = 2;
		Short wrapper_sho = 2;
		Integer wrapper_int = 2;
		Float wrapper_flo = 2.0f;
		Long wrapper_lon = 2L;
		Double wrapper_dou = 2D;

		System.out.println("Byte = primitive");
		System.out.println("Byte = byte   "+(wrapper_byt = num_byt));
		System.out.println("Byte = char   incompatible types ");//+(wrapper_byt = num_cha));
		System.out.println("Byte = short  incompatible types ");//"+(wrapper_byt = num_sho));
		System.out.println("Byte = int    incompatible types ");//"+(wrapper_byt = num_int));
		System.out.println("Byte = float  incompatible types ");//"+(wrapper_byt = num_flo));
		System.out.println("Byte = long   incompatible types ");//"+(wrapper_byt = num_lon));
		System.out.println("Byte = double incompatible types ");//"+(wrapper_byt = num_dou));
		System.out.println("primitive = Wrapper");
		System.out.println("byte = Byte      "+(num_byt = wrapper_byt));
		System.out.println("byte = Character incompatible types ");//"+(num_byt = wrapper_cha));
		System.out.println("byte = Short  	 incompatible types ");//"+(num_byt = wrapper_sho));
		System.out.println("byte = Interger  incompatible types ");//"+(num_byt = wrapper_int));
		System.out.println("byte = Float  	 incompatible types ");//"+(num_byt = wrapper_flo));
		System.out.println("byte = Long   	 incompatible types ");//"+(num_byt = wrapper_lon));
		System.out.println("byte = Double 	 incompatible types ");//"+(num_byt = wrapper_dou));

		System.out.println("");
		System.out.println("Character = byte      incompatible types ");//"+(wrapper_cha = num_byt));
		System.out.println("Character = byte   incompatible types ");//+(wrapper_cha = num_byt));
		System.out.println("Character = char   "+(wrapper_cha = num_cha));
		System.out.println("Character = short  incompatible types ");//+(wrapper_cha = num_sho));
		System.out.println("Character = int    incompatible types ");//+(wrapper_cha = num_int));
		System.out.println("Character = float  incompatible types ");//+(wrapper_cha = num_flo));
		System.out.println("Character = long   incompatible types ");//+(wrapper_cha = num_lon));
		System.out.println("Character = double incompatible types ");//+(wrapper_cha = num_dou));

		System.out.println("");
		System.out.println("char = Byte      	  incompatible types ");//"+(cha_byt = wrapper_byt));

		// int = Wrapper
		System.out.println("");
		System.out.println("int = Wrapper");
		System.out.println("int = Byte      "+(num_int = wrapper_byt));
		System.out.println("int = Character "+(num_int = wrapper_cha));
		System.out.println("int = Short  	"+(num_int = wrapper_sho));
		System.out.println("int = Interger  "+(num_int = wrapper_int));
		System.out.println("int = Float  	incompatible types ");//"+(num_int = wrapper_flo));
		System.out.println("int = Long   	incompatible types ");//"+(num_int = wrapper_lon));
		System.out.println("int = Double 	incompatible types ");//"+(num_int = wrapper_dou));
		// Integer = primitive
		System.out.println("");	
		System.out.println("Integer = primitive");
		System.out.println("Integer = byte   incompatible types ");//"+(wrapper_int = num_byt));
		System.out.println("Integer = char   incompatible types ");//"+(wrapper_int = num_cha));
		System.out.println("Integer = short  incompatible types ");//"+(wrapper_int = num_sho));
		System.out.println("Integer = int    "+(wrapper_int = num_int));
		System.out.println("Integer = float  incompatible types ");//"+(wrapper_int = num_flo));
		System.out.println("Integer = long   incompatible types ");//"+(wrapper_int = num_lon));
		System.out.println("Integer = double incompatible types ");//"+(wrapper_int = num_dou));

		// float = Wrapper
		System.out.println("");
		System.out.println("float = Wrapper");
		System.out.println("float = Byte      "+(num_flo = wrapper_byt));
		System.out.println("float = Character "+(num_flo = wrapper_cha));
		System.out.println("float = Short  	"+(num_flo = wrapper_sho));
		System.out.println("float = Interger  "+(num_flo = wrapper_int));
		System.out.println("float = Float  	"+(num_flo = wrapper_flo));
		System.out.println("float = Long   	"+(num_flo = wrapper_lon));
		System.out.println("float = Double 	incompatible types ");//"+(num_flo = wrapper_dou));
		
		System.out.println("");	
		System.out.println("Float = primitive");
		System.out.println("Float = byte   incompatible types ");//"+(wrapper_flo = num_byt));
		System.out.println("Float = char   incompatible types ");//"+(wrapper_flo = num_cha));
		System.out.println("Float = short  incompatible types ");//"+(wrapper_flo = num_sho));
		System.out.println("Float = int    incompatible types ");//"+(wrapper_flo = num_int));
		System.out.println("Float = float  "+(wrapper_flo = num_flo));
		System.out.println("Float = long   incompatible types ");//"+(wrapper_flo = num_lon));
		System.out.println("Float = double incompatible types ");//"+(wrapper_flo = num_dou));


		// long to Wrapper
		System.out.println("");
		System.out.println("long = Wrapper");
		System.out.println("long = Byte      "+(num_lon = wrapper_byt));
		System.out.println("long = Character "+(num_lon = wrapper_cha));
		System.out.println("long = Short  	"+(num_lon = wrapper_sho));
		System.out.println("long = Interger  "+(num_lon = wrapper_int));
		System.out.println("long = Float  	incompatible types");//+(num_lon = wrapper_flo));
		System.out.println("long = Long   	"+(num_lon = wrapper_lon));
		System.out.println("long = double 	incompatible types");//+(num_lon = wrapper_dou));
		
		System.out.println("");	
		System.out.println("Long = primitive");
		System.out.println("Long = byte   incompatible types ");//"+(wrapper_dou = num_byt));
		System.out.println("Long = char   incompatible types ");//"+(wrapper_dou = num_cha));
		System.out.println("Long = short  incompatible types ");//"+(wrapper_dou = num_sho));
		System.out.println("Long = int    incompatible types ");//"+(wrapper_dou = num_int));
		System.out.println("Long = float  incompatible types ");//"+(wrapper_dou = num_flo));
		System.out.println("Long = long   incompatible types ");//"+(wrapper_dou = num_lon));
		System.out.println("Long = double "+(wrapper_dou = num_dou));
		

		// dobule to Wrapper
		System.out.println("");
		System.out.println("double = Wrapper");
		System.out.println("double = Byte      "+(num_dou = wrapper_byt));
		System.out.println("double = Character "+(num_dou = wrapper_cha));
		System.out.println("double = Short  	"+(num_dou = wrapper_sho));
		System.out.println("double = Interger  "+(num_dou = wrapper_int));
		System.out.println("double = Float  	"+(num_dou = wrapper_flo));
		System.out.println("double = Long   	"+(num_dou = wrapper_lon));
		System.out.println("double = Double 	"+(num_dou = wrapper_dou));
		
		System.out.println("");	
		System.out.println("Double = primitive");
		System.out.println("Double = byte   incompatible types ");//"+(wrapper_dou = num_byt));
		System.out.println("Double = char   incompatible types ");//"+(wrapper_dou = num_cha));
		System.out.println("Double = short  incompatible types ");//"+(wrapper_dou = num_sho));
		System.out.println("Double = int    incompatible types ");//"+(wrapper_dou = num_int));
		System.out.println("Double = float  incompatible types ");//"+(wrapper_dou = num_flo));
		System.out.println("Double = long   incompatible types ");//"+(wrapper_dou = num_lon));
		System.out.println("Double = double "+(wrapper_dou = num_dou));
	}

	private static void testArrays()
	{
		char [] data = {'t','i','m','o','t','h','y'};
		//char [] date = {'timoteus'};
		String s = String.copyValueOf(data, 0, 3); // concats the chars
		char [] tim = new char[3];
		s.getChars(0,3,tim,0); // fills tim with the first three letters
		for (char c: tim)
		{
			System.out.print(c);
		}
		/* removed Korean characters
		int code_point = verb.codePointCount(0,1);
		int dong = verb.indexOf();
		System.out.println(code_point+" "+dong);
		String timo = "timo";
		String tima = "tima";
		boolean matches = timo.regionMatches(0, tima, 0, 3); // true
		System.out.println(matches);
		*/
	}

	private static void testValueOf()
	{
		String binary = "01000000";
		int result = Integer.valueOf(binary,2);
		System.out.println(result);
	}

	private static void testWappers()
	{
		Byte b = new Byte("0");
		Character c = new Character('`');
		Short s = new Short((short)0);
		Integer i = new Integer(0);
		Float f = new Float(0);
		Long l = new Long(0);
		Double d = new Double(0);

		byte by = 0;
		char ch = (char)0;
		ch = '\0';
		ch = '\u0000';
		short sh = 0;;
		int in = 0;
		float fl = 0;
		long lo = 0;
		double do1 = 0;
		System.out.println(b.equals(b));
		System.out.println(b.equals(c));
		System.out.println(b.equals(s));
		System.out.println(b.equals(i));
		System.out.println(b.equals(f));
		System.out.println(b.equals(l));
		System.out.println(b.equals(d));
		System.out.println("");
		System.out.println(i == ch);
		System.out.println(i == sh);
		System.out.println(i == in);
		System.out.println(i == fl);
		System.out.println(i == lo);
		System.out.println(i == do1);

	}

	public static void testLessThanOrEqualTo()
	{
		int num;
		for (num = 0; num <= 10; num++)
		{
			System.out.println("num "+num);
		}
		System.out.println("num at end of loop "+num);
	}

	private static void testInstanceOf()
	{
		Object o = 1;
		if (o instanceof Integer)
		{
			System.out.println("OK!");
		}
	}

	private static void testPrecedence()
	{
		int a = 6;
		int b = 5;
		int c = 10;
		int rs = a + ++b * c / a * b;
		System.out.println(rs);
		rs = a + (++b)* ((c / a)* b);
		System.out.println(rs);	

		int d = 1;
		int e = 2;
		int f = 3;
		int g = f / e / d;
		System.out.println(g);

		System.out.println((72 / 2) / 3);
	}

	public float parseFloat(String s){
   		float f = 0.0f;
   		try{
      		f = Float.valueOf(s).floatValue();
      		return f ;
   		}
   		catch(NumberFormatException nfe){
      		System.out.println("Invalid input " + s);
      		f = Float.NaN ;
      		return f;
   		}
   		finally { System.out.println("finally");  }
   		return f ;
	}

	public static void main(String args[]) 
	{
		ExamQuestions eq = new ExamQuestions();
		if (args.length > 0)
		{
			int nd = Integer.parseInt(args[0]);
			System.out.println(nd);
		}
		//testArrays();
		//testExamQuestions();
		//testEquals();
		//testBitwise();
		//randomCode();
		//unorthadoxUnary();
		//basicFailedQuestions();
		//failedRegex();
		//payRollExample();
		//Class ExamQuestions = ExamQuestions.class;
		//arrayWork();
		//aMethod("0");
		// int, long, float, double, Integer, Object, error
		//aMethod(0.0f);
		// float, double, Float, Object, error.
		//testIO();
		//testException();
		//testNumbers2();
		testNumbers2_5();
		//testNumbers3();
		//testOperators();
		//System.out.println("");
		//testOperators2();
		//testErrors();
		try
		{
			//testExceptions();
		} catch (Exception e)
		{
			System.out.println("e");
		}
		//ExamQuestions eq = new ExamQuestions();
		//testRuntimeErrors();
		//boolean b = 1; // incomatible types.
		//testSubstring1();
		//testSubstring2();
		//testSubstring3();
		//testLoops();
		//testStringBuilder();
		//testCharValues();
		//testInstanceof();
		//testLoop2();
		//testPromotion();
		//testFloat();
		//testOrder();
		//testByte();
		//testIntern();
		//testForSwitch();
		//switchTest((byte)81);
		//ifTest(false);
		//ifTest(true);
		//testStrings();
		//testDoubleAndFloat();
		//testNumbers2();
		//System.out.printf("Hi %03d", 1);
		//testValueOf();
		//testWappers();
		//testNan();
		//testLessThanOrEqualTo();
		//testInstanceOf();
		//testPrecedence();
		//testBooleans();
	}
}