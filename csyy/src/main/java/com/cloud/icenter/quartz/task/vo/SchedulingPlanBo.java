package com.cloud.icenter.quartz.task.vo;

public class SchedulingPlanBo {

    /**
     * 调度计划ID<br>
     * 游离调度计划的id为空，通过保存方法(save)可以持久化到DB
     */
    private String id;

    /**
     * 调度计划运行规则
     */
    private String cron;

    /**
     * 调度计划实际使用的任务实例id<br>
     * 即spring中的注册名，默认调度其execute(String json)来执行任务
     */
    private String taskBeanId;

    /**
     * 执行任务时使用的参数
     */
    private String json;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getTaskBeanId() {
        return taskBeanId;
    }

    public void setTaskBeanId(String taskBeanId) {
        this.taskBeanId = taskBeanId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

}
