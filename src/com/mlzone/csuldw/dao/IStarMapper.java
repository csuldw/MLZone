package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.StarEntity;

public interface IStarMapper {
	/**
	 * 取消赞
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
    int deleteStarById(Integer id);

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

    StarEntity selectById(Integer id);

    int updateByIdSelective(StarEntity starEntity);

    int updateById(StarEntity starEntity);
}