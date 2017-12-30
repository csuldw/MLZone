package com.mlzone.csuldw.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.common.WriteExcel;
import com.mlzone.csuldw.dao.IArticleInfoMapper;
import com.mlzone.csuldw.dao.IUserMapper;
import com.mlzone.csuldw.entity.UserEntity;
import com.mlzone.csuldw.service.IArticleInfoService;
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

	private Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserMapper userMapper;
	
	@Autowired
	IArticleInfoMapper articleInfoMapper;

	@Override
	public String findNicknameById(String id) {
		String age = userMapper.findNicknameById(id);
		return age;
	}

	@Override
	public PageInfo<UserEntity> getUserListByParam(String keywords,
			int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> params = new HashMap<>();
		params.put("keywords", keywords);
		List<UserEntity> users = userMapper.getListByParam(params);
		PageInfo<UserEntity> userPage = new PageInfo<UserEntity>(users);
		return userPage;
	}

	@Override
	public List<UserEntity> getUserList() {
		List<UserEntity> users = userMapper.getListByParam(null);
		return users;
	}

	@Override
	public InputStream getInputStream(int pageNum, int pageSize)
			throws Exception {
		String[] title = new String[] { "id", "username", "age" };
		List<UserEntity> users = getUserList();
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
		if (userEntity.getId() != 0) {
			log.info(userEntity.toString());
			articleInfoMapper.updateAuthor(userEntity.getId(), userEntity.getNickname());
		}
		return userMapper.saveOrUpdate(userEntity);
	}

	@Override
	public int updateUserById(UserEntity userEntity) {
		return userMapper.update(userEntity);
	}

	@Override
	public UserEntity getUserById(Integer id) {
		return userMapper.getById(id);
	}

	@Override
	public boolean checkUserExistByUsername(String username) {
		boolean isExist = false;
		if (userMapper.checkUserExistByUsername(username) > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public UserEntity login(String username, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		UserEntity user = userMapper.login(params);
		return user;
	}
}
