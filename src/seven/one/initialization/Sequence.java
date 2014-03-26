package seven.one.initialization;
import org.apache.log4j.Logger;
public class Sequence extends SuperSequence
{ 
	static Logger log = Logger.getLogger(Sequence.class);
	Sequence() {log.info("c: constructor"); } 
	{log.info("y: normal init block"); } 
	public static void main(String[] args) 
	{ 
		log.info("1st Object -------");
		new Sequence().go(); 
		log.info("2nd Object -------");
		Sequence s = new Sequence();
		s.go();
	} 
	void go() {log.info("g: go method"); } 
	static {log.info("w: static init block"); } 
	{log.info("z: normal init block"); } 
	static {log.info("x: static init block"); } 
} 