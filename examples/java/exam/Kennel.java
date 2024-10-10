class Animal{void run() {}}

class Dog extends Animal {void bark() {}}

class Kennel
{
	public static void main(String[] args)  
	{
		Animal d = new Dog();
		/*This is totally legal, calling
  		the method run is no problem 
  		because it is defined inside 
  		the Animal class: */
		d.run();

		/*Compliler Error! Calling
  		the method bark results
  		in an error because it is
  		not defined in the Animal
  		class:  */
		//d.bark();
}

}