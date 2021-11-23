package m_Thread_.base;

public class ThreadInterrupted1 {
        public static void main(String[] args) throws InterruptedException {
            Thread t = new MyThread1();
            t.start();
            Thread.sleep(30);//main线程暂停,HelloThread线程开始打印：i+hello，
            // MyThread1执行到 hello.join();  等待hello线程结束
            t.interrupt(); // 中断t线程，而此时t线程正位于hello.join()的等待中，此方法会立刻结束等待并抛出InterruptedException
            t.join(); // 等待t线程结束
            System.out.println("end");
        }
    }

    class MyThread1 extends Thread {
        public void run() {
            Thread hello = new HelloThread();
            hello.start(); // 启动hello线程
            try {
                System.out.println(1111111111);
                hello.join(); // 等待hello线程结束
                System.out.println(222222222);
            } catch (InterruptedException e) {
                System.out.println(e.hashCode()+e.toString());
                System.out.println("interrupted!");
            }
            hello.interrupt(); //MyThread1准备结束，同时通知HelloThread中断，
            // 而此时HelloThread大概率处在Thread.sleep(100);
            // 收到interrupt()，sleep(100)会抛出InterruptedException:sleep interrupted异常
            // 所以可能并不是通过while (!isInterrupted())判断退出HelloThread线程
            // 所以可以试一下，注释掉Thread.sleep(100);看看可不可以通过while (!isInterrupted())结束线程
            // 结果是可以的
        }
    }

/**
 * 如果目标线程处于等待状态，该线程会捕获到InterruptedException；
 * 目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程；
 */
class HelloThread extends Thread {
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.hashCode()+e.toString());
                    System.out.println(33333);
                    break;
                }
            }
        }
    }
