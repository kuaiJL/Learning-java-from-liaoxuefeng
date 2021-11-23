package m_Thread_.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_ {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            //for (int i = 0; i < 10000; i++) {
            try {
                c.add(1);
                //Thread.sleep(2000);这样没有，🔒已经在add里面释放
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //}
        }).start();

//        new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                c.dec(1);
//            }
//        }).start();

        new Thread(() -> {
            try {
                c.tryGetLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        Thread.sleep(5000);
        System.out.println(c.count);
    }

}

class Counter {
    private final Lock lock = new ReentrantLock();
    public int count;

    public void add(int n) throws InterruptedException {
        lock.lock();
        try {
            count += n;
        } finally {
            System.out.println("睡2秒前");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("睡2秒后");
            lock.unlock();
        }
    }

    public void dec(int n) {
        lock.lock();
        try {
            count -= n;
        } finally {
            lock.unlock();
        }
    }

    public void tryGetLock() throws InterruptedException {
        //如果1秒后仍未获取到锁，tryLock()返回false，程序就可以做一些额外处理(跳出判断)
        if (lock.tryLock(1, TimeUnit.SECONDS)) {//换成5秒，则可获得🔒
            try {
                System.out.println("获得了🔒");
                count += 777;
            } finally {
                lock.unlock();
            }
        }
        System.out.println("没有获得🔒,俺去做其他事了");
    }
}

/**
 * synchronized关键字用于加锁，但这种锁一是很重，二是获取时必须一直等待，没有额外的尝试机制。
 * java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁，
 */