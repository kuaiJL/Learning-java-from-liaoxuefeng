package g_Collection_.List_;

import java.util.List;
import java.util.Objects;

public class WriteEqual {
    public static void main(String[] args) {
        //null==null,true
        String s=null;
        System.out.println(s == null);
        {
            System.out.println("c" == new String("c"));
            System.out.println("c".equals(new String("c")));
            List<String> list = List.of("A", "B", "C");
            System.out.println(list.contains(new String("C"))); // true or false?
            System.out.println(list.indexOf(new String("C"))); // 2 or -1?
            //^^^^^^因为List内部并不是通过==判断两个元素是否相等，
            // ^^^^^而是使用equals()方法判断两个元素是否相等
        }
        System.out.println("-------------------------------------");
        {
            List<Person> list = List.of(
                    new Person("Xiao Ming"),
                    new Person("Xiao Hong"),
                    new Person("Bob")
            );
            System.out.println(list.contains(new Person("Bob")));
            //^^^ false，没有正确覆写equals()方法。
            System.out.println(new Person("Bob")==new Person("Bob"));//相当于上面
        }
        System.out.println("-------------------------------------");
        {
            List<Person1> list = List.of(
                    new Person1("Xiao Ming",1),
                    new Person1("Xiao Hong",2),
                    new Person1("Bob",3)
            );
            System.out.println(list.contains(new Person1("Bob",3)));
            System.out.println(list.get(2).equals1(new Person1("Bob",3)));
            System.out.println(list.get(2).equals2(new Person1("Bob",3)));
        }
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}

class Person1 {
    public String name;
    public int age;

    public Person1(String s, int i) {
        this.name=s;
        this.age=i;
    }

    public boolean equals(Object o){
        if (o instanceof Person1){
            Person1 p = (Person1) o;
            //对于引用字段比较，我们使用equals()，对于基本类型字段的比较，我们使用==。
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }
    //如果this.name为null，那么equals()方法会报错，因此，需要继续改写如下：
    public boolean equals1(Object o){
        if (o instanceof Person1){
            Person1 p = (Person1) o;
            boolean nameEquals = false;
            if (this.name == null && p.name == null) { nameEquals = true;}
            if (this.name != null) {
                nameEquals = this.name.equals(p.name);
            }
            //对于引用字段比较，我们使用equals()，对于基本类型字段的比较，我们使用==。
            return nameEquals && this.age == p.age;
        }
        return false;
    }
//要简化引用类型的比较，我们使用Objects.equals()静态方法：
   public boolean equals2(Object o) {
        if (o instanceof Person1) {
            Person1 p = (Person1) o;
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }
}
