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
    public void setKey(K _key)	{ this.key = _key; }
    public V getValue() { return value; }
    public void setValue(V _value)	{ this.key = _value; }

    public static void main(String[] args) 
    {
        OrderedPair<String, Integer> op1 = new OrderedPair<>("Even", 8);
		OrderedPair<String, String>  op2 = new OrderedPair<>("hello", "world");	
		OrderedPair<Integer, String> p1 = new OrderedPair<>(1, "apple");
		OrderedPair<Integer, String> p2 = new OrderedPair<>(2, "pear");
		//boolean same = Util.<Integer, String>compare(op1, op2);
		//System.out.println("op1 == op2 "+same);
		// cannot compare op1 and op2
		boolean same = Util.<Integer, String>compare(p1, p2);
		System.out.println("p1 == p2 "+same); // false
		same = Util.compare(p1, p2); // still works without the diamond
		System.out.println("p1 == p2 w/o generics "+same); 
		// This is called type inference, it allows you to invoke a
		// generic method as an ordinary method
    }

}
