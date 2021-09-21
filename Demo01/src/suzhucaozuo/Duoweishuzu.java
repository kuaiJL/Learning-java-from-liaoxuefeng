package suzhucaozuo;

import java.util.Arrays;

public class Duoweishuzu {
    public static void main(String[] args) {
        int [][] ns ={{1,2,3,4},{5,6},{7,8,9}};
        for (int [] arr: ns) {
            for (int n:arr) {
                System.out.print(n+",");
            }
            System.out.println();
        }
        //或者使用Java标准库的Arrays.deepToString()
        System.out.println("*****************");
        System.out.println(Arrays.deepToString(ns));

        // 用二维数组表示的学生成绩:
        {double average = 0;
        int sum=0;
        int counts=0;
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        for (int [] s_sco:scores) {
            for (int n : s_sco) {
                sum+=n;
            }
            counts+=s_sco.length;
        }
        average=sum/counts;

        System.out.println(average);}

        for (String arg : args) {
            if ("-version".equals(arg)) {
                System.out.println("v 1.0");
                break;
        }
    }
}}
