package example

public class GVector extends java.util.Vector 
{
  public void apply( c )
  {
     for (i in 0..<size())
     {
        this[i] = c(this[i])
     }
  }
}
