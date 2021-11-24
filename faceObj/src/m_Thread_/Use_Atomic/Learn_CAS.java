package m_Thread_.Use_Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Learn_CAS {
    private AtomicInteger atomicInteger;

    public Learn_CAS(AtomicInteger a){
        this.atomicInteger = a;
    }

    int incrementAndGet() {
        int prev, next;
        do {
            prev = atomicInteger.get();
            next = prev + 1;
        } while ( ! atomicInteger.compareAndSet(prev, next));
        //若prev被其他线程改了，则返回false，继续循环
        return next;
    }

    public static void main(String[] args) throws InterruptedException {
        {
            Learn_CAS learn_cas = new Learn_CAS(new AtomicInteger(67));
            new Thread(() -> {
                learn_cas.atomicInteger.incrementAndGet();
            }).start();
            Thread.sleep(10);
            int newValue = learn_cas.incrementAndGet();
            System.out.println(newValue);
            Thread.sleep(100);
            System.out.println(learn_cas.atomicInteger);
        }
        System.out.println("-----------------------------");
        //我们利用AtomicLong可以编写一个多线程安全的全局唯一ID生成器：
        IdGenerator idGenerator = new IdGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.print(idGenerator.getNextId());
        }
    }
}

//我们利用AtomicLong可以编写一个多线程安全的全局唯一ID生成器：

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
