package liuchengkongzhi;

public class if_ {
    public static void main(String[] args) {
        ifDouble();
        System.out.println("****************************");
        obj1();
        System.out.println("****************************");
        obj2();
        System.out.println("****************************");
        int n = 70;
        if (n >= 90) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");
    }

    //if (n >= 90) {
//        // n >= 90为true:
//        System.out.println("优秀");
//        } else {
//        // n >= 90为false:
//        if (n >= 60) {
//        // n >= 60为true:
//        System.out.println("及格了");
//        } else {
//        // n >= 60为false:
//        System.out.println("挂科了");
//        }
//        }

    //前面讲过了浮点数在计算机中常常无法精确表示，并且计算可能出现误差，
    // 因此，判断浮点数相等用==判断不靠谱：
    // 正确的方法是利用差值小于某个临界值来判断：
    public static void ifDouble() {
        double x = 1 - 9.0 / 10;
        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }
    }

    public static void obj1() {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }

    public static void obj2() {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
    }

    //java8不支持此switch语句表达；
//    public static void switch1() {
//        String fruit = "orange";
//        int opt = switch (fruit) {
//            case "apple" -> 1;
//            case "pear", "mango" -> 2;
//            default -> {
//                int code = fruit.hashCode();
//                yield code; // switch语句返回值
//            }
//        };
//        System.out.println("opt = " + opt);
//    }
}


