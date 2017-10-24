package com.mlzone.csuldw.service;

import java.util.List;
import java.util.Map;

import com.mlzone.csuldw.entity.RecommendationEntity;

/**
 * 
 * Date: 2017年10月14日 下午10:57:16 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public interface IRecommendationService {
	
    int deleteRecommendationById(Integer id);
    
    int saveOrUpdateRecommendation(RecommendationEntity recommendationEntity);
    
    List<Map<String, Object>> getRecommendationListByParam(String keywords);

}
