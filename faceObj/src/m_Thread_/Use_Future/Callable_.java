package m_Thread_.Use_Future;

        import java.math.BigDecimal;
        import java.math.RoundingMode;
        import java.util.concurrent.*;

public class Callable_ {
    public static void main(String[] args) throws Exception {
//        BigDecimal bigDecimal = null;
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task("601857"));
        System.out.println(future.isDone()+"1");
            while (!future.isDone()){
                //使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，
                // 这两种方法都不是很好，因为主线程也会被迫等待。so 使用CompletableFuture
            }
        System.out.println("oooooo");
        System.out.println(future.get());//在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
        System.out.println(future.isDone()+"2");

//        try {
//             bigDecimal = future.get(2, TimeUnit.SECONDS);
//        }catch (TimeoutException e){
//            System.out.println(bigDecimal+"KJL");
//            System.out.println("异步");
//        }
        es.shutdown();
    }
}

class Task implements Callable<BigDecimal> {

    public Task(String code) {
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(3000);
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
    }
}
