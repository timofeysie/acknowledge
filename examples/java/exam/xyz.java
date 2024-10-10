public class xyz 
{
   public static void main(String args[]) 
   {
      for(int i = 0; i < 2; i++) 
      {
         for(int j = 2; j>= 0; j--) 
         {
            if(i == j) 
            {
            	System.out.println(i+" "+j);
            	break;
            }
            System.out.println("i=" + i + " j="+j);
         }
      }
   }
}
//i=0 j=2
//i=0 j=1
// break at 0 0
//i=1 j=2
// break at 1 1
