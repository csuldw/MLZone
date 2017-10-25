package com.mlzone.csuldw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlzone.csuldw.dao.ICommentMapper;
import com.mlzone.csuldw.entity.CommentEntity;
import com.mlzone.csuldw.service.ICommentService;

/**
 * 
 * Date: 2017年10月14日 下午10:59:24 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentMapper commentMapper;
	
	@Override
	public int deleteCommentById(Integer id) {
		return commentMapper.deleteById(id);
	}

	@Override
	public int saveOrUpdateComment(CommentEntity commentEntity) {
		return commentMapper.saveOrUpdate(commentEntity);
	}

	@Override
	public List<CommentEntity> getCommentListByUserId(Integer userId) {
		return commentMapper.getCommentListByUserId(userId);
	}

	@Override
	public List<CommentEntity> getCommentListByArticleId(Integer articleId) {
		return commentMapper.getCommentListByArticleId(articleId);
	}

	@Override
	public int countCommentByArticleId(Integer articleId) {
		return commentMapper.countCommentByArticleId(articleId);
	}
}
