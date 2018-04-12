package com.feng.project.system.dict.domain;

import com.feng.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型对象 sys_dict_type
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictType extends PageDomain
{
    /** 字典主键 */
    private Long dictId;
    /** 字典名称 */
    private String dictName;
    /** 字典类型 */
    private String dictType;
    /** 状态（0正常 1禁用） */
    private int status;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private String createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private String updateTime;
    /** 备注 */
    private String remark;
}
