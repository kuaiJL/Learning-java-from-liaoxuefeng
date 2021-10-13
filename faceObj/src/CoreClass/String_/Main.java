package CoreClass.String_;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**小结
 * Java字符串String是不可变对象；
 * 字符串操作不改变原字符串内容，而是返回新字符串；
 * 常用的字符串操作：提取子串、查找、替换、大小写转换等；
 * Java使用Unicode编码表示String和char；
 * 转换编码就是将String和byte[]转换，需要指定编码；
 * 转换为byte[]时，始终优先考虑UTF-8编码。
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //Java字符串的一个重要特点就是字符串不可变。
        // 这种不可变性是通过内部的private final char[]字段，
        // 以及没有任何修改char[]的方法实现的。
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        /**
         * 字符串Hello并没有改变，改变的是s的指向，s->HELLO
         * 从表面上看，两个字符串用==和equals()比较都为true，
         * 但实际上那只是Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，
         * 自然s1和s2的引用就是相同的。
         */
        String s11 = "hello";
        String s22 = "HELLO".toLowerCase();
        System.out.println(s11 == s22);
        System.out.println(s11.equals(s22));//结论：两个字符串比较，必须总是使用equals()方法。
        System.out.println("***************************");
        // 是否包含子串:
        System.out.println("Hello".contains("ll"));// true
        "Hello".contains("ll"); // true
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll"
        System.out.println("  \tHello\r\n ".trim());

//        格式化字符串
//        字符串提供了formatted()方法和format()静态方法，可以传入其他参数，替换占位符，然后生成新的字符串：
        String ss = "Hi %s, your score is %d!";
        System.out.println(ss.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        System.out.println("kkk"+ss);
        //要特别注意，Integer有个getInteger(String)方法，
        // 它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        System.out.println(Integer.getInteger("java.version"));
        System.out.println("*******************");
        /**
         * important！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
         * 这是因为通过new String(char[])创建新的String实例时，
         * 它并不会直接引用传入的char[]数组，而是会复制一份，
         * 所以，修改外部的char[]数组不会影响String实例内部的char[]数组，因为这是两个不同的数组。
         */
        char[] cs = "Hello".toCharArray();
        String sss = new String(cs);
        System.out.println(sss);
        cs[0] = 'X';
        System.out.println(sss);
        /** ^^^^^
         * 这是因为通过new String(char[])创建新的String实例时，
         * 它并不会直接引用传入的char[]数组，而是会复制一份，
         * 所以，修改外部的char[]数组不会影响String实例内部的char[]数组，因为这是两个不同的数组。
         */
        System.out.println("*******************");
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score ssss = new Score(scores);
        ssss.printScores();
        scores[2] = 99;
        ssss.printScores();
        /** ^^^^^^
         * 观察两次输出，由于Score内部直接引用了外部传入的int[]数组，
         * 这会造成外部代码对int[]数组的修改，影响到Score类的字段。
         *  如果外部代码不可信，这就会造成安全隐患。
         */
        System.out.println("*******************");
        byte[] b1 = "中国".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b2 = "中A".getBytes("UTF-8"); // 按UTF-8编码转换  [-28, -72, -83, 65]:e4b8ad,0x41=65
        //System.out.println("\u4e2d\u56fd");
        //System.out.println(new String(b1));
        byte[] b3 = "中国".getBytes("GBK"); // 按GBK编码转换
        byte[] b4 = "中国".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        byte[] b5 = "中国".getBytes("Unicode");
        System.out.println(Arrays.toString(b1)+Arrays.toString(b2)+"\n"+Arrays.toString(b3)+Arrays.toString(b4)+Arrays.toString(b5));
    }
}

class Score {
    private int[] scores;
    public Score(int[] scores) {
        // this.scores = scores;
        this.scores = Arrays.copyOf(scores,scores.length);
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
