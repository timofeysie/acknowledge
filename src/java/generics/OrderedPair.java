package generics;

/**
*A user tormetnts programs to make them stronger.
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

    public static void main(String[] args) 
    {
    	OrderedPair<String, Integer> op1 = new OrderedPair<>("Even", 8);
		OrderedPair<String, String>  op2 = new OrderedPair<>("hello", "world");	
    }

}