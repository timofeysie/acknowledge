import java.util.List;

public class WildcardCaptureError 
{

    void foo(List<?> i) 
    {
        // i.set(0, i.get(0));
        // in the above call, the compiler processes the i input parameter
        // as being of type Object. When the foo method invokes 
        // List.set(int, E), the compiler is not able to confirm the type
        // of object that is being inserted into the list,
        // and an error is produced. 
        // the code is attempting to perform a safe operation, 
        // so to work around the compiler error
        fooHelper(i);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) 
    {
        l.set(0, l.get(0));
    }

}