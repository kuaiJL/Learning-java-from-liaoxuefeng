package d_reflect.DongTaiDaiLi_jiekoushili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 所有interface类型的变量总是通过某个实例向上转型并赋值给接口类型变量的：1
 * CharSequence cs = new StringBuilder();
 * 有没有可能不编写实现类，直接在运行期创建某个interface的实例呢？
 * 这是可能的，因为Java标准库提供了一种动态代理（Dynamic Proxy）的机制：可以在运行期动态创建某个interface的实例。
 */
public class Proxy_newProxyInstance {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy.getClass());
                System.out.println(method);
                if (method.getName().equals("morning")){
                    System.out.println("Good morning,"+args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),// 传入ClassLoader
                new Class[]{Hello.class},   // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
        System.out.println(Hello.class);
    }
}

/**
 * 在运行期动态创建一个interface实例的方法如下：
 * 定义一个InvocationHandler实例，它负责实现接口的方法调用；
 * 通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
 * 使用的ClassLoader，通常就是接口类的ClassLoader；
 * 需要实现的接口数组，至少需要传入一个接口进去；
 * 用来处理接口方法调用的InvocationHandler实例。
 * 将返回的Object强制转型为接口。
 */
interface Hello{
    void morning(String name);
}

/**
 * 小结
 * Java标准库提供了动态代理功能，允许在运行期动态创建一个接口的实例；
 * 动态代理是通过Proxy创建代理对象，然后将接口方法“代理”给InvocationHandler完成的。
 */