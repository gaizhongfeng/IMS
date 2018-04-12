package com.feng.project.system.role.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.feng.project.system.role.domain.RoleMenu;

/**
 * 角色与菜单关联表 数据层
 * 
 * @author feng
 */
@Mapper
public interface IRoleMenuDao
{

    /**
     * 通过角色ID删除角色和菜单关联
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleMenuByRoleId(Long roleId);
    
    /**
     * 批量新增角色菜单信息
     * 
     * @param roleMenuList 角色菜单列表
     * @return 结果
     */
    public int batchRoleMenu(List<RoleMenu> roleMenuList);

}
