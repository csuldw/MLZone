package com.mlzone.csuldw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlzone.csuldw.dao.IArticleCategoryMapper;
import com.mlzone.csuldw.entity.ArticleCategoryEntity;
import com.mlzone.csuldw.service.IArticleCategoryService;

/**
 * 
 * Date: 2017年10月14日 下午10:59:36 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Service
public class ArticleCategoryServiceImpl implements IArticleCategoryService {

	@Autowired
	private IArticleCategoryMapper articleCategoryMapper; 
	
	@Override
	public ArticleCategoryEntity getArticleCategoryById(Integer id) {
		return articleCategoryMapper.getArticleCategoryById(id);
	}

	@Override
	public int saveOrUpdateArticleCategory(ArticleCategoryEntity articleCategoryEntity) {
		return articleCategoryMapper.saveOrUpdate(articleCategoryEntity);
	}

	@Override
	public List<ArticleCategoryEntity> getArticleCategoryListByParam(String keywords) {
		Map<String, Object> params = new HashMap<>();
		params.put("keywords", keywords);
		return articleCategoryMapper.getListByParam(params);
	}

}
