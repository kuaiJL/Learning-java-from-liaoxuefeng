package Z_javaClassicBook.InputOutput.app24;
public class SafeUserStat {
    int userCount;

    public synchronized int getUserCount() {
        return userCount;
    }

    public synchronized void increment() {
        userCount++;
    }

    public synchronized void decrement() {
        userCount--;
    }
}