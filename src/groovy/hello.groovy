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
println "22. Semi colons optional.  Multiple lines OK."
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
println "23,  multiple assignments"
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
def (a2, b2, c1) = elements
assert a2 == 1
assert b2 == 2
assert c1 == null
// Ack was here.

println ""
println "24"
println "Empty collections are coerced to false."
def numbers = [1,2,3]
assert numbers //true, as numbers in not empty
numbers = []
assert !numbers //true, as numbers is now an empty collection

println ""
println "25"
println "Iterators and Enumerations with no further elements are "
println "coerced to false."
assert ![].iterator() // false because the Iterator is empty
assert [0].iterator() // true because the Iterator has a next element
def v = new Vector()
assert !v.elements()  // false because the Enumeration is empty
v.add(new Object())
assert v.elements()   // true because the Enumeration has more elements
println ""
println "Non-empty maps are coerced to true."
assert ['one':1]
assert ![:]
println ""
println "Matching regex patterns are coerced to true."
println "Non-empty Strings, GStrings and CharSequences are coerced to true."
println "Non-zero numbers are coerced to true."
println "Non-null object references are coerced to true."
println ""
println "26. I/O"
println "through each line of a file the following can be used..."
def fields = ["a":"1", "b":"2", "c":"3"]
new File("foo.ini").withWriter { out ->
    fields.each() { key1, value1 ->
        out.writeLine("${key1}=${value1}")
    }
}
new File("foo.ini").eachLine { line -> println(line) }
println ""
println "27.  Ranges allow you to create a list of sequential values."
// an inclusive range
def range = 5..8
assert range.size() == 4
assert range.get(2) == 7
assert range[2] == 7
assert range instanceof java.util.List
assert range.contains(5)
assert range.contains(8)
// lets use a half-open range
range = 5..<8
assert range.size() == 3
assert range.get(2) == 7
assert range[2] == 7
assert range instanceof java.util.List
assert range.contains(5)
assert ! range.contains(8)
//get the end points of the range without using indexes
range = 1..10
assert range.from == 1
assert range.to == 10
// an inclusive range
def range_i = 'a'..'d'
assert range_i.size() == 4
assert range_i.get(2) == 'c'
assert range_i[2] == 'c'
assert range_i instanceof java.util.List
assert range_i.contains('a')
assert range_i.contains('d')
assert ! range_i.contains('e')
println "also Ranges can be used to iterate using the for statement."
for (K in 1..10) 
{
  println "Hello ${K}"
}
println "the same effect, by iterating a range with each method:"
(1..10).each { l ->
  println "Hello ${l}"
}
println "Ranges can be also used in the switch statements:"
def years = 13
switch (years) {
   case 1..10: interestRate = 0.076; break;
  case 11..25: interestRate = 0.052; break;
      default: interestRate = 0.037;
}
println ""
println "28.  Maps"
println " [:] is the empty map expression."
println "Map keys are strings by default: [a:1] is equivalent to ['a':1]."
println "But if you really want a variable to become the key, "
println "you have to wrap it between parentheses: [(a):1]."
map = [name:"Gromit", likes:"cheese", id:1234]
assert map.get("name") == "Gromit"
assert map.get("id") == 1234
assert map["name"] == "Gromit"
assert map['id'] == 1234
assert map instanceof java.util.Map
println "Maps like beans can use the dot notation."
assert map.name == "Gromit"
assert map.id == 1234
def emptyMap = [:]
assert emptyMap.size() == 0
emptyMap.put("foo", 5)
assert emptyMap.size() == 1
assert emptyMap.get("foo") == 5
assert emptyMap.foo == 5
println ""
println "29.  the star-dot '*.' operator"
println "can perform operations on all the members of a collection "
println "using the '*.' operator"
assert [1, 3, 5] == ['a', 'few', 'words']*.size()
println "you can find big words from a list as follows"
def words = ['ant', 'buffalo', 'cat', 'dinosaur']
assert words.findAll{ w -> w.size() > 4 } == ['buffalo', 'dinosaur']
println "Or you can find the first letters of some words as follows:"
words = ['ant', 'buffalo', 'cat', 'dinosaur']
assert words.collect{ it[0] } == ['a', 'b', 'c', 'd']
println "you have methods like findIndexOf, grep, any, every, min, max, "
println "flatten, intersect, disjoint, sort, join and others."
println ""
println "30. Slicing with the subscript operator"
println "you can use ranges to extract part of a List/array/String/regex. "
println "This is often referred to as slicing in scripting languages "
println "like Python. You can also use a list of indexes too."
text = "nice cheese gromit!" // text and x already defined
def sub = text[5..10]
assert sub == 'cheese'
println " use negative indices to count from the end of the List, array, "
println "String etc."
text = "nice cheese gromit!" // text and x already defined
x = text[-1]
assert x == "!"
def name = text[-7..-2]
assert name == "gromit"
println "Also if you use a backwards range (the starting index is greater than the end index) then the answer is reversed."
text = "nice cheese gromit!"
name = text[3..1]
assert name == "eci"
println ""
println "31. Dynamic objects (Expandos)"
println "do not have to have their properties defined in advance."
def player = new Expando()
player.name = "Dierk"
player.greeting = { "Hello, my name is $name" }
println player.greeting()
player.name = "Jochen"
println player.greeting()
println ""
println "32. egular expressions"
println "the ~\"pattern\" expression "
println "creates a compiled Java Pattern object from the given pattern "
println "string."
println "the =~ (create Matcher) "
println "and ==~ (returns boolean, whether String matches the pattern) "
println "operators."
import java.util.regex.Matcher
import java.util.regex.Pattern
// ~ creates a Pattern from String
def pattern = ~/foo/
assert pattern instanceof Pattern
assert pattern.matcher("foo").matches()    // returns TRUE
assert ! pattern.matcher("foobar").matches() // returns FALSE, because matches() must match whole String
// =~ creates a Matcher, and in a boolean context, it's "true" if it has at least one match, "false" otherwise.
assert "cheesecheese" =~ "cheese"
assert "cheesecheese" =~ /cheese/
assert "cheese" == /cheese/   /*they are both string syntaxes*/
assert ! ("cheese" =~ /ham/)
// ==~ tests, if String matches the pattern
assert "2009" ==~ /\d+/  // returns TRUE
assert "holla" ==~ /\d+/ // returns FALSE
// lets create a Matcher
def matcher = "cheesecheese" =~ /cheese/
assert matcher instanceof Matcher
// lets do some replacement
def cheese = ("cheesecheese" =~ /cheese/).replaceFirst("nice")
assert cheese == "nicecheese"
assert "color" == "colour".replaceFirst(/ou/, "o")
cheese = ("cheesecheese" =~ /cheese/).replaceAll("nice")
assert cheese == "nicenice"
// simple group demo
// You can also match a pattern that includes groups.  First create a matcher object,
// either using the Java API, or more simply with the =~ operator.  Then, you can index
// the matcher object to find the matches.  matcher[0] returns a List representing the
// first match of the regular expression in the string.  The first element is the string
// that matches the entire regular expression, and the remaining elements are the strings
// that match each group.
// Here's how it works:
def m = "foobarfoo" =~ /o(b.*r)f/
assert m[0] == ["obarf", "bar"]
assert m[0][1] == "bar"
// Although a Matcher isn't a list, it can be indexed like a list.  In Groovy 1.6
// this includes using a collection as an index:
matcher = "eat green cheese" =~ "e+"
assert "ee" == matcher[2]
assert ["ee", "e"] == matcher[2..3]
assert ["e", "ee"] == matcher[0, 2]
assert ["e", "ee", "ee"] == matcher[0, 1..2]
matcher = "cheese please" =~ /([^e]+)e+/
assert ["se", "s"] == matcher[1]
assert [["se", "s"], [" ple", " pl"]] == matcher[1, 2]
assert [["se", "s"], [" ple", " pl"]] == matcher[1 .. 2]
assert [["chee", "ch"], [" ple", " pl"], ["ase", "as"]] == matcher[0, 2..3]
// Matcher defines an iterator() method, so it can be used, for example,
// with collect() and each():
matcher = "cheese please" =~ /([^e]+)e+/
matcher.each { println it }
matcher.reset()
assert matcher.collect { it } == [["chee", "ch"], ["se", "s"], [" ple", " pl"], ["ase", "as"]]
// The semantics of the iterator were changed by Groovy 1.6.
// In 1.5, each iteration would always return a string of the entire match, ignoring groups.
// In 1.6, if the regex has any groups, it returns a list of Strings as shown above.
//
// there is also regular expression aware iterator grep()
assert ["foo", "moo"] == ["foo", "bar", "moo"].grep(~/.*oo$/)
// which can be written also with findAll() method
assert ["foo", "moo"] == ["foo", "bar", "moo"].findAll { it ==~ /.*oo/ }
println ""