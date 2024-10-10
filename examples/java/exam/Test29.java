public class Test29
{
  public void method1(int i)
  {
    int j = (i*30 - 2)/100;   
    POINT1 : for(;j<10; j++)
    {
      boolean flag  = false;
      while(!flag)
      {
			  if(Math.random()>0.5) break POINT1;
      }
    }
    POINT2 : while(j>0)
    {
       System.out.println(j--);
       if(j == 4) break POINT2;
    }
  }

  public static void main(String[] args) {
    Test29 t29 = new Test29();
    t29.method1(7);
  }
}