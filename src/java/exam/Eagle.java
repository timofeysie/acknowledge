class Bird {
    public Bird(){     }
}
class Eagle extends Bird { 
    public String name;
    public Eagle(String name){
        this.name = name;
    }

    private String method(String a)
    {
    	return "1";
    }

    private int method(int a)
    {
    	return 1;
    }

    
    public static void main(String[] args) {
        System.out.println(new Eagle("Bald Eagle").name);
    }
}