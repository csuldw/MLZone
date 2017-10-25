package com.mlzone.csuldw.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T>
{    
    public int save(T t);
    
    public int saveOrUpdate(T t);
    
    public int saveSelective(T t);
    
    public int delete(Object params);    

    public int deleteById(@Param("id")Serializable id);

    public int update(T t);
    
    public int updateSelective(T t);
    
    public T getById(@Param("id") Serializable id);
    
    public T getByParam(Object params);
    
    public List<T> getListByParam(Object params);
        
    public List<T> getList(T t);
    
    public List<T> getList();
    
}
