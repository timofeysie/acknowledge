//package generic;

/**
* T becomes Object after type erasure.
*/
public class Node<T> 
{

    private T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) 
    {
        System.out.println("Node.setData");
        this.data = data;
    }

}