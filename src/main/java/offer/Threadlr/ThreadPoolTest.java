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
public class ThreadPoolTest {
    public static void main(String[] args) {
        //int j = 0;
        haha();
        System.out.println(7777);
    }

    public static void haha(){
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
                }
            });
        }
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
}
