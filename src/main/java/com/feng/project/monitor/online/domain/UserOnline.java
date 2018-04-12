package com.feng.project.monitor.online.domain;

import java.util.Date;
import com.feng.framework.web.page.PageDomain;
import com.feng.project.monitor.online.domain.OnlineSession.OnlineStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 当前在线会话 sys_user_online
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserOnline extends PageDomain
{
    /** 用户会话id */
    private String sessionId;

    /** 部门名称 */
    private String deptName;

    /** 登录名称 */
    private String loginName;

    /** 登录IP地址 */
    private String ipaddr;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** session创建时间 */
    private Date startTimestamp;

    /** session最后访问时间 */
    private Date lastAccessTime;

    /** 超时时间，单位为分钟 */
    private Long expireTime;

    /** 在线状态 */
    private OnlineStatus status = OnlineStatus.on_line;

    /** 备份的当前用户会话 */
    private OnlineSession session;

    /**
     * 设置session对象
     */
    public static final UserOnline fromOnlineSession(OnlineSession session)
    {
        UserOnline online = new UserOnline();
        online.setSessionId(String.valueOf(session.getId()));
        online.setDeptName(session.getDeptName());
        online.setLoginName(session.getLoginName());
        online.setStartTimestamp(session.getStartTimestamp());
        online.setLastAccessTime(session.getLastAccessTime());
        online.setExpireTime(session.getTimeout());
        online.setIpaddr(session.getHost());
        online.setBrowser(session.getBrowser());
        online.setOs(session.getOs());
        online.setStatus(session.getStatus());
        online.setSession(session);
        return online;
    }

}
