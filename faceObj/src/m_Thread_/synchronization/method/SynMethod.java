package m_Thread_.synchronization.method;

/**
 * 让线程自己选择锁对象往往会使得代码逻辑混乱，也不利于封装。
 * 更好的方法是把synchronized逻辑封装起来。
 */
public class SynMethod {
    public static void main(String[] args) throws InterruptedException {
        //synchronized锁住的对象是this，即当前实例，这又使得创建多个Counter实例的时候，
        // 它们之间互不影响，可以并发执行：
        var c1 = new Counter();
        var c2 = new Counter();
        {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    c1.add(1);
                }
            }).start();

            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    c1.dec(1);
                }
            }).start();
        }

        {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    c2.add(1);
                }
            }).start();

            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    c2.dec(1);
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(c1.count);
        System.out.println(c2.count);
    }
}

//如果一个类被设计为允许多线程正确访问，
// 我们就说这个类就是“线程安全”的（thread-safe），下面的Counter类就是线程安全的
class Counter {
    public int count = 0;

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }
        /*等价上面的add*/
//    public synchronized void add(int n) { // 锁住this
//        count += n;
//    } // 解锁

    public synchronized void dec(int n) {
            count -= n;
    }

    public int get() {
        return count;
    }
}