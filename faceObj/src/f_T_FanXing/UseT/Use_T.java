package f_T_FanXing.UseT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Use_T {
    public static void main(String[] args) {
        {
            //使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object：
// 编译器警告:
            List list = new ArrayList();
            list.add("Hello");
            list.add("World");
            String first = (String) list.get(0);
            String second = (String) list.get(1);
        }
        {
            //此时，只能把<T>当作Object使用，没有发挥泛型的优势。
            //当我们定义泛型类型<String>后，List<T>的泛型接口变为强类型List<String>：
            // 无编译器警告:
            List<String> list1 = new ArrayList<String>();
            list1.add("Hello");
            list1.add("World");
// 无强制转型:
            String first1 = list1.get(0);
            String second1 = list1.get(1);
        }
        {
            //当我们定义泛型类型<Number>后，List<T>的泛型接口变为强类型List<Number>：
            //list里面可以放Number的子类
            List<Number> list = new ArrayList<Number>();
            //如下有编译错误
            //list.add(new Integer(123));
            //list.add(new Double(12.34));
            //list.add(new Byte((byte) 112));
            list.add(1233456);
            list.add(123.3456);

            Number first = list.get(0);
            Number second = list.get(1);
            System.out.println(list);
        }

        {
           /*
                除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。
                例如，Arrays.sort(Object[])可以对任意数组进行排序，
                但待排序的元素必须实现Comparable<T>这个泛型接口：
            */
            Person[] ps = new Person[] {
                    new Person("Bob", 61),
                    new Person("Alice", 88),
                    new Person("Lily", 75),
                    new Person("rafa", 75),
            };
            Arrays.sort(ps);
            System.out.println(Arrays.toString(ps));
        }
    }
}
    /*
        如果不加“implements Comparable<Person>”运行程序，
        我们会得到ClassCastException，即无法将Person转型为Comparable。
        我们修改代码，让Person实现Comparable<T>接口：*/

class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public int compareTo(Person other) {
        if (this.score != other.score){
            return this.score-other.score;
        }
        else {
            return this.name.compareTo(other.name);
        }
    }
    public String toString() {
        return this.name + "," + this.score;
    }
}

