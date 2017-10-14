package com.mlzone.csuldw.service;

import java.io.InputStream;
import java.util.List;

import com.mlzone.csuldw.entity.UserEntity;

/**
 * 
 * Date: 2017年10月14日 下午10:51:12 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public interface IUserService {
	
	public String findNicknameById(String id);
    
    public int saveOrUpdateUser(UserEntity userEntity);
    
    public int updateUserById(UserEntity userEntity);
    
    public List<UserEntity> getUserList(int pageNum, int pageSize);

    public InputStream getInputStream(int pageNum, int pageSize) throws Exception;
    
    public UserEntity getUserById(Integer id);

}
