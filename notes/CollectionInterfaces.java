
public interface Collection<E> extends Iterable<E> {
    int size(); // cardinality
    boolean isEmpty();
    boolean contains(Object element);
    boolean add(E element);
    boolean remove(Object element);
    Iterator<E> iterator();
    boolean containsAll(Collection<?> c); // true if c is subset
    boolean addAll(Collection<? extends E> c); // union
    boolean removeAll(Collection<?> c); // transforms set into the (asymmetric) set difference
    boolean retainAll(Collection<?> c); // intersection of two sets
    void clear();
    Object[] toArray();
    <T> T[] toArray(T[] a);
}
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove(); //optional
}
static void filter(Collection<?> c) {
    for (Iterator<?> it = c.iterator(); it.hasNext(); )
        if (!cond(it.next()))
            it.remove();   // polymorphic algorithm
}

/*
Set Interface

Set is a Collection that cannot contain duplicate elements. 
It models the mathematical set abstraction. 
The Set interface contains only methods inherited from Collection
Two Set instances are equal if they contain the same elements.
Set implementations: 
- HashSet
- TreeSet
- LinkedHashSet. 

HashSet, which 
- stores its elements in a hash table, is 
- the best-performing implementation; however it makes 
- no guarantees concerning the order of iteration. 

TreeSet, which 
- stores its elements in a red-black tree, 
- orders its elements based on their values; it is 
- substantially slower than HashSet. 

LinkedHashSet, which is 
- implemented as a hash table with a linked list running through it, 
- orders its elements based insertion-order 
- no chaotic ordering provided at a cost that is only slightly higher.
*/
Collection<Type> noDups = new HashSet<Type>(c); // remove dupes
Collection<Type> noDups = new LinkedHashSet<Type>(c);//preserves the order of the original collection while removing duplicate element.

        Set<String> s = new HashSet<String>();
/*
The code refers to the Collection by its interface type (Set)
 rather than by its implementation type (HashSet). 
 This is a strongly recommended programming practice because 
 it gives you the flexibility to change implementations by changing 
 the constructor. 
 If either of the variables used to store a collection or 
 the parameters used to pass it around are declared to be 
 of the Collection's implementation type rather than its interface type, 
 all such variables and parameters must be changed in order to change 
 its implementation type.
Furthermore, there's no guarantee that the resulting program will work. 
If the program uses any nonstandard operations present in the original 
implementation type but not in the new one, the program will fail. 
Referring to collections only by their interface prevents you from 
using any nonstandard operations.

If you want the program to print the word list in alphabetical order, 
change the Set's implementation type from HashSet to TreeSet.

To calculate the union, intersection, or set difference of two sets
nondestructively, copy one set before calling the appropriate bulk 
operation. The following are the resulting idioms.
*/
Set<Type> union = new HashSet<Type>(s1);
union.addAll(s2);
Set<Type> intersection = new HashSet<Type>(s1);
intersection.retainAll(s2);
Set<Type> difference = new HashSet<Type>(s1);
difference.removeAll(s2);
/*
Find which words in the argument list occur only once and which occur
 more than once, but you do not want any duplicates printed out
 repeatedly. This effect can be achieved by generating two sets —
 one containing every word in the argument list and the other
 containing only the duplicates. The words that occur only once are 
 the set difference of these two sets
*/
public class FindDups2 {
    public static void main(String[] args) {
        Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();
        for (String a : args)
            if (!uniques.add(a))
                dups.add(a);
        uniques.removeAll(dups); // Destructive set-difference
        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}
/*
symmetric set difference — the set of elements contained in either of 
two specified sets but not in both nondestructively.
*/
Set<Type> symmetricDiff = new HashSet<Type>(s1);
symmetricDiff.addAll(s2);
Set<Type> tmp = new HashSet<Type>(s1);
tmp.retainAll(s2);//the set containing only the elements common to both sets.
symmetricDiff.removeAll(tmp);

/*
List Implementations

1. general-purpose and 2. special-purpose.

1. General-Purpose

- ArrayList
- LinkedList. 
ArrayList offers 
- constant-time positional access
- fast
- does not have to allocate a node object for each element in the List, 
- can take advantage of System.arraycopy when it has to move multiple
 elements at the same time. 
- a Vector without the synchronization overhead.
- tuning parameter: the initial capacity
(the number of elements the ArrayList can hold before it has to grow)

LinkedList
- If you frequently add elements to the beginning of the List
- iterate over the List to delete elements from its interior
- Positional access requires linear-time in a LinkedList
- constant-time in an ArrayList
- the constant factor for LinkedList is much worse.
- no tuning parameters and seven 

optional operations 
- clone
- addFirst
- getFirst
- removeFirst
- addLast
- getLast
- removeLast  
(LinkedList also implements the Queue interface)

2. Special-purpose

CopyOnWriteArrayList 
- backed up by a copy-on-write array
- similar in nature to CopyOnWriteArraySet. 
- No synchronization is necessary, even during iteration, 
- iterators are guaranteed never to throw ConcurrentModificationException. 
- well suited to maintaining event-handler lists, in which 
change is infrequent, and 
traversal is frequent and potentially time-consuming.

*/

search:
        for (i = 0; i < arrayOfInts.length; i++) 
        {
            for (j = 0; j < arrayOfInts[i].length;j++) 
            {
                if (arrayOfInts[i][j] == searchfor) 
                {
                    foundIt = true;
                    break search;
                }
            }
        }