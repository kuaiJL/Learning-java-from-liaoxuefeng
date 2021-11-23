package m_Thread_.UseReadWriteLock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock_ {
    public static void main(String[] args) {
        Counter c = new Counter();
        new Thread(() ->{
            for (int i = 0; i < 100000; i++) {
                c.inc(i/10000);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    System.out.println(Arrays.toString(c.get()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"得到了");
            }).start();
        }


    }
}

class Counter {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() throws InterruptedException {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            Thread.sleep(1000);//在某一读线程释放锁前，让该线程睡眠1秒，
            // 如果在释放锁前，其他读线程无法读写，则会在10秒后所有线程才会读完毕，
            // 但是程序运行的时间显然很短，明显小于10秒，说明使用ReadWriteLock的readLock()🔒时
            //就算没有释放🔒，其他读线程依然可以进行get()读操作。
            rlock.unlock(); // 释放读锁
        }
    }
}