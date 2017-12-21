package com.mlzone.csuldw.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.common.DateUtils;
import com.mlzone.csuldw.common.OAuthTokenUtils;
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
			if(userEntity.getId() == 0){
				userEntity.setRegDate(DateUtils.getFormatedDate(DateUtils.DATE_FORMAT_PATTEN_TYPE1));
			}
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
	
	@RequestMapping(value = "/user/login.do", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request, String username, String password)
	{
		Map<String, Object> result = new HashMap<>();
		UserEntity user = userService.login(username, password);
		if(user != null)
		{
			log.info(user.toString());
			request.getSession().setAttribute("user", user);
			result.put("msg", "success");
			result.put("code", "1000");
			OAuthTokenUtils tokenUtils =  OAuthTokenUtils.getInstance();
			
			String token = tokenUtils.token("MLZone", "zola", user.getUsername());
			result.put("tokenId", token);
			result.put("userId", user.getUsername());
//			result.put("session", request.getSession().toString()); 
		}
		else
		{
			result.put("msg", "token认证失败");
			result.put("code", "4000");
		}
		return result;
	}
	
	@RequestMapping(value = "/user/getAuth.do", method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getAuth(HttpSession session, HttpServletRequest request)
	{
		Map<String, Object> result = new HashMap<>();
		String authToken = request.getHeader("O-Auth-Token");
		String userId = request.getHeader("O-Auth-UserId");
		OAuthTokenUtils tokenUtils =  OAuthTokenUtils.getInstance();
		Map<String, Object> parseRes = tokenUtils.parseToken(authToken);
		System.out.println(parseRes);
		if(Integer.parseInt(parseRes.get("code").toString()) == 1000){
			JSONObject jsonObj = new JSONObject(parseRes.get("data").toString());
			if(userId!= null && userId.equals(jsonObj.get("userId")) ){
				result.put("code", "1000");
				result.put("isAuth", 1);
				result.put("msg", "token认证成功!");
			}else{
				result.put("code", "4002");
				result.put("isAuth", 0);
				result.put("msg", "token认证失败!");
			}
		}
		else{
			result = parseRes;
		}
		return result;
	}
}