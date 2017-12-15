package com.mlzone.csuldw.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mlzone.csuldw.entity.CommentEntity;

public interface ICommentMapper extends BaseMapper<CommentEntity>{

    /**
     * 根据用户ID获取评论
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param userId
     * @return
     * @since
     */
    List<CommentEntity> getCommentListByUserId(Integer userId);

    /**
     * 获取某一文章的评论
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param articleId
     * @return
     * @since
     */
    List<CommentEntity> getCommentListByArticleId(Integer articleId);
    
    /**
     * 获取子评论
     *
     * Author:liudiwei
     * Date:2017年12月15日
     * @param id
     * @return
     * @since
     */
    List<CommentEntity> getSubCommentListById(@Param("id") Serializable id);
    
    /**
     * 根据文章ID获取这篇文章的总评论数量
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param articleId
     * @return
     * @since
     */
    int countCommentByArticleId(Integer articleId);
    
}