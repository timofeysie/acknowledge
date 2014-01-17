public class ShadowTest 
{

    public int x = 0;  

    class FirstLevel 
    {

        public int x = 1;  // the member variable of the inner class FirstLevel called x

        /**
        * The parameter in the method methodInFirstLevel is also called x
        * It shadows the variable of the inner class FirstLevel x.
        */
        void methodInFirstLevel(int x) 
        {
            System.out.println("x = " + x); // it refers to the method parameter. 
            System.out.println("this.x = " + this.x); // refers to the member variable of the inner class FirstLevel
            // To accesses the member variable of the class ShadowTest from the method methodInFirstLevel:
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x); // output is 0
        }
    }

    public static void main(String... args) 
    {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}