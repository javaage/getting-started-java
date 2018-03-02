package com.cisco.la.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.la.entity.UserJoin;
import com.cisco.la.join.UserJoinMapper;
import com.cisco.la.mapper.CourseHistoryModelMapper;
import com.cisco.la.mapper.CourseModelMapper;
import com.cisco.la.mapper.UserModelMapper;
import com.cisco.la.model.CourseHistoryModel;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModelExample;
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

	@Override
	@Transactional
	public void addUserWithHistory(UserJoin userJoin) throws Exception {
		UserModel userModel = (UserModel)userJoin;
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.insert(userModel);
		
		List<String> listHistory = userJoin.getListHistory();
		for(String history : listHistory){
			CourseModelMapper courseModelMapper = sqlSession.getMapper(CourseModelMapper.class);
			CourseModelExample courseModelExample = new CourseModelExample();
			com.cisco.la.model.CourseModelExample.Criteria criteria = courseModelExample.createCriteria();
			criteria.andCourseNameEqualTo(history);
			List<CourseModel> listCourseModel = courseModelMapper.selectByExample(courseModelExample);
			if(listCourseModel.size()>0){
				CourseHistoryModelMapper courseHistoryModelMapper = sqlSession.getMapper(CourseHistoryModelMapper.class);
				CourseHistoryModel courseHistoryModel = new CourseHistoryModel();
				courseHistoryModel.setUserID(userJoin.getId());
				courseHistoryModel.setCourseID(listCourseModel.get(0).getId());
				courseHistoryModel.setUpdateTime(new Date());
				courseHistoryModelMapper.insert(courseHistoryModel);
			}else{
				throw new Exception(history + "does not exsit.");
			}
		}
		
	}

	@Override
	@Transactional()
	public void updateUserWithHistory(UserJoin userJoin) throws Exception{
		UserModel userModel = (UserModel)userJoin;
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		userModelMapper.updateByPrimaryKey(userModel);
	}
}
