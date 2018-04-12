package com.feng.project.system.post.domain;

import com.feng.framework.web.page.PageDomain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 岗位对象 sys_post
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends PageDomain
{
    /** 岗位ID */
    private Long postId;
    /** 岗位编码 */
    private String postCode;
    /** 岗位名称 */
    private String postName;
    /** 岗位排序 */
    private String postSort;
    /** 状态（0正常 1停用） */
    private int status;
    /** 用户是否存在此岗位标识 默认不存在 */
    private boolean flag = false;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private String createTime;
    /** 更新时间 */
    private String updateTime;
    /** 更新者 */
    private String updateBy;
    /** 备注 */
    private String remark;

}
