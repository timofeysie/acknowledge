import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._

/**
Why is Scala so popular?
* Multiple classes can be imported from the same package by enclosing
them in curly braces.
* When importing all the names of a package or class, one uses the underscore character (_) instead of
the asterisk (*). That’s because the asterisk is a valid Scala identifier (e.g. method
name)
*/
object HelloScala {
  def main(args: Array[String]) {
    println("Acknowledge Scala~")
    val now = new Date
	val df = getDateInstance(LONG, Locale.FRANCE)
	/* Methods taking one argument can be used
	with an infix syntax. 
	a less verbose way of writing the expression
	df.format(now).
	It's not really such a great feature, is it?*/
	println(df format now)
  }
}