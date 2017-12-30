package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.common.DateUtils;
import com.mlzone.csuldw.common.MD5Util;
import com.mlzone.csuldw.common.OAuthTokenUtils;
import com.mlzone.csuldw.common.ResultModel;
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
			log.info(userEntity.toString());
			userEntity.setPassword(MD5Util.getMD5(userEntity.getPassword()));
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
	
	/**
	 * 登录
	 * 
	 * @author liudiwei
	 * @since 2017年12月27日 
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/user/login.do", method = {RequestMethod.POST})
	@ResponseBody
	public ResultModel login(HttpServletRequest request, String username, String password)
	{
		ResultModel result = new ResultModel();
		password = MD5Util.getMD5(password);
		UserEntity user = userService.login(username, password);
		log.info("username: " + username + " | password: "  + password);
		Map<String, Object> data = new HashMap<>();
		if(user != null)
		{
			log.info(user.toString());
			request.getSession().setAttribute("user", user);
			result.setCode(1000);
			OAuthTokenUtils tokenUtils =  OAuthTokenUtils.getInstance();
			
			String token = tokenUtils.token("MLZone", "zola", user.getUsername());
			data.put("tokenId", token);
			data.put("userId", user.getUsername());
			result.setData(data);
		}
		else
		{
			result.setCode(4003);
		}
		return result;
	}
	
	/**
	 * 获取token认证
	 * 
	 * @author liudiwei
	 * @since 2017年12月27日 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/getAuth.do", method = {RequestMethod.GET})
	@ResponseBody
	public ResultModel getAuth(HttpSession session, HttpServletRequest request)
	{
		ResultModel result = new ResultModel();
		String authToken = request.getHeader("O-Auth-Token");
		String userId = request.getHeader("O-Auth-UserId");
		log.info(authToken + "|" + userId); 
		OAuthTokenUtils tokenUtils =  OAuthTokenUtils.getInstance();
		Map<String, Object> parseRes = tokenUtils.parseToken(authToken);
		log.info(parseRes);
		if(Integer.parseInt(parseRes.get("code").toString()) == 1000){
			JSONObject jsonObj = new JSONObject(parseRes.get("data").toString());
			if(userId!= null && userId.equals(jsonObj.get("userId")) ){
				result.setCode(1000);
				result.setMsg("token认证成功!");
			}else{
				result.setCode(4001);
				result.setMsg("认证失败,请重新登录！");
			}
		}
		else{
			result.setCode(4001);
		}
		return result;
	}
}
