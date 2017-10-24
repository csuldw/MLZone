package com.mlzone.csuldw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlzone.csuldw.dao.IRecommendationMapper;
import com.mlzone.csuldw.entity.RecommendationEntity;
import com.mlzone.csuldw.service.IRecommendationService;

/**
 * 
 * Date: 2017年10月14日 下午10:58:12 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Service
public class RecommendationServiceImpl implements IRecommendationService {

	@Autowired
	IRecommendationMapper recommendationMapper;
	
	@Override
	public int deleteRecommendationById(Integer id) {
		return recommendationMapper.deleteRecommendationById(id);
	}

	@Override
	public int saveOrUpdateRecommendation(
			RecommendationEntity recommendationEntity) {
		return recommendationMapper.saveOrUpdateRecommendation(recommendationEntity);
	}

	@Override
	public List<Map<String, Object>> getRecommendationListByParam(String keywords) {
		return recommendationMapper.getRecommendationListByParam(keywords);
	}

}
