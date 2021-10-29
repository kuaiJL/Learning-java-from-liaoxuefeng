package Z_javaClassicBook.InputOutput.app24;
public class ThreadCoordinationDemo {
    public static void main(String[] args) throws InterruptedException {
        DeliveryNoteHolder c = new DeliveryNoteHolder();
        DispatcherThread dispatcherThread = new DispatcherThread(c);

        DriverThread driverThread1 = new DriverThread(c, "Eddie");
        DriverThread driverThread2 = new DriverThread(c, "kjl");

        driverThread1.setName("Eddie线程：");
        driverThread2.setName("kjl线程：");

        dispatcherThread.start();
        driverThread1.start();
        driverThread2.start();
        Thread.sleep(2000);
        System.out.println("派单员线程状态"+dispatcherThread.getState());
        System.out.println("派单员线程活着吗："+dispatcherThread.isAlive());

        if (!dispatcherThread.isAlive()){
            driverThread1.stopped=true;
            driverThread2.stopped=true;
        }
        Thread.sleep(100);
        driverThread1.interrupt();
        driverThread2.interrupt();
        Thread.sleep(1000);
        System.out.println(driverThread1.stopped);
        System.out.println(driverThread1.isAlive());
        System.out.println(driverThread2.isAlive());

    }
}