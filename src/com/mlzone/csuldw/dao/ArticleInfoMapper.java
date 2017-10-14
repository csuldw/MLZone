package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.ArticleInfoEntity;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfoEntity record);

    int insertSelective(ArticleInfoEntity record);

    ArticleInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleInfoEntity record);

    int updateByPrimaryKey(ArticleInfoEntity record);
}