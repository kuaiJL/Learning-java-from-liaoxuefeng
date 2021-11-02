package f_T_FanXing.Wildcard;

import java.util.ArrayList;
import java.util.List;

public class Extend_char {
    public static void main(String[] args) {
        {
            //注意：传入的类型是Pair<Number>，实际参数类型是(Integer, Integer)。
            Pair<Number> p = new Pair<>(1, 2);
            System.out.println(add(p));//3
            //既然实际参数是Integer类型，试试传入Pair<Integer>
            Pair<Integer> p1 = new Pair<>(123, 456);
            //System.out.println(add(p1)); 不兼容的类型: Pair<java.lang.Integer>无法转换为Pair<java.lang.Number>
            var p2 = new Pair<>(3, 5);
            //System.out.println(add(p2)); //自动推断p2为Pair<Integer>
            int sum = add(new Pair<>(3, 7));
            System.out.println(sum); //根据add()自动推断new Pair<>(3, 7)为Pair<Number>
            //System.out.println(add(new Pair<Integer>(2,3)));
        }
        System.out.println("-------------------------------------");
        {
            Pair<Integer> p3 = new Pair<>(123, 456);
            int n = Adder(p3);
            System.out.println(n);
            var p2 = new Pair<>(3.1, 5.1);
            System.out.println(Adder(p2));
            System.out.println(Adder(new Pair<>(2.2, 3.3)));
        }
        System.out.println("---------------------------------------");
        {
            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            System.out.println(sumOfList(list));
            System.out.println(list);
        }
        System.out.println("---------------------------------------");
        {
            List<Double> list = new ArrayList<>();
            list.add(1.2);
            list.add(2.2);
            list.add(3.2);
            System.out.println(sumOfDoubleList(list));
            System.out.println(list);
        }
    }
   static String sumOfList(List<? extends String> list) {
        String sum = "0";
        for (int i=0; i<list.size(); i++) {
            String n = list.get(i);
            sum = sum + n;
        }
       list.remove("2");
       return sum;
    }

    static double sumOfDoubleList(List<? extends Double> list) {
        double sum = 0;
        for (int i=0; i<list.size(); i++) {
            double n = list.get(i);
            sum = sum + n;
        }
        //list.add(new Double(5.5));  不能正常编译并使用
        list.remove(2.2);   //能正常编译和调用
        return sum;
    }
    static int add(Pair<Number> p){
        Number first = p.getFirst();
        Number last= p.getLast();
        return first.intValue()+ last.intValue();
    }

    /**
     * 有没有办法使得方法参数接受Pair<Integer>？办法是有的，
     * 这就是使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型。
     * 我们把代码改写如下：
     */
    static int Adder(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
        /**
         * 这就是<? extends Number>通配符的一个重要限制：
         * 方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number)。
         */
//        p.setFirst(new Integer(first.intValue() + 100));
//        p.setLast(new Integer(last.intValue() + 100));
//        return p.getFirst().intValue() + p.getFirst().intValue();
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
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last; }
}
