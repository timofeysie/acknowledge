class Game{
  public void play() throws Exception{
    System.out.println("Playing...");
  }
}

public class Soccer extends Game{
   public void play(){
      System.out.println("Playing Soccer...");      
   }
   public static void main(String[] args){
       Game g1 = new Soccer(); // error: unreported exception, must be caught or
       g1.play();
       // declared to be thrown.
       Soccer g2 = new Soccer(); // this is OK!
       g2.play();
   }
}