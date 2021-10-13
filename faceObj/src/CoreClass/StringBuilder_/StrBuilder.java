package CoreClass.StringBuilder_;

/**
 * 小结
 * StringBuilder是可变对象，用来高效拼接字符串；
 *
 * StringBuilder可以支持链式操作，实现链式操作的关键是返回实例本身；
 *
 * StringBuffer是StringBuilder的线程安全版本，现在很少使用。
 */
public class StrBuilder {
    public static void main(String[] args) {
        {//代码块，s只在花括号类起作用
            String s = "";
            for (int i = 0; i < 3; i++) {
                s = s + "," + i;
                System.out.println(s);
            }
        }
        //String s ="11";
        System.out.println("****************");
        {
            StringBuilder sb = new StringBuilder(1024);
            System.out.println(sb.toString());
            for (int i = 0; i < 20; i++) {
                sb.append(',');
                sb.append(i);
            }
            System.out.println(sb);
            String s = sb.toString();
            System.out.println(s);
        }
        System.out.println("****************");
        {
            var sb = new StringBuilder(1024);
            sb.append("Mr ")
                    .append("Bob")
                    .append("!")
                    .insert(1, "Hello, ");
            System.out.println(sb.toString());
        }
        System.out.println("****************");
        {
            Adder adder = new Adder(1);
            adder.add(3)
                    .add(5)
                    .inc()
                    .add(10);
            System.out.println(adder.value());
        }
    }
}

//仿照StringBuilder，我们也可以设计支持链式操作的类。例如，一个可以不断增加的计数器：
class Adder {
    private int sum = 0;
    public Adder(int sum){
        this.sum=sum;
    }
    public Adder add(int n){
        sum += n;
        return this;
    }
    public Adder inc(){
        sum ++;
        return this;
    }
    public int value(){
        return sum;
    }
}