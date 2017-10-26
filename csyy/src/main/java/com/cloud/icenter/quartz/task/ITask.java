package com.cloud.icenter.quartz.task;

import org.quartz.Job;


/**
 * 任务总接口
 * 
 * @author leiliuf
 *
 */
public interface ITask extends Job{

    /**
     * 任务执行前
     * 
     * @return false:执行遇到问题抛出异常
     */
    boolean before(String json);

    /**
     * 执行任务
     * 
     * @return false:执行遇到问题抛出异常
     */
    boolean execute(String json);

    /**
     * 任务执行后
     * 
     * @return false:执行遇到问题抛出异常
     */
    boolean after(String json);
}
