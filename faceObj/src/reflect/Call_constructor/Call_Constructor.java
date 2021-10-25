package reflect.Call_constructor;

import java.lang.reflect.Constructor;
import java.util.Arrays;
/**
 * Constructor对象封装了构造方法的所有信息；
 * 通过Class实例的方法可以获取Constructor实例：getConstructor()，getConstructors()，
 * getDeclaredConstructor()，getDeclaredConstructors()；
 * 通过Constructor实例可以创建一个实例对象：newInstance(Object... parameters)；
 * 通过设置setAccessible(true)来访问非public构造方法。
 * 注意Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题。
 */
public class Call_Constructor {
    public static void main(String[] args) throws Exception  {
        /**
         * Person p = Person.class.newInstance();
         * 调用Class.newInstance()的局限是，它只能调用该类的public无参数构造方法。
         * 如果构造方法带有参数，或者不是public，就无法直接通过Class.newInstance()来调用。
         */

        /**
         * 为了调用任意的构造方法，Java的反射API提供了Constructor对象，
         * 它包含一个构造方法的所有信息，可以创建一个实例。Constructor对象和Method非常类似，
         * 不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例
         */
        Constructor cons1 = Integer.class.getConstructor(int.class);
        Integer n1 = (Integer) cons1.newInstance(369);
        System.out.println(n1);

        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("520");
        System.out.println(n2);
        System.out.println(Integer.class.getDeclaredConstructors());
        for (Constructor<?> declaredConstructor : Integer.class.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println(Arrays.toString(Integer.class.getDeclaredConstructors()));
    }
}

