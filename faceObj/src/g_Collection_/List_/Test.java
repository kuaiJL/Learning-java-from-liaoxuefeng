package g_Collection_.List_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        { // 构造从start到end的序列：
            final int start = 10;
            final int end = 20;
            List<Integer> list = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                list.add(i);
            }
            // 随机删除List中的一个元素:
            int removed = list.remove((int) (Math.random() * list.size()));
            int found = findMissingNumber(start, end, list);
            System.out.println(list.toString());
            System.out.println("missing number: " + found);
            System.out.println(removed == found ? "测试成功" : "测试失败");
        }

        {
            final int start = 10;
            final int end = 20;
            List<Integer> list = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                list.add(i);
            }
            // 洗牌算法shuffle可以随机交换List中的元素位置:
            Collections.shuffle(list);
            // 随机删除List中的一个元素:
            int removed = list.remove((int) (Math.random() * list.size()));
            int found = findMissingNumber1(start, end, list);
            System.out.println(list.toString());
            System.out.println("missing number: " + found);
            System.out.println(removed == found ? "测试成功" : "测试失败");
        }
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        while(list.contains(start)){ // list.get(start - 10) == start
            start++;
        }
        return start;
    }

    static int findMissingNumber1(int start, int end, List<Integer> list) {
        // int sum = 0;
        // int sum1 = 0;
        // for (int i = start; i <= end; i++) {
        //     sum += i;
        //     if(i!=20){
        //         sum1 += list.get(i - 10);
        //     }
        // }
        // System.out.println(sum);
        // System.out.println(sum1);
        // return sum - sum1;
        // int i=start;
        // for(;list.indexOf(i)>=0;i++) {}
        // return i;
        while(list.contains(start)){ // list.get(start - 10) == start
            start++;
        }
        return start;
    }

}
