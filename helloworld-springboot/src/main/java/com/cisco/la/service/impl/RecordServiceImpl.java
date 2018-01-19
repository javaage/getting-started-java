package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.mapper.RecordModelMapper;
import com.cisco.la.model.RecordModel;
import com.cisco.la.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addRecord(RecordModel recordModel) {
		RecordModelMapper recordModelMapper = sqlSession.getMapper(RecordModelMapper.class);
		recordModelMapper.insert(recordModel);
	}

	public void updateRecord(RecordModel recordModel) {
		RecordModelMapper recordModelMapper = sqlSession.getMapper(RecordModelMapper.class);
		recordModelMapper.updateByPrimaryKey(recordModel);
	}

	public RecordModel getRecordByID(int id) {
		RecordModelMapper recordModelMapper = sqlSession.getMapper(RecordModelMapper.class);
	    RecordModel recordModel = recordModelMapper.selectByPrimaryKey(id);
	    return recordModel;
	}
	
	public List<RecordModel> getRecordList(){
		RecordModelMapper recordModelMapper = sqlSession.getMapper(RecordModelMapper.class);
		return recordModelMapper.selectByExample(null);
	}
}
