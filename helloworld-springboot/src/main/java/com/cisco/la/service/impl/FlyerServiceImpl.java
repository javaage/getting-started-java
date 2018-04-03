package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.entity.FlyerJoin;
import com.cisco.la.entity.QuizJoin;
import com.cisco.la.join.QuizJoinMapper;
import com.cisco.la.mapper.FlyerModelMapper;
import com.cisco.la.model.FlyerModel;
import com.cisco.la.service.FlyerService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;

@Service
public class FlyerServiceImpl implements FlyerService {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void addFlyer(FlyerModel flyerModel) {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		flyerModelMapper.insert(flyerModel);
	}

	@Override
	public void updateFlyer(FlyerModel flyerModel) {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		flyerModelMapper.updateByPrimaryKey(flyerModel);
	}

	@Override
	public FlyerJoin getFlyerByID(int id) {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		FlyerModel flyerModel = flyerModelMapper.selectByPrimaryKey(id);
		
		FlyerJoin flyerJoin = new FlyerJoin();
		flyerJoin.setActive(flyerModel.getActive());
		flyerJoin.setActiveTime(flyerModel.getActiveTime());
		flyerJoin.setAudienceList(flyerModel.getAudienceList());
		flyerJoin.setAudienceType(flyerModel.getAudienceType());
		flyerJoin.setContent(flyerModel.getContent());
		flyerJoin.setId(flyerModel.getId());
		flyerJoin.setUpdateTime(flyerModel.getUpdateTime());
		
		if("U".equalsIgnoreCase(flyerModel.getAudienceType()))
			flyerJoin.setListUserModel(userService.getUserByIDs(flyerModel.getAudienceList()));
		else
			flyerJoin.setListRoleModel(roleService.getRoleByIDs(flyerModel.getAudienceList()));
		return flyerJoin;
	}

	@Override
	public List<FlyerModel> getFlyerList() {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		return flyerModelMapper.selectByExample(null);
	}

	@Override
	public List<FlyerModel> getWaitingFlyerList() {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		
		return null;
	}

}
