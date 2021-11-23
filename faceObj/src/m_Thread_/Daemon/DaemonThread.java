package m_Thread_.Daemon;

import java.time.LocalTime;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        TimerThread t = new TimerThread();
        //如何创建守护线程呢？方法和普通线程一样，只是在调用start()方法前，
        // 调用setDaemon(true)把该线程标记为守护线程
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}