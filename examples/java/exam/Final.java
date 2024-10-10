abstract class Super
{
	int i;
	Super(int i){this.i=i;}
	abstract double add();
}
final class Sub extends Super
{
	int i;
	Sub(int i, int j){
		super(i);
		this.i = i;
	}	

	double add(int i)
	{
		return (float)++i;
	}

	/**
	*In the original question, this method was not implemented,
	* therefore the compilation of the class failed.
	*/
	double add()
	{
		return (float)--i;
	}
}
/**
* From the EPractize Advanced Sessions, question 4
*/
public class Final
{
	public static void main(String[] args) {
		Sub s = new Sub(5,6);
		System.out.println(s.add(2));
	}
}