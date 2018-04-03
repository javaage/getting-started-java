package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.mapper.FlyerModelMapper;
import com.cisco.la.model.FlyerModel;
import com.cisco.la.service.FlyerService;

@Service
public class FlyerServiceImpl implements FlyerService {
	@Autowired
	private SqlSession sqlSession;
	
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
	public FlyerModel getFlyerByID(int id) {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		return flyerModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FlyerModel> getFlyerList() {
		FlyerModelMapper flyerModelMapper = sqlSession.getMapper(FlyerModelMapper.class);
		return flyerModelMapper.selectByExample(null);
	}

}
