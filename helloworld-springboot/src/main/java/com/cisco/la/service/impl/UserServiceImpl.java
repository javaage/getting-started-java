package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.join.UserJoinMapper;
import com.cisco.la.mapper.UserModelMapper;
import com.cisco.la.model.UserModel;
import com.cisco.la.model.UserModelExample;
import com.cisco.la.model.UserModelExample.Criteria;
import com.cisco.la.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addUser(UserModel userModel) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.insert(userModel);
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
		UserJoinMapper userJoinMapper = sqlSession.getMapper(UserJoinMapper.class);
		return userJoinMapper.getUserJoin();
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.UserService#getUserListByRoleID(int)
	 */
	@Override
	public List<UserModel> getUserListByRoleID(int roleID) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		UserModelExample example = new UserModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIDEqualTo(roleID);
		criteria.andActiveEqualTo(true);
		return userModelMapper.selectByExample(example);
	}
}
