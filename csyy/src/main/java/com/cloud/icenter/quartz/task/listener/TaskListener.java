package com.cloud.icenter.quartz.task.listener;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.cloud.icenter.quartz.task.SchedulingPlan;
import com.cloud.icenter.quartz.task.vo.SchedulingPlanBo;
import com.cloud.icenter.yyzx.taskinfo.pojo.TaskInfo;
import com.cloud.icenter.yyzx.taskinfo.service.TaskInfoService;

/**
 * 系统初始化操作
 * 启动所有已启用的任务
 * @author zhangle
 */
@Component
public class TaskListener implements ApplicationListener<ContextRefreshedEvent> {
  
	private static final Log logger = LogFactory.getLog(TaskListener.class);
	
	@Autowired
	private TaskInfoService taskInfoService;
	
   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")) {
            DetachedCriteria criteria = DetachedCriteria.forClass(TaskInfo.class);
            criteria.add(Restrictions.eq("status", "1"));
            List<?> list = taskInfoService.find(criteria);
            if (CollectionUtils.isNotEmpty(list)) {
                for (Object object : list) {
                    TaskInfo info = (TaskInfo) object;
                    try {
                        taskStart(info);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
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

}
