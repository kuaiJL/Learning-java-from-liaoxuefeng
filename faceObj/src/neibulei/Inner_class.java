package neibulei;

import java.util.HashMap;
/**
 * 小结
 * Java的内部类可分为Inner Class、Anonymous Class和Static Nested Class三种：
 * Inner Class和Anonymous Class本质上是相同的，都必须依附于Outer Class的实例，
 *即隐含地持有Outer.this实例，并拥有Outer Class的private访问权限；
 * Static Nested Class是独立类，但拥有Outer Class的private访问权限。
 */
public class Inner_class {
    public static void main(String[] args) {
        //Inner Class
        Outer outer = new Outer("kjl");
        Outer.Inner inner = outer.new Inner();
        inner.hello();
        System.out.println(inner);//neibulei.Outer$Inner@41629346

        //Anonymous Class
        Outer1 outer1 = new Outer1("Nested");
        outer1.asyncHello();
        //除了接口外，匿名类也完全可以继承自普通类
        //map1是一个普通的HashMap实例，但map2是一个匿名类实例，只是该匿名类继承自HashMap。
        // map3也是一个继承自HashMap的匿名类实例，并且添加了static代码块来初始化数据。
        // 观察编译输出可发现Main$1.class和Main$2.class两个匿名类文件。
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>() {}; // 匿名类!
        HashMap<String, String> map3 = new HashMap<>() {
            {
                put("A", "1");
                put("B", "2");
            }
        };
        System.out.println(map3.get("A"));

        //Static Nested Class
        Outer2.StaticNested sn = new Outer2.StaticNested();
        sn.hello();
    }
}
//1.Inner Class
class Outer {
    private String name;

    Outer(String name){
        this.name = name;
    }

    class Inner {
        void hello(){
                System.out.println("Hello,"+Outer.this.name);
        }
    }
}

//2.Anonymous Class
class Outer1 {
    private String name;

    Outer1(String name) {
        this.name = name;
    }
//还有一种定义Inner Class的方法，它不需要在Outer Class中明确地定义这个Class，
// 而是在方法内部，通过匿名类（Anonymous Class）来定义
    void asyncHello(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello,匿名类（Anonymous Class）,"+Outer1.this.name);
            }
        };
        new Thread(r).start();
        //Java编译器会将每个匿名类依次命名为Outer$1、Outer$2、Outer$3……
        System.out.println(r);
    }
}
    //3.Static Nested Class,使用static修饰，称为静态内部类
    class Outer2 {
        private static String NAME = "OUTER";

        private String name;

        Outer2(String name) {
            this.name = name;
        }

        static class StaticNested {
            void hello() {
                System.out.println("Hello, " + Outer2.NAME);
            }
        }
    }


