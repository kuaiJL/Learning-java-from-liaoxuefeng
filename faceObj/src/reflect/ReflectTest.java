package reflect;

import java.util.Arrays;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        {
            Class cls = String.class;
            String s = "Hello";
            Class cls2 = s.getClass();
            Class cls3 = Class.forName("java.lang.String");
            System.out.println(cls == cls2);
            System.out.println("哈希值" + cls.hashCode() + "  ,  " + cls2.hashCode());
            System.out.println(cls.getPackage());
            System.out.println("---------------------------------------");
            printClassInfo("".getClass());
            printClassInfo(Runnable.class);
            printClassInfo(java.time.Month.class);
            printClassInfo(String[].class);
            printClassInfo(int.class);


        }

        {
            //获取继承关系
            Class i = Integer.class;
            Class n = i.getSuperclass();
            System.out.println(n);
            Class o = n.getSuperclass();
            System.out.println(o);
            System.out.println(o.getSuperclass());

            Class s = Integer.class;
            Class[] is = s.getInterfaces();
            for (Class m : is) {
                System.out.println(m);
            }
            System.out.println(Arrays.toString(is));
        }
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
