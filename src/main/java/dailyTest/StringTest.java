package dailyTest;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zack.lr on 2017/7/23.
 */
public class StringTest {
    public static void main(String[] args) {

        Long topicId=5L;
        String conditionPattern = " topic_id=%s  and offer_id is  NULL ";
        String condition = String.format(conditionPattern, topicId);
        System.out.println(condition);

        HashMap<List<String>, String> map = new HashMap<List<String>, String>();

    }
}
