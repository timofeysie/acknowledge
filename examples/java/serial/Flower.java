/**
  * This class is used by the SerObjWithCodebase example.
  * It is a Serializable class.
  */
 
public class Flower implements java.io.Serializable {
    String color, variety;
     
    public Flower(String variety, String color) {
    this.color = color;
    this.variety = variety;
    }
     
    public String toString() {
    return color + " " + variety;
    }
}