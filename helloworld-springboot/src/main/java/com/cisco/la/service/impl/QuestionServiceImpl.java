package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.mapper.QuestionModelMapper;
import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuestionModelExample;
import com.cisco.la.model.QuestionModelExample.Criteria;
import com.cisco.la.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addQuestion(QuestionModel questionModel) {
		QuestionModelMapper questionModelMapper = sqlSession.getMapper(QuestionModelMapper.class);
		questionModelMapper.insert(questionModel);
	}

	@Override
	public List<QuestionModel> getQuestionList(int quizID) {
		QuestionModelMapper questionModelMapper = sqlSession.getMapper(QuestionModelMapper.class);
		QuestionModelExample questionModelExample = new QuestionModelExample();
		Criteria criteria = questionModelExample.createCriteria();
		criteria.andQuizIDEqualTo(quizID);
		questionModelExample.setOrderByClause("qust_number");
		return questionModelMapper.selectByExample(questionModelExample);
	}

	@Override
	public void deleteQuestions(int quizID) {
		QuestionModelMapper questionModelMapper = sqlSession.getMapper(QuestionModelMapper.class);
		QuestionModelExample questionModelExample = new QuestionModelExample();
		Criteria criteria = questionModelExample.createCriteria();
		criteria.andQuizIDEqualTo(quizID);
		questionModelMapper.deleteByExample(questionModelExample);
		
	}
}
