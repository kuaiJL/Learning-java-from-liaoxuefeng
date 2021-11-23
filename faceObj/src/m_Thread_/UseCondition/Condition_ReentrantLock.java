package m_Thread_.UseCondition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock比直接使用synchronized更安全，可以替代synchronized进行线程同步。
 * 但是，synchronized可以配合wait和notify实现线程在条件不满足时等待，条件满足时唤醒，
 * 用ReentrantLock我们怎么编写wait和notify的功能呢？
 * 答案是使用Condition对象来实现wait和notify的功能。
 * 我们仍然以TaskQueue为例，把前面用synchronized实现的功能通过ReentrantLock和Condition来实现：
 */
public class Condition_ReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        var q = new TaskQueue();
        //对于q，当多个线程调用q.addTask()时，相当于多个线程同时添加任务，
        //但是addTask用synchronized修饰了，所以解决了线程安全问题，多线程竞争
        var ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            //多个线程在等待获取要执行的任务
            var t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        /*加入队列线程*/
        var add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + ((int) (Math.random() * 100)&0x1f);
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);
        //中断结束在等待的线程
        for (var t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
                /*if (condition.await(1, TimeUnit.SECOND)) {
                    // 被其他线程唤醒
                } else {
                    // 指定时间内没有被其他线程唤醒
                }*/
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}

