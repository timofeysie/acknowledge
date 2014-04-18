class Test6<Ob>
{
	static Ob getOb()
	{
		// error: non-static type variable On 
		// cannot be referenced from a static
		// context.
		return null;
	}
}