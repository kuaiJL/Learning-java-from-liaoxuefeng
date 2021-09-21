package base;

public class Method_overload {
    public static void main(String[] args) {
        Hello h = new Hello();
        h.hello();

        h.hello("kjl");

        h.hello("rafa",15);
    }


}

class Hello {
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}
