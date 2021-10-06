package neibulei;

public class Inner_class {
    public static void main(String[] args) {
        Outer outer = new Outer("kjl");
        Outer.Inner inner = outer.new Inner();
        inner.hello();
        System.out.println(inner);//neibulei.Outer$Inner@41629346
        Outer1 outer1 = new Outer1("Nested");
        outer1.asyncHello();
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
                System.out.println("Hello,"+Outer1.this.name);
            }
        };
        new Thread(r).start();
    }
}
