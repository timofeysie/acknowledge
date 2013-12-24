//hello.groovy
println "hello, groovy ---------------------"
for (arg in this.args ) 
{
  println "Argument:" + arg;
}
this.args.each{ arg -> println "hello, ${arg}"}
// Argument: arg1
// Argument: arg2 etc...

println ""
println "1"
println "List can hold various types, like int, string or dates."
def list = [1, 2, 'hello', new java.util.Date()]
assert list.size() == 4
assert list.get(2) == 'hello'
assert list[2] == 'hello'
// def list = [1, 2, 3]
for (i in list) { println i }

println ""
println "2"
println "Map"
def map = ['name':'James', 'location':'London']
assert map.size() == 2
assert map.get('name') == 'James'
assert map['name'] == 'James'
println "Call the name ${map['name']}"

println ""
println "3"
println "Closures"
def closure1 = { param -> println("hello ${param} closure.") }
closure1.call("world!")
println "Closure has two args."
closure1 = { greeting, name -> println("Closure "+greeting + name) }
closure1.call("one ", "two")

println ""
println "3-1"
def closure2 = { println "hello " + it }
closure2.call("default parameter it")
println "process collections"
[1, 2, 3].each ({ item -> print "${item}-" })
["k1":"v1", "k2":"v2"].each {key, value -> println key + "=" + value}

println ""
println "4"
println "If a given closure is the last parameter of a method," 
println "its definition can reside outside of the parentheses"
def fun(int i, Closure c) 
{
  c.call(i)
}
// put Closure out of ()
[1, 2, 3].each() { item -> print "${item}-" } // 1-2-3-
fun(123) { i -> println i } // 123
// omit ()
[1, 2, 3].each ({ item -> print "${item}-" }) // 1-2-3-
// omit enclosing ()
[1, 2, 3].each { item -> print "${item}-" } // 1-2-3-
// normal
[1, 2, 3].each(({ item -> print "${item}-" })) // 1-2-3-
// using the fun function to do the same thing
[1,2,3].each {fun(it,{item -> print "${item}-"})} // 1-2-3-
def closure3 = { i -> println i}
//[1, 2, 3].each() closure // error. closure has been previously defined

println ""
println ""
println "5"
println "Collect the return value of calling a closure on" 
println "each item in a collection"
def value = [1, 2, 3].collect { it * 2 }
assert value == [2, 4, 6]
println value

println ""
println "6"
println "finds first item matching closure predicate"
value = [1, 2, 3].find { it > 1 }
//assert value == 2
//value.find { it > 1 } // causes an assertion error
assert value == 2
println value 

println ""
println "7"
println "find: finds all items matching closure predicate"
value = [1, 2, 3].findAll { it > 1 }
assert value == [2, 3]
println value

println ""
println "8"
println "Inject: pass a value into the first iteration"
println "and then pass the result of that iteration" 
println "into the next iteration and so on."
println "This is ideal for counting and other forms of processing"
value = [1, 2, 3].inject('counting: ') { str, item -> str + item }
assert value == "counting: 123"
println "first value "+value
value = [1, 2, 3, 4, 5].inject(0) { count, item -> count + item }
println "second value "+value // prints 15 - this seems the same as 
// #12 join

println ""
println "9"
println "Every: returns true if all items match the closure predicate."
value = [1, 2, 3].every { it < 5 }
assert value
println "value "+value // true
value = [1, 2, 3].every { item -> item < 3 }
assert ! value
println "value "+value  // false

println ""
println "10"
println "any"
println "returns true if any item match the closure predicate"
value = [1, 2, 3].any { it > 2 }
assert value
println "value "+value // true
value = [1, 2, 3].any { item -> item > 3 }
assert value == false
println "value "+value  // false

println ""
println "11"
println "max // min"
println "returns the max//min values of the collection -"
println "for Comparable objects"
value = [9, 4, 2, 10, 5].max()
//assert value == 10
println "value "+value
value = [9, 4, 2, 10, 5].min()
assert value == 2
println "value "+value
value = ['x', 'y', 'a', 'z'].min()
assert value == 'a'
println "value "+value

println ""
println "12"
println "join"
println "concatenates the values of the collection together"
println "with a string value"
value = [1, 2, 3].join('-')
//assert value == '1-2-3'
println value;

println ""
println "13"
println "ternary operator"
println "Groovy supports the ternary operator (see also the Elvis operator."
def y = 5
def x = (y > 1) ? "worked" : "failed"
assert x == "worked"
println x

println ""
println "14"
println "the Groovy switch statement can handle any kind of switch value and different kinds of matching can be performed."
println "the case value using the isCase(switchValue) method, which defaults to call equals(switchValue) but has been overloaded for various types like Class or regex etc."
x = 1.23
def result = ""
switch ( x ) 
{
    case "foo":
        result = "found foo"
        // lets fall through
    case "bar":
        result += "bar"
    case [4, 5, 6, 'inList']:
        result = "list"
        break
    case 12..30:
        result = "range"
        break
    case Integer:
        result = "integer"
        break
    case Number:
        result = "number"
        break
    default:
        result = "default"
}
assert result == "number"
println "result "+result

println ""
println "15"
println "the usual while {...} loops like Java."
x = 0
y = 5
while (y-- > 0) 
{
    x++
}
assert x == 5
println "x "+x

