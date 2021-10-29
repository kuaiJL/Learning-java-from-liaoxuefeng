package f_T_FanXing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Why_we_use {
    public static void main(String[] args) {
        //使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object
        List list = new ArrayList();
        list.add("Hello");
        list.add("World!");
        /**
         * //System.out.println(list.get(0).charAt(2));
         * // String.charAt函数用不了，因为list.get()返回的是Object
         * //即相当于 Object obj = new String("Hello");
         * //obj没有charAt函数，之所以System.out.println(list.get(0))，
         * //能打印出来“Hello”，而不是“@5461848”之类
         * //是因为多态，即list.get(0)首先调用子类的类型String的toString方法。
         * //要想使用String.cahrAt()方法，必须先向下转型，即:
         */
        String first = (String) list.get(0);
        System.out.println(first.charAt(2));
        /**
         * list.get(0).getClass()得到的仍然是原来的Class,因为子类覆写了getClass()
         */
        System.out.println(list.get(0).getClass());

        /**
         * 如果用上述ArrayList存储String类型，会有这么几个缺点：
         * 需要强制转型；
         * 不方便，易出错。
         *
         * 要解决上述问题，我们可以为String单独编写一种ArrayList：
         * public class StringArrayList {
         *     private String[] array;
         *     private int size;
         *     public void add(String e) {...}
         *     public void remove(int index) {...}
         *     public String get(int index) {...}
         * }
         *
         * 这样一来，存入的必须是String，取出的也一定是String，不需要强制转型，因为编译器会强制检查放入的类型：
         * StringArrayList list = new StringArrayList();
         * list.add("Hello");
         * String first = list.get(0);
         * // 编译错误: 不允许放入非String类型:
         * list.add(new Integer(123));
         *
         * 问题暂时解决。
         * 然而，新的问题是，如果要存储Integer，还需要为Integer单独编写一种ArrayList：
         * 实际上，还需要为其他所有class单独编写一种ArrayList：
         * LongArrayList
         * DoubleArrayList
         * PersonArrayList
         *
         * 这是不可能的，JDK的class就有上千个，而且它还不知道其他人编写的class。
         * 为了解决新的问题，我们必须把ArrayList变成一种模板：ArrayList<T>，代码如下：
         *
         * public class ArrayList<T> {
         *     private T[] array;
         *     private int size;
         *     public void add(T e) {...}
         *     public void remove(int index) {...}
         *     public T get(int index) {...}
         * }
         * T可以是任何class。这样一来，我们就实现了：编写一次模版，可以创建任意类型的ArrayList：
         */
        List list1 = new LinkedList();
        list1.add(new Stu("kjl"));
        list1.add(new Stu("py"));
        System.out.println(list1.get(0).getClass());
    }
}

class Stu{
    public String name;
    public Stu(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }
}