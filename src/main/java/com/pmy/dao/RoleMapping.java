package com.pmy.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pmy.entity.Role;
import com.pmy.entity.User;


public interface RoleMapping {
	/**
	 * 得到所有角色
	 * @return
	 */
	List<Role> getRoles();
}