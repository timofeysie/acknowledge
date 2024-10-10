/*
When we pass references in Java what actually gets passed is the value of 
that reference (i.e. memory address of the object being referenced and not 
the actual object called by that reference) and it gets passed as value 
(i.e a copy of the reference is made). Now when we make changes to the object 
referenced by that reference it reflects on that object even outside of the 
method being called but any changes made to the reference itself is not 
reflected on that reference outside of the method which is called. In the 
example below when the reference v is passed from method first() to second() 
the value of v is passed. When we assign the value val to v it is valid only 
inside the method second() and thus inside the method second() what gets 
printed is 15 (initial value of i in the object referenced by val), then a 
blank space and then 0 (value of local variable i). After this when we return 
to the method first() v actually refers to the same object to which it was 
referring before the method second() was called, but one thing should be noted 
here that the value of i in that object (referred by v inside the method first()) 
was changed to 20 in the method second() and this change does reflect even 
outside the method second(), hence 20 gets printed in the method first(). 
Thus overall output of the code in consideration is
15 0
20 
*/
class Value
{
    public int i = 15;
}
public class Test
{
    public static void main(String argv[])
    {
        Test t = new Test();
        t.first();
    }
    public void first()
    {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }
    public void second(Value v, int i)
    {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v =  val;
        System.out.println(v.i + " " + i);
    }
}