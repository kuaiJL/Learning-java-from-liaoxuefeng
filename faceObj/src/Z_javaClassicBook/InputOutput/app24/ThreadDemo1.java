package Z_javaClassicBook.InputOutput.app24;
public class ThreadDemo1 extends Thread {
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
    public static void main(String[] args) {
        (new ThreadDemo1()).start();
    }
}