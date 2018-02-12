package com.cisco.la.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.entity.CourseHistoryJoin;
import com.cisco.la.join.CourseHistoryJoinMapper;
import com.cisco.la.mapper.CourseHistoryModelMapper;
import com.cisco.la.model.CourseHistoryModel;
import com.cisco.la.model.CourseHistoryModelExample;
import com.cisco.la.model.CourseHistoryModelExample.Criteria;
import com.cisco.la.service.CourseHistoryService;

@Service
public class CourseHistoryServiceImpl implements CourseHistoryService {
	@Autowired
	private SqlSession sqlSession;

	public void addCourseHistory(CourseHistoryModel courseHistoryModel) {
		CourseHistoryModelMapper courseHistoryModelMapper = sqlSession.getMapper(CourseHistoryModelMapper.class);
		courseHistoryModelMapper.insert(courseHistoryModel);
	}

	public List<CourseHistoryJoin> getCourseHistoryByUserID(String userID) {
		CourseHistoryJoinMapper courseHistoryJoinMapper = sqlSession.getMapper(CourseHistoryJoinMapper.class);
		
		return courseHistoryJoinMapper.getCourseHistoryByUserID(userID);
	}

}
