import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class ATest {
    public static void main(String[] args) throws IntrospectionException {
        {//代码块，s只在花括号类起作用
            String s = "";
            for (int i = 0; i < 3; i++) {
                s = s + "," + i;
                System.out.println(s);
            }
        }
        //String s ="11";
        System.out.println("****************");
        {
            StringBuilder sb = new StringBuilder(1024);
            System.out.println(sb.toString());
            for (int i = 0; i < 20; i++) {
                sb.append(',');
                sb.append(i);
            }
            System.out.println(sb);
            String s = sb.toString();
            System.out.println(s);
        }
        System.out.println("****************");
        {
            var sb = new StringBuilder(1024);
            sb.append("Mr ")
                    .append("Bob")
                    .append("!")
                    .insert(1, "Hello, ");
            System.out.println(sb.toString());
        }
        System.out.println("****************");

        {
            Adder adder = new Adder(1);
            adder.add(3)
                    .add(5)
                    .inc()
                    .add(10);
            System.out.println(adder.value());
        }
        {
            System.out.println("最常用的静态方法parseInt()可以把字符串解析成一个整数：");
            int x1 = Integer.parseInt("100"); // 100
            int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析
            System.out.println(x1);
            System.out.println(x2);
        }

        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
    }
}

    //仿照StringBuilder，我们也可以设计支持链式操作的类。例如，一个可以不断增加的计数器：
    class Adder {
        private int sum = 0;

        public Adder(int sum) {
            this.sum = sum;
        }

        public Adder add(int n) {
            sum += n;
            return this;
        }

        public Adder inc() {
            sum++;
            return this;
        }

        public int value() {
            return sum;
        }
    }


    class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

