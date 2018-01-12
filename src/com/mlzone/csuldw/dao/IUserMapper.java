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
     * 检查邮箱是否已经被注册
     * 
     * @author liudiwei
     * @since 2018年1月12日 
     * @param email
     * @return
     */
    int checkEmailExistByUsername(String email);
    
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
