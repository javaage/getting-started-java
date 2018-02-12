package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.entity.RoleHistoryJoin;
import com.cisco.la.join.RoleHistoryJoinMapper;
import com.cisco.la.mapper.RoleHistoryModelMapper;
import com.cisco.la.model.RoleHistoryModel;
import com.cisco.la.service.RoleHistoryService;

@Service
public class RoleHistoryServiceImpl implements RoleHistoryService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addRoleHistory(RoleHistoryModel roleHistoryModel) {
		RoleHistoryModelMapper roleHistoryModelMapper = sqlSession.getMapper(RoleHistoryModelMapper.class);
		roleHistoryModelMapper.insert(roleHistoryModel);
	}

	public List<RoleHistoryModel> getRoleHistoryList() {
		RoleHistoryModelMapper roleHistoryModelMapper = sqlSession.getMapper(RoleHistoryModelMapper.class);
		return roleHistoryModelMapper.selectByExample(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cisco.la.service.RoleHistoryService#getRoleHistoryListByUserID(java.
	 * lang.String)
	 */
	@Override
	public List<RoleHistoryJoin> getRoleHistoryListByUserID(String userID) {
		RoleHistoryJoinMapper roleHistoryJoinMapper = sqlSession.getMapper(RoleHistoryJoinMapper.class);
		
		return roleHistoryJoinMapper.getRoleHistoryByUserID(userID);
	}
}
