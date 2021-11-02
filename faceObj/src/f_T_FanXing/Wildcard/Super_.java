package f_T_FanXing.Wildcard;

/**
 * 对比extends和super通配符
 * 我们再回顾一下extends通配符。作为方法参数，<? extends T>类型和<? super T>类型的区别在于：
 * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
 * <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
 * 一个是允许读不允许写，另一个是允许写不允许读。
 */
public class Super_ {
    public static void main(String[] args) {
        {
            Pair_<Number> p1 = new Pair_<>(12.3, 4.56);
            Pair_<Integer> p2 = new Pair_<>(123, 456);
            System.out.println(p1.getFirst().getClass());
            setSame(p1, 100);
            setSame(p2, 200);
            System.out.println(p1.getFirst() + ", " + p1.getLast());
            System.out.println(p2.getFirst() + ", " + p2.getLast());
        }
        System.out.println("-----------------------------------------");
        {
            //Java的泛型还允许使用无限定通配符（Unbounded Wildcard Type），即只定义一个<?>：
            //大多数情况下，可以引入泛型参数<T>消除<?>通配符：
            //<?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类：
            Pair_<Integer> p3 = new Pair_<>(123, 456);
            Pair_<?> p4 = p3; // 安全地向上转型
            Pair_<?> p5=new Pair_<>("12.3","45.6");
            System.out.println(p3.getClass());
            System.out.println(p4.getClass());
            System.out.println(p5.getClass());
            System.out.println(p4.getFirst() + ", " + p4.getLast());
        }
    }

    static void setSame(Pair_<? super Integer> p, Integer n) {
//        System.out.println(p.getFirst().getClass());
        p.setFirst(n);
        p.setLast(n);
        //Integer x = p.getFirst();
//        System.out.println(x.getClass());
//        System.out.println(p.getFirst().getClass());
//        System.out.println(p.getFirst());

    }
}

class Pair_<T> {
    private T first;
    private T last;

    public Pair_(T first, T last) {
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
        this.last = last;
    }
}