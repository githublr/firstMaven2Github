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
        // ����һ��������߳�ֵ �̳߳صĴ�С��������仯
        ttlr();
        System.out.println(8989889);
    }

    public static void ttlr(){
        for (int i = 0; i < 10; i++) {

            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        // ģ�����߳�����
                    } catch (InterruptedException e) {
                    }
                    System.out.println("���߳�" + Thread.currentThread() + "ִ�����");

                }
            });

        }

        // ����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������
        //threadPool.shutdown();

        try {
            // ����رա�������ʱ���ߵ�ǰ�߳��жϣ�������һ�����ȷ���֮�󣬶�������������ֱ�������������ִ��
            // ������ȴ�10��
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //
            e.printStackTrace();
        }

        System.out.println("����ִ�С�");
    }

}
