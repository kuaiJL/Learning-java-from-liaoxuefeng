package bao;

import base.Test;

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

    }
}
