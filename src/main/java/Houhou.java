import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zack.lr on 2017/6/14.
 */
public class Houhou {
    public static void main(String[] args) {
        System.out.println("houhou");

        System.out.println(Double.valueOf(Double.valueOf("6.355555") * 100).longValue());

        String[] lirui = null;
        lirui = "lirui,l8izh,lidan".split(",");
        System.out.println(lirui[0]+lirui[1]+lirui[2]);

        for(int i=0;i<10000;i++){
            ArrayList<Long> longs = new ArrayList<Long>();
        }

        ArrayList<Long> long2 = new ArrayList<Long>();
        long2.add(22L);
        long2.add(33L);
        long2.add(44L);
        System.out.println(long2.contains(22L));

        System.out.println("ha");
    }

    @Test
    public void teststringbuffer(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("lirui");
        buffer.append("lizhi");
        System.out.println(buffer.toString());

        Long aa = 5L;
        System.out.println(aa.toString());
    }

    @Test
    public void testkkk(){
        HashMap<String, Long> map = new HashMap<String, Long>();
        Long haha = map.put("haha", null);
        if(map.get("haha") == null){
            System.out.println(123);
        }
    }

    @Test
    public void hhkk(){
        //Long gearMkc = 5L;
        Long gearMkc = null;
        gearMkc=(gearMkc==null?0:gearMkc);
        System.out.println(gearMkc);
    }

    @Test
    public void uuoo(){
        Long gear = 5L;
        Long gearMkc = null;

        if(gear != null || gearMkc != null ){
            System.out.println(1222);
        }

        if( gearMkc != null || gear != null ){
            System.out.println(4455);
        }

        Integer a = null;
        Integer b = 0;
        System.out.println(a==b);   //false
    }

    @Test
    public void testuu(){
        //将offerId数据集从List<String>转化为Set<Long>
        Set<Long> offerIds = new HashSet<Long>();
        for(long i=0;i<offerIds.size();i++){
            offerIds.add(i);
        }

        Object[] objects = offerIds.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void hh44(){
        String status = "approved";
        boolean a = !"approved".equals(status) && !"tbd".equals(status);
        System.out.println(a);
        if(a){
            System.out.println("haha");
        }

        boolean b = !"approved".equals(status) || !"tbd".equals(status);
        System.out.println(b);
        if(b){
            System.out.println("haha");
        }
    }

    @Test
    public void uu(){
        Integer gearMkc=null;
        Long memDiscountMkc = 933L;
        if(gearMkc!=null || memDiscountMkc!=null ){
            System.out.println( "报名端是退出报名状态，而mkc端却有值：");
        }

        int a = 0;
        Long b = 0L;
        System.out.println(a==b);
    }

    @Test
    public void uu2() {
        Integer gearMkc = null;
        Long memDiscountMkc = null;
        if (gearMkc != null || memDiscountMkc != null) {
            System.out.println("报名端是退出报名状态，而mkc端却有值：");
        } else {
            System.out.println("enen");
        }
    }
}
