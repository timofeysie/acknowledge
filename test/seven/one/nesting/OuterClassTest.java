package seven.one.nesting;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class OuterClassTest extends TestCase 
{

    static Logger log = Logger.getLogger(OuterClassTest.class);

	public void testAccessOuter()
    {
    	log.info("");
    	log.info("###"+this.getClass().getSimpleName()+"###");
		log.info("Another class could only run the code if it has access to our outer class  ");
		log.info("becuase it has default, or package access so any class within the same  ");
		log.info("package as OuterClass will be able to run the code below without any issues.  ");
		log.info("OuterClass outer = new OuterClass();");
		log.info("OuterClass.InnerClass inner1 = outer.new InnerClass();");
		OuterClass outer = new OuterClass(); 
		OuterClass.InnerClass inner1 = outer.new InnerClass(); 
		inner1.accessOuter();
		log.info("A one line version:");
		log.info("OuterClass.InnerClass inner = new OuterClass().new InnerClass().accessOuter();");
		log.info("The 'new' keyword creates the inner class instance frpm an existing outer class instance,");
		log.info("instead of using the 'new' keyword to create a brand new instance.");
		OuterClass.InnerClass inner = new OuterClass().new InnerClass();
		//inner.accessOuter(); 
		log.info("");
		log.info("Nested Class");
		log.info("OuterClass.Nested nested = new OuterClass.Nested();");
		OuterClass.NestedClass nested = new OuterClass.NestedClass(); 
		log.info("nested.nestedClassMethod(); // This is OK");
		nested.nestedClassMethod(); 
		//outer.outerClassMethod();
		log.info("outer.outerClassMethod(); // but does not compile");
		log.info("This has private access in OuterClass");
	}

	public void createAnonymousSubclassOfSomeClass()
	{
		OuterClass outer = new OuterClass(); 
		log.info("");
		log.info("Creating an instance of a subclass of SomeClass where");
		log.info("methods are being defined at the same time that an instance of a class is created.");
		log.info("It's anonymous because the subclass has no name");
		log.info("SomeClass anonymous = new SomeClass() {");
  		log.info("    public void someClassMethod() {log.info(anonymous method call);}};");
  		log.info("");
  		log.info("This would create an instance of the Anonymous class:");
		log.info("SomeClass some_class = new SomeClass();");	
  		log.info("inner.createAnonymousSubclassOfSomeClass();");
  		log.info("error: cannot find symbol: method createAnonymousSubclassOfSomeClass()");
  		log.info("location: vaiable inner of type OuterClass.InnerClass");
  		log.info("");
  		log.info("");
  		log.info("the implications of an anonymous inner class using polymorphism are that");
  		log.info("using the anonymous inner class reference variable type you can only call methods");
  		log.info("that are defined inside the type (the class) of the reference variable. ");
  		log.info("Using our example, this means that with anonymous reference we can only call methods");
  		log.info("that are defined inside SomeClass.");
  		outer.createAnonymousSubclassOfSomeClass();

  		log.info("if we try to invoke a method that is defined inside our anonymous class");
  		log.info("which is not overridden from the superclass, using our anonymous inner class reference,");
  		log.info("then we will get an error.");
  		log.info("```");
		log.info("SomeClass anonymous = new SomeClass() ");
		log.info("{");
  		log.info("	public void someClassMethod() {log.info(anonymous method call);}");
  		log.info("	public void anonymousSubclassMethod(){log.info(Can we do this?);}");
  		log.info("};");
  		log.info("// regular declaration);");
		log.info("SomeClass some_class = new SomeClass();");
		log.info("anonymous.someClassMethod();	");
		log.info("```");
	}

}