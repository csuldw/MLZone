package com.mlzone.csuldw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mlzone.csuldw.entity.ArticleInfoEntity;

/**
 * 
 * Date: 2017年10月14日 下午10:51:05 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public interface IArticleInfoService {
	
	int deleteArticleInfoById(Integer id);
	
    int saveOrUpdateArticleInfo(ArticleInfoEntity articleInfoEntity);

    List<ArticleInfoEntity> getArticleInfoList(int pageNum, int pageSize);

    ArticleInfoEntity getArticelInfoById(Integer id);
    
    List<ArticleInfoEntity>getArticleInfoListByParams(String keywords, String tag, String category, int pageNum, int pageSize);

    int countArticleInfoByParams(String keywords, String tag, String category);

}
