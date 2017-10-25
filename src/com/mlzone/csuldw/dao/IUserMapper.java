package com.mlzone.csuldw.dao;

import com.mlzone.csuldw.entity.UserEntity;

public interface IUserMapper extends BaseMapper<UserEntity>{
	
    String findNicknameById(String id);
    
    /**
     * 
     *
     * Author:liudiwei
     * Date:2017年10月15日
     * @param username
     * @return
     * @since
     */
    int checkUserExistByUsername(String username);
    
}