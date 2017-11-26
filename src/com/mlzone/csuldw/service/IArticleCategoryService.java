package com.mlzone.csuldw.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.entity.ArticleCategoryEntity;
import com.mlzone.csuldw.entity.UserEntity;

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
    
    public List<ArticleCategoryEntity> getArticleCategoryListByParam(String keywords);


}
