public class BreakTest{
  public static void main(String[] args){
    int i = 0, j = 5;
    lab1 : for( ; ; i++)
    {
      for( ; ; --j)  
      {
      	if( i >j )
        {
          System.out.println("i > j: break");
          break lab1;
        }
     	  System.out.println(" i = "+i+", j = "+j);
      }
    }
    System.out.println(" i = "+i+", j = "+j);
  }
}