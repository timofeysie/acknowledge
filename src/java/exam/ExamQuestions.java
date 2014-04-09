import java.lang.StringBuffer;
import java.util.Vector;

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

public static void main(String args[]) 
{
	ExamQuestions qs = new ExamQuestions();
	qs.trueOrFalse();	
	qs.trueOrFalse2();
	qs.StringBuilderQuestion();	
	qs.testLoop();
	qs.initDataTypes();
	testEquals();
	testBitwise();
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
	String[] arr = (String[])set.toArray();
}

}