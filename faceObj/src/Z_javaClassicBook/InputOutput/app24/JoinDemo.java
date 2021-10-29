package Z_javaClassicBook.InputOutput.app24;
public class JoinDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("After 3 seconds");
        });
        thread.start();

        try {
			thread.join();
		} catch (InterruptedException e) {
		}
        System.out.println("Exit");
    }
}