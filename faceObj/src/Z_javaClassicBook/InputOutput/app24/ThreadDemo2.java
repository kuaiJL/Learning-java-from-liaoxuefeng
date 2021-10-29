package Z_javaClassicBook.InputOutput.app24;
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}