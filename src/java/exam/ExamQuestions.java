import java.lang.StringBuffer;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

public class ExamQuestions
{

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
	//Integer num_123S = Integer.parseInt("123L");
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
		System.out.println("Integer == float "+(num3 == num4));
		System.out.println("double == float "+(num5 == num4));
		System.out.println("float == int "+(num6 == num7));
		System.out.println("int == byte? "+(num7 == num8));
		System.out.println(num1 == num2); // false
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

	private static void failedFinalMockExamQuestions()
	{
		String str = "Java*JSP*EJB*J2EE";
		System.out.println(Arrays.toString(str.split("*",-2)));
		/* java.util.regex.PatternSyntaxException:
		Dangling meta character * near index 0.
		PatternSysntaxException occurs if the regular expressions's
		syntx is invalid.  Note that to use "*" as a delimiter,
		we have to specify "\\*" as the regular expression.
		Given that, we would split the string into
		[Java, JSP, EJB, J2EE]
		Also, the -2 is not needed; the same output is got without it.
		*/
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
	}

	public static void main(String args[]) 
	{
		//testExamQuestions();
		//testEquals();
		//testBitwise();
		//randomCode();
		//unorthadoxUnary();
		//basicFailedQuestions();
		//failedFinalMockExamQuestions();
		//payRollExample();
		//Class ExamQuestions = ExamQuestions.class;
		arrayWork();
	}
}