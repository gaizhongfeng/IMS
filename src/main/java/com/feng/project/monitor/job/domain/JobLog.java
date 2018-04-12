package com.feng.project.monitor.job.domain;

import java.util.Date;
import com.feng.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 定时任务调度日志信息 sys_job_log
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class JobLog  extends PageDomain
{
    /** ID */
    private Integer jobLogId;
    /** 任务名称 */
    private String jobName;
    /** 任务组名 */
    private String jobGroup;
    /** 任务方法 */
    private String methodName;
    /** 方法参数 */
    private String params;
    /** 日志信息 */
    private String jobMessage;
    /** 是否异常 */
    private int isException;
    /** 异常信息 */
    private String exceptionInfo;
    /** 创建时间 */
    private Date createTime;
}
