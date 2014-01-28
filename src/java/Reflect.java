import java.lang.reflect.Method;
import java.lang.annotation.*;

/**
*@Supress
*/
public class Reflect 
{
    void m() 
    {
        try 
        {
            Reflect warn = new Reflect();
            Class c = warn.getClass();
            Method m = c.getDeclaredMethod("m");
            //<T extends Annotation> T =  m.getAnnotation(Class<T> annotationClass);
            // Returns this element's annotation for the specified type if such an annotation is present, else null.
             //Annotation[] a = m.getDeclaredAnnotations();
             //System.out.println(a[0]);
            // Returns all annotations that are directly present on this element.
             /*
 Class<?>   getDeclaringClass()
          Returns the Class object representing the class or interface that declares the method represented by this Method object.
 Object     getDefaultValue()
          Returns the default value for the annotation member represented by this Method instance.
 Class<?>[]     getExceptionTypes()
          Returns an array of Class objects that represent the types of the exceptions declared to be thrown by the underlying method represented by this Method object.
 Type[]     getGenericExceptionTypes()
          Returns an array of Type objects that represent the exceptions declared to be thrown by this Method object.
 Type[]     getGenericParameterTypes()
          Returns an array of Type objects that represent the formal parameter types, in declaration order, of the method represented by this Method object.
 Type   getGenericReturnType()
          Returns a Type object that represents the formal return type of the method represented by this Method object.
 int    getModifiers()
          Returns the Java language modifiers for the method represented by this Method object, as an integer.
 String     getName()
          Returns the name of the method represented by this Method object, as a String.
 Annotation[][]     getParameterAnnotations()
          Returns an array of arrays that represent the annotations on the formal parameters, in declaration order, of the method represented by this Method object.
 Class<?>[]     getParameterTypes()
          Returns an array of Class objects that represent the formal parameter types, in declaration order, of the method represented by this Method object.
 Class<?>   getReturnType()
          Returns a Class object that represents the formal return type of the method represented by this Method object.
 TypeVariable<Method>[]     getTypeParameters()
          Returns an array of TypeVariable objects that represent the type variables declared by the generic declaration represented by this GenericDeclaration object, in declaration order.
 int    hashCode()
          Returns a hashcode for this Method.
 Object     invoke(Object obj, Object... args)
          Invokes the underlying method represented by this Method object, on the specified object with the specified parameters.
 boolean    isBridge()
          Returns true if this method is a bridge method; returns false otherwise.
 boolean    isSynthetic()
          Returns true if this method is a synthetic method; returns false otherwise.
 boolean    isVarArgs()
          Returns true if this method was declared to take a variable number of arguments; returns false otherwise.
 String   
        */
        //System.out.println(m.toGenericString()+" Returns a string describing this Method, including type parameters.");
        System.out.println(m.toString()+" Returns a string describing this Method.");
        } catch (NoSuchMethodException x) 
        {
            x.printStackTrace();
        }
    }
}