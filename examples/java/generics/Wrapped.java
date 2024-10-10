interface Copyable<T> 
{ 
  T copy(); 
} 

// aftger eras7ure: 
//final class Wrapped 
final class Wrapped <Elem extends Copyable<Elem>> 
{ 

  /**
  * If the theObject field  were public and we could 
  * assign to it, the assignment would be unsafe because
  * the compiler cannot ensure that the value being
  * assigned really is of type Elem .  Yet the assignment
  * is permitted and flagged as an "unchecked" assignment.
  * Reading the field  is safe and does not result in a
  * warning. 
  */
  private Elem theObject; 
  // private Copyable theObject; // after erasure
  // this field of the raw type Wrapped is changed 
  // by type erasure and is of type Copyable after 
  // type erasure. 

  public Wrapped(Elem arg) { theObject = arg.copy(); }
  // public Wrapped( Copyable arg) 

  public void setObject(Elem arg) { theObject = arg.copy(); }
  // public void setObject( Copyable arg)

  public Elem getObject() { return theObject.copy(); }
// public Copyable getObject()

  public boolean equals(Object other) 
  { 
    if (other == null) return false; 
    if (! (other instanceof Wrapped))  return false; 
    return (this.theObject.equals(((Wrapped)other).theObject)); 
  }

   }