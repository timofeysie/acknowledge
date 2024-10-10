class B 
{
    private int bMember = 12;
    def bMethod (String name_)
    {
      A aInsideB = new A();
      return (aInsideB.publicMethod (name_));
    }
 }