package com.mlzone.csuldw.service;

import java.io.InputStream;
import java.util.List;

import com.mlzone.csuldw.entity.UserEntity;

public interface IUserService {
    String findAge(String id);
    
    List<UserEntity> getUser(int pageNum, int pageSize);

    public InputStream getInputStream(int pageNum, int pageSize) throws Exception;
}
