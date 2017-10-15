package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlzone.csuldw.entity.RecommendationEntity;
import com.mlzone.csuldw.service.IRecommendationService;

/**
 * 
 * Date: 2017年10月15日 下午2:00:10 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class RecommendationController {
	
	@Autowired
	IRecommendationService recommendationService;
	
	/**
	 * 新增或更新推荐信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param recommendationEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/saveOrUpdateRecommendation.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrUpdateRecommendation(RecommendationEntity recommendationEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int insertResult = recommendationService.saveOrUpdateRecommendation(recommendationEntity);
			if(insertResult == 1){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 根据ID删除推荐信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/deleteRecommendationById.do")
	@ResponseBody
	public Map<String, Object> deleteRecommendationById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int deleteResult = recommendationService.deleteRecommendationById(id);
			if(deleteResult == 1){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 根据参数筛选推荐列表
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param categoryId
	 * @param source
	 * @param recommendationType
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/user/getRecommendationListByParams.do")
	@ResponseBody
	public Map<String, Object> getRecommendationListByParams(Integer categoryId, String source, Integer recommendationType){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<RecommendationEntity> recommendationList = recommendationService.getRecommendationListByParams(categoryId, source, recommendationType);
			resultMap.put("data", recommendationList);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}

}
