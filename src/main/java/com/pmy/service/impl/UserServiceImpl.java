package com.pmy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmy.dao.UserMapping;
import com.pmy.entity.User;
import com.pmy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapping userMapping;

	/**
	 * 登录
	 */
	public User login(String userCode, String userPassword) {
		return userMapping.login(userCode, userPassword);
	}

	/**
	 * 根据条件查询用户列表
	 */
	public List<User> getUserList(String queryUserName, int queryUserRole,
			int pageIndex, int pageSize) {
		return userMapping.getUserList(queryUserName, queryUserRole,
				(pageIndex - 1) * pageSize, pageSize);
	}

	/**
	 * 根据姓名或角色查询返回的记录数
	 */
	public int getUserRows(String userName, int userRole) {
		return userMapping.getUserRows(userName, userRole);
	}

	/**
	 * 修改登录密码
	 */
	public int changePassword(String userCode, String userPassword,
			String newPassword) {
		return userMapping.changePassword(userCode, userPassword, newPassword);
	}

	/**
	 * 增加用户
	 */
	public int addUser(User user) {
		return userMapping.addUser(user);
	}
	/**
	 * 根据Id修改用户
	 */
	public int modifyUserById(Integer id) {
		return userMapping.modifyUserById(id);
	}
}
