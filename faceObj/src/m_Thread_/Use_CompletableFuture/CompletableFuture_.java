package m_Thread_.Use_CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，
 * 这两种方法都不是很好，因为主线程也会被迫等待。
 * 从Java 8开始引入了CompletableFuture，它针对Future做了改进，
 * 可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
 */
public class CompletableFuture_ {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:  需要一个实现了Supplier接口的对象：
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFuture_::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        System.out.println("异步");
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
