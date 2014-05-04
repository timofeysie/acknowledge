package java.lang;
public class ExtendedObject extends java.lang.Object
{
		String name = "DEFAULT VALUE";
		protected void finalize() { name = null; }
		public static void main(String as[]) throws Throwable
		{
			Object ob = new ExtendedObject();
			ob.finalize();
			System.out.println(ob);
		}
}