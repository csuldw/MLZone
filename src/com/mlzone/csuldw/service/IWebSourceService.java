package com.mlzone.csuldw.service;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.entity.WebSourceEntity;

public interface IWebSourceService
{

	int saveOrUpdate(WebSourceEntity webSourceEntity);

	int deleteById(Integer id);

	PageInfo<WebSourceEntity> getListByParams(String sourceType, String keywords, int pageNum, int pageSize);

}
