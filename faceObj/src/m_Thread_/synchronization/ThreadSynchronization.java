package m_Thread_.synchronization;

/**
 * 当多个线程同时运行时，线程的调度由操作系统决定，程序本身无法决定。
 * 因此，任何一个线程都有可能在任何指令处被操作系统暂停，然后在某个时间段后继续执行。
 * 这个时候，有个单线程模型下不存在的问题就来了：如果多个线程同时读写共享变量，会出现数据不一致的问题。
 */
public class ThreadSynchronization {
    public static void main(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
        System.out.println(Counter.count1);
    }
}

class Counter {
    //用Counter.lock实例作为锁，两个线程在执行各自的synchronized(Counter.lock) { ... }代码块时，
    // 必须先获得锁，才能进入代码块进行。执行结束后，在synchronized语句块结束会自动释放锁。
    // 这样一来，对Counter.count变量进行读写就不可能同时进行。
    // 上述代码无论运行多少次，最终结果都是0。
    public static final Object lock = new Object();
    public static int count = 0;
    public static int count1 = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i=0; i<100000; i++) {
            Counter.count += 1;
            synchronized(Counter.lock) {//同步Count1
                Counter.count1 += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i=0; i<100000; i++) {
            Counter.count -= 1;
            synchronized(Counter.lock) {//同步Count1
                Counter.count1 -= 1;
            }
        }
    }
}

