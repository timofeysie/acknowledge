//package congeries;

import java.util.*;

public class CollectionsDemo 
{

   public static void main(String args[]) 
   {
      CollectionsDemo convocation = new CollectionsDemo();
      convocation.linkedHashSetDemo();
      convocation.IdentityHashMapDemo();
   }

   private void linkedHashSetDemo()
   {
      // create a hash set
      LinkedHashSet <String> hs = new LinkedHashSet<>();
      // add elements to the hash set
      hs.add("B");
      hs.add("A");
      hs.add("D");
      hs.add("E");
      hs.add("C");
      hs.add("F");
      System.out.println(hs);
   }

   /**
   *This class provides constant-time performance for the 
   * basic operations (get and put), assuming the system
   * identity hash function (System.identityHashCode(Object))
   * disperses elements properly among the buckets.
   */
   private void IdentityHashMapDemo()
   {
      // Create a hash map
      IdentityHashMap ihm = new IdentityHashMap();
      // Put elements to the map
      ihm.put("Zara", new Double(3434.34));
      ihm.put("Mahnaz", new Double(123.22));
      ihm.put("Ayan", new Double(1378.00));
      ihm.put("Daisy", new Double(99.22));
      ihm.put("Qadir", new Double(-19.08));
      
      // Get a set of the entries
      Set set = ihm.entrySet();
      // Get an iterator
      Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) 
      {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      // Deposit 1000 into Zara's account
      double balance = ((Double)ihm.get("Zara")).doubleValue();
      ihm.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " +
      ihm.get("Zara"));
   }

}