package offer.Threadlr;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by zack.lr on 2017/7/13.
 */
public class ThreadSubMain2 {
    public static void main(String[] args) {
        // ʹ���̰߳�ȫ��Vector
        Vector<Thread> threads = new Vector<Thread>();
        for (int i = 0; i < 10; i++) {

            Thread iThread = new Thread(new Runnable() {
                public void run() {

                    try {
                        Thread.sleep(1000);
                        // ģ�����߳�����
                    } catch (InterruptedException e) {
                    }
                    System.out.println("���߳�" + Thread.currentThread() + "ִ�����");

                }
            });

            threads.add(iThread);
            iThread.start();
        }

        for (Thread iThread : threads) {
            try {
                // �ȴ������߳�ִ�����
                iThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("����ִ�С�");
    }

    @Test
    public void hehe(){
        Integer a=0;
        if(a==0){
            System.out.println(222);
        }
        System.out.println(Integer.valueOf("7"));
    }
}
