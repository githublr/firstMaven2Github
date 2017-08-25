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
            limiter = RateLimiter.create(qps);//RateLimiter.create(5) 表示桶容量为5且每秒新增5个令牌，即每隔200毫秒新增一个令牌；
            resourceRateLimiterMap.putIfAbsent(resource,limiter);
        }
        limiter.setRate(qps);                 //important method: setRate(double)
    }

    public static boolean enter(String resource) throws Exception {
        RateLimiter limiter = resourceRateLimiterMap.get(resource);
        if(limiter==null){
            throw new Exception(resource);
        }
        if(!limiter.tryAcquire()){            //表示消费一个令牌，如果当前桶中有足够令牌则成功（返回值为0）
            System.out.println("=========被限流了=======");
            return true;
        }
        return false;
    }

    static class TestWork implements Runnable{
        public void run() {
            try {
                if(!enter("test")){
                    System.out.println("*******没有被限流*********");
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
