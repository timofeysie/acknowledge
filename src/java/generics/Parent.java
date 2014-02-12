class Parent implements Comparable<Parent> 
{
    protected String name;

    @Override
    public int compareTo(Parent o) 
    {
        return this.name.compareTo(o.name);
    }
}