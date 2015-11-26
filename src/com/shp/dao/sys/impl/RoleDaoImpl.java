package com.shp.dao.sys.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shp.dao.sys.RoleDao;
import com.shp.model.sys.Role;

import core.dao.BaseDao;

/**
 * 角色的数据持久层的实现类
 * Copyright (C) 2015 - 2020 SHP快易全栈应用开发平台
 */
@Repository
public class RoleDaoImpl extends BaseDao<Role> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

	// 删除角色
	public void deleteSysUserAndRoleByRoleId(Long roleId) {
		Query query = this.getSession().createSQLQuery("delete from sysuser_role where role_id = :roleId");
		query.setParameter("roleId", roleId);
		query.executeUpdate();
	}

	// 根据菜单编码删除按钮权限
	public void deleteRolePermissionByMenuCode(String menuCode) {
		Query query = this.getSession().createSQLQuery("delete from role_permission where permissions like '%" + menuCode + "%'");
		query.executeUpdate();
	}

	// 保存按钮权限
	public void saveRolePermission(Long roleId, String permissions) {
		Query query = this.getSession().createSQLQuery("insert into role_permission values (:roleId,:permissions)");
		query.setParameter("roleId", roleId);
		query.setParameter("permissions", permissions);
		query.executeUpdate();
	}

}
