package com.feng.project.system.dept.domain;

import lombok.Data;

/**
 * 部门对象 sys_dept
 * 
 * @author feng
 */
@Data
public class Dept
{
    /** 部门ID */
    private Long deptId;
    /** 父部门ID */
    private Long parentId;
    /** 部门名称 */
    private String deptName;
    /** 显示顺序 */
    private String orderNum;
    /** 负责人 */
    private String leader;
    /** 联系电话 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 部门状态:0正常,1停用 */
    private int status;
    /** 父部门名称 */
    private String parentName;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private String createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private String updateTime;

}
