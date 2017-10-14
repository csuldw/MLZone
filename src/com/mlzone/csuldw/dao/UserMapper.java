package com.mlzone.csuldw.dao;

import java.util.List;

import com.mlzone.csuldw.entity.UserEntity;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存或更新用户
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param userEntity
     * @return
     * @since
     */
    int saveOrUpdateUser(UserEntity userEntity);

    int insertSelective(UserEntity userEntity);

    int updateByPrimaryKeySelective(UserEntity userEntity);

    /**
     * 根据主键更新user
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param record
     * @return
     * @since
     */
    int updateUserById(UserEntity userEntity);
    
    String findNicknameById(String id);
    
    /**
     * 获取用户列表
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @return
     * @since
     */
    List<UserEntity> getUserList(); 

    /**
     * 根据用户ID获取用户信息
     *
     * Author:liudiwei
     * Date:2017年10月14日
     * @param id
     * @return
     * @since
     */
    UserEntity getUserById(Integer id);
    
}