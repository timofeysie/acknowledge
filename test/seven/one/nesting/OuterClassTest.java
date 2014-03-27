package seven.one.nesting;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class OuterClassTest extends TestCase 
{

    static Logger log = Logger.getLogger(OuterClassTest.class);

	public void testAccessOuter()
    {
    	log.info("");
    	log.info(this.getClass().getSimpleName());
		log.info("Another class could only run the code if it has access to our outer class becuase it has default, or package access so any class within the same package as OuterClass will be able to run the code above without any issues.");
		OuterClass outer = new OuterClass(); 
		OuterClass.InnerClass inner1 = outer.new InnerClass(); 
		inner1.accessOuter();
		log.info("one line version:");
		log.info("OuterClass.InnerClass inner = new OuterClass().new InnerClass().accessOuter();");
		log.info("The 'new' keyword creates the inner class instance.  The 'new' keyword on an existing instance, instead of using the 'new' keyword to create a brand new instance.");
		OuterClass.InnerClass inner = new OuterClass().new InnerClass();
		inner.accessOuter();

		log.info("Nested Class");
		log.info("OuterClass.Nested nested = new OuterClass.Nested();");
		OuterClass.Nested nested = new OuterClass.Nested(); 
		nested.nestedClassMethod(); 
		//outer.outerClassMethod(); // has private access in OuterClass

	}

}