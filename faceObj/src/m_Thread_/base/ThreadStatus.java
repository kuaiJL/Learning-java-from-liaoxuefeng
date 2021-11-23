package m_Thread_.base;

public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        //Thread.sleep(5); //main线程睡眠5毫秒 ： start->hello->end
        //t.join();  //t.join()等待t线程结束后再继续运行：start->hello->end
        System.out.println("end");
    }
}
