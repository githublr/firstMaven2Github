package com.intern.ali;

import com.alibaba.dts.client.executor.job.processor.SimpleJobProcessor;
import com.alibaba.dts.client.executor.simple.processor.SimpleJobContext;
import com.alibaba.dts.common.domain.result.ProcessResult;
import com.alibaba.dts.common.logger.SchedulerXLoggerFactory;
//import com.alibaba.dts.common.logger.innerlog.Logger;


/**
 * Created by zack.lr on 2017/6/26.
 */
public class HahaDTS implements SimpleJobProcessor {

    public ProcessResult process(SimpleJobContext context) {
        //Logger logger = SchedulerXLoggerFactory.getLogger(ClientMain.class);
        //logger.info("comelirui222");
        System.out.println("==========!");
        //logger.warn("endelirui222");
        //context.getAvailableMachineAmount();//��job����� ���Ի�ȡ���ֵ�ǻ��ŵĿͻ��˻���������
        //context.getCurrentMachineNumber();//��job����� ���Ի�ȡ���ֵ�ǵ�ǰ�ͻ��˻�����ţ�ÿһ̨�������б�Ŵ�0��ʼ������
        return new ProcessResult(true);//true��ʾִ�гɹ���false��ʾʧ��
    }

}
