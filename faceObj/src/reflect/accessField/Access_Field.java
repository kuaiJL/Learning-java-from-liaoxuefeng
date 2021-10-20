package reflect.accessField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Access_Field {
    public static void main(String[] args) throws NoSuchFieldException {
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
        System.out.println("-------------------------------------------");
        //getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
        int m = cls.getField("name").getModifiers();
        Modifier.isFinal(m); // false
        Modifier.isPublic(m); // true
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // false
        Modifier.isStatic(m); // false
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isFinal(m));
        System.out.println("-------------------------------------------");
    }
}
class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}