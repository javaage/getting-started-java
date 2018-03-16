package com.cisco.la.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.entity.QuizJoin;
import com.cisco.la.join.QuizJoinMapper;
import com.cisco.la.mapper.QuizModelMapper;
import com.cisco.la.model.QuizModel;
import com.cisco.la.model.QuizModelExample;
import com.cisco.la.model.QuizModelExample.Criteria;
import com.cisco.la.service.QuestionService;
import com.cisco.la.service.QuizService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public void addQuiz(QuizModel quizModel) {
		QuizModelMapper quizModelMapper = sqlSession.getMapper(QuizModelMapper.class);
		quizModelMapper.insert(quizModel);
	}

	public void updateQuiz(QuizModel quizModel) {
		QuizModelMapper quizModelMapper = sqlSession.getMapper(QuizModelMapper.class);
		quizModelMapper.updateByPrimaryKey(quizModel);
	}

	@Override
	public List<QuizJoin> getQuizList() {
		QuizJoinMapper quizJoinMapper = sqlSession.getMapper(QuizJoinMapper.class);
		
		return quizJoinMapper.getQuizJoinList();
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.QuizService#getQuizByName(java.lang.String)
	 */
	@Override
	public QuizJoin getQuizByID(int quizID) {
		QuizJoinMapper quizJoinMapper = sqlSession.getMapper(QuizJoinMapper.class);
		
		QuizJoin quizJoin = quizJoinMapper.getQuizJoinByID(quizID);
		
		quizJoin.setListQuestionModel(questionService.getQuestionList(quizID));
		
		if("U".equalsIgnoreCase(quizJoin.getAudienceType()))
			quizJoin.setListUserModel(userService.getUserByIDs(quizJoin.getAudienceList()));
		else
			quizJoin.setListRoleModel(roleService.getRoleByIDs(quizJoin.getAudienceList()));
		return quizJoin;
	}

	@Override
	public List<QuizModel> getQuizByCourseID(int courseID) {
		QuizModelMapper quizModelMapper = sqlSession.getMapper(QuizModelMapper.class);
		QuizModelExample quizModelExample = new QuizModelExample();
		Criteria criteria = quizModelExample.createCriteria();
		criteria.andCourseIDEqualTo(courseID);
		criteria.andActiveEqualTo(true);
		quizModelExample.setOrderByClause("QUZ_ID desc");
		return quizModelMapper.selectByExample(quizModelExample);
	}

	@Override
	public List<QuizModel> getWaitingQuizList() {
		QuizModelMapper quizModelMapper = sqlSession.getMapper(QuizModelMapper.class);
		QuizModelExample quizModelExample = new QuizModelExample();
		Criteria criteria = quizModelExample.createCriteria();
		criteria.andActiveEqualTo(true);
		
		TimeZone tz = TimeZone.getDefault();
		int offset = tz.getRawOffset()/3600000;
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.HOUR_OF_DAY, 8-offset);
		
		criteria.andUpdateTimeLessThan(new Date());
		criteria.andActiveTimeLessThan(cal.getTime());
		
		return quizModelMapper.selectByExample(quizModelExample);
	}
}
