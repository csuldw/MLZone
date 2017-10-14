package com.mlzone.csuldw.service.impl;

import org.springframework.stereotype.Service;

import com.mlzone.csuldw.dao.StarMapper;
import com.mlzone.csuldw.entity.StarEntity;
import com.mlzone.csuldw.service.IStarService;

/**
 * 
 * Date: 2017年10月14日 下午11:27:12 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Service
public class StarServiceImpl implements IStarService {

	StarMapper starMapper;
	@Override
	public int deleteStarById(Integer id) {
		return starMapper.deleteStarById(id);
	}

	@Override
	public int saveStar(StarEntity starEntity) {
		return starMapper.saveStar(starEntity);
	}

	@Override
	public int countStarByCommentId(Integer commentId) {
		return starMapper.countStarByCommentId(commentId);
	}

}
