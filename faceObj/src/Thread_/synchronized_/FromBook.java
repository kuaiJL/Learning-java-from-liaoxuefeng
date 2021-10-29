package Thread_.synchronized_;

public class FromBook {
    static boolean started = false;

    public synchronized static void setStarted() { //delete synchronized
        started = true;}
    public synchronized static boolean getStarted() {//delete synchronized
        return started;}

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                setStarted();
                System.out.println("started set to true");
            }
        });
        thread1.start();

        while (!getStarted()) {
            // wait until started
            // System.out.println(getStarted());
            /**
             * f I delete "synchronized" , "Wait 3 seconds and exit" will not be printed.
             * But if I add "System.out.println(getStarted());" or "System.out.println(123);"...
             * inside the while loop, "Wait 3 seconds and exit" will be printed.
             * I want to know why
             */
      /*
          answer:When you move println into the while loop, you introduce additional synchronization
            because println uses synchronized memory access internally.
       */

        }

        System.out.println("Wait 3 seconds and exit");
    }

}