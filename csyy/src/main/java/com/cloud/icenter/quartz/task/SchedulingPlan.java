package com.cloud.icenter.quartz.task;

import org.quartz.Job;

import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.quartz.task.vo.SchedulingPlanBo;

/**
 * 
 * 调度计划基础类<br>
 * 
 * @author leiliuf
 *
 */
public class SchedulingPlan implements ISchedulingPlan {
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
	 * 调度计划运行规则备注，例：30秒执行一次
	 */
	private String remarks;

	/**
	 * 调度计划实际使用的任务实例id<br>
	 * 即spring中的注册名，默认调度其execute(String json)来执行任务
	 */
	private String taskBeanId;
	/**
	 * 执行任务时使用的参数
	 */
	private String json;

	/**
	 * 构造方法（供反射处理）<br>
	 * 构造之后必须使用setSchedulingPlanBo()
	 * 
	 * @param bo
	 */
	public SchedulingPlan() {
	}

	/**
	 * 构造方法
	 * 
	 * @param bo
	 */
	public SchedulingPlan(SchedulingPlanBo bo) {
		setSchedulingPlanBo(bo);
	}

	@Override
	public void setSchedulingPlanBo(SchedulingPlanBo bo) {
		// id 可以为空-游离对象
		if (bo.getId() == null || bo.getId().length() < 1) {
			this.id = null;
		} else {
			this.id = bo.getId();
		}

		if (bo.getCron() == null || bo.getCron().length() < 1) {
			this.cron = null;
		} else {
			this.cron = bo.getCron();
		}

		if (bo.getJson() == null || bo.getJson().length() < 1) {
			this.json = null;
		} else {
			this.json = bo.getJson();
		}

		// 必须有
		if (bo.getTaskBeanId() == null || bo.getTaskBeanId().length() < 1) {
			this.taskBeanId = null;
		} else {
			this.taskBeanId = bo.getTaskBeanId();
		}
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean publish() {
		Class<? extends Job> task = null;
		try {
			task = (Class<? extends Job>) SpringUtil.getBean(taskBeanId).getClass();
			QuartzUtil.addJob(id, task, cron, json);
			System.out.println("任务：" + task.getName() + " : id=" +id+ "启动，表达式为：" + cron);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean revoke() {
		try {
			QuartzUtil.removeJob(id);
			System.out.println("任务 : id=" +id+ " 取消，表达式为：" + cron);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean execute() {
		try {
			Task task = (Task) SpringUtil.getBean(taskBeanId);
			System.out.println("任务 : id=" +id+ " 执行，表达式为：" + cron);
			task.execute(json);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String getCron() {
		return cron;
	}

	@Override
	public String getTaskBeanId() {
		return taskBeanId;
	}

	@Override
	public String getJson() {
		return json;
	}

	@Override
	public String getRemarks() {
		return remarks;
	}
}
