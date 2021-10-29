package d_reflect.accessMethod;

import java.lang.reflect.Method;

public class Access_Method {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
        for (Method method : stdClass.getDeclaredMethods()) {
            System.out.println("-------------------------------");
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getParameterTypes().length);
            System.out.println(method.getModifiers());
        }
        System.out.println("-------------------------------");
        //当我们获取到一个Method对象时，就可以对它进行调用。我们以下面的代码为例：
        {
            String s = "Hello world";
            String r = s.substring(6, 8); // "wo"
            String r1 = s.substring(6); // "world"
            System.out.println(r + "----" + r1);
        }
        System.out.println("-------------------------------");
        //如果用反射来调用substring方法，需要以下代码：
        {// String对象:
            String s = "Hello world";
            // 获取String substring(int)方法，参数为int:
            Method m1 = String.class.getMethod("substring", int.class);
            // 获取String substring(int,int)方法，参数为int,int:
            Method m2 = String.class.getMethod("substring", int.class,int.class);
            // 在s对象上调用该方法并获取结果:
            String r1 = (String) m1.invoke(s, 6);
            String r2 = (String) m2.invoke(s, 6,8);
            // 打印调用结果:
            System.out.println(r1+"********"+r2);
        }
        System.out.println("-------------------------------");
        {//调用静态方法
            //如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，
            // 所以invoke方法传入的第一个参数永远为null
            Method m = Integer.class.getMethod("parseInt", String.class);
            Integer n = (Integer) m.invoke(null, "12345");
            System.out.println(n);
        }
        System.out.println("--调用非public方法-----------------------------");
        {
            Student student = new Student();
            Method m = Student.class.getDeclaredMethod("getGrade", int.class);
            m.setAccessible(true);
            int grade = (int) m.invoke(student, 7);
            System.out.println(grade);
            //
            Method m1 = Student.class.getDeclaredMethod("setName", String.class);
            m1.setAccessible(true);
            m1.invoke(student,"阿兹皮里亏他");
            System.out.println(student.name);
        }
    }
}

class Student extends Person {
    String name;
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
    private void setName(String name){
        this.name=name;
    }
}

class Person {
    public String getName() {
        return "Person";
    }
}
