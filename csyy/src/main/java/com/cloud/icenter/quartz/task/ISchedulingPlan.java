package com.cloud.icenter.quartz.task;

import com.cloud.icenter.quartz.task.vo.SchedulingPlanBo;


/**
 * 调度计划总接口<br>
 * 核心属性： id、cron、TaskBeanId 、 json
 *
 * @author leiliuf
 */
public interface ISchedulingPlan {

    /**
     * 获取调度id
     * 
     * @return
     */
    String getId();

    /**
     * 发布调度计划<br>
     * 添加调度至Spring Quartz调度管理
     * 
     * @return false：发布失败
     */
    boolean publish();

    /**
     * 撤回调度计划<br>
     * 删除调度至Spring Quartz调度管理
     * 
     * @return false：撤回失败
     */
    boolean revoke();

    /**
     * 立即执行调度计划<br>
     * 
     * @return 执行遇到问题，抛出异常
     */
    boolean execute();

    /**
     * 获取表达式
     * 
     * @return
     */
    String getCron();

    /**
     * 获取实际执行bean
     * 
     * @return
     */
    String getTaskBeanId();

    /**
     * 获取参数json
     * 
     * @return
     */
    String getJson();
    
    /**
     * 获取调度计划备注
     * @return
     */
    String getRemarks();

    /**
     * 设定bo（如果不是使用带参数的构造，必须使用这个方法）
     * 
     * @param bo
     */
    void setSchedulingPlanBo(SchedulingPlanBo bo);

}
