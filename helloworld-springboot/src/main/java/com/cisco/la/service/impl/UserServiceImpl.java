package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.mapper.UserModelMapper;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addUser(UserModel userModel) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.insert(userModel);
	}

	public void inactiveUser(String id) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		UserModel userModel = userModelMapper.selectByPrimaryKey(id);
		userModel.setActive(false);
		userModelMapper.updateByPrimaryKey(userModel);
	}

	public void updateUser(UserModel userModel) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.updateByPrimaryKey(userModel);
	}

	public UserModel getUserByID(String id) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
	    UserModel userModel = userModelMapper.selectByPrimaryKey(id);
	    return userModel;
	}
	
	public List<UserModel> getUserList(){
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		return userModelMapper.selectByExample(null);
	}
}
