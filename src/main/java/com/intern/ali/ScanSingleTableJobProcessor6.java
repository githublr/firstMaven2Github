package com.intern.ali;

import com.alibaba.dts.client.executor.job.processor.ParallelJobProcessor;
import com.alibaba.dts.client.executor.parallel.processor.ParallelJobContext;
import com.alibaba.dts.common.constants.Constants;
import com.alibaba.dts.common.domain.result.ProcessResult;
import com.alibaba.dts.common.domain.result.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zack.lr on 2017/7/29.
 */
public class ScanSingleTableJobProcessor6 implements ParallelJobProcessor {

    private static int pageSize = 1000;

    public ProcessResult process(ParallelJobContext context) throws InterruptedException{

        Object task = context.getTask();//��ȡҪ���������
        String taskName = context.getTaskName();//��ȡ��������

        if(Constants.DEFAULT_ROOT_LEVEL_TASK_NAME.equals(taskName)) {//�����DTSϵͳĬ�Ͽ�ʼ����ͱ�ʾ����ʼ��
            System.out.println("lirui");
            int recordCount = queryRecordCount();
            int pageAmount = recordCount / pageSize;//�����ҳ����
            for(int i = 0 ; i < pageAmount ; i ++) {
                List<Record> recordList = queryRecord(i);//���ݷ�ҳ��ѯһҳ����
                Result<Boolean> result = context.dispatchTaskList(recordList, "record��¼");//��������ַ���ȥ���д���
                System.out.println(result+" ***");//��ӡ�ַ����
            }
            return new ProcessResult(true);//true��ʾִ�гɹ���false��ʾʧ��
        } else if("record��¼".equals(taskName)) {//���task��Record���͵���ô˵����record��¼����
            System.out.println("lizhi");
            Record record = (Record)task;
            System.out.println(record+" ===");//����record��¼
            return new ProcessResult(true);//true��ʾִ�гɹ���false��ʾʧ��
        }
        return new ProcessResult(true);//��ò�Ҫ����null ����null�ͻ��ж�Ϊ����ִ��ʧ��
    }

    /**
     * ��ѯ��¼����
     * @return
     */
    private int queryRecordCount() {
        //return 1000000;
        return 2000;
    }

    /**
     * ��ѯһҳ����
     * @param pageNum
     * @return
     */
    private List<Record> queryRecord(int pageNum) {
        List<Record> recordList = new ArrayList<Record>();
        for(int i = 0 ; i < pageSize ; i ++) {
            recordList.add(new Record(pageNum + "-" + i));
        }
        return recordList;
    }

}


class Record implements Serializable {

    private static final long serialVersionUID = -33431929501353767L;

    private String col1;

    public Record(String col1) {
        this.col1 = col1;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    @Override
    public String toString() {
        return "Record [col1=" + col1 + "]";
    }

}