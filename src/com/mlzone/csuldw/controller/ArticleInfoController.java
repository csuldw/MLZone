package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.service.impl.ArticleInfoServiceImpl;

/**
 * 
 * Date: 2017年10月14日 下午11:02:54 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class ArticleInfoController {
	
	@Autowired
	private ArticleInfoServiceImpl articleInfoServiceImpl;
	
	@RequestMapping(value = "/articleInfo/getArticelInfoById.do")
	@ResponseBody
	public Map<String, Object> getArticelInfoById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			ArticleInfoEntity articleInfoEntity = articleInfoServiceImpl.getArticelInfoById(id);
			resultMap.put("data", articleInfoEntity);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}
	
}
