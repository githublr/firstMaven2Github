package com.intern.ali;

import com.alibaba.dts.client.SchedulerxClient;
import com.alibaba.dts.common.logger.SchedulerXLoggerFactory;
//import com.alibaba.dts.common.logger.innerlog.Logger;
import com.alibaba.edas.schedulerx.SchedulerXLogLevel;

/**
 * Created by zack.lr on 2017/6/26.
 */
public class ClientMain {
    public static void main(String[] args) {
        SchedulerxClient dtsClient = new SchedulerxClient();
        dtsClient.setGroupId("1-3-3-5869");//此处填写控制台创建分组后生成的分组ID
        /*dtsClient.setGroupId("1-3-3-6223");//此处填写控制台创建分组后生成的分组ID*/

        //dtsClient.setDefaultLogLevel(SchedulerXLogLevel.WARN);
        dtsClient.setDefaultLogLevel(SchedulerXLogLevel.INFO);
        //dtsClient.setExecuteLogLevel();
        try {
            dtsClient.init();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
