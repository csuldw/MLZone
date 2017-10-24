package com.mlzone.csuldw.dao;

import java.util.List;

import com.mlzone.csuldw.entity.CommentEntity;

public interface ICommentMapper {
	/**
	 * 根据评论ID删除评论
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
    int deleteCommentById(Integer id);

    /**
     * 保存或更新评论
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param commentEntity
     * @return
     * @since
     */
    int saveOrUpdateComment(CommentEntity commentEntity);
    
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
     * 根据文章ID获取这篇文章的总评论数量
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param articleId
     * @return
     * @since
     */
    int countCommentByArticleId(Integer articleId);
    
    int insertSelective(CommentEntity commentEntity);

    CommentEntity selectById(Integer id);

    int updateByIdSelective(CommentEntity commentEntity);

    int updateById(CommentEntity commentEntity);
}