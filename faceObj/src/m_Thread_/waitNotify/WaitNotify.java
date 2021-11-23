package m_Thread_.waitNotify;

import java.util.*;

public class WaitNotify {
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
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
