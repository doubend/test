package com.cloud.icenter.yyzx.taskinfo.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.quartz.task.QuartzUtil;
import com.cloud.icenter.quartz.task.SchedulingPlan;
import com.cloud.icenter.quartz.task.vo.SchedulingPlanBo;
import com.cloud.icenter.yyzx.taskinfo.pojo.TaskInfo;
import com.cloud.icenter.yyzx.taskinfo.service.TaskInfoService;

/**
 * Created with gender.
 * 
 * @author: whcai Date: 2017-03-20 15:54:44
 */
@Controller
@RequestMapping(value = "/taskinfo")
public class TaskInfoAction extends ModelAction<TaskInfo> {

    @Autowired
    private TaskInfoService taskInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return "taskinfo/taskinfoList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "taskinfo/taskinfoAdd";
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/query")
    public void query() {
        taskInfoService.find(getPagination());
        printJson(getPagination());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doAdd(TaskInfo taskInfo) {
        try {
            taskInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
            taskInfo.setStatus("0");
            taskInfoService.add(taskInfo);
        } catch (Exception e) {
            return jsonResult(-1, e.getMessage());
        }
        return jsonResult(200, "ok");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable String id) {
        TaskInfo taskInfo = taskInfoService.get(id);
        setAttribute("taskinfo", taskInfo);
        return "taskinfo/taskinfoEdit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doDelete(@PathVariable String id) {
        try {
            TaskInfo task = taskInfoService.get(id);
            taskStop(task);
            taskInfoService.delete(id);
        } catch (Exception e) {
            return jsonResult(-1, e.getMessage());
        }
        return jsonResult(200, "ok");
    }
    @RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult changeStatus(@PathVariable String id) {
        String message = "ok";
        boolean flag = false;
        try {
            TaskInfo task = taskInfoService.get(id);
            String status = task.getStatus();
            if("1".equals(status)){
                task.setStatus("0");
                message = "任务已禁用！";
                flag = taskStop(task);
            }else{
                task.setStatus("1");
                message = "任务已启用！";
                flag = taskStart(task);
            }
            if(flag){
                taskInfoService.update(task);
            }else{
                throw new Exception("任务操作失败！");
            }
        } catch (Exception e) {
            return jsonResult(-1, e.getMessage());
        }
        return jsonResult(200, message);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doUpdate(TaskInfo taskInfo) {
        try {
            TaskInfo oldTaskInfo = taskInfoService.get(taskInfo.getId());
            oldTaskInfo.setName(taskInfo.getName());
            oldTaskInfo.setJson(taskInfo.getJson());
            oldTaskInfo.setRemarks(taskInfo.getRemarks());
            oldTaskInfo.setTaskBeanId(taskInfo.getTaskBeanId());
            oldTaskInfo.setCron(taskInfo.getCron());
            oldTaskInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            taskInfoService.update(oldTaskInfo);
        } catch (Exception e) {
            return jsonResult(-1, e.getMessage());
        }
        return jsonResult(200, "ok");
    }
    @RequestMapping(value = "/checkCron", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkCron(String cron) {
        if (cron == null || cron.length() < 10) {
            return jsonResult(-1, "false");
        }
        boolean flag = QuartzUtil.taskValidate(cron);
        if (!flag) {
            return jsonResult(-1, "false");
        } else {
            return jsonResult(200, "ok");
        }
    }
    /**
     * 跳转到设置调度设置cron页面
     * 
     * @return
     */
    @RequestMapping(value = "/setCron", method = RequestMethod.GET)
    public String setCron() {
        return "cron/index";
    }

    public boolean taskStart(TaskInfo info) throws Exception{
        SchedulingPlanBo planBo = new SchedulingPlanBo();
        planBo.setTaskBeanId(info.getTaskBeanId());
        planBo.setJson(info.getJson());
        planBo.setId(info.getId());
        planBo.setCron(info.getCron());
        SchedulingPlan plan = new SchedulingPlan(planBo);
        return plan.publish();
    }
    public boolean taskStop(TaskInfo info) throws Exception{
        SchedulingPlanBo planBo = new SchedulingPlanBo();
        planBo.setTaskBeanId(info.getTaskBeanId());
        planBo.setJson(info.getJson());
        planBo.setId(info.getId());
        planBo.setCron(info.getCron());
        // 取消
        SchedulingPlan plan = new SchedulingPlan(planBo);
        return plan.revoke();
    }

}
