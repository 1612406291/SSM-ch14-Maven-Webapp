package com.pmy.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pmy.entity.User;
import com.pmy.service.RoleService;
import com.pmy.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;
	
	/**
	 * 
	 * @return
	 */
	public String modifyUserById(){
		return null;
		
	}
	
	/**
	 * 实现跳转到登录页
	 * @return
	 */
	@RequestMapping(value="dologin.do")
	public String dologin(HttpSession session){
		session.setAttribute("error", "登录名或密码错误");
		return "login";
	}
	
	/**
	 * 实现登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(@RequestParam String userCode,
										   @RequestParam String userPassword,
										   HttpSession session,
										   Map<String, Object> model){
			User logined = us.login(userCode, userPassword);
			if (logined != null) {//登录成功
				//放入session
				session.setAttribute("user", logined);
				return "redirect:/user/main.do";
			}else {
				return "redirect:/user/dologin.do";
			}
	}
	@RequestMapping(value="main.do")
	public String main(){
		return "frame";
	}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("userSession");
		return "login";
	}
	/**
	 * 得到所有的用户角色
	 * @param queryUserRole
	 * @param modMap
	 * @return
	 */
	/*@RequestMapping("/useradd.do")
	public String getAllRoles(String userRole,Map<String, Object> modMap){
		modMap.put("roleList", rs.getRoles());
		return "useradd";
	}*/
	/**
	 * 按条件查询
	 * @return
	 */
	private int pageSize =5;
	@RequestMapping("user.do")
	public String getUserList(String queryUserName,
														String queryUserRole,
														@RequestParam(defaultValue="1") Integer pageIndex,Map<String, Object> model){
		model.put("roleList", rs.getRoles());
		model.put("queryUserName", queryUserName);
		Integer roleInteger=0;
		if(queryUserRole!=null){
			roleInteger=Integer.parseInt(queryUserRole);
		}
		//计算总行数
		int totalCount =us.getUserRows(queryUserName, roleInteger
				);
		System.out.println(totalCount);
		//计算总页数
		int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		model.put("userList", us.getUserList(queryUserName, roleInteger, pageIndex, pageSize));
		model.put("currentPageNo", pageIndex);//当前的页码
		model.put("totalPageCount", totalPageCount);//总页数
		model.put("totalCount", totalCount);//总行数
		return "userlist";
	}
	/**
	 * 跳转到增加用戶页面
	 * @return
	 */
	@RequestMapping("useradd.do")
	public String addUser(User user){
		return "useradd";
	}
	/**
	 * 增加用户功能
	 * @param user
	 * @return
	 */
	@RequestMapping("addsave.do")
	public String addUserSave(User user){
		int add =us.addUser(user);
		if (add > 0) {
			return "redirect:/user/userlist.do";
		}
		return "useradd";
	}
}
