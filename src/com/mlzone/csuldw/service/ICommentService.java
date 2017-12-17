package com.mlzone.csuldw.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.entity.CommentEntity;

/**
 * 
 * Date: 2017年10月14日 下午10:54:21 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public interface ICommentService {
	
    int deleteCommentById(Integer id);

    int saveOrUpdateComment(CommentEntity commentEntity);

    List<CommentEntity> getCommentListByUserId(Integer userId);

    List<CommentEntity> getCommentListByArticleId(Integer articleId);

    int countCommentByArticleId(Integer articleId);
    
    public PageInfo<CommentEntity> getCommentListByParam(String keywords, int pageNum, int pageSize, Integer fromUserId, Integer toUserId, Integer articleId, String parentCommentId);


}
