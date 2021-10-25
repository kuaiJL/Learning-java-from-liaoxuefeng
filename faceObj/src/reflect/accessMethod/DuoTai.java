package reflect.accessMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DuoTai {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Person1.class.getMethod("hello");
        method.invoke(new Person1());
        method.invoke(new Student1());
        //^^^上述的反射代码,实际上相当于：Person p = new Student();
        //                                  p.hello();
        //method.invoke(new Object());
        //必须是Person1的子类实例

    }
}
class Person1 {
    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student1 extends Person1 {
    public void hello() {
        System.out.println("Student:hello");
    }
}