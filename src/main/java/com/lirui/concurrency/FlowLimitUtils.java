package com.lirui.concurrency;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zack.lr on 2017/6/23.
 */
public class FlowLimitUtils {
    private static final ConcurrentHashMap<String,RateLimiter> resourceRateLimiterMap = new ConcurrentHashMap<String,RateLimiter>();

    public static void createFlowLimitMap(String resource,double qps){
        RateLimiter limiter = resourceRateLimiterMap.get(resource);
        if(limiter==null){
            limiter = RateLimiter.create(qps);//RateLimiter.create(5) ��ʾͰ����Ϊ5��ÿ������5�����ƣ���ÿ��200��������һ�����ƣ�
            resourceRateLimiterMap.putIfAbsent(resource,limiter);
        }
        limiter.setRate(qps);                 //important method: setRate(double)
    }

    public static boolean enter(String resource) throws Exception {
        RateLimiter limiter = resourceRateLimiterMap.get(resource);
        if(limiter==null){
            throw new Exception(resource);
        }
        if(!limiter.tryAcquire()){            //��ʾ����һ�����ƣ������ǰͰ�����㹻������ɹ�������ֵΪ0��
            System.out.println("=========��������=======");
            return true;
        }
        return false;
    }

    static class TestWork implements Runnable{
        public void run() {
            try {
                if(!enter("test")){
                    System.out.println("*******û�б�����*********");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String source = "test";
        double qps = 10;
        createFlowLimitMap(source,qps);
        Thread.sleep(1000L);
        ExecutorService pools = Executors.newFixedThreadPool(40);
        for(int i=0;i<16;i++){
            TestWork testWork = new TestWork();
            pools.execute(testWork);
        }
    }

    @Test
    public void testlr(){
/*        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));*/

        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(10));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
    }

}
