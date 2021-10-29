package Z_javaClassicBook.InputOutput.app24;
public class DeliveryNoteHolder {
    private String deliveryNote;
    private boolean available = false;

    public synchronized String get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("do not wait()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                return Thread.currentThread().getName()+"结束";
            }
        }
        available = false;
        System.out.println(System.currentTimeMillis()
                + ": got " + deliveryNote);
        notifyAll();
        System.out.print("得到了 deliveryNote;");
        return deliveryNote;
    }

    public synchronized void put(String deliveryNote) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        this.deliveryNote = deliveryNote;
        available = true;
        System.out.println(System.currentTimeMillis() + 
                ": Put " + deliveryNote);
        notifyAll();
    }
}