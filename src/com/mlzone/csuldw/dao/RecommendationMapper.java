package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.RecommendationEntity;

public interface RecommendationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendationEntity record);

    int insertSelective(RecommendationEntity record);

    RecommendationEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendationEntity record);

    int updateByPrimaryKey(RecommendationEntity record);
}