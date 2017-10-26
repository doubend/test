package com.cloud.icenter.quartz.task;

import java.text.ParseException;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import com.cloud.icenter.common.utils.DateUtil;

/**
 * spring quartz工具类
 * 
 * @author wangjiaxi
 * @update 2016年3月31日
 */
public class QuartzUtil {

    private static final Log logger = LogFactory.getLog(QuartzUtil.class);
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "SCHEDULING_PLAN_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "SCHEDULING_PLAN_TRIGGERGROUP_NAME";

    /**
     * 添加一个定时任务，使用默认的任务组名，触发器名
     * 
     * @param jobName
     *            任务名称（必须唯一）
     * @param cls
     *            定时执行的类
     * @param cron
     *            定时执行时间表达式
     * @param json
     *            任务执行需要的参数
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobName, Class<? extends Job> cls, String cron, String json)
            throws SchedulerException, ParseException {
        Scheduler sched = schedulerFactory.getScheduler();
        // 通过任务名称得到任务
        JobDetail jobDetail = sched.getJobDetail(new JobKey(jobName, JOB_GROUP_NAME));
        if (jobDetail == null) {
            // 没有任务，直接添加
            jobDetail = JobBuilder.newJob(cls).withIdentity(jobName, JOB_GROUP_NAME).build();

            // 向定时执行的类中传参，在定时的类中可以通过
            // JobDataMap dataMap = contextJob.getMergedJobDataMap();
            // String json = dataMap.get("json").toString();获得
            jobDetail.getJobDataMap().put("json", json);

            // 创建触发器
            // 触发器时间设定
            CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity(jobName, TRIGGER_GROUP_NAME)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
            sched.scheduleJob(jobDetail, trigger);
            // 启动
            if (!sched.isShutdown()) {
                sched.start();
                logger.info(DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss") + " 任务：" + jobName + "启动，表达式为：" + cron);
            }
        } else {
            // 已经存在任务，执行修改
            updateJobTime(jobName, cron, json);
        }
    }

    /**
     * 修改一个任务的触发时间
     * 
     * @param jobName
     *            任务名称
     * @param cron
     *            任务触发时间
     * @param json
     *            任务执行需要的参数
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void updateJobTime(String jobName, String cron, String json) throws SchedulerException,
            ParseException {
        Scheduler sched = schedulerFactory.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
        if (trigger == null) {
            return;
        }
        String oldTime = trigger.getCronExpression();
        if (!oldTime.equalsIgnoreCase(cron)) {
            JobKey jobKey = JobKey.jobKey(jobName, JOB_GROUP_NAME);
            JobDetail jobDetail = sched.getJobDetail(jobKey);
            Class<? extends Job> objJobClass = jobDetail.getJobClass();
            removeJob(jobName);
            if (cron != null && cron.length() > 10) {
                addJob(jobName, objJobClass, cron, json);
            }
            logger.debug(DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss") + " 任务：" + jobName + "修改，表达式改为：" + cron);
        }
    }

    /**
     * 移除一个定时任务
     * 
     * @param jobName
     */
    public static void removeJob(String jobName) {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
            sched.pauseTrigger(triggerKey);// 停止触发器
            sched.unscheduleJob(triggerKey);// 移除触发器
            JobKey jobKey = JobKey.jobKey(jobName, JOB_GROUP_NAME);
            sched.deleteJob(jobKey);// 删除任务
            logger.debug(DateUtil.getCurrentDateStr("yyyy-MM-dd HH:mm:ss") + " 任务：" + jobName + "删除");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 验证任务cron表达式是否有效
     * 
     * @param cron
     * @return
     */
    public static boolean taskValidate(String cron) {
        Scheduler scheduler;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            String id = UUID.randomUUID().toString();
            // JobDetail jd = scheduler
            // .getJobDetail(new JobKey(id, id + "_group"));
            JobDetail jd = JobBuilder.newJob(TaskValidate.class).withIdentity(id, id + "_group").usingJobData("id", id)
                    .build();

            // jd.getJobDataMap().put("id", id);
            try {
                CronTrigger ct = (CronTrigger) TriggerBuilder.newTrigger().withIdentity(id, id + "_group")
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
                scheduler.scheduleJob(jd, ct);
            } catch (Exception e) {
                // e.printStackTrace();
                return false;
            }
            return true;
        } catch (SchedulerException e) {
            // e.printStackTrace();
            return false;
        }
    }

   

}
