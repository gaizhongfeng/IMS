package com.feng.project.system.menu.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 角色对象 sys_menu
 * 
 * @author feng
 */
@Data
public class Menu
{
    /** 菜单ID */
    private Long menuId;
    /** 菜单名称 */
    private String menuName;
    /** 父菜单名称 */
    private String parentName;
    /** 父菜单ID */
    private Long parentId;
    /** 显示顺序 */
    private String orderNum;
    /** 菜单URL */
    private String url;
    /** 类型:0目录,1菜单,2按钮 */
    private String menuType;
    /** 菜单状态:0显示,1隐藏 */
    private int visible;
    /** 权限字符串 */
    private String perms;
    /** 菜单图标 */
    private String icon;
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
    /** 子菜单 */
    private List<Menu> children = new ArrayList<Menu>();

}
