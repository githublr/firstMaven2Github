package com.bcp;

import com.alibaba.bcp.sdk.main.Bootstrap;
import com.alibaba.bcp.task.runner.java.RuleExcutor;

import java.util.Map;

/**
 * Created by zack.lr on 2017/7/21.
 */
public class GenerateBcp implements RuleExcutor{
    public Object excute(Map<String, Object> context) {
        Map<String,Object> messages = (Map<String,Object>)context.get("memberApproved");
        String topicId = String.valueOf(messages.get("topicId"));
        if(topicId==null || topicId==""){
            return false;
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        Bootstrap.generateJingWeiRule("xdb_check_info", "e2_enroll_record");
    }
}
