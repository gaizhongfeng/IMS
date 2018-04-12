package com.feng.project.system.role.domain;

import java.util.Date;
import com.feng.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色对象 sys_role
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends PageDomain
{
    /** 角色ID */
    private Long roleId;
    /** 角色名 */
    private String roleName;
    /** 角色权限 */
    private String roleKey;
    /** 角色排序 */
    private String roleSort;
    /** 角色状态:0正常,1禁用 */
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
    /** 用户是否存在此角色标识 默认不存在 */
    private boolean flag = false;
    /** 菜单组 */
    private Long[] menuIds;

}
