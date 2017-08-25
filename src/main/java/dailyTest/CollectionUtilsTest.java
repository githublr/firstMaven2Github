package dailyTest;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zack.lr on 2017/6/26.
 */
public class CollectionUtilsTest {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = null;
        List<Integer> c = new ArrayList<Integer>();
        c.add(5);
        c.add(6);
        //判断集合是否为空
        System.out.println(CollectionUtils.isEmpty(a));   //true
        System.out.println(CollectionUtils.isEmpty(b));   //true
        System.out.println(CollectionUtils.isEmpty(c));   //false

        //判断集合是否不为空
        System.out.println(CollectionUtils.isNotEmpty(a));   //false
        System.out.println(CollectionUtils.isNotEmpty(b));   //false
        System.out.println(CollectionUtils.isNotEmpty(c));   //true

        //两个集合间的操作
        List<Integer> e = new ArrayList<Integer>();
        e.add(2);
        e.add(1);
        List<Integer> f = new ArrayList<Integer>();
        f.add(1);
        f.add(2);
        List<Integer> g = new ArrayList<Integer>();
        g.add(12);
        //比较两集合值
        System.out.println(CollectionUtils.isEqualCollection(e, f));   //true
        System.out.println(CollectionUtils.isEqualCollection(f, g));   //false

        List<Integer> h = new ArrayList<Integer>();
        h.add(1);
        h.add(2);
        h.add(3);
        ;
        List<Integer> i = new ArrayList<Integer>();
        i.add(3);
        i.add(3);
        i.add(4);
        i.add(5);
        //并集
        System.out.println(CollectionUtils.union(i, h));  //[1, 2, 3, 3, 4, 5]
        //交集
        System.out.println(CollectionUtils.intersection(i, h)); //[3]
        //交集的补集
        System.out.println(CollectionUtils.disjunction(i, h)); //[1, 2, 3, 4, 5]
        //e与h的差
        System.out.println(CollectionUtils.subtract(h, i)); //[1, 2]
        System.out.println(CollectionUtils.subtract(i, h)); //[3, 4, 5]

    }

    @Test
    public void testlr(){
        HashMap<String, HashMap<String, String>> mkcMap=new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("gear","2");
        mkcMap.put("lirui",map1);

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("discount","9.9");
        mkcMap.put("lizhi",map2);

        for (Map.Entry<String, HashMap<String, String>> entry : mkcMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(entry.getValue().get("gear")+","+entry.getValue().get("discount"));
        }
        /*
        lirui
        {gear=2}
        lizhi
        {discount=9.9}
         */

    }

    @Test
    public void test2(){
        HashMap<String, String> map = new HashMap<String, String>();
        //HashMap<String, String> map=null;
        map.put("lirui","lizhi");
        System.out.println(map.size());
    }

    @Test
    public void test3(){
        //List<Integer> list1=null;
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(12);
        list1.add(34);
        list1.add(56);
        System.out.println(list1.size());
    }
    
    
}