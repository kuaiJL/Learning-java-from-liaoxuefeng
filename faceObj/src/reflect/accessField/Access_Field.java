package reflect.accessField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Access_Field {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        {
            Class cls = Student.class;
            //Field getField(name)：根据字段名获取某个public的field（包括父类）
            System.out.println(cls.getField("score"));
            // 获取继承的public字段"name":
            System.out.println(cls.getField("name"));
            //System.out.println(cls.getField("grade")); //throws NoSuchFieldException
            //Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
            // 可获取private字段"grade":
            System.out.println(cls.getDeclaredField("grade"));
            //Field[] getFields()：获取所有public的field（包括父类）
            System.out.println(cls.getFields());
            //Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
            System.out.println(cls.getDeclaredFields());
            for (Field declaredField : cls.getDeclaredFields()) {
                System.out.println(declaredField);
            }
            //System.out.println(cls.getDeclaredFields()[0]);
            }
        System.out.println("-------------------------------------------");
        //getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
        {
            int m = Student.class.getField("name").getModifiers();
            Modifier.isFinal(m); // false
            Modifier.isPublic(m); // true
            Modifier.isProtected(m); // false
            Modifier.isPrivate(m); // false
            Modifier.isStatic(m); // false
            System.out.println(Modifier.isPublic(m));
            System.out.println(Modifier.isFinal(m));
        }
        System.out.println("-------------------------------------------");
        {
            /**
             * 获取字段值
             *    先获取Class实例，再获取Field实例，
             *    然后，用Field.get(Object)获取指定实例的指定字段的值。
             */
            Object p = new Person1("Xiao Ming");
            Class c = p.getClass();
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);
            Object value = f.get(p);//java.lang.String
            System.out.println(value); // "Xiao Ming"
        }
        System.out.println("-------------------------------------------");
        {/**
         * 设置字段值
         *    设置字段值是通过Field.set(Object, Object)实现的，
         *    其中第一个Object参数是指定的实例，第二个Object参数是待修改的值
         */
            Person2 p = new Person2("Xiao Ming");
            System.out.println(p.getName()); // "Xiao Ming"
            Class c = p.getClass();
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);
            f.set(p, "Xiao Hong");
            System.out.println(p.getName()); // "Xiao Hong"
        }
    }
}
class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}

class Person1 {
    private String name;

    public Person1(String name) {
        this.name = name;
    }
}

class Person2 {
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}