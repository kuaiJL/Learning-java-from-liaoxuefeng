package Z_javaClassicBook.InputOutput.app24;
public class DriverThread extends Thread {
    DeliveryNoteHolder deliveryNoteHolder;
    public volatile boolean stopped = false;
    String driverName;

    public DriverThread(DeliveryNoteHolder holder, String
            driverName) {
        deliveryNoteHolder = holder;
        this.driverName = driverName;
    }

    @Override
    public void run() {
            while (!stopped) {
                String deliveryNote = deliveryNoteHolder.get();
                System.out.println("-----"+driverName);
                System.out.println("得到还是结束："+deliveryNote);
                System.out.println("---------------------------------");
                try {
                    sleep(300);
                    System.out.println(Thread.currentThread().getName()+"sleep(300);");
                } catch (InterruptedException e) {
                    System.out.println("iiiiiiiiiiii");
                }
            }
            System.out.println(Thread.currentThread().getName()+"stopped");
    }
}