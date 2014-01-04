package representing

/*
Runtime vs Compile time, Static vs Dynamic Add
@groovy.transform.TypeChecked
The compiler will report errors at compile time instead of runtime.

*/
@groovy.transform.TypeChecked
class Acknowledge
{
   void Acknowkledge() { println 'Hello' }
   
    def salute( person ) { println "Hello ${person.name}!" }
    def welcome( String location ) { println "Welcome to ${location.state}!" }

}