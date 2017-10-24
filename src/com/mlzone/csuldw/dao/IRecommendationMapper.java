package com.mlzone.csuldw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mlzone.csuldw.entity.RecommendationEntity;

public interface IRecommendationMapper {
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
     * 根据关键字获取推荐的列表 待完善
     *
     * Author:liudiwei
     * Date:2017年10月24日
     * @param keywords
     * @return
     * @since
     */
    List<Map<String, Object>> getRecommendationListByParam(@Param("keywords") String keywords);
    
    int insertSelective(RecommendationEntity recommendationEntity);

    /**
     * 根据ID获取推荐内容
     *
     * Author:liudiwei
     * Date:2017年10月24日
     * @param id
     * @return
     * @since
     */
    RecommendationEntity selectById(Integer id);

    int updateByIdSelective(RecommendationEntity recommendationEntity);

    int updateById(RecommendationEntity recommendationEntity);
}