package CoreClass;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * 小结
 * BigInteger用于表示任意大小的整数；
 * BigInteger是不变类，并且继承自Number；
 * 将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确。
 */
public class other {
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
            //包装类型 https://www.liaoxuefeng.com/wiki/1252599548343744/1260473794166400
            System.out.println("最常用的静态方法parseInt()可以把字符串解析成一个整数：");
            int x1 = Integer.parseInt("100"); // 100
            int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析
            System.out.println(x1);
            System.out.println(x2);
        }
        System.out.println("****************");
        {
            /**
             * JavaBean的作用
             * JavaBean主要用来传递数据，即把一组数据组合成一个JavaBean便于传输。
             * 此外，JavaBean可以方便地被IDE工具分析，生成读写属性的代码，主要用在图形界面的可视化设计中。
             */
            BeanInfo info = Introspector.getBeanInfo(Person.class);
            for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
                System.out.println(pd.getName());
                System.out.println("  " + pd.getReadMethod());
                System.out.println("  " + pd.getWriteMethod());
            }
        }
        System.out.println("---------------------------------------------");
        {
            /**
             * BigInteger用于表示任意大小的整数；
             * BigInteger是不变类，并且继承自Number；
             * 将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确。
             */
            BigInteger i1 = new BigInteger("123456789000");
            BigInteger i2 = new BigInteger("12345678901234567890");
            System.out.println(i1.longValue()); // 123456789000
            //System.out.println(i1.multiply(i1).longValueExact());
            // java.lang.ArithmeticException: BigInteger out of long range
        }
        System.out.println("---------------------------------------------");
        {
            /**
             * BigDecimal用于表示精确的小数，常用于财务计算；
             * 比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()。
             */
            BigDecimal d1 = new BigDecimal("123.4500");
            BigDecimal d2 = d1.stripTrailingZeros();
            System.out.println(d1.scale()); // 4
            System.out.println(d2.scale()); // 2,因为去掉了00
            BigDecimal d3 = new BigDecimal("1234500");
            BigDecimal d4 = d3.stripTrailingZeros();
            System.out.println(d3.scale()); // 0
            System.out.println(d4.scale()); // -2
            BigDecimal d5 = new BigDecimal("123.456");
            BigDecimal d6 = new BigDecimal("23.456789");
            BigDecimal d7 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
            System.out.println(d7);
            //BigDecimal d4 = d1.divide(d2); // 报错：ArithmeticException，因为除不尽
            System.out.println("---------------------------------------------");
            //还可以对BigDecimal做除法的同时求余数：
            BigDecimal n = new BigDecimal("12.345");
            BigDecimal m = new BigDecimal("0.12");
            BigDecimal[] dr = n.divideAndRemainder(m);
            System.out.println(dr[0]); // 102
            System.out.println(dr[1]); // 0.105
            //调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，
            // 分别是商和余数，其中商总是整数，余数不会大于除数。
            // 我们可以利用这个方法判断两个BigDecimal是否是整数倍数：
            BigDecimal n1 = new BigDecimal("12.75");
            BigDecimal m1 = new BigDecimal("0.15");
            BigDecimal[] dr1 = n1.divideAndRemainder(m1);
            if (dr1[1].signum() == 0) {
                System.out.println("n是m的整数倍");
            }
        }
        System.out.println("---比较BigDecimal------------------------------------------");
        //!!!!比较BigDecimal
        /*如果查看BigDecimal的源码，可以发现，
           实际上一个BigDecimal是通过一个BigInteger和一个scale来表示的，
            即BigInteger表示一个完整的整数，而scale表示小数位数：*/
        //BigDecimal也是从Number继承的，也是不可变对象。
        {
            BigDecimal d1 = new BigDecimal("123.456");
            BigDecimal d2 = new BigDecimal("123.45600");
            System.out.println(d1.equals(d2)); // false,因为scale不同
            System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
            System.out.println(d1.compareTo(d2)); // 0
        }

        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
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

