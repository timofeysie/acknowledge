class TestOperatorsPrecedence 
{ 
/* Play with this order:
postfix         expr++ expr--  
unary           ++expr --expr +expr -expr ~ !  
multiplicative  * / %  
additive        + -  
shift           << >> >>>  
relational      < > <= >= instanceof  
equality        == !=  
bitwise AND     &  
bitwise exclusive OR    ^  
bitwise inclusive OR    |  
logical AND     &&  
logical OR      ||  
ternary         ? :  
assignment      = += -= *= /= %= &= ^= |= <<= >>= >>>=
*/

public static void main(String[] args) 
{
	int i = 1;
	int j = 1;
	int k = ++i * j++;
	System.out.println("i "+i+" j "+j+" k "+k); 
	convertDecimal(18);	
	TestOperatorsPrecedence top = new TestOperatorsPrecedence();
	top.test();
}

/*
1. Convert 18 to binary 0001 0010
2. Interchanging 0s and 1s 1110 1101
3. Adding 1 -- 1110 11
*/
private static void convertDecimal(int bin)
{
	// int bin = Integer.parseInt(binn); // no suitable method
	System.out.println(bin);
	System.out.println(""+Integer.toBinaryString(bin));
	bin = ~bin;
	System.out.println("~ "+Integer.toBinaryString(bin)+" "+bin);
	bin+=1;
	System.out.println("+= "+Integer.toBinaryString(bin)+" "+bin);
	System.out.println("= "+bin);
	bin = bin>>1;
	System.out.println(">> 1 "+Integer.toBinaryString(bin)+" "+bin);
	bin = bin << 1;
	System.out.println("<< 1 "+Integer.toBinaryString(bin)+" "+bin);
	bin = bin >>> 1;
	System.out.printf(">>> "+Integer.toBinaryString(bin)+" "+bin);
}

private void test()
{
	ValueObject obj1 = new ValueObject(); obj1.value = "first";
	ValueObject obj2 = new ValueObject(); obj2.value = "first";
	ValueObject obj3 = obj1;
	boolean test1 = (obj1.value == obj2.value); //false
	boolean test2 = (obj1.value == obj3.value); //true
	System.out.printf(test1+" "+test2);

}

public class ValueObject
{
	public String value;
}

} 