class Suitcase {
   int num = 1;
   Suitcase suitcase;
   public Suitcase(int _num){ this.num = _num; }
   public static void main(String[] args){
	final Suitcase a = new Suitcase(5);
	Suitcase b = new Suitcase(10);
	a.suitcase = b;
	b.suitcase = setIt(a, b);
	System.out.println(a.suitcase.num+" "+b.suitcase.num);
   }
   
   public static Suitcase setIt(final Suitcase x, final Suitcase y){
       x.suitcase = y.suitcase;
       return x;
   }
   
}