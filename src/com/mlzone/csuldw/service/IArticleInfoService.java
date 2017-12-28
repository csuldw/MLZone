package com.mlzone.csuldw.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.entity.vo.ArticleCountStatVo;

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
    
    Page<ArticleInfoEntity>getArticleInfoListByPage(String keywords, String author, String title, String publicDate, String categoryName,  String tags, Integer isPublish, int pageNum, int pageSize);

    Page<ArticleInfoEntity> getArticleInfoList(int pageNum, int pageSize);

    ArticleInfoEntity getArticelInfoById(Integer id);
    
    List<ArticleInfoEntity>getArticleInfoListByParams(String keywords, String tag, String category, int pageNum, int pageSize);

    int countArticleInfoByParams(String keywords, String tag, String category);

    List<ArticleCountStatVo> getArticleCountByParam(String queryType);

}
