package com.pmy.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmy.dao.RoleMapping;
import com.pmy.dao.UserMapping;
import com.pmy.entity.Role;
import com.pmy.entity.User;
import com.pmy.service.RoleService;
import com.pmy.service.UserService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapping mapping;

	/**
	 * 查询得到所有角色
	 */
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return mapping.getRoles();
	}
	

}
