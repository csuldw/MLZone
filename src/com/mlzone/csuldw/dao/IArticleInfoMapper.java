package com.mlzone.csuldw.dao;

import java.util.List;

import com.mlzone.csuldw.entity.ArticleInfoEntity;

public interface IArticleInfoMapper {
	
	/**
	 * 根据ID删除文章
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
    int deleteArticleInfoById(Integer id);

    /**
     * 保存或修改文章信息
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param articleInfoEntity
     * @return
     * @since
     */
    int saveOrUpdateArticleInfo(ArticleInfoEntity articleInfoEntity);
    
    /**
     * 获取文章列表
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @return
     * @since
     */
    List<ArticleInfoEntity> getArticleInfoList();

    int insertSelective(ArticleInfoEntity articleInfoEntity);

    /**
     * 根据文章ID获取文章信息
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param id
     * @return
     * @since
     */
    ArticleInfoEntity getArticelInfoById(Integer id);

    int updateByPrimaryKeySelective(ArticleInfoEntity articleInfoEntity);

    int updateByPrimaryKey(ArticleInfoEntity articleInfoEntity);
    
    /**
     * 根据条件查找文章，待完善
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param keyword
     * @param tag
     * @param category
     * @return
     * @since
     */
    List<ArticleInfoEntity>getArticleInfoListByParams(String keyword, String tag, String category);

    /**
     * 根据条件统计文章数量，待完善
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param keyword
     * @param tag
     * @param category
     * @return
     * @since
     */
    int countArticleInfoByParams(String keyword, String tag, String category);
}