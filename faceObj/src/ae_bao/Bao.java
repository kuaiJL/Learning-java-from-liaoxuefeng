package ae_bao;

import a_base.Test;

// 导入System类的所有静态字段和静态方法:
import static java.lang.System.*;

public class Bao {
    public static void main(String[] args) {
        Person p = new Person();
        p.hello();
        //base.Test k = new base.Test();
        Test t = new Test();
        t.test();
        out.println("********import static java.lang.System.*;");
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
        out.println(s1.getClass()+"@"+Integer.toHexString(s1.hashCode()));
        out.println(s2.getClass()+"@"+Integer.toHexString(s2.hashCode()));

        System.out.println(s1.equals(s2));
        String s11 = "hello";
        String s22 = "HELLO".toLowerCase();
        System.out.println(s11 == s22);
        System.out.println(s11.equals(s22));
        out.println(s11.getClass()+"@"+Integer.toHexString(s11.hashCode()));
        out.println(s22.getClass()+"@"+Integer.toHexString(s22.hashCode()));
    }
}
