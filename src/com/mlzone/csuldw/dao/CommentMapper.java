package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.CommentEntity;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentEntity record);

    int insertSelective(CommentEntity record);

    CommentEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentEntity record);

    int updateByPrimaryKey(CommentEntity record);
}