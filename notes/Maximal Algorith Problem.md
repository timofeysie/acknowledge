# The Maximal Algorith Problem #

TO fix:
MaximalAlgorithm test method causes this error:
method max ... cannot be applied to given types:
	int count = max(ci, 0, 10);
	required: List<? extends T>, int, int
	found: List<Integer>,int,int 
	reason: inferred type does not conform to declared bounds.
	inferred: Integer
	bounds: Object,Comparable<? super Integer>
	where T is a type-variable
So the question is, how to invoke the upper bounded List<? extends T>?
And the bounds in the error say it's lower bounded.

<T extends Object & Comparable<? super T>>
        T max(List<? extends T> list, int begin, int end)

Jack (Aug 25 2012 at 13:17 by Oh Yeah rep 6) asked a question on StackOverflow and got some answers:

? extends Object adds no value, because everything extends Object, so these two methods are equivalent:

public static <T extends Object & Comparable<? super T>> T findMax(List<T> myList, int begin, int end)
public static <T extends Comparable<? super T>> T findMax(List<T> myList, int begin, int end)

Having made that simplification, your question is basically are these equivalent:

... findMax(List<T> myList, int begin, int end)
... findMax(List<? extends T> myList, int begin, int end)

These two are not the same. In the second method, you can pass in a List with a type that's a subclass of the returned type, whereas in the first method the List's type must be the same type as the returned type.
(answered on Aug 25 2012 at 13:27 by Bohemian rep 115k)

The answer is continued in notes where Bohemian is immediately schooled:

- But the inferred type can be a supertype in either case. List<Integer> l = new ArrayList<Integer>(); Number findMax = findMax(l,0,0); This compiles with either version. –  (Marko Topolnik Aug 25 2012 at 13:31, 65,648 reputation, from Croatia. profile views	7,515.  His profile says "Senior software engineer and business analyst having a rather rare opportunity to work a full-time job programming Clojure. Also in love with the Lucene API.") 

- @bohemian: "? extends Object adds no value...are equivalent."  You are wrong here.They are not equivalent as the latter will be erased to Comparable and is not binary compatible with pre-generics code (while the first is binary compatible) –  (Cratylus Aug 25 2012 at 13:31.  20,131 reputation points.  member for	3 years, 7 months.  profile views 2,310) 
 	
@bohemian But how does java determine whether ClassC is T or a subtype of T? –  Oh Yeah Aug 25 2012 at 14:06