class HiddenMember 
{
  private String name;

  def getClosure (String name)
  {
    //return { name -> println ("Argument: ${name}, Object: ${owner.name}")}
    // error
    // the current scope already contains a variable of the name name
    //
    // same for this line
    //return { name -> println (name)}  
  }
}
