package liuchengkongzhi;

public class for_ {
    public static void main(String[] args) {
        foreach1();
        System.out.println("*********************");
        reverse1();
    }

    public static void foreach1() {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }

    public static void reverse1(){
        int[] ns = {1,4,9,16,25};
        for (int i = ns.length-1; i >= 0 ; i--) {
            System.out.println(ns[i]);
        }
    }
}
