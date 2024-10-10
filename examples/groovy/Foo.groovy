println "the return statement is optional at the end of methods"
println " Also you don't need to specify a return type"
println "(it will default to Object in the bytecode if none is specified)"
class Foo 
{
	def calculatePrice() 
	{
		1.23
	}
	
	static void main(args) 
	{
		def foo = new Foo()
		def p = foo.calculatePrice()
		assert p > 0
		println "Found price: " + p
	}
}