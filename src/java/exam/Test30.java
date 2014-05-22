interface Flyer{ }
class Bird implements Flyer { }
class Eagle extends Bird { }
class Bat extends Bird { }

public class Test30 {
    
    public static void main(String[] args) {
        Flyer f = new Eagle();
        Eagle e = new Eagle();
        Bat b = new Bat();
        
        if(f instanceof Flyer) System.out.println("f is a Flyer");
        if(e instanceof Bird) System.out.println("e is a Bird");
        if(b instanceof Bird) System.out.println("b is a Bird");
    }
}
