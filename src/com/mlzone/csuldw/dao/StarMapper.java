package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.StarEntity;

public interface StarMapper {
	/**
	 * 取消赞
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
    int deleteStar(Integer id);

    /**
     * 保存赞
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param starEntity
     * @return
     * @since
     */
    int saveStar(StarEntity starEntity);
    
    /**
     * 根据评论ID统计点赞数量
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param id
     * @return
     * @since
     */
    int countStarByCommentId(Integer commentId);

    int insertSelective(StarEntity starEntity);

    StarEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StarEntity starEntity);

    int updateByPrimaryKey(StarEntity starEntity);
}