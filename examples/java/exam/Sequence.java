class SuperSuper
{
	SuperSuper(){System.out.println("S: super super constructor");}
}
class SuperSequence extends SuperSuper
{
	SuperSequence(){System.out.println("s: super constructor");}
}
public class Sequence extends SuperSequence
{ 
	Sequence() { System.out.println("c: constructor"); } 

	{System.out.println("y: normal init block"); } 
	
	public static void main(String[] args) 
	{ 
		System.out.println("1st Object -------");
		new Sequence().go(); 
		System.out.println("2nd Object -------");
		Sequence s = new Sequence();
		s.go();
	} 
	
	void go() {System.out.println("g: go method"); } 

	static {System.out.println("w: static init block"); } 

	{System.out.println("z: normal init block"); } 
	
	static {System.out.println("x: static init block"); } 
} 