package Z_Lambda.One;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FunctionalInterface允许传入：
 *
 * 接口的实现类（传统写法，代码较繁琐）；
 * Lambda表达式（只需列出参数名，由编译器推断类型）；
 * 符合方法签名的静态方法；
 * 符合方法签名的实例方法（实例类型被看做第一个参数类型）；
 * 符合方法签名的构造方法（实例类型被看做返回类型）。
 * FunctionalInterface不强制继承关系，不需要方法名称相同，
 * 只要求方法参数（类型和数量）与方法返回类型相同，即认为方法签名相同。
 */
public class Main {
    public static void main(String[] args) {
        String[] array = {"cbc","acd","bde"};
        Arrays.sort(array, new Comparator<String>() {
            //传入一个Comparator实例，以匿名类方式编写
            //匿名Comparator实例必须实现其compare方法
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------------------");
        String[] array1 = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array1, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(String.join(", ", array1));
        System.out.println("------------------------------------------------");
        String[] array2 = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array2, (s1, s2) -> s1.compareTo(s2));
        System.out.println(String.join(", ", array2));
        System.out.println("传入了静态方法cmp的引用------------------------------------------------");
        String[] array3 = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array3, Main::cmp);
        System.out.println(String.join(", ", array3));
        System.out.println("引用实例方法------------------------------------------------");
        String[] array4 = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array4, String::compareTo);
        System.out.println(String.join(", ", array4));

        System.out.println("引用实例方法------------------------------------------------");
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println("\uD83C\uDF04\uD83D\uDDFC");
        /**⬆⬆⬆⬆⤴⤴⤴🔺🔺🔺🔺🌄🗼
         * 后面我们会讲到Stream的map()方法。现在我们看到，这里的map()需要传入的FunctionalInterface的定义是：
         * @FunctionalInterface
         * public interface Function<T, R> {
         *     R apply(T t);
         * }
         * 把泛型对应上就是方法签名Person apply(String)，即传入参数String，返回类型Person。
         * 而Person类的构造方法恰好满足这个条件，因为构造方法的参数是String，
         * 而构造方法虽然没有return语句，但它会隐式地返回this实例，类型就是Person，
         * 因此，此处可以引用构造方法。构造方法的引用写法是类名::new，因此，此处传入Person::new。
         */
    }
    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}