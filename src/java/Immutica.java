/* Immutica
To make an immutable object:
1. In your constructor for your own immutable object, 
	primitives and other immutable objects can be accepted without 
	any further work on your part.
2. In your constructor for your own immutable object, if you accept 
	non-immutable objects, you have to make copies of them to assure that 
	the caller who called your constructor doesn't still have a reference 
	that might be used to change the non-immutable object that is now 
	a field of your object.
3. All of the fields of your immutable object must be private.
4. You can't have any setter() methods for any of your fields.
5. You can have getter() methods for primitives and for immutable fields.
6. For non-immutable fields, if you have any getters, you must return 
	a copy of the field so that the caller gets a reference to their 
	own copy and can't possibly change your copy.
*/
final class Immutica
{
	private String fixed;
	private Immutica(){}
	public Immutica(String _fix)
	{
		this.fixed = new String(_fix);
	}
	public String getFixed()
	{
		return new String(this.fixed);
	}
}