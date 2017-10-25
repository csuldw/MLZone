package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.StarEntity;

public interface IStarMapper extends BaseMapper<StarEntity>{
    
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

}