import com.alibaba.dts.common.util.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zack.lr on 2017/6/14.
 */
public class Hello0614 {
    public static void main(String[] args) {
        System.out.println("hello0614");
        System.out.println("test new");
        System.out.println("haha");
    }

    @Test
    public void testlr(){
        StringBuilder builder = new StringBuilder();
        System.out.println(StringUtil.isEmpty(builder.toString()));
        builder.append("aa");
        builder.append("bb");
        builder.append("cc");
        System.out.println(builder.toString());
    }

    @Test
    public void testlr2(){
        List<String> list=new ArrayList<String>();

        list.add("��һ��Ԫ��");  //���б����������

        list.add("�ڶ���Ԫ��");  //���б����������

        list.add("������Ԫ��");  //���б����������

        List<String> list1=new ArrayList<String>();

        list1.add("��һ��Ԫ��");  //���б����������

        list1.add("������Ԫ��");  //���б����������

        boolean ret=list.retainAll(list1);

        if(ret){

            System.out.println("Ԫ�ر��Ƴ��ɹ�");
            for(String a : list){
                System.out.println(a);
            }
        }else{

            System.out.println("�б��в�����Ҫ�Ƴ���Ԫ��");

        }
    }

    @Test
    public void testlr3(){
        ArrayList list = new ArrayList();
        String aa=null;
        String bb=null;
        list.add(aa);
        list.add(bb);
        System.out.println(list.size());
    }
}
