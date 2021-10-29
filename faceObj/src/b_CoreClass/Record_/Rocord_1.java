package b_CoreClass.Record_;

/**
 * 从Java 14开始，提供新的record关键字，可以非常方便地定义Data Class：
 * 使用record定义的是不变类；
 * 可以编写Compact Constructor对参数进行验证；
 * 可以定义静态方法。
 */
public class Rocord_1 {
    public static void main(String[] args) {
        Point p = new Point(123, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);
        //这样我们可以写出更简洁的代码：
        var z = Point.of();
        var p1 = Point.of(123, 456);
    }
}

record Point(int x, int y) {
    //注意到方法public Point {...}被称为Compact Constructor，它的目的是让我们编写检查逻辑，
    public Point{
        if (x<0||y<0){
            throw new IllegalArgumentException();
        }
    }
    //作为record的Point仍然可以添加静态方法。一种常用的静态方法是of()方法，用来创建Point
    //这样我们可以写出更简洁的代码：
    public static Point of() {
        return new Point(0, 0);
    }
    public static Point of(int x, int y) {
        return new Point(x, y);
    }
}