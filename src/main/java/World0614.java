import com.alibaba.china.pte.buyer.service.BuyerShowQueryService;
import com.alibaba.citrus.util.StringUtil;
import org.junit.Test;

import java.util.*;

/**
 * Created by zack.lr on 2017/6/14.
 */
public class World0614 {
    public static void main(String[] args) {
        System.out.println("world0614aaa");
        System.out.println("test merge");


    }

    public void testfff(){
        if("lirui".equals("李睿")){
            int a = 4;
        }
        //a=3;
    }

    @Test
    public void testhh(){
        String[] topicIds = null;
        String argsStr="14489,3666,33399";
        if(argsStr!=null){
            topicIds = argsStr.split(",");
        }
        List<Long> topicS = new ArrayList<Long>();
        for (String topicId:topicIds) {
            System.out.println(topicId);

            topicS.add(Long.valueOf(topicId));
        }

        for (Long aa:topicS) {
            System.out.println(aa);
        }
    }

    @Test
    public void haha(){
        int a = 5;
        if(a>3){
            System.out.println("haha");
            return;
        }
        System.out.println("enen");
    }

    @Test
    public void hehe(){
        String code=null;
        for (int i = 0; i < 5; i++) {

            if (StringUtil.isEmpty(code = StringUtil.isEmpty(" ") ? "4" : "")) {
                System.out.println(code);
                continue;
            }else{
                System.out.println("haha");
            }

        }
    }

    @Test
    public void heihei(){
        //String label = "";

        for(int i=0;i<5;i++){
            String label = null;
            System.out.println(label.getClass());
            System.out.println("=======");
            if (label==null || label.equals("")){
                continue;
            }
            System.out.println("000");
        }
        /*if (label==null || label.equals("")){
            System.out.println("dddd");
        }*/
/*        if(label.equals("lirui")){
            System.out.println("enen");
        }*/
    }

    @Test
    public void xixi(){
        System.out.println(1111);
        int count = 0;
        count++;
        System.out.println(count);
        System.out.println(count);
    }

    @Test
    public void houhou(){
        Integer a = null;
        try{
            a = 4/0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(a==null){
            System.out.println("haha0720");
        }
    }

    @Test
    public void testmap(){
        Map<String,String > aa = new HashMap<String ,String>();
        aa.put("lirui","22");
        System.out.println(aa.entrySet().contains("22"));
        System.out.println(aa.entrySet().contains("lirui"));
        System.out.println(aa.entrySet().iterator());
        Iterator<Map.Entry<String, String>> iterator = aa.entrySet().iterator();
//        System.out.println(iterator.next());
        Map.Entry<String, String> next = iterator.next();
        System.out.println(next.getValue());
    }

    @Test
    public void testint(){
        String s = "12";
        System.out.println(Integer.parseInt(s));
        System.out.println(Integer.valueOf(s));

        Integer gear=null;
        gear = Integer.parseInt(s);
        System.out.println(gear);

        Integer a = 6;
        int b  =6;
        System.out.println(a==b);

        String status = "tbd";
        if(!"approved".equals(status) || !"tbd".equals(status)){
            System.out.println(5555555);
        }

        String status2 = "wait";
        String topic =null;
        //String topic ="333";
        if((!"approved".equals(status2) && !"tbd".equals(status2)) || topic==null){
            System.out.println(666666);
        }
    }

    @Test
    public void testhhh(){
        //List<Long> tags = topicQueryService.queryTopicTag(Long.valueOf(topicId));
        List<Long> tags = null;
/*        if(tags==null || tags.size()<=0 || !tags.contains(226L)){
            System.out.println("haha");
        }*/
        if( !tags.contains(226L)){
            System.out.println("haha"); //这样会报错
        }

    }

    @Test
    public void hahaw(){
        /*System.out.println(Long.valueOf("1233"));

        int[] ints = new int[5];
        ints[0] = 5;
        System.out.println(ints.length);*/

        String array0 = "1,2,3,4,";

        String[] split = array0.split(",");
        int[] array = new int[array0.length()];
        for (int i =0;i<split.length;i++) {
            array[i] = Integer.parseInt(split[i]);
            System.out.println(array[i]);
        }

    }

    @Test
    public void hahaw33(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =1;i<5;i++){
            stringBuilder.append(i);
            stringBuilder.reverse();
        }

        System.out.println(stringBuilder.toString());
    }

    @Test
    public void hahaw66(){
        BuyerShowQueryService service;
        ResultModel<liruiModel> model  = new ResultModel<liruiModel>();
        model.setErrMsg("haha");
        System.out.println(model==null);
    }

    @Test
    public void hahaw77(){
        for(int i=0;i<40;i++){
            System.out.println(i);
        }

    }

    class liruiModel{
        int a ;
        String b;
    }

    public class ResultModel<T> {

        private static final long serialVersionUID = 1495746515360663288L;

        /**
         * 结果返回的业务数据
         */
        private T model;

        /**
         * 备注信息
         */
        private String errMsg;


        public T getModel() {
            return model;
        }

        public void setModel(T model) {
            this.model = model;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }
    }

    @Test
    public void hahaw88(){
        Long a = 100L;
        long l = a * 100;
        long L = a * 100;
        System.out.println(l);
        System.out.println(l==L);
    }

    abstract class a {
        int c = 5;
    }

    class b extends a{
        public b(){
            c=6;
        }
    }

}
