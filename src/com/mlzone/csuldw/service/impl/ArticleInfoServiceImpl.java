package com.mlzone.csuldw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mlzone.csuldw.dao.IArticleInfoMapper;
import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.service.IArticleInfoService;

/**
 * 
 * Date: 2017年10月14日 下午10:51:28 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Service
public class ArticleInfoServiceImpl implements IArticleInfoService {

	@Autowired
	IArticleInfoMapper articleInfoMapper;
	
	@Override
	public int deleteArticleInfoById(Integer id) {
		return articleInfoMapper.deleteArticleInfoById(id);
	}

	@Override
	public int saveOrUpdateArticleInfo(ArticleInfoEntity articleInfoEntity) {
		return articleInfoMapper.saveOrUpdateArticleInfo(articleInfoEntity);
	}

	@Override
	public List<ArticleInfoEntity> getArticleInfoList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return articleInfoMapper.getArticleInfoList();
	}

	@Override
	public ArticleInfoEntity getArticelInfoById(Integer id) {
		return articleInfoMapper.getArticelInfoById(id);
	}

	@Override
	public List<ArticleInfoEntity> getArticleInfoListByParams(String keywords, String tag, String category, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return articleInfoMapper.getArticleInfoListByParams(keywords, tag, category);
	}

	@Override
	public int countArticleInfoByParams(String keywords, String tag,String category) {
		return articleInfoMapper.countArticleInfoByParams(keywords, tag, category);
	}

}
