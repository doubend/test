package com.cloud.icenter.quartz.task.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cloud.icenter.quartz.task.Task;

/**
 * 测试任务
 * 
 * @author wjx
 *
 */
@Service(value = "testTaskRun")
public class TestTaskRun extends Task{
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public boolean execute(String json) {
        System.out.println("run");
        return false;
    }
}
