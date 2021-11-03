package g_Collection_.List_;

import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        {
            List<String> list = List.of("apple", "pear", "banana");
            // 四种遍历List方式
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                System.out.println(s);
            }
            for (Iterator<String> it = list.iterator(); it.hasNext();) {
                String s = it.next();
                System.out.println(s);
            }
            System.out.println("----------------------------");
            for (String string : list) {
                System.out.println(string);
            }
            System.out.println("----------------------------");
            list.forEach(System.out::println);
        }
        System.out.println("----------------------------");
        {// List和Array转换\
            // List to Array
            List<String> list1 = List.of("apple", "pear", "banana");
            Object[] array = list1.toArray();//
            for (Object s : array) {
                System.out.println(s);
            }
            List<Integer> list = List.of(123, 456, 789);

            Integer[] array1 = list.toArray(new Integer[3]);///
            for (Integer n : array1) {
                System.out.println(n);
            }
            Number[] array2 = list.toArray(new Number[3]);//
            for (Number n : array2) {
                System.out.println(n);
            }
            Integer[] array3 = list.toArray(new Integer[list.size()]);// 最常用的是传入一个“恰好”大小的数组
            for (Integer n : array3) {
                System.out.println(n);
            }
            Integer[] array4 = list.toArray(Integer[]::new);//
            for (Integer n : array4) {
                System.out.println(n);
            }
        }
        System.out.println("----------------------------");
        {//如果我们调用List.of()，它返回的是一个只读List：
            //Arrary to List
            Integer[] array = { 1, 2, 3 };
            List<Integer> list = List.of(array);
            List<Integer> list1 = List.of( new Integer[]{4,5,6} );
            System.out.println(list+"----"+list1);
            //list.add(7);
            //list1.add(4);
        }
    }
}
