package com.pmy.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pmy.entity.Provider;
import com.pmy.entity.User;


public interface UserMapping {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(@Param("userCode")String userCode,
			@Param("userPassword")String userPassword);
	
	/**
	 * 通过条件查询-userList
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<User> getUserList(@Param("userName")String userName,
													@Param("userRole")int userRole,
													@Param("pageIndex")int pageIndex,
													@Param("pageSize")int pageSize);
	
	/**
	 * 根据姓名或角色查询返回的记录数
	 * @param userName
	 * @param userRole
	 * @return
	 */
	int getUserRows(@Param("userName")String userName,
										@Param("userRole")int userRole);
	
	/**
	 * 修改密码
	 * @param userCode
	 * @param userPassword
	 * @param newPassword
	 * @return
	 */
	int changePassword(@Param("userCode")String userCode,
												@Param("userPassword")String userPassword,
												@Param("newPassword")String newPassword);
	/**
	 * 增加用户
	 * @param provider
	 * @return
	 */
	int addUser(User user);
	/**
	 * 修改用户
	 * @param id
	 * @return
	 */
	int modifyUserById(Integer id);
	
}