package com.pmy.service;

import java.util.List;

import com.pmy.entity.Role;
import com.pmy.entity.User;

public interface RoleService {
	/**
	 * 得到所有角色
	 * @return
	 */
	List<Role> getRoles();
}
