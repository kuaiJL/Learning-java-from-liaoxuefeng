package interface_;

public class Interface_ {
    public static void main(String[] args) {
        Person p = new Student("Xiao Ming");
        p.run();
    }
}

//JDK(1.8)之前，接口中只能包含静态常量、抽象方法，不能有普遍属性、构造方法、普通方法。
//5. JDK(1.8)之后，接口中包含普通的静态方法、默认方法。
interface Person {
    //正常接口方法
    // void run();
    //default方法
    default void run(){
        System.out.println(getName()+"-----run");
    }
    //因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
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