package com.cisco.la.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.la.Application;
import com.cisco.la.Application.Env;
import com.cisco.la.common.CustomMessage;
import com.cisco.la.common.SparkService;
import com.cisco.la.entity.UserJoin;
import com.cisco.la.join.UserJoinMapper;
import com.cisco.la.mapper.CourseHistoryModelMapper;
import com.cisco.la.mapper.CourseModelMapper;
import com.cisco.la.mapper.UserModelMapper;
import com.cisco.la.model.CourseHistoryModel;
import com.cisco.la.model.CourseHistoryModelExample;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModelExample;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.RoleHistoryModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.model.UserModelExample;
import com.cisco.la.model.UserModelExample.Criteria;
import com.cisco.la.service.GoldenSampleService;
import com.cisco.la.service.MessageService;
import com.cisco.la.service.RoleHistoryService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SparkService sparkService;
	
	@Autowired
	private GoldenSampleService goldenSampleService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private RoleHistoryService roleHistoryService;
	
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
	
	public List<UserModel> getUserByIDs(String IDs) {
		UserJoinMapper userJoinMapper = sqlSession.getMapper(UserJoinMapper.class);
		return userJoinMapper.getUserByIDs(IDs);
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
	@Transactional(rollbackFor=Exception.class)
	public void addUserWithHistory(UserJoin userJoin) throws Exception {
		UserModel userModel = (UserModel)userJoin;
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		
		if(userModelMapper.selectByPrimaryKey(userJoin.getId())==null){
			userModelMapper.insert(userModel);
		}else{
			userModelMapper.updateByPrimaryKey(userModel);
		}
		
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
				
				CourseHistoryModelExample example = new CourseHistoryModelExample();
				com.cisco.la.model.CourseHistoryModelExample.Criteria criteriaCourseHistory = example.createCriteria();
				criteriaCourseHistory.andCourseIDEqualTo(listCourseModel.get(0).getId());
				criteriaCourseHistory.andUserIDEqualTo(userJoin.getId());
				List<CourseHistoryModel> listCourseHistoryModel = courseHistoryModelMapper.selectByExample(example);
				
				if(listCourseHistoryModel.size() > 0){
					courseHistoryModelMapper.updateByExample(courseHistoryModel, example);
				}else{
					courseHistoryModelMapper.insert(courseHistoryModel);
				}
			}else{
				Application.logger.debug(history + "does not exsit.");
			}
		}
		
	}
	
	public List<UserModel> getUserListByRoleIDs(String roleIDs) {
		UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		UserModelExample example = new UserModelExample();
		Criteria criteria = example.createCriteria();
		
		String[] idArray = roleIDs.split(",");
		
		List<Integer> idList = new ArrayList<Integer>();
		
		for(int i = 0; i< idArray.length; i++){
			if(!idArray[i].trim().isEmpty()){
				idList.add(Integer.parseInt(idArray[i].trim()));
			}
		}
		if(idList.size()>0){
			criteria.andRoleIDIn(idList);
			criteria.andActiveEqualTo(true);
			return userModelMapper.selectByExample(example);
		}else{
			return new ArrayList<UserModel>();
		}
	}
	
	public void sendUpdateMessage(UserModel oldUserModel, UserModel userModel) {
		MessageModel latestMessageModel = messageService.getLatestMessageByUserID();
		int session = 1;
		int level = 1;
		int serial = 1;
		if(latestMessageModel!=null){
			session = latestMessageModel.getSession()+1;
			level = latestMessageModel.getLevel()+1;
			serial = latestMessageModel.getSerial()+1;
		}
		
		Application.logger.debug("begin send");
		if(Application.envCurrent != Env.local){
			if(userModel.getRoleID() == null || userModel.getRoleID()<=0){
				sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_FALLBACK_MESSAGE, userModel.getName()));
				
				Application.logger.debug(String.format(CustomMessage.CHAT_BOLT_QUERY_ROLE_MESSAGE, userModel.getName()));
				sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_QUERY_ROLE_MESSAGE, userModel.getName()));
			}else if(userModel.getRoleID() != oldUserModel.getRoleID()){
				sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_FALLBACK_MESSAGE, userModel.getName()));
				
				RoleModel roleModel = roleService.getRoleByID(userModel.getRoleID());
				Application.logger.debug(String.format(CustomMessage.CHAT_BOLT_CONGRATS_ROLE_MESSAGE, userModel.getName(), roleModel.getRoleName()));
				sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_CONGRATS_ROLE_MESSAGE, userModel.getName(), roleModel.getRoleName()));
				
				String action = "input.changeRole";
				String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(userModel.getId(), roleModel.getId());
		    	if(!prefCourse.isEmpty()){
		    		Application.logger.debug(String.format(CustomMessage.CHAT_BOLT_PREFER_ROLE_MESSAGE, roleModel.getRoleName(), prefCourse));
					//result = sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_PREFER_ROLE_MESSAGE, roleModel.getRoleName(), prefCourse));
		    		MessageModel messageModelPreferRole = new MessageModel();
		    		messageModelPreferRole.setActive(true);
		    		messageModelPreferRole.setContent(String.format(CustomMessage.CHAT_BOLT_PREFER_ROLE_MESSAGE, roleModel.getRoleName(), prefCourse));
		    		messageModelPreferRole.setCreateDate(new Date());
		    		messageModelPreferRole.setLevel(level);
		    		messageModelPreferRole.setSerial(serial);
		    		messageModelPreferRole.setSession(session);
		    		messageModelPreferRole.setUserID(userModel.getId());
		    		messageModelPreferRole.setAction(action);
		    		messageModelPreferRole.setIntent("accept");
		    		messageService.addMessage(messageModelPreferRole);
					
					String recentCourse = goldenSampleService.getRecentCoursePref(userModel.getId(), roleModel.getId());
					if(!recentCourse.isEmpty()){
						Application.logger.debug(recentCourse);
						//result = sparkService.sendMarkdownMessage(userModel.getId(), recentCourse);
						serial += 1;
						MessageModel messageModelPreferCourse = new MessageModel();
						messageModelPreferCourse.setActive(true);
						messageModelPreferCourse.setContent(recentCourse);
						messageModelPreferCourse.setCreateDate(new Date());
						messageModelPreferCourse.setLevel(level);
						messageModelPreferCourse.setSerial(serial);
						messageModelPreferCourse.setSession(session);
						messageModelPreferCourse.setUserID(userModel.getId());
						messageModelPreferCourse.setAction(action);
						messageModelPreferCourse.setIntent("accept");
		        		messageService.addMessage(messageModelPreferCourse);
						
						Application.logger.debug(CustomMessage.CHAT_BOLT_REGISTER_URL);
						//result = sparkService.sendMarkdownMessage(userModel.getId(), CustomMessage.CHAT_BOLT_REGISTER_URL);
						serial += 1;
						level += 1;
						MessageModel messageModelRegistUrl = new MessageModel();
						messageModelRegistUrl.setActive(true);
						messageModelRegistUrl.setContent(CustomMessage.CHAT_BOLT_REGISTER_URL);
						messageModelRegistUrl.setCreateDate(new Date());
						messageModelRegistUrl.setLevel(level);
						messageModelRegistUrl.setSerial(serial);
						messageModelRegistUrl.setSession(session);
						messageModelRegistUrl.setUserID(userModel.getId());
						messageModelRegistUrl.setAction(action);
						messageModelRegistUrl.setIntent("accept");
		        		messageService.addMessage(messageModelRegistUrl);
					}
					
					messageService.disableMessage(userModel.getId(),action,session);
		    	}
		    	RoleHistoryModel roleHistoryModel = new RoleHistoryModel();
				roleHistoryModel.setUserID(userModel.getId());
				roleHistoryModel.setRoleID(userModel.getRoleID());
				roleHistoryModel.setUpdateTime(new Date());
				roleHistoryService.addRoleHistory(roleHistoryModel);
			}
		}
	}
}
