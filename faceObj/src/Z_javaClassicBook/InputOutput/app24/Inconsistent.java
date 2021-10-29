package Z_javaClassicBook.InputOutput.app24;
public class Inconsistent {
    static boolean started = false;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                started = true;
                System.out.println("started set to true");
            }
        });
        thread1.start();

        while (!started) {
            // wait until started
        }
        int a = 1;
        System.out.println("Wait 3 seconds and exit");
    }

}