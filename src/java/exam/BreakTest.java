public class BreakTest{
  public static void main(String[] args){
    int i = 0, j = 5;
    lab1 : for( ; ; i++)
    {
      for( ; ; )  
      {
      	if( i >j ) break lab1;
     	j++;
      }
    }
    System.out.println(" i = "+i+", j = "+j);
  }
}