package a_base;

public class extend_ {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);
        System.out.println(s.getName());

        System.out.println("-----------------------------");
        Person_ex s1 = new Student1("京东",24,99);
        //s1.score不行，Person_ex s1没有score字段
        System.out.println("s1.score不行，Person_ex s1没有score字段");
//Student s2= new Person_ex("hahaah",88); 直接向下转型不行

        System.out.println("-----------------------------");
        Person_ex s19 = new Student("京东111",24,99);
        //父类引用不了本身没有的字段和方法
        System.out.println(s19.age);
        Student s2=(Student)s19;
        System.out.println(s2.score);
        System.out.println(s2.getName());
    }
}

class Person_ex {
    protected String name;
    protected int age;
    public Person_ex(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Student extends Person_ex {
    protected int score;
    public Student(String name, int age, int score) {
        //编译器会帮我们自动加一句super();
        //如果父类没有默认的构造方法，
        // 子类就必须显式调用super()
        // 并给出参数以便让编译器定位到父类的一个合适的构造方法。
        super(name,age);
        this.score = score;
    }
    public String getName() {
        return this.name+","+this.age+","+this.score;
    }
}

class Student1 extends Person_ex {
    protected int score;

    public Student1(String name, int age,int score) {
        super(name, age);
        this.score=score;
    }

}