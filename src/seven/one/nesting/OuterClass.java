package seven.one.nesting;

import org.apache.log4j.Logger;

class OuterClass 
{
	static Logger log = Logger.getLogger(OuterClass.class);
	private int privInt = 10;
	int instanceVar = 5;

	class InnerClass 
	{  
		public void accessOuter() 
		{
			log.info("InnerClass.accessOuter: The outer class's privInt is "
			 + privInt);
		} 
	}

	private void outerClassMethod()
	{
		log.info("OuterClassMethod: inside the OuterClass create the inner class directly.");
		log.info("InnerClass inClass = new InnerClass();");
		InnerClass inClass = new InnerClass();
	}

	static class NestedClass 
	{
		void nestedClassMethod() 
		{
			log.info("Nestic Class Method: "); 
			// instanceVar = 10;
			log.info("non-static variables cannot be accessed from a static context");
		}
	}

	public class SomeClass
	{
		public void someClassMethod() {log.info("someClassMethod");}
	}

	public void createAnonymousSubclassOfSomeClass()
	{
		SomeClass anonymous = new SomeClass() 
		{
  			public void someClassMethod() {log.info("anonymous method call");}
  			public void anonymousSubclassMethod(){log.info("extended class metod only");}
  		};
  		// regular declaration
		SomeClass some_class = new SomeClass();

		anonymous.someClassMethod();	
		//anonymous.anonymousSubclassMethod(); // no no no
		// can only call methods in the super class
	}

	public static void main(String[] args) 
	{
		//create instance of outer class first:
		OuterClass outClass = new OuterClass(); 
		OuterClass.InnerClass inner = outClass.new InnerClass(); 
		outClass.outerClassMethod();
		inner.accessOuter();

		OuterClass.NestedClass nested = new OuterClass.NestedClass(); 
		nested.nestedClassMethod(); 

		NestedClass nested2 = new NestedClass(); 
		nested2.nestedClassMethod();

		// SomeClass cannot be accessed from a static environment.
		//SomeClass anonymous = new SomeClass() {
  		//	public void someClassMethod() {log.info("anonymous method call");}};

		//SomeClass some_class = new SomeClass();	
	}

}