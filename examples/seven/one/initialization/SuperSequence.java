package seven.one.initialization;

import org.apache.log4j.Logger;

class SuperSequence extends SuperSuper
{
	static Logger log = Logger.getLogger(SuperSequence.class);
	
	SuperSequence(){log.info("s: super constructor");}
}