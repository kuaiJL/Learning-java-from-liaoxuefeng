package jingtaiziduan;

public class JingTaiZiDuan {
    public static void main(String[] args) {
        Person ming = new Person("Xiao Ming", 12);
        Person hong = new Person("Xiao Hong", 15);
        ming.number = 88;
        System.out.println(hong.number);
        hong.number = 99;
        System.out.println(ming.number);
        //↑↑↑↑↑↑↑↑ ：虽然实例可以访问静态字段，但是它们指向的其实都是Person class的静态字段。
        // 所以，所有实例共享一个静态字段。
        //因此，不推荐用实例变量.静态字段去访问静态字段，因为在Java程序中，实例对象并没有静态字段。
        // 在代码中，实例对象能访问静态字段只是因为编译器可以根据实例类型自动转换为类名.静态字段来访问静态对象。
        //推荐用类名来访问静态字段。可以把静态字段理解为描述class本身的字段（非实例字段）。
        // 对于上面的代码，更好的写法是：Person.number = 99;
        //System.out.println(Person.number);
        Person.number = 100;
        System.out.println(Person.number);
        System.out.println("*****************************");
        Ren.number=1;
        System.out.println(Ren.number);
        Ren.setNumber(3);
        System.out.println(Ren.number);
        System.out.println("*****************************");
        People_ frz = new People_(1);
        System.out.println(frz.getSex());
        System.out.println("People.MALE="+People.MALE);
        People.staticMothod();
        People_.staticMothod();
    }
}

class Person {
    public String name;
    public int age;

    public static int number;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Ren {
    public static int number;

    public static void setNumber(int value) {
        number = value;
    }
}

interface People{
    public static final int MALE = 1;
    int FEMALE = 2;
    //因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
    public static void staticMothod(){
        System.out.println(MALE+","+FEMALE);
    }
    String getSex();
}

class People_ implements People{
     private int sex;

     public static String ststicA = "abc";
     public People_(int sex){
         this.sex=sex;
     }

     //如果子类中定义了相同名字的静态方法，那就是完全不同的方法了，直接从属于子类。可以通过子类直接调用。
     public static void staticMothod(){
         System.out.println("实现类与接口同名的静态方法，直接从属于子类，非覆写实现"+ststicA);
     }
    @Override
    public String getSex() {
         if (this.sex==1) {
             return "男";
         }
         else if (this.sex==2){
             return "女";
         }
         else{
             return "?";
         }
    }
}