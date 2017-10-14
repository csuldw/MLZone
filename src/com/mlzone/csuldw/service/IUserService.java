package com.mlzone.csuldw.service;

import java.io.InputStream;
import java.util.List;

import com.mlzone.csuldw.entity.UserEntity;

public interface IUserService {
	
	public String findNicknameById(String id);
    
    public int saveOrUpdateUser(UserEntity userEntity);
    
    public int updateUserById(UserEntity userEntity);
    
    public List<UserEntity> getUserList(int pageNum, int pageSize);

    public InputStream getInputStream(int pageNum, int pageSize) throws Exception;
    
}
