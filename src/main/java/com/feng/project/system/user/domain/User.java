package com.feng.project.system.user.domain;

import com.feng.framework.web.page.PageDomain;
import com.feng.project.system.dept.domain.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户对象 sys_user
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends PageDomain
{
    /** 用户ID */
    private Long userId;
    /** 部门ID */
    private Long deptId;
    /** 部门父ID */
    private Long parentId;
    /** 登录名 */
    private String loginName;
    /** 用户名称 */
    private String userName;
    /** 用户邮箱 */
    private String email;
    /** 手机号码 */
    private String phonenumber;
    /** 密码 */
    private String password;
    /** 盐加密 */
    private String salt;
    /** 类型:Y默认用户,N非默认用户 */
    private String userType;
    /** 帐号状态:0正常,1禁用 */
    private int status;
    /** 拒绝登录描述 */
    private String refuseDes;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private String createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private String updateTime;
    /** 部门对象 */
    private Dept dept;
    /** 角色组 */
    private Long[] roleIds;
    /** 岗位组 */
    private Long[] postIds;

}
