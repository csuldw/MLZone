package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.entity.UserEntity;
import com.mlzone.csuldw.service.IUserService;
import com.mysql.jdbc.log.Log;

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
	
	private static Logger log = Logger.getLogger(UserController.class);

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
	public Map<String, Object> saveOrUpdateUser(@RequestBody UserEntity userEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			System.out.println(userEntity.toString());
			int saveResult = userService.saveOrUpdateUser(userEntity);
			if(saveResult > 0){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
				resultMap.put("info", "数据保存失败！"); 

			}
		} catch (Exception e) {
			resultMap.put("result", "error");
			resultMap.put("info", "数据库操作异常！");
			log.info(e.toString());
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
	public Map<String, Object> updateUser(@RequestBody UserEntity userEntity){
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

	@RequestMapping(value = "/user/getUserListByParam.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserListByParam(String keywords, int pageNum, int pageSize) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			log.info("keywords:" + keywords);
			PageInfo<UserEntity> users = userService.getUserListByParam(keywords, pageNum, pageSize);
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
	@RequestMapping(value = "/user/getUserById.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			UserEntity userEntity = userService.getUserById(id);
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
	@RequestMapping(value = "/user/checkUserExistByUsername.do", method = {RequestMethod.POST})
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