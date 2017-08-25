/*
package com.bcp;

import java.util.*;
import com.alibaba.bcp.task.runner.java.RuleExcutor;
import com.alibaba.bcp.client.util.*;
import com.alibaba.bcp.service.util.*;
import com.alibaba.bcp.task.data.ServiceParams;
import com.alibaba.bcp.task.data.service.ServiceFactory;
import com.alibaba.china.maya.kaleido.api.service.IPromotionService;
import com.alibaba.china.maya.api.model.ResultModel;
import  com.alibaba.china.maya.kaleido.api.model.PromotionModel;
import com.alibaba.china.maya.kaleido.api.service.ActivityService;
import com.alibaba.china.enroll2.biz.param.EnrollQueryParam;
import com.alibaba.bcp.task.event.jingwei.JingWeiDataReader;
import  com.alibaba.china.maya.kaleido.api.model.PromotionModel;
import com.alibaba.china.maya.kaleido.api.model.Activity;
import com.alibaba.china.maya.kaleido.api.service.IActivityService;
import com.alibaba.china.maya.kaleido.api.service.ISceneService;
import com.alibaba.china.maya.kaleido.api.model.SceneModel;
import com.alibaba.china.maya.kaleido.api.service.ActivityService;
import com.alibaba.china.maya.kaleido.api.model.ActivityTopicModel;
import com.alibaba.china.maya.kaleido.api.params.ActivityTopicQueryParam;

public class LstactivitydatamonitorBCPFilter implements RuleExcutor {
    public Object excute(Map<String,Object> context){
        JingWeiDataReader e2_enroll_record=(JingWeiDataReader)context.get("e2_enroll_record");
        String topicId = e2_enroll_record.strV("topic_id");
        String offerId = e2_enroll_record.strV("offer_id");
        String status = e2_enroll_record.strV("status");
        String enrollRecordId = e2_enroll_record.strV("id");
        Console.println("topicId:"+topicId+"offerId:"+offerId+"status:"+status);
        if(topicId==null || topicId=="" || !"approved".equals(status)){
            return false;
        }
        IPromotionService promotionService = ServiceFactory.createHsfService(IPromotionService.class,"1.0.0","");
        ResultModel<PromotionModel> resultModel = promotionService.getPromotion(0,Long.valueOf(topicId));
        if(resultModel==null || resultModel.getModel()==null){
            return false;
        }
        ActivityTopicQueryParam param = new ActivityTopicQueryParam();
        param.setTopicId(Long.valueOf(topicId));
        ActivityService activityService1 = ServiceFactory.createHsfService(ActivityService.class,"1.0.0","");
        ResultModel<List<ActivityTopicModel>> activity1 = activityService1.getActivityTopicList(param);
        if(activity1==null || activity1.getModel()==null || activity1.getModel().size()==0){
            return false;
        }
        PromotionModel promotion = resultModel.getModel();
        Long activityId = promotion.getActivityId();
        IActivityService activityService = ServiceFactory.createHsfService(IActivityService.class,"1.0.0","");
        ResultModel<Activity> activity= activityService.getActivity(activityId);
        if(activity==null || activity.getModel()==null){
            return false;
        }
        Long sceneId = activity.getModel().getSceneId();
        String marketingScene = activity.getModel().getMarketingScene();
        String marketingType = activity.getModel().getMarketingType();
        if("lstdszk".equals(marketingScene) || "lst".equals(marketingType)){
            return true;
        }
        return false;
    }
}*/
