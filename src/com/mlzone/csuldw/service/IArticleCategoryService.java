package com.mlzone.csuldw.service;

import com.mlzone.csuldw.entity.ArticleCategoryEntity;

/**
 * 
 * Date: 2017年10月14日 下午7:14:24 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public interface IArticleCategoryService {
	
    public ArticleCategoryEntity getArticleCategoryById(Integer id);
    
    public int saveOrUpdateArticleCategory(ArticleCategoryEntity articleCategoryEntity);

}
