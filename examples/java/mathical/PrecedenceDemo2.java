public class PrecedenceDemo2  
{  
    public static void main(String[] args)  
    {  
        new PrecedenceDemo2(args.length == 0 ?  
                10 :  
                Integer.parseInt(args[0])).printComplements();  
    }//end main  
      
    private int i;  
      
    public PrecedenceDemo2(int i)  
    {  
        this.i = i;  
    }//end constructor  
      
    private void printComplements()  
    {  
        System.out.printf(  
                "~%d = %d%n~%d = %d%n~++(i == %d) = %d%n~(i == %d)++ = %d%n" +  
                "now i is %d%n%n",  
                i, ~i, i + 1, ~(i + 1), i, ~++i, i, ~i++, i);  
    }//end printComplements  
}//end class  