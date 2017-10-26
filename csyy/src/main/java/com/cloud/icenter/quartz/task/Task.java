package com.cloud.icenter.quartz.task;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务基础类<br>
 * 任务实例由spring管理<br>
 * 所有任务必须继承此类<br>
 * 任务调用使用动态代理控制执行前、执行后操作
 * 
 * @author leiliuf
 *
 */
public abstract class Task implements ITask{

    @Override
    public boolean before(String json){
        return true;
    }

    @Override
    public abstract boolean execute(String json);

    @Override
    public boolean after(String json){
        return true;
    }
    
    @Override
    public void execute(JobExecutionContext contextJob) throws JobExecutionException {
        // 获取参数
        JobDataMap dataMap = contextJob.getMergedJobDataMap();
        String param = "";
        Object json = dataMap.get("json");
        if (json != null) {
            param = json.toString();
        }
        execute(param);
    }

}
