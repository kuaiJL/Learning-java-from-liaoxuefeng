package f_T_FanXing.Type_Erasure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ChaShiFa {
    public static void main(String[] args) throws Exception {
        {
            Pair<String> p1 = new Pair<>("Hello", "world");
            Pair<Integer> p2 = new Pair<>(123, 456);
            var c1 = p1.getClass();
            Class c2 = p2.getClass();
            System.out.println(c1);
            System.out.println(c1==c2); // true
            System.out.println(c1==Pair.class); // true
            System.out.println(p1 instanceof Pair); // true
            System.out.println(p1 instanceof Pair<String>); // true
            //System.out.println(p2 instanceof Pair<String>);//  Compile error
        }
        {
            Pair1<String> pair1 = new Pair1<>(String.class);
            System.out.println(pair1);
        }
        System.out.println("--------------------------------------------");
        {
            //在继承了泛型类型的情况下，子类可以获取父类的泛型类型。
            // 例如：IntPair可以获取到父类的泛型类型Integer。
            Class<IntPair> clazz = IntPair.class;
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) t;
                Type[] types = pt.getActualTypeArguments();
                Type firstType = types[0];
                Class<?> typeClass = (Class<?>) firstType;
                System.out.println(typeClass);
            }
        }
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
    public boolean equals(Object t){
        return this == t;
    }
    public boolean same(T t) {
        return this == t;
    }
}

//要实例化T类型，我们必须借助额外的Class<T>参数：
 class Pair1<T> {
    private T first;
    private T last;
    public Pair1(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        System.out.println(clazz);
        System.out.println(clazz=="kjl".getClass());
        first = clazz.newInstance();
        last = clazz.newInstance();
    }
}

//泛型继承
class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}

/*
        因为Java引入了泛型，所以，只用Class来标识类型已经不够了。实际上，Java的类型系统结构如下：
        ┌────┐
        │Type│
        └────┘
        ▲
        │
        ┌────────────┬────────┴─────────┬───────────────┐
        │            │                  │               │
        ┌─────┐┌─────────────────┐┌────────────────┐┌────────────┐
        │Class││ParameterizedType││GenericArrayType││WildcardType│
        └─────┘└─────────────────┘└────────────────┘└────────────┘
        */
