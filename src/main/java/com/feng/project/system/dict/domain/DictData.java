package com.feng.project.system.dict.domain;

import com.feng.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author feng
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictData extends PageDomain
{
    /** 字典编码 */
    private Long dictCode;
    /** 字典排序 */
    private Long dictSort;
    /** 字典标签 */
    private String dictLabel;
    /** 字典键值 */
    private String dictValue;
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
