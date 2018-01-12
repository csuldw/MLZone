package com.mlzone.csuldw.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
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
    
    public PageInfo<UserEntity> getUserListByParam(String keywords, int pageNum, int pageSize);

    public List<UserEntity> getUserList();

    public InputStream getInputStream(int pageNum, int pageSize) throws Exception;
    
    public UserEntity getUserById(Integer id);
    
    boolean checkUserExistByUsername(String username);
    
    boolean checkEmailExistByUsername(String email);
    
    public UserEntity login(String username, String password);

}
