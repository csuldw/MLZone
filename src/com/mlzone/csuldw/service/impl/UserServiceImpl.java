package com.mlzone.csuldw.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.common.WriteExcel;
import com.mlzone.csuldw.dao.IUserMapper;
import com.mlzone.csuldw.entity.UserEntity;
import com.mlzone.csuldw.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	public IUserMapper userMapper;

	@Override
	public String findAge(String id) {
		// TODO Auto-generated method stub
		String age = userMapper.findAge(id);
		return age;
	}

	@Override
	public List<UserEntity> getUser(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<UserEntity> users = userMapper.getUser();
		return users;
	}
	
	@Override
	public InputStream getInputStream(int pageNum, int pageSize) throws Exception {
		String[] title = new String[] { "id", "username", "age"};
		List<UserEntity> users = getUser(pageNum, pageSize);
		List<Object[]> dataList = new ArrayList<Object[]>();
		for (int i = 0; i < users.size(); i++) {
			Object[] obj = new Object[4];
			obj[0] = users.get(i).getId();
			obj[1] = users.get(i).getUsername();
			obj[2] = users.get(i).getAge();
			dataList.add(obj);
		}
		WriteExcel ex = new WriteExcel(title, dataList);
		InputStream in;
		in = ex.export();
		return in;
	}
}
