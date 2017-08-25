package com.intern.ali;

import com.alibaba.dts.client.executor.job.processor.SimpleJobProcessor;
import com.alibaba.dts.client.executor.simple.processor.SimpleJobContext;
import com.alibaba.dts.common.domain.result.ProcessResult;
import com.alibaba.dts.common.logger.SchedulerXLoggerFactory;
//import com.alibaba.dts.common.logger.innerlog.Logger;


/**
 * Created by zack.lr on 2017/6/26.
 */
public class HelloWorldJobProcessor implements SimpleJobProcessor {

    public ProcessResult process(SimpleJobContext context) {
        //Logger logger = SchedulerXLoggerFactory.getLogger(ClientMain.class);
        //logger.info("comelirui");
        System.out.println("Hello World lirui!");
        //logger.warn("endelirui");
        //context.getAvailableMachineAmount();//简单job多机版 可以获取这个值是活着的客户端机器数量。
        //context.getCurrentMachineNumber();//简单job多机版 可以获取这个值是当前客户端机器编号，每一台机器都有编号从0开始递增。
        return new ProcessResult(true);//true表示执行成功，false表示失败
    }

}
