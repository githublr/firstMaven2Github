import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by zack.lr on 2017/5/26.
 */
public class Helloworld {
    public static void main(String[] args) {
        System.out.println("lirui2");
        System.out.println("lirui0614");
        System.out.println("enenenen");
        Object a = "12";
        System.out.println(Long.valueOf(a.toString()));
        String b = "中国";
        System.out.println(b.equals("中国"));
        ArrayList<Long> longs = new ArrayList<Long>();
        ArrayList<Long> longs2 = new ArrayList<Long>(12);
        boolean add = new ArrayList<Integer>().add(12);

        Integer c = null;
        c = Integer.valueOf("33");
        System.out.println(c);

        System.out.println(Long.parseLong("9.4"));
        System.out.println(Long.valueOf("9.3"));

        Integer ha = 3;
        Long bb = 4L;
        testlr(ha,bb);
    }

    public static void testlr(int ha , long bb){
        System.out.println(ha);System.out.println(bb);

    }

    @Test
    public void testff(){
        //java.math.BigDecimal
        System.out.println(Double.valueOf("345.666").longValue());
        System.out.println(Double.valueOf("567.890"));
        Double aa = Double.valueOf("567.890");
        BigDecimal decimal;
        //decimal = new BigDecimal();

        System.out.println(aa.longValue());
        double v = Double.parseDouble("3.4444");

        System.out.println(Double.valueOf("5.666").longValue());

        System.out.println(Double.parseDouble("2.3333333"));
        System.out.println(Long.parseLong("3.5555L"));
    }

    @Test
    public void testlrrr(){
        /*long aa = 1.34L;
        Long bb = 1.34L;
        Long cc = 1.34l;
        long dd = 1.34l;*/


        String[] topicIds = "lirui".split(",");
        System.out.println(topicIds[0]);

        System.out.println(Double.valueOf("4.56")*100 > 0);
        System.out.println(Double.valueOf("-3.45")>0);
        System.out.println(Double.valueOf(Double.valueOf("3.566777") * 100).longValue());
        System.out.println(Double.valueOf(Double.valueOf("9.633333") * 100).longValue());

        System.out.println("===================");
        System.out.println(String.valueOf(Double.valueOf("9.56") * 100));
        //Long aa = 9.0;
    }
}