println "The for loop in Groovy is much simpler and works with any kind of array, collection, Map etc."
for (int i = 0; i < 5; i++) 
{
	println "loop "+i
}

// iterate over a range
x = 0
for ( i in 0..9 ) 
{
    x += i
}
assert x == 45
// iterate over a list
x = 0
for ( i in [0, 1, 2, 3, 4] ) 
{
    x += i
}
assert x == 10
// iterate over an array
array = (0..4).toArray()
x = 0
for ( i in array ) 
{
    x += i
}
assert x == 10
// iterate over a map
map = ['abc':1, 'def':2, 'xyz':3]
x = 0
for ( e in map ) 
{
    x += e.value
}
assert x == 6
// iterate over values in a map
x = 0
for ( v in map.values() ) 
{
    x += v
}
assert x == 6
// iterate over the characters in a string
def text = "abc"
list = []
for (c in text) 
{
    list.add(c)
}
assert list == ["a", "b", "c"]

println ""
println "16"
println "closures again"
println "In addition, you can use closures in place of most for loops, using each() and eachWithIndex():"
def stringList = [ "java", "perl", "python", "ruby", "c#", "cobol",
                   "groovy", "jython", "smalltalk", "prolog", "m", "yacc" ];

def stringMap = [ "Su" : "Sunday", "Mo" : "Monday", "Tu" : "Tuesday",
                  "We" : "Wednesday", "Th" : "Thursday", "Fr" : "Friday",
                  "Sa" : "Saturday" ];

stringList.each() { print " ${it}" }; println "";
// java perl python ruby c# cobol groovy jython smalltalk prolog m yacc

stringMap.each() { key, value1 -> println "${key} == ${value1}" };
// Su == Sunday
// We == Wednesday
// Mo == Monday
// Sa == Saturday
// Th == Thursday
// Tu == Tuesday
// Fr == Friday

stringList.eachWithIndex() { obj, i -> println " ${i}: ${obj}" };
// 0: java
// 1: perl
// 2: python
// 3: ruby
// 4: c#
// 5: cobol
// 6: groovy
// 7: jython
// 8: smalltalk
// 9: prolog
// 10: m
// 11: yacc

stringMap.eachWithIndex() { obj, i -> println " ${i}: ${obj}" };
// 0: Su=Sunday
// 1: We=Wednesday
// 2: Mo=Monday
// 3: Sa=Saturday
// 4: Th=Thursday
// 5: Tu=Tuesday
// 6: Fr=Friday

println ""
println "17.  Returning values from if-else"
println "when they are the last expression in a method or a closure"
def method() 
{
    if (true) 1 else 0
}
assert method() == 1
println method()


println ""
println "18.  If an exception is thrown in the try block,"
println "the last expression in the catch block is returned instead."
println "finally blocks don't return any value."
def method0(bool) 
{
    try 
    {
        if (bool) throw new Exception("foo")
        1
    } catch(e) 
    {
        2
        //e.printStackTrace()
    } finally 
    {
        3
    }
}
assert method0(false) == 1
assert method0(true) == 2
println "arg false "+method0(false)
println "arg true "+method0(true)

println ""
println "19.  operator overloading "
println "comparison operators handle nulls gracefully avoiding "
println "the throwing of java.lang.NullPointerException"
println "a == b  same as   a.equals(b) or a.compareTo(b) == 0 ** "
println "a != b  same as ! a.equals(b) "
def a = null
def b = "foo"
assert a != b
assert b != a
assert a == null

println ""
println "20.   when comparing numbers of different types the type coercion"
println "rules apply to convert numbers to the largest numeric type"
println "before the comparison"
Byte a1 = 12
Double b1 = 10
assert a1 instanceof Byte
assert b1 instanceof Double
assert a1 > b1

println ""
println "21.   Classes & Scripts"
println "by default things are public"
def foo(list, value) 
{
    println "Calling function foo() with param ${value}"
    list << value
}
x = []
foo(x, 1)
foo(x, 2)
assert x == [1, 2]
println "Creating list ${x}"

println ""
println "22 Semi colons optional.  Multiple lines OK."
x = [1, 2, 3,
	4, 5, 6]
println(
	x
)
if (x != null &&
	x.size() > 5) 
{
	println("Works!")
}
else 
{
	assert false: "should never happen ${x}"
}

println ""
println "multiple assignments"
def geocode(String location) 
{
    // implementation returns [48.824068, 2.531733] for Paris, France
    [48.824068, 2.531733]
}
def (_lat, _long) = geocode("Paris, France")
assert _lat == 48.824068
assert _long == 2.531733
def (int i, String s) = [1, 'Groovy']
assert i == 1
assert s == 'Groovy'
println "assignment (with prior definition of the variables), "
println "just omit the def keyword"
def firstname, lastname
(firstname, lastname) = "Guillaume Laforge".tokenize()
assert firstname == "Guillaume"
assert lastname == "Laforge"
println "for the case with more variables than list elements, "
println "here, c will be null:"
def elements = [1, 2]
def (a, b, c) = elements
assert a == 1
assert b == 2
assert c == null
println "the standard school swap case in one line"
// given those two variables
a = 1, b = 2
// swap variables with a list
(a, b) = [b, a]
assert a == 2
assert b == 1

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

// current method calls page