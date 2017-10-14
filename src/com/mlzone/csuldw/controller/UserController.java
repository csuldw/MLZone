package com.mlzone.csuldw.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * 保存用户
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
	
	
	
	
	@RequestMapping(value = "/hello.do")
	public String find(HttpServletRequest request) {
		String age = userService.findNicknameById("1");
		System.out.println(age);// 如果实验成功，在控制台会打印年龄25
		return "index";
	}

	@RequestMapping(value = "view.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> testView(@RequestBody List<UserEntity> user) {
		Map<String, Object> res = new HashMap<>();
		for (UserEntity entity : user) {
			System.out.println(entity.toString());
		}
		return res;
	}

	@RequestMapping(value = "/getUserList.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserList(int pageNum, int pageSize) {
		Map<String, Object> res = new HashMap<>();
		System.out.println(pageNum + " " + pageSize);
		List<UserEntity> users = userService.getUserList(pageNum, pageSize);
		res.put("data", users);
		return res;
	}

	@RequestMapping(value = "/exportUser.do")
	@ResponseBody
	public Map<String, Object> exportUser(HttpServletResponse response, int pageNum,
			int pageSize) throws Exception {
		Map<String, Object> res = new HashMap<>();
		System.out.println(pageNum + " " + pageSize);
		InputStream is = userService.getInputStream(pageNum, pageSize);
		write("1.xls", is);
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("contentDisposition",
				"attachment;filename=AllUsers.xls");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
		res.put("filePath", "D:/1.xls");
		return res;
	}

	private void write(String filename, InputStream in) {
		String path = "D:/";
		File file = new File(path);
		if (!file.exists()) {
			if (!file.mkdirs()) {// 若创建文件夹不成功
				System.out.println("Unable to create external cache directory");
			}
		}
		File targetfile = new File(path + filename);
		OutputStream os = null;
		try {
			os = new FileOutputStream(targetfile);
			int ch = 0;
			while ((ch = in.read()) != -1) {
				os.write(ch);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}