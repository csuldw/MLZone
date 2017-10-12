package com.mlzone.csuldw.dao;

import java.util.List;

import com.mlzone.csuldw.entity.UserEntity;

public interface IUserMapper {
	
    String findAge(String id);
    
    List<UserEntity> getUser(); 
}
