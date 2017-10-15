package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlzone.csuldw.entity.UserEntity;
import com.mlzone.csuldw.service.IUserService;

/**
 * 
 * Date: 2017年10月14日 下午3:08:33 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 保存或更新用户名
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param userEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/saveOrUpdateUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrUpdateUser(UserEntity userEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int insertResult = userService.saveOrUpdateUser(userEntity);
			if(insertResult == 1){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 更新用户信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param userEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/updateUser.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUser(UserEntity userEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int insertResult = userService.updateUserById(userEntity);
			if(insertResult == 1){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@RequestMapping(value = "/user/getUserList.do")
	@ResponseBody
	public Map<String, Object> getUserList(int pageNum, int pageSize) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<UserEntity> users = userService.getUserList(pageNum, pageSize);
			resultMap.put("data", users);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			e.printStackTrace();
		}
		return resultMap;
	}	
	
	/**
	 * 根据ID获取用户信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param userId
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/getUserById.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserById(Integer userId){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			UserEntity userEntity = userService.getUserById(userId);
			resultMap.put("data", userEntity);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}
	
	/**
	 * 检查用户名是否存在
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param username
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/checkUserExistByUsername.do")
	@ResponseBody
	public Map<String, Object> checkUserExistByUsername(String username){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			boolean isExist = userService.checkUserExistByUsername(username);
			resultMap.put("isExist", isExist);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}
}