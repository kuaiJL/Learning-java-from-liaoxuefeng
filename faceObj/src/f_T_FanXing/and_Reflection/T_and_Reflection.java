package f_T_FanXing.and_Reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class T_and_Reflection {
    public static void main(String[] args) throws Exception {
        {   //Java的部分反射API也是泛型。例如：Class<T>就是泛型：
            // compile warning:
            Class clazz = String.class;
            String str = (String) clazz.newInstance();
            System.out.println(str.hashCode());
            str = "qwer";
            System.out.println(str.hashCode());

            // no warning:
            Class<String> klass = String.class;
            String str1 = klass.newInstance();
        }
        System.out.println("---------------------------------");
        {   //调用Class的getSuperclass()方法返回的Class类型是Class<? super T>：
            Class<? super String> w = String.class.getSuperclass();
            System.out.println(w);
            System.out.println(Integer.class.getSuperclass());
        }
        System.out.println("---------------------------------");
        {   //构造方法Constructor<T> 也是泛型：
            Class<Integer> clazz = Integer.class;
            Constructor<Integer> cons = clazz.getConstructor(int.class);
            Integer i = cons.newInstance(123);
            System.out.println(i);
        }
        System.out.println("---------------------------------");
        {   //我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组：
            Pair<String>[] ps = null; // ok
            //Pair<String>[] ps1 = new Pair<String>[2]; // compile error!

            @SuppressWarnings("unchecked")
            Pair<String>[] ps2 = (Pair<String>[]) new Pair[2];//必须通过强制转型实现带泛型的数组：
            ps2[0] = new Pair<>("k", "j");
            //ps2[1] = new Pair<Integer>(1,2);or ps2[1] = new Pair<>(1,2); 错误
            ps2[1] = new Pair<>("l", "h");
            for (Pair<String> stringPair : ps2) {
                System.out.println(stringPair.getFirst());
            }
        }
        System.out.println("---------------------------------");
        {
            Pair[] arr = new Pair[2];
            arr[0] = new Pair<String>("a", "b");
            arr[1] = new Pair<Integer>(1, 2);
            for (Pair pair : arr) {
                System.out.println(pair.getFirst());
            }
        }
        System.out.println("---------------------------------");
        {
            String[] ss = ArrayHelper.asArray("a", "b", "c");
            Integer[] ns = ArrayHelper.asArray(1, 2, 3);
            Pair<String>[] pairs = ArrayHelper.asArray(new Pair("a", "b"), new Pair("1", "2"));
            System.out.println(pairs[1].getFirst().getClass());
        }
        System.out.println("---------------------------------");
        var n=new Abc<String>().createArray(String.class);
        n[0] = "q";
        n[1] = "w";
        System.out.println(n.length);
    }
}

class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}
//借助Class<T>来创建泛型数组：
 class Abc<T> {
    T[] createArray(Class<T> cls) {
         return (T[]) Array.newInstance(cls, 5);
     }
}
class ArrayHelper {
    //利用可变参数创建泛型数组T[]：
    @SafeVarargs
    static <T> T[] asArray(T... objs) {
        return objs;
    }
}