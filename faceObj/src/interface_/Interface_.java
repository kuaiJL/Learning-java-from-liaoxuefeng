package interface_;

public class Interface_ {
    public static void main(String[] args) {
        Person p = new Student("Xiao Ming");
        p.run();
    }
}

interface Person {
    //正常接口方法
    // void run();
    //default方法
    default void run(){
        System.out.println(getName()+"-----run");
    }
    String getName();
}

class Student implements Person{
    private String name;
    public Student(String name){
        this.name=name;
    }

//    实现类可以不必覆写default方法。
//    @Override
//    public void run() {
//        System.out.println(this.name+",run");
//    }

    @Override
    public String getName() {
        return this.name;
    }
}