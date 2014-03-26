package seven.one.initialization;

import org.apache.log4j.Logger;

public class Sequence extends SuperSequence
{ 
	static Logger log = Logger.getLogger(Sequence.class);

	Sequence() { System.out.println("c: constructor"); } 

	{System.out.println("y: normal init block"); } 
	
	public static void main(String[] args) 
	{ 
		log.info("1st Object -------");
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