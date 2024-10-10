/* Traits are similar to interfaces which can also contain code. In Scala, when a class inherits from a trait, it implements that trait’s interface, and inherits all the code contained in the trait.

When comparing objects, six different predicates can be useful: smaller, smaller or equal, equal, not equal, greater or equal, and greater. However, defining all of them is fastidious, especially since four out of these six can be expressed using the remaining two. That is, given the equal and smaller predicates (for example), one can express the other ones. In Scala, all these observations can be nicely captured by the following trait declaration: */

trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean =  (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

/* The predicates for equality and inequality do not appear here since they are by default present in all objects.
The type Any which is used above is the type which is a super-type of all other types in Scala. It can be seen as a more general version of Java’s Object type, since it is also a super-type of basic types like Int, Float, etc.  (I thought it was scala.AnyRef) */

class Date(y: Int, m: Int, d: Int) extends Ord {
  def year = y
  def month = m
  def day = d
  override def toString(): String = year + "-" + month + "-" + day
}

override def equals(that: Any): Boolean =
  that.isInstanceOf[Date] && {
    val o = that.asInstanceOf[Date]
    o.day == day && o.month == month && o.year == year
  }

/* 
isInstanceOf = instanceof operator.
asInstanceOf = cast operator: if the object is an instance of the given type, 
it is viewed as such, otherwise a ClassCastException is thrown.
*/

/* the predicate tests for inferiority, as follows.
 It makes use of another predefined method, error, which 
 throws an exception with the given error message.
*/
def <(that: Any): Boolean = {
  if (!that.isInstanceOf[Date])
    error("cannot compare " + that + " and a Date")
  val o = that.asInstanceOf[Date]
  (year < o.year) ||
  (year == o.year && (month < o.month ||
                     (month == o.month && day < o.day)))
}

/* Generics.
 the initial value given to that variable is _, 
 which represents a default value. 
 This default value is 0 for numeric types, 
 false for the Boolean type, 
 () for the Unit type and null for all object types.
*/
class Reference[T] {
  private var contents: T = _
  def set(value: T) { contents = value }
  def get: T = contents
}

/* To specify which type to use for the type parameter T, 
For example, to create and use a cell holding an integer, 
one could write the following:*/

object IntegerReference {
  def main(args: Array[String]) {
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))
  }
}
