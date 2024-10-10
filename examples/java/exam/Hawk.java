class Bird 
{ 
	{ System.out.print("i1 "); } 
	public Bird() 
	{ System.out.print("c1 "); } 
} 
class Raptor extends Bird 
{ 
	static { System.out.print("si1 "); } 
	public Raptor() { System.out.print("c2 "); } 
	{ System.out.print("i2 "); } 
	static { System.out.print("si2 "); } 
} 
class Hawk extends Raptor 
{ 
	public static void main(String[] args) { 
	System.out.print("main "); 
	new Hawk(); 
	System.out.println("hawk "); 
	} 
}