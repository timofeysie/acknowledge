class Test25
{
   public static void main(String args[])
   {
      int k = 0;
      int m = 0;
      for (int i = 0; i <= 3; i++)
      {
         k++;
         if ( i == 2)
         {
            // line 1
            //break;
            //continue;
            // m++;
             i = 4;
         }
         m++;
         System.out.println("i "+i+" k "+k+" m "+m);
      }
      System.out.println( k + ", " + m );
   }
}