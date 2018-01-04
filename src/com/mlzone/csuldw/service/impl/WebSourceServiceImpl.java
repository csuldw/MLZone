package com.mlzone.csuldw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.dao.IWebSourceMapper;
import com.mlzone.csuldw.entity.UserEntity;
import com.mlzone.csuldw.entity.WebSourceEntity;
import com.mlzone.csuldw.service.IWebSourceService;

/**
 * 
 * @author 刘帝伟
 *
 */
@Service
public class WebSourceServiceImpl implements IWebSourceService {

	private Logger log = Logger.getLogger(WebSourceServiceImpl.class);
	
	@Autowired
	IWebSourceMapper webSourceMapper;
	
	@Override
	public int saveOrUpdate(WebSourceEntity webSourceEntity)
	{
		if(webSourceEntity.getId() == null){
			return webSourceMapper.save(webSourceEntity);
		}else{
			return webSourceMapper.update(webSourceEntity);
		}
	}

	@Override
	public int deleteById(Integer id)
	{
		return webSourceMapper.deleteById(id);
	}

	@Override
	public PageInfo<WebSourceEntity> getListByParams(String sourceType, String keywords, int pageNum, int pageSize)
	{
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> params = new HashMap<>();
		params.put("sourceType", sourceType);
		params.put("keywords", keywords);
		PageInfo<WebSourceEntity> sourcePage = new PageInfo<WebSourceEntity>(webSourceMapper.getListByParam(params));
		return sourcePage;
	}

	

}
