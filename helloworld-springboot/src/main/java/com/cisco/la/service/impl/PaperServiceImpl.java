package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.join.PaperJoinMapper;
import com.cisco.la.mapper.PaperModelMapper;
import com.cisco.la.mapper.RoleModelMapper;
import com.cisco.la.model.PaperModel;
import com.cisco.la.model.PaperModelExample;
import com.cisco.la.model.PaperModelExample.Criteria;
import com.cisco.la.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addPaper(PaperModel paperModel) {
		PaperModelMapper paperModelMapper = sqlSession.getMapper(PaperModelMapper.class);
		paperModelMapper.insert(paperModel);
	}

	@Override
	public void updatePaper(PaperModel paperModel) {
		PaperModelMapper paperModelMapper = sqlSession.getMapper(PaperModelMapper.class);
		paperModelMapper.updateByPrimaryKey(paperModel);
	}

	@Override
	public PaperModel getPaperByID(int id) {
		PaperModelMapper paperModelMapper = sqlSession.getMapper(PaperModelMapper.class);
		return paperModelMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PaperModel> getPaperList() {
		PaperModelMapper paperModelMapper = sqlSession.getMapper(PaperModelMapper.class);
		return paperModelMapper.selectByExample(null);
	}

	@Override
	public List<PaperModel> getWaitingPaper() {
		PaperJoinMapper paperJoinMapper = sqlSession.getMapper(PaperJoinMapper.class);
		return paperJoinMapper.getWaitingPaper();
	}

	@Override
	public void inactivePaperByQuizID(int quizID) {
		PaperJoinMapper paperJoinMapper = sqlSession.getMapper(PaperJoinMapper.class);
		paperJoinMapper.inactivePaperByQuizID(quizID);
	}
	
	public PaperModel getActivePaperByUserID(String userID){
		PaperJoinMapper paperJoinMapper = sqlSession.getMapper(PaperJoinMapper.class);
		return paperJoinMapper.getActivePaperByUserID(userID);
	}

	public PaperModel getLatestPaperByUserID(String userID){
		PaperJoinMapper paperJoinMapper = sqlSession.getMapper(PaperJoinMapper.class);
		return paperJoinMapper.getLatestPaperByUserID(userID);
	}
}
