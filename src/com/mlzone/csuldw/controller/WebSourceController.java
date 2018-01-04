package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.entity.WebSourceEntity;
import com.mlzone.csuldw.service.IWebSourceService;

/**
 * 
 * Date: 2018年1月4日 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class WebSourceController {
	
	private static Logger log = Logger.getLogger(WebSourceController.class);
	
	@Autowired
	IWebSourceService webSourceService;
	
	/**
	 * 保存或更新网络资源
	 * 
	 * @author liudiwei
	 * @since 2018年1月4日 
	 * @param webSourceEntity
	 * @return
	 */
	@RequestMapping(value = "/webSource/saveOrUpdateWebSource.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrUpdateWebSource(@RequestBody WebSourceEntity webSourceEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int saveResult = webSourceService.saveOrUpdate(webSourceEntity);
			if(saveResult > 0){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
				resultMap.put("info", "数据保存失败！"); 
			}
		} catch (Exception e) {
			resultMap.put("result", "error");
			resultMap.put("info", "数据库操作异常！");
			log.error(e);
		}
		return resultMap;
	}
	
	/**
	 * 删除网络资源
	 * 
	 * @author liudiwei
	 * @since 2018年1月4日 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/webSource/deleteWebSourceById.do", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> deleteWebSourceById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int deleteResult = webSourceService.deleteById(id);
			if(deleteResult == 1) {
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}

	/**
	 * 获取网络资源列表
	 * 
	 * @author liudiwei
	 * @since 2018年1月4日 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/webSource/getWebSourceListByParam.do", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> getWebSourceListByParam(String sourceType, String keywords, 
			int pageNum, int pageSize) {		
		Map<String, Object> resultMap = new HashMap<>();
		try {
			log.info("sourceType: " + sourceType + " | keywords:" + keywords);
			PageInfo<WebSourceEntity> webSourceEntity = webSourceService.getListByParams(sourceType, keywords, pageNum, pageSize);
			resultMap.put("data", webSourceEntity);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			e.printStackTrace();
		}
		return resultMap;
	}	

}
