package com.mlzone.csuldw.dao;

import java.util.List;

import com.mlzone.csuldw.entity.RecommendationEntity;

public interface RecommendationMapper {
	/**
	 * 根据推荐ID删除该推荐
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
    int deleteRecommendationById(Integer id);

    /**
     * 保存或更新推荐
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param recommendationEntity
     * @return
     * @since
     */
    int saveOrUpdateRecommendation(RecommendationEntity recommendationEntity);

    /**
     * 根据参数获取推荐的列表 待完善
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param categoryId
     * @param source
     * @param recommendationType
     * @return
     * @since
     */
    List<RecommendationEntity> getRecommendationListByParams(Integer categoryId, String source, Integer recommendationType);
    
    int insertSelective(RecommendationEntity recommendationEntity);

    RecommendationEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendationEntity recommendationEntity);

    int updateByPrimaryKey(RecommendationEntity recommendationEntity);
}