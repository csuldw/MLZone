package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.StarEntity;

public interface StarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StarEntity record);

    int insertSelective(StarEntity record);

    StarEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StarEntity record);

    int updateByPrimaryKey(StarEntity record);
}