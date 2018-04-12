package com.feng.framework.web.page;

import java.util.Map;
import lombok.Data;

/**
 * 表格请求参数封装
 * 
 * @author feng
 */
@Data
public class PageUtilEntity
{
    /** 当前记录起始索引 */
    private int page;
    /** 每页显示记录数 */
    private int size;
    /** 排序列 */
    private String orderByColumn;
    /** 排序的方向 "desc" 或者 "asc". */
    private String isAsc;
    /** true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性 */
    private boolean entityOrField;
    /** 总记录数 */
    private int totalResult;
    /** 搜索值 */
    private String searchValue;
    /** 请求参数 */
    protected Map<String, Object> reqMap;
}
