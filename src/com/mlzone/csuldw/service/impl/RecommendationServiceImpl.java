package com.mlzone.csuldw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
		return recommendationMapper.deleteById(id);
	}

	@Override
	public int saveOrUpdateRecommendation(
			RecommendationEntity recommendationEntity) {
		return recommendationMapper.saveOrUpdate(recommendationEntity);
	}

	@Override
	public Page<RecommendationEntity> getRecommendationListByParam(String keywords, int pageNum, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keywords", keywords);
		PageHelper.startPage(pageNum, pageSize);
		List<RecommendationEntity> recommendationList = recommendationMapper.getListByParam(params);
		Page<RecommendationEntity> entityPage = (Page<RecommendationEntity>) (recommendationList);
		return entityPage;
	}

}
