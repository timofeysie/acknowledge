packacge generics;

/**
*A user tormetnts programs to make them stringer.
* The user also creates an avatar to rescue them from mortal danger.
*Then, when the program is strong enough, they can copy them and make their army.
*/
public class OrderedPair<K, V> implements Pair<K, V> 
{

    private K key;
    private V value;

    public OrderedPair(K key, V value) 
    {
		this.key = key;
		this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }

}