package com.mlzone.csuldw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.entity.vo.ArticleCountStatVo;

public interface IArticleInfoMapper extends BaseMapper<ArticleInfoEntity>{
	
    List<ArticleCountStatVo> getArticleCountByQueryType(Object params);
    
    /**
     * 更新文章中的关联作者
     *
     * Author:liudiwei
     * Date:2017年12月30日
     * @param userId
     * @param author
     * @return
     * @since
     */
    int updateAuthor(@Param("userId") Integer userId, @Param("author") String author);

    int updateViewCount(@Param("id") Integer id);
    
    /**
     * 简单推荐功能
     * 
     * @author liudiwei
     * @since 2018年1月17日 
     * @param params
     * @return
     */
    List<ArticleInfoEntity> getRecArticleListByParam(Object params);
}
