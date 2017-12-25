package com.mlzone.csuldw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.entity.vo.ArticleCountStatVo;

public interface IArticleInfoMapper extends BaseMapper<ArticleInfoEntity>{
	
    /**
     * 根据条件查找文章，待完善
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param keywords
     * @param tag
     * @param category
     * @return
     * @since
     */
    List<ArticleInfoEntity>getArticleInfoListByParams(String keywords, String tag, String category);

    /**
     * 根据条件统计文章数量，待完善
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param keywords
     * @param tag
     * @param category
     * @return
     * @since
     */
    int countArticleInfoByParams(String keywords, String tag, String category);
	
    List<ArticleCountStatVo> getArticleCountByQueryType(Object params);
}
