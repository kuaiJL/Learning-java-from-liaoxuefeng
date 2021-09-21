package liuchengkongzhi;
import java.util.Scanner;
//https://www.liaoxuefeng.com/wiki/1252599548343744/1255887264020640#0
public class in_out {
    public static void main(String[] args) {
        promote();
    }


    public static void in(){
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }

    //请帮小明同学设计一个程序，输入上次考试成绩（int）和本次考试成绩（int），
    // 然后输出成绩提高的百分比，保留两位小数位（例如，21.75%）。
    /**       %.2f%%;;;;
     *         float pro=(float)(thisScore-beforeScore)/beforeScore;
     */
    public static void promote(){
        Scanner scanner1 = new Scanner(System.in); // 创建Scanner对象
        System.out.print("上次成绩: "); // 打印提示
        int beforeScore = scanner1.nextInt(); // 读取一行输入并获取整数
        System.out.print("这次成绩: "); // 打印提示
        int thisScore = scanner1.nextInt(); // 读取一行输入并获取整数
        float pro=(float)(thisScore-beforeScore)/beforeScore;
        System.out.println(pro);
        System.out.printf("这次成绩：%d, 这次成绩：%d \n,提高了：%.2f%%",beforeScore,thisScore,pro*100);

    }
}
