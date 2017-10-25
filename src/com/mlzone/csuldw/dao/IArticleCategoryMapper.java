package com.mlzone.csuldw.dao;

import org.apache.ibatis.annotations.Param;

import com.mlzone.csuldw.entity.ArticleCategoryEntity;

public interface IArticleCategoryMapper extends BaseMapper<ArticleCategoryEntity>{
	
    int delete(int id);

    /**
     * 根据ID获取文章类别信息
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param id
     * @return
     * @since
     */
    ArticleCategoryEntity getArticleCategoryById(@Param("categoryId") Integer id);

}