package offer.Threadlr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zack.lr on 2017/7/13.
 */
public class TheadTT {
    static final ExecutorService threadPool = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        // 定义一个缓冲的线程值 线程池的大小根据任务变化
        ttlr();
        System.out.println(8989889);
    }

    public static void ttlr(){
        for (int i = 0; i < 10; i++) {

            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        // 模拟子线程任务
                    } catch (InterruptedException e) {
                    }
                    System.out.println("子线程" + Thread.currentThread() + "执行完毕");

                }
            });

        }

        // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
        //threadPool.shutdown();

        try {
            // 请求关闭、发生超时或者当前线程中断，无论哪一个首先发生之后，都将导致阻塞，直到所有任务完成执行
            // 设置最长等待10秒
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //
            e.printStackTrace();
        }

        System.out.println("这里执行。");
    }

}
