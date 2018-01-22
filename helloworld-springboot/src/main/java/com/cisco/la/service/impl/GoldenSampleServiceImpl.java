package com.cisco.la.service.impl;
import com.cisco.la.mapper.GoldenSampleModelMapper;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.model.GoldenSampleModelExample;
import com.cisco.la.service.GoldenSampleService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoldenSampleServiceImpl implements GoldenSampleService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addGoldenSample(GoldenSampleModel goldenSampleModel) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		goldenSampleModelMapper.insert(goldenSampleModel);
	}

	public void updateGoldenSample(GoldenSampleModel goldenSampleModel) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		goldenSampleModelMapper.updateByPrimaryKey(goldenSampleModel);
	}

	@Override
	public List<GoldenSampleModel> getGoldenSampleList() {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		GoldenSampleModelExample goldenSampleModelExample = new GoldenSampleModelExample();
		goldenSampleModelExample.setOrderByClause("order by rl_active desc");
		return goldenSampleModelMapper.selectByExample(null);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.GoldenSampleService#getGoldenSampleByName(java.lang.String)
	 */
	@Override
	public GoldenSampleModel getGoldenSampleByID(int id) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		return goldenSampleModelMapper.selectByPrimaryKey(id);
	}
}
