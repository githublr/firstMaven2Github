package offer.Threadlr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zack.lr on 2017/7/12.
 */
public class ThreadPoolTest22 {
    public static void main(String[] args) {
        //int j = 0;
        //final int a=0;
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        synchronized (ThreadPoolTest22.class){
            for (int i = 0; i < 10; i++) {
                final int index = i;
                cachedThreadPool.execute(new Runnable() {
                    volatile int j=0;
                    public void run() {
                        System.out.println("haa"+(index));
                        //a =6;
                    }
                });
            }
        }
        System.out.println(7777);
    }

    public static void haha(){
        final int[] a = {0};
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {

            final int index = i;
/*            try {
                //Thread.sleep(index * 1000);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            cachedThreadPool.execute(new Runnable() {
                volatile int j=0;
                public void run() {
                    System.out.println("haa"+(index));
                    a[0] =6;
                }
            });
        }

        System.out.println(a[0]);
    }

    @Test
    public void testfinal(){
        final HashMap<String, String> map = new HashMap<String, String>();
        map.put("lirui","haha");
        map.put("enen","xoxo");

        for(final Map.Entry<String,String> a:map.entrySet()){
            System.out.println(a.getKey());
        }

        final Person a = new Person();
        for(int i=0;i<2;i++){
            a.setName("lirui");
            a.setName("Àîî£");
            System.out.println(a.getName());
        }

        ArrayList<Integer> aa = new ArrayList<Integer>();
        aa.add(12);
        aa.add(34);
        aa.add(56);
        for(final int bb:aa){
            System.out.println(bb);
        }
    }

    class Person{
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void test123(){
        int threadCount = 3;

        synchronized(this)
        {
            Thread[] threads = new Thread[4];

            for (int i = 0; i < threadCount; i++)
            {
                //Thread t = new Thread(new ThreadStart(Add));
                Thread t = new Thread();
                threads[i] = t;
            }
            for (int i = 0; i < threadCount; i++)
            {
                threads[i].start();
            }
        }

        //SomeMethod();
    }
        public void Add()
        {
//
        }
}
