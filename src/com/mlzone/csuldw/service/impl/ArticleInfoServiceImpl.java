package com.mlzone.csuldw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mlzone.csuldw.common.DateUtils;
import com.mlzone.csuldw.dao.IArticleInfoMapper;
import com.mlzone.csuldw.dao.IUserMapper;
import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.entity.vo.ArticleCountStatVo;
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
	
	@Autowired
	IUserMapper userMapper;

	@Override
	public int deleteArticleInfoById(Integer id) {
		return articleInfoMapper.deleteById(id);
	}

	@Override
	public int saveOrUpdateArticleInfo(ArticleInfoEntity articleInfoEntity) {
		if (articleInfoEntity.getAuthor() == null || articleInfoEntity.getAuthor() == "") {
			articleInfoEntity.setAuthor(userMapper.getById(712).getNickname());
		}
		if (articleInfoEntity.getId() == 0) {
			articleInfoEntity.setPublicDate(DateUtils
					.getFormatedDate(DateUtils.DATE_FORMAT_PATTEN_TYPE1));
			return articleInfoMapper.save(articleInfoEntity);
		} else {
			return articleInfoMapper.update(articleInfoEntity);
		}
	}

	@Override
	public Page<ArticleInfoEntity> getArticleInfoList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<ArticleInfoEntity> articlePage = (Page<ArticleInfoEntity>) articleInfoMapper
				.getList();
		return articlePage;
	}

	@Override
	public ArticleInfoEntity getArticelInfoById(Integer id) {
		articleInfoMapper.updateViewCount(id);
		return articleInfoMapper.getById(id);
	}

	@Override
	public Page<ArticleInfoEntity> getArticleInfoListByPage(String keywords,
			String author, String title, String publicDate,
			String categoryName, String tags, Integer isPublish, int pageNum,
			int pageSize, String orderColumn, String orderType) {
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> params = new HashMap<>();
		params.put("keywords", keywords);
		params.put("author", author);
		params.put("title", title);
		params.put("publicDate", publicDate);
		params.put("categoryName", categoryName);
		params.put("tags", tags);
		params.put("isPublish", isPublish);
		params.put("orderColumn", orderColumn);
		params.put("orderType", orderType);
		Page<ArticleInfoEntity> articlePage = (Page<ArticleInfoEntity>) articleInfoMapper
				.getListByParam(params);
		return articlePage;
	}

	@Override
	public List<ArticleCountStatVo> getArticleCountByParam(String queryType) {
		Map<String, Object> params = new HashMap<>();
		if (queryType != null && "year".equals(queryType)) {
			params.put("queryType", "%Y");
		} else if (queryType != null && "month".equals(queryType)) {
			params.put("queryType", "%Y-%m");
		} else {
			params.put("queryType", queryType);
		}
		return articleInfoMapper.getArticleCountByQueryType(params);
	}

	@Override
	public Page<ArticleInfoEntity> getRecArticelInfoList(int pageNum, int pageSize, String orderColumn,
			String orderType)
	{
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> params = new HashMap<>();
		params.put("orderColumn", orderColumn);
		params.put("orderType", orderType);
		Page<ArticleInfoEntity> articlePage = (Page<ArticleInfoEntity>) articleInfoMapper.getRecArticleListByParam(params);
		return articlePage;
	}

}
