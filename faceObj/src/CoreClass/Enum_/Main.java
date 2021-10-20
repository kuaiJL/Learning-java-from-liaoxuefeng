package CoreClass.Enum_;

public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        System.out.println(Weekday.SAT.ordinal());
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
        System.out.println("************************************");
        Weekday1 day1 = Weekday1.SUN;
        if (day1.dayValue == 6 || day1.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
        System.out.println("************************************");
        Weekday2 day2 = Weekday2.SUN;
        if(day2.dayValue==6 || day2.dayValue==0){
            System.out.println("Today is "+day2+". Work at home!");
        }
        else {
            System.out.println("Today is "+day2+". Work at office!");
        }
        System.out.println("************************************");
        switch(day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday{
    SUN, MON, TUE, WED, THU, FRI, SAT
}

//例如，我们定义的Color枚举类：
enum Color {
    RED, GREEN, BLUE;
}

//编译器编译出的class大概就像这样：

/**
 * public final class Color extends Enum { // 继承自Enum，标记为final class
 *     // 每个实例均为全局唯一:
 *     public static final Color RED = new Color();
 *     public static final Color GREEN = new Color();
 *     public static final Color BLUE = new Color();
 *     // private构造方法，确保外部无法调用new操作符:
 *     private Color() {}
 * }
 */

/**
 * 但是，如果不小心修改了枚举的顺序，编译器是无法检查出这种逻辑错误的。
 * 要编写健壮的代码，就不要依靠ordinal()的返回值。
 * 因为enum本身是class，所以我们可以定义private的构造方法，并且，给每个枚举常量添加字段：
 */
enum Weekday1 {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;
    private Weekday1(int dayValue) {
        this.dayValue = dayValue;
    }
}

enum Weekday2 {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday2(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}
