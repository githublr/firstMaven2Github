package com.intern.ali;

/**
 * Created by zack.lr on 2017/8/8.
 */


import com.alibaba.dts.client.executor.grid.processor.GridJobContext;
import com.alibaba.dts.client.executor.job.processor.GridJobProcessor;
import com.alibaba.dts.common.constants.Constants;
import com.alibaba.dts.common.domain.result.ProcessResult;

import java.util.ArrayList;
import java.util.List;

public class HelloGridJobProcessor implements GridJobProcessor {

    @Override
    public ProcessResult process(GridJobContext context) throws Exception {
        String taskName = context.getTaskName();
        if (Constants.DEFAULT_ROOT_LEVEL_TASK_NAME.equals(taskName)) {
            context.dispatchTaskList(buildDataSmall(context), "一级分发");
            return new ProcessResult(true);
        } else if ("一级分发".equals(taskName)) {
            return new ProcessResult(true);
        }
        return new ProcessResult(true);
    }

    private List<? extends Object> buildDataSmall(GridJobContext context) {
        int count = 1000000;
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            data.add(i);
        }
        return data;
    }
}
