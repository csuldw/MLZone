package com.mlzone.csuldw.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.mlzone.csuldw.common.WriteExcel;
import com.mlzone.csuldw.dao.UserMapper;
import com.mlzone.csuldw.entity.UserEntity;
import com.mlzone.csuldw.service.IUserService;

/**
 * 
 * Date: 2017年10月14日 下午10:59:59 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public String findNicknameById(String id) {
		String age = userMapper.findNicknameById(id);
		return age;
	}

	@Override
	public List<UserEntity> getUserList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserEntity> users = userMapper.getUserList();
		return users;
	}
	
	@Override
	public InputStream getInputStream(int pageNum, int pageSize) throws Exception {
		String[] title = new String[] { "id", "username", "age"};
		List<UserEntity> users = getUserList(pageNum, pageSize);
		List<Object[]> dataList = new ArrayList<Object[]>();
		for (int i = 0; i < users.size(); i++) {
			Object[] obj = new Object[4];
			obj[0] = users.get(i).getId();
			obj[1] = users.get(i).getUsername();
			obj[2] = users.get(i).getNickname();
			dataList.add(obj);
		}
		WriteExcel ex = new WriteExcel(title, dataList);
		InputStream in;
		in = ex.export();
		return in;
	}

	@Override
	public int saveOrUpdateUser(UserEntity userEntity) {
		return userMapper.saveOrUpdateUser(userEntity);
	}

	@Override
	public int updateUserById(UserEntity userEntity) {
		return userMapper.updateUserById(userEntity);
	}

	@Override
	public UserEntity getUserById(Integer id) {
		return userMapper.getUserById(id);
	}
}
