class Mom
{
    int i;
    /* this method is private so the call from
    method2 will go here, and not from the chile. If this 
    is public/protected/friendly (default), the
    Child's class method1() would be called.
    */
    private void method1()
    {
        System.out.println("Parent's method1()");
    }
    public void method2()
    {
        System.out.println("Parent's method2()");
        method1();
    }
    public void set(int a [][], int x, int y, int o)
    {
        a[x][y] = 0;
        System.out.println("inside set");
        toString(a);
    }

    public void toString(int a[][])
    {
        for (int x = 0; x < a.length; x++)
        {
            for (int y = 0; y < a[x].length; y++)
            {
                //int place = 
                System.out.print(a[x][y]+" ");
            }
            System.out.println();
        }
    }

}
class Me extends Mom
{
    public void method1()
    {
        System.out.println("Child's method1()");        
    }
    public static void main(String args[])
    {
        Mom m = new Me();
        m.method2();
        m.i = 1;
        System.out.println("i is "+m.i);
        final int SET = 1;
        final int ERASE = 0;
        int [][] a = new int[3][3];
        m.toString(a);
        a[0][0] = 1;
        a[1][1] = 1;
        m.set(a,2,2,SET);
        m.toString(a);
        Me me = new Me();
        m = me;
    }
}