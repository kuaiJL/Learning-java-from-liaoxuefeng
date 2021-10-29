package f_T_FanXing.Custom_T;

public class CustomT {
    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>("壹","贰");
        System.out.println(stringPair.getFirst()+"----"+stringPair.getLast());
        System.out.println("----------------------------------");
        Pair1<String> stringPair1 = new Pair1<>("1","2").create("3","4");
        System.out.println(stringPair1.getFirst());
        System.out.println("----------------------------------");
        Pair4<String, Integer> stringIntegerPair4 = new Pair4<>("威少", 32);
        System.out.println(stringIntegerPair4.getFirst() + ":" + stringIntegerPair4.getLast());
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

//编写泛型类时，要特别注意，泛型类型<T>不能用于静态方法。例如：
/*
 class Pair1<T> {
    private T first;
    private T last;
    public Pair1(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { return first; }
    public T getLast() { return last; }

    // 对静态方法使用<T>:导致编译错误，我们无法在静态方法create()的方法参数和返回类型上使用泛型类型T。
    public static Pair1<T> create(T first, T last) {
        return new Pair1<T>(first, last);
    }
}*/
class Pair1<T> {
    private T first;
    private T last;

    public Pair1(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    // 对静态方法使用<T>:导致编译错误，我们无法在静态方法create()的方法参数和返回类型上使用泛型类型T。
    public Pair1<T> create(T first, T last) {
        return new Pair1<T>(first, last);
    }
}

class Pair2<T> {
    private T first;
    private T last;

    public Pair2(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    // 对静态方法使用<T>:导致编译错误，我们无法在静态方法create()的方法参数和返回类型上使用泛型类型T。
    // 有些同学在网上搜索发现，可以在static修饰符后面加一个<T>，编译就能通过：
    // 但实际上，这个<T>和Pair<T>类型的<T>已经没有任何关系了。
    public static <T> Pair2<T> create(T first, T last) {
        return new Pair2<T>(first, last);
    }
}

class Pair3<T> {
    private T first;
    private T last;

    public Pair3(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    // 对于静态方法，我们可以单独改写为“泛型”方法，只需要使用另一个类型即可。
    // 对于上面的create()静态方法，我们应该把它改为另一种泛型类型，例如，<K>：
    public static <K> Pair3<K> create(K first, K last) {
        return new Pair3<K>(first, last);
    }
}

/**
 * 多个泛型类型
 * 泛型还可以定义多种类型。例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>：
 */

class Pair4<T,K>{
    private T first;
    private K last;
    public Pair4(T first , K last){
        this.first=first;
        this.last=last;
    }
    public T getFirst() { return first; }
    public K getLast() { return last; }
}
