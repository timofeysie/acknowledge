package seven.one.nesting;

import org.apache.log4j.Logger;

class OuterClass 
{
	static Logger log = Logger.getLogger(OuterClass.class);
	private int privInt = 10;
	class InnerClass 
	{  
		public void accessOuter() 
		{
			log.info("The outer class's privInt is " + privInt);
		} 
	}

	private void outerClassMethod()
	{
		log.info("OuterClassMethod: inside the OuterClass create the inner class directly.");
		log.info("InnerClass inClass = new InnerClass();");
		InnerClass inClass = new InnerClass();
	}

	static class Nested 
	{
		void nestedClassMethod() 
		{
			log.info("Nestic Static Dog."); 
		}
	}

	public static void main(String[] args) 
	{
		//create instance of outer class first:
		OuterClass outClass = new OuterClass(); 
		OuterClass.InnerClass inner = outClass.new InnerClass(); 
		outClass.outerClassMethod();
		inner.accessOuter();

		OuterClass.Nested nested = new OuterClass.Nested(); 
		nested.nestedClassMethod(); 

		Nested n = new Nested(); 
		n.nestedClassMethod();
	}

}