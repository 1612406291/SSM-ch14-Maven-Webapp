package com.pmy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pmy.entity.User;

public interface UserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User login(String userCode,String userPassword);
	/**
	 * 根据条件查询用户列表
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	public List<User> getUserList(String queryUserName,int queryUserRole,int pageIndex, int pageSize);
	/**
	 * 根据姓名或角色查询返回的记录数
	 * @param userName
	 * @param userRole
	 * @return
	 */
	int getUserRows(String userName,int userRole);
	/**
	 * 增加用户
	 * @param provider
	 * @return
	 */
	int addUser(User user);
	/**
	 * 更改密码
	 * @param userCode
	 * @param userPassword
	 * @param newPassword
	 * @return
	 */
	int changePassword(String userCode,String userPassword,String newPassword);
	/**
	 * 根据Id修改用户
	 * @param id
	 * @return
	 */
	int modifyUserById(Integer id);
}
