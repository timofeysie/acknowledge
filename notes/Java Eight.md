Table

Concurrency  
Notes  


###Concurrency###
Two basic units of execution: processes and threads.
- Processing time for a single core is shared among processes and threads through an OS feature called time slicing.

**Processes**  
Have a self-contained execution environment. A process generally has a complete, private set of basic run-time resources; in particular, each process has its own memory space.
- To facilitate communication between processes, most operating systems support Inter Process Communication (IPC) resources, such as pipes and sockets. IPC is used not just for communication between processes on the same system, but processes on different systems.
- Most implementations of the Java virtual machine run as a single process. A Java application can create additional processes using a ProcessBuilder object. 

**Threads**
(Sometimes called lightweight processes)
- creating a new thread requires fewer resources than creating a new process.
- Threads exist within a process & share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.
- For a Java program, the main thread has the ability to create additional threads.

Two basic strategies for using Thread objects to create a concurrent application:  

1. To directly control thread creation and management, simply instantiate Thread each time the application needs to initiate an asynchronous task.

2. To abstract thread management from the rest of your application, pass the application's tasks to an executor (discussed with other high-level concurrency objects).

There are two ways to create an instance of Thread: Implement Runnable or Extend Thread.

A. Provide a Runnable object. The Runnable interface defines a single method, run, meant to contain the code executed in the thread. The Runnable object is passed to the Thread constructor, as in the HelloRunnable example:
```
public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from a thread!");
    }
    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}
```
- this method is more general, because the Runnable object can subclass a class other than Thread.
- it separates the Runnable task from the Thread object that executes the task, is more flexible, and is applicable to the high-level thread management APIs.

B. Subclass Thread. The Thread class itself implements Runnable, though its run method does nothing. An application can subclass Thread, providing its own implementation of run, as in the HelloThread example:
```
public class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello from a thread!");
    }
    public static void main(String args[]) {
        (new HelloThread()).start();
    }
}
```
- this method is easier to use in simple applications, but is limited by the fact that your task class must be a descendant of Thread. 

bookmark: file:///C:/Users/%EB%B0%95%EC%A7%84%EC%98%81/Downloads/javatutorials/tutorial/essential/concurrency/runthread.html





Notes
- unlike local and anonymous classes, lambda expressions do not have any shadowing issues 
- Lambda expressions are lexically scoped. This means that they do not inherit any names from a supertype or introduce a new level of scoping. 
- like local and anonymous classes, a lambda expression can only access local variables and parameters of the enclosing block that are final or effectively final. 
- The data type these methods expect is called the target type and you can only use lambda expressions in situations in which the Java compiler can determine a target type: Variable declarations, Assignments, Return statements, Array initializers, Method or constructor arguments, Lambda expression bodies, Conditional expressions, ?:, Cast expressions

###Default Methods###
**Virtual extension methods**, or, as they are often called, **defender methods**, can now be added to interfaces providing a default implementation of the declared behavior. interfaces can now implement methods & it doesn’t break the implementations.

Interface Methods: Default methods and abstract methods in interfaces are inherited like instance methods. 
- However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. 
Rule # 1: Instance methods are preferred over interface default methods.  Pegasus.identifyMyself() returns the string "I am a horse."

```
public class Pegasus extends Horse implements Flyer, Mythical 
{
    public static void main(String... args) 
    {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}
class Horse{public String identifyMyself(){return "I am a horse.";}}
interface Flyer 
{
    default public String identifyMyself() 
    {
        return "I am able to fly.";
    }
}
public interface Mythical 
{
    default public String identifyMyself() 
    {
        return "I am a mythical creature.";
    }
}
```
Rule # 2: Methods that are already overridden by other candidates are ignored. Dragon.identifyMyself() returns the string "I am able to lay eggs."
```
public interface Animal 
{
    default public String identifyMyself() 
    {
        return "interface_animal";
    }
}
public interface EggLayer extends Animal 
{
    default public String identifyMyself() 
    {
        return "I am able to lay eggs.";
    }
}
public interface FireBreather extends Animal 
{ 
    default public String identifyMyself() 
    {
        return "I am able to breathe fire.";
    }
}
public class Dragon implements EggLayer, FireBreather 
{
    public static void main (String... args) 
    {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}
```
  This circumstance can arise when supertypes share a common ancestor.
You could invoke any of the of the default implementations with the super keyword.
You can use the super keyword to invoke a default method in both classes and interfaces.
Inherited instance methods from classes can override abstract interface methods. 
- Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also, class methods cannot use the this keyword as there is no instance for this to refer to.



- overriding.interface methods contians code that needs Java 8.

Nested Classes

- captured variable: a local class can only access local variables that are declared final.
- in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.
Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters.
Starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. 


