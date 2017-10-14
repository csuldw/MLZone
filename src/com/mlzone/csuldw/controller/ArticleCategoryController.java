package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlzone.csuldw.entity.ArticleCategoryEntity;
import com.mlzone.csuldw.service.impl.ArticleCategoryServiceImpl;

/**
 * 
 * Date: 2017年10月14日 下午7:16:42 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class ArticleCategoryController {
	
	@Autowired
	private ArticleCategoryServiceImpl articleCategoryServiceImpl;
	
	/**
	 * 根据ID获取文章类别
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleCategory/getArticleCategoryById.do")
	@ResponseBody
	public Map<String, Object> getArticleCategoryById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			ArticleCategoryEntity articleCategoryEntity = articleCategoryServiceImpl.getArticleCategoryById(id);
			resultMap.put("date", articleCategoryEntity);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println("getArticleCategoryById" + e);
		}
		return resultMap;
	}
	
	/**
	 * 保存或更新文章类目信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param articleCategoryEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleCategory/saveOrUpdateArticleCategory.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrUpdateArticleCategory(ArticleCategoryEntity articleCategoryEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int saveResult = articleCategoryServiceImpl.saveOrUpdateArticleCategory(articleCategoryEntity);
			if(saveResult == 1){
				resultMap.put("result", "success"); 
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			resultMap.put("result", "error");
		}
		return resultMap;
	}
}
