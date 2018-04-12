package com.feng.project.monitor.job.util;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.feng.common.constant.ScheduleConstants;
import com.feng.common.utils.spring.SpringUtils;
import com.feng.project.monitor.job.domain.Job;
import com.feng.project.monitor.job.domain.JobLog;
import com.feng.project.monitor.job.service.IJobLogService;

import lombok.extern.slf4j.Slf4j;

/**
 * 定时任务
 * 
 * @author feng
 *
 */
@Slf4j
public class ScheduleJob extends QuartzJobBean
{
    private ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        Job job = (Job) context.getMergedJobDataMap().get(ScheduleConstants.JOB_PARAM_KEY);

        IJobLogService jobLogService = (IJobLogService) SpringUtils.getBean(IJobLogService.class);

        JobLog jobLog = new JobLog();
        jobLog.setJobName(job.getJobName());
        jobLog.setJobGroup(job.getJobGroup());
        jobLog.setMethodName(job.getMethodName());
        jobLog.setParams(job.getParams());
        jobLog.setCreateTime(new Date());

        long startTime = System.currentTimeMillis();

        try
        {
            // 执行任务
            log.info("任务开始执行 - 名称：{} 方法：{}", job.getJobName(), job.getMethodName());
            ScheduleRunnable task = new ScheduleRunnable(job.getJobName(), job.getMethodName(), job.getParams());
            Future<?> future = service.submit(task);
            future.get();
            long times = System.currentTimeMillis() - startTime;
            // 任务状态 0：成功 1：失败
            jobLog.setIsException(0);
            jobLog.setJobMessage(job.getJobName() + " 总共耗时：" + times + "毫秒");

            log.info("任务执行结束 - 名称：{} 耗时：{} 毫秒", job.getJobName(), times);
        }
        catch (Exception e)
        {
            log.info("任务执行失败 - 名称：{} 方法：{}", job.getJobName(), job.getMethodName());
            log.error("任务执行异常  - ：", e);
            long times = System.currentTimeMillis() - startTime;
            jobLog.setJobMessage(job.getJobName() + " 总共耗时：" + times + "毫秒");
            // 任务状态 0：成功 1：失败
            jobLog.setIsException(1);
            jobLog.setExceptionInfo(e.toString());
        }
        finally
        {
            jobLogService.addJobLog(jobLog);
        }
    }
}
