package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.ArticleCategoryEntity;

public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCategoryEntity record);

    int insertSelective(ArticleCategoryEntity record);

    ArticleCategoryEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleCategoryEntity record);

    int updateByPrimaryKey(ArticleCategoryEntity record);
}