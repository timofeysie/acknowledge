# The Maximal Algorith Problem #

Generics: "10% benefit and 90% head-scratching."

The Question:  Write a generic method to find the maximal element in the range [begin, end) of a list.

The Answer: 

public final class Algorithm 
{
    public static <T extends Object & Comparable<? super T>>
        T max(List<? extends T> list, int begin, int end) 
        {

        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
}

Oue Test program, MaximalAlgorithm causes this compile time error:

method max ... cannot be applied to given types:
	int count = max(ci, 0, 10);
	required: List<? extends T>, int, int
	found: List<Integer>,int,int 
	reason: inferred type does not conform to declared bounds.
	inferred: Integer
	bounds: Object,Comparable<? super Integer>
	where T is a type-variable

So the next question is, how to invoke the upper bounded List<? extends T>?
And the bounds in the error say it's lower bounded.

<T extends Object & Comparable<? super T>>
        T max(List<? extends T> list, int begin, int end)

The StackOverflow discussions:

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

- But the inferred type can be a supertype in either case. List<Integer> l = new ArrayList<Integer>(); Number findMax = findMax(l,0,0); This compiles with either version. –  (Marko Topolnik Aug 25 2012 at 13:31, 65,648 reputation, from Croatia. profile views	7,515.  His profile says "Senior software engineer and business analyst having a rather rare opportunity to work a full-time job programming Clojure. Also in love with the Lucene API.". 2,181 Answers) 

- @bohemian: "? extends Object adds no value...are equivalent."  You are wrong here.They are not equivalent as the latter will be erased to Comparable and is not binary compatible with pre-generics code (while the first is binary compatible) –  (Cratylus Aug 25 2012 at 13:31.  20,131 reputation points.  member for	3 years, 7 months.  profile views 2,310) 
 	
@bohemian But how does java determine whether ClassC is T or a subtype of T? –  Oh Yeah Aug 25 2012 at 14:06

That answer was voted up by 5.  The next answer by, the sr. Clojur Lucerne loving Marko, was not voted up at all.

The way type inference works, T is always going to be inferred to the type param of the list you call the function with, so the additional liberty given by <? extends T> will never be used. You can write List<T> with the same result.

Answering to the subtler point raised by bohemian, the inferred type will be assignable to any supertype as well, so once again no flexibility is added by the longer signature.  (answered Aug 25 2012 at 13:26, before he commented on the above answer)

- But if <? extends T> isn't used, why doesn't everyone just write <T>? (by Jack/Oh Yeah Aug 25 2012 at 13:49)
- I wonder the same. There's probably yet another, even subtler point that we are overlooking. That's Generics for you, 10% benefit and 90% head-scratching. –  Marko Topolnik Aug 25 2012 at 14:08
- Haha. Good to know. –  Oh Yeah Aug 25 2012 at 14:36

The next answer which was also not voted up, points out that the "method that guarantees not to modify your collection (at least not a way that would corrupt it).  The List<? extends T> myList essentially makes list a read-only list inside the body of findMax which can not add any instance in the list (either T or subtype of T) except null." (answered on Aug 25 2012 at 13:35 by Cratylus, rep 20.1k)

Jack's question is ultimately not answered.  He states his question again on a note, and there is no reply:
"At compile time is the compiler able to tell if the class I pass as my list type is T or a subtype of T? If so, how? If not, what is the purpose of writing "findMax(List<? extends T>..." ? Writing "findMax(List<T>" should be the same thing, correct?" (Oh Yeah Aug 25 2012 at 22:15)

(source: http://stackoverflow.com/questions/12122302/in-the-following-example-is-list-extends-t-necessary-or-will-listt-do)

Next question, also about using List<T>, asked a year later on Aug 23 2013 at 20:43 by Prashant Bhate reputation 4,347.

The crux: "is it really necessary in type of the argument? It seems to me that it will be the same if we leave just List<T> or Collection<T>, isn't it?"

There is a working example that uses colors to test out a minimal version of the method signature.  But shouldn't there be a way to just use integers?
But remember the error,  the inferred type has the bounds Object,Comparable<? super Integer>

In the sample answer by East825, the user did this:
List<ColoredPoint> points = Arrays.asList(new ColoredPoint(1, 2, Color.BLACK),
class ColoredPoint extends Point
Point implements Comparable<Point>

So any object that implements Comparable should be in.
Then how do we implement Comparable?
"Lists (and arrays) of objects that implement this interface can be sorted automatically by Collections.sort (and Arrays.sort). Objects that implement this interface can be used as keys in a sorted map or as elements in a sorted set, without the need to specify a comparator."
OK.  That's nice.  SO we made a MaxComparable class, but when trying to use it the compiler says:
inferred: MaxComparable
bounds: Object,Comparable<? super MaxComparable>
where T is a type - variable.

If we change the <? super T> to just <T>, we get two more detailed errors.


(source: http://stackoverflow.com/questions/17255202/why-do-we-need-bounded-wilcard-extends-t-in-collections-max-method)