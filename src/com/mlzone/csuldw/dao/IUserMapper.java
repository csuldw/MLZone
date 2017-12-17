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
    
    /**
     * 登录判断
     *
     * Author:liudiwei
     * Date:2017年12月17日
     * @param username
     * @param password
     * @return
     * @since
     */
    UserEntity login(Object params);
    
}