package com.feng.framework.shiro.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;

import com.feng.common.constant.CommonConstant;
import com.feng.common.utils.MessageUtils;
import com.feng.common.utils.StringUtils;
import com.feng.common.utils.SystemLogUtils;
import com.feng.common.utils.security.ShiroUtils;
import com.feng.project.system.user.domain.User;

import lombok.extern.slf4j.Slf4j;

/**
 * 退出过滤器
 * 
 * @author feng
 */
@Slf4j
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter
{

    /**
     * 退出后重定向的地址
     */
    private String loginUrl;

    public String getLoginUrl()
    {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl)
    {
        this.loginUrl = loginUrl;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception
    {
        try
        {
            Subject subject = getSubject(request, response);
            String redirectUrl = getRedirectUrl(request, response, subject);
            try
            {
                User user = (User) ShiroUtils.getSubjct().getPrincipal();
                if (StringUtils.isNotNull(user))
                {
                    String loginName = user.getLoginName();
                    // 记录用户退出日志
                    SystemLogUtils.log(loginName, CommonConstant.LOGOUT, MessageUtils.message("user.logout.success"));
                }
                // 退出登录
                subject.logout();
            }
            catch (SessionException ise)
            {
                log.error("logout fail.", ise);
            }
            issueRedirect(request, response, redirectUrl);
        }
        catch (Exception e)
        {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", e);
        }
        return false;
    }

    /**
     * 退出跳转URL
     */
    @Override
    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject)
    {
        String url = getLoginUrl();
        if (StringUtils.isNotEmpty(url))
        {
            return url;
        }
        return super.getRedirectUrl(request, response, subject);
    }

}
