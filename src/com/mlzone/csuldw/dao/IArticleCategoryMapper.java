package com.mlzone.csuldw.dao;

import org.apache.ibatis.annotations.Param;

import com.mlzone.csuldw.entity.ArticleCategoryEntity;

public interface IArticleCategoryMapper {
	
    int deleteById(Integer id);

    /**
     * 保存或更新文章类型
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param articleCategoryEntity
     * @return
     * @since
     */
    int saveOrUpdateArticleCategory(ArticleCategoryEntity articleCategoryEntity);

    int insertSelective(ArticleCategoryEntity articleCategoryEntity);

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

    int updateByIdSelective(ArticleCategoryEntity articleCategoryEntity);

    int updateById(ArticleCategoryEntity articleCategoryEntity);
}