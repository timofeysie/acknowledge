class InstanceofDemo {
    public static void main(String[] args) {

        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        System.out.println("obj1 instanceof Parent: "
            + (obj1 instanceof Parent));
        System.out.println("obj1 instanceof Child: "
            + (obj1 instanceof Child));
        System.out.println("obj1 instanceof MyInterface: "
            + (obj1 instanceof MyInterface));
        System.out.println("obj2 instanceof Parent: "
            + (obj2 instanceof Parent));
        System.out.println("obj2 instanceof Child: "
            + (obj2 instanceof Child));
        System.out.println("obj2 instanceof MyInterface: "
            + (obj2 instanceof MyInterface));

        System.out.println("\nobj1 name "+obj1.getClass().getSimpleName());
        System.out.println("obj1 superclass "+obj1.getClass().getSuperclass()); // its superclass 
        Object [] interfs1 = obj1.getClass().getInterfaces();
        for (Object intf:interfs1)
            System.out.println("obj1 "+intf); // interfaces it implements
        //System.out.println("obj1 "+obj1.getFields().getMethods());

        System.out.println("\nobj2 name "+obj2.getClass().getSimpleName());
        System.out.println("obj2 superclass "+obj2.getClass().getSuperclass()); // its superclass 
        Object [] interfs2 = obj2.getClass().getInterfaces();
        for (Object intf:interfs2)
            System.out.println("obj2 "+intf); // interfaces it implements
        //System.out.println("obj1 "+obj1.getFields().getMethods());

        /*
        cannot find symbol Parent
        System.out.println("obj1 == Parent: "
            + (obj1 == Parent));
        System.out.println("obj1 == Child: "
            + (obj1 == Child));
        System.out.println("obj1 == MyInterface: "
            + (obj1 == MyInterface));
        System.out.println("obj2 == Parent: "
            + (obj2 == Parent));
        System.out.println("obj2 == Child: "
            + (obj2 == Child));
        System.out.println("obj2 == MyInterface: "
            + (obj2 == MyInterface));
            */
    }
}

class Parent implements Cloneable{}
class Child extends Parent implements MyInterface {}
interface MyInterface {}