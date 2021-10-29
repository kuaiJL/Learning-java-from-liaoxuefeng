package a_base;

public class Construction_method {
    public static void main(String[] args) {
        Person1 p= new Person1("kjl",23);
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println("***************");
        Person1 p1= new Person1("kjl1");
        System.out.println(p1.getName());
        //System.out.println(p1.getAge());
        System.out.println("***************");

        new Person1();
        System.out.println("$$$$$$$$$$");

        Person1 p2=new Person1();
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
        System.out.println(p2);
    }
}

class Person1 {
    private String name;
    private int age;
    public Person1(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println(this);
    }

    public Person1(String name){
        this.name=name;
        System.out.println(this);
    }

    public Person1() {
        this("rafa",35);
        System.out.println(this);
    }

    public String getName(){
        return  this.name;
    }

    public int getAge(){
        return  this.age;
    }
}
