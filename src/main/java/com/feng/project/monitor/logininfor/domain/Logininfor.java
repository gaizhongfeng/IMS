package com.feng.project.monitor.logininfor.domain;

import java.util.Date;
import com.feng.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统访问日志情况信息 sys_logininfor
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Logininfor extends PageDomain
{
    /** ID */
    private Integer infoId;
    /** 用户账号 */
    private String loginName;
    /** 登录状态 0成功 1失败 */
    private String status;
    /** 登录IP地址 */
    private String ipaddr;
    /** 浏览器类型 */
    private String browser;
    /** 操作系统 */
    private String os;
    /** 提示消息 */
    private String msg;
    /** 访问时间 */
    private Date loginTime;

}