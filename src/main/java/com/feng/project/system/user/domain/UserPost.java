package com.feng.project.system.user.domain;

import lombok.Data;

/**
 * 用户和岗位关联 sys_user_post
 * 
 * @author feng
 */
@Data
public class UserPost
{
    /** 用户ID */
    private Long userId;
    /** 岗位ID */
    private Long postId;
}
