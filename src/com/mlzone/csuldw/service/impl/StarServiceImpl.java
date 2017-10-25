package com.mlzone.csuldw.service.impl;

import org.springframework.stereotype.Service;

import com.mlzone.csuldw.dao.IStarMapper;
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

	IStarMapper starMapper;
	@Override
	public int deleteStarById(Integer id) {
		return starMapper.deleteById(id);
	}

	@Override
	public int saveStar(StarEntity starEntity) {
		return starMapper.save(starEntity);
	}

	@Override
	public int countStarByCommentId(Integer commentId) {
		return starMapper.countStarByCommentId(commentId);
	}

}
