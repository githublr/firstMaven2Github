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

        Object task = context.getTask();//获取要处理的任务
        String taskName = context.getTaskName();//获取任务名称

        if(Constants.DEFAULT_ROOT_LEVEL_TASK_NAME.equals(taskName)) {//如果是DTS系统默认开始任务就表示任务开始了
            System.out.println("lirui");
            int recordCount = queryRecordCount();
            int pageAmount = recordCount / pageSize;//计算分页数量
            for(int i = 0 ; i < pageAmount ; i ++) {
                List<Record> recordList = queryRecord(i);//根据分页查询一页数据
                Result<Boolean> result = context.dispatchTaskList(recordList, "record记录");//把子任务分发出去并行处理
                System.out.println(result+" ***");//打印分发结果
            }
            return new ProcessResult(true);//true表示执行成功，false表示失败
        } else if("record记录".equals(taskName)) {//如果task是Record类型的那么说明是record记录任务
            System.out.println("lizhi");
            Record record = (Record)task;
            System.out.println(record+" ===");//处理record记录
            return new ProcessResult(true);//true表示执行成功，false表示失败
        }
        return new ProcessResult(true);//最好不要反回null 返回null就会判定为任务执行失败
    }

    /**
     * 查询记录数量
     * @return
     */
    private int queryRecordCount() {
        //return 1000000;
        return 2000;
    }

    /**
     * 查询一页数据
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