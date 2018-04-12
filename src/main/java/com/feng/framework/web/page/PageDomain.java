package com.feng.framework.web.page;

import lombok.Data;

@Data
public class PageDomain
{
    /** 当前记录起始索引 */
    private int pageNum;
    /** 每页显示记录数 */
    private int pageSize;
    /** 排序列 */
    private String orderByColumn;
    /** 排序的方向 "desc" 或者 "asc". */
    private String isAsc;
    /** 搜索值 */
    private String searchValue;

    public String getOrderBy()
    {
        return orderByColumn + " " + isAsc;
    }

}
