package com.feng.project.monitor.job.domain;

import java.io.Serializable;
import java.util.Date;
import com.feng.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 定时任务调度信息 sys_job
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Job  extends PageDomain implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long jobId;
    /** 任务名称 */
    private String jobName;
    /** 任务组名 */
    private String jobGroup;
    /** 任务方法 */
    private String methodName;
    /** 方法参数 */
    private String params;
    /** cron执行表达式 */
    private String cronExpression;
    /** 状态（0正常 1暂停） */
    private int status;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 更新者 */
    private String updateBy;
    /** 备注 */
    private String remark;

}
