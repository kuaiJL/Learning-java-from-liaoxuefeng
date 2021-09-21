package suzhucaozuo;

import java.util.Arrays;

public class shuzupaixu {
    public static void main(String[] args) {
        // 排序前:
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        System.out.println("排序前："+Arrays.toString(ns));
        BubbleSort(ns,true);
        BubbleSort(ns,false);
        //Java的标准库已经内置了排序功能，我们只需要调用JDK提供的Arrays.sort()就可以排序
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));

    }

    //冒泡排序
    public static void BubbleSort(int[] ns,boolean flag) {
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if(flag==true){
                    if (ns[j] > ns[j+1]) {
                        // 交换ns[j]和ns[j+1]:
                        int tmp = ns[j];
                        ns[j] = ns[j+1];
                        ns[j+1] = tmp;
                    }
                }
                else {
                    if(ns[j+1]>ns[j]){
                        int tmp = ns[j];
                        ns[j] = ns[j+1];
                        ns[j+1] = tmp;
                    }
                }
            }
        }
        // 排序后:
        System.out.println(Arrays.toString(ns));
    }


}
