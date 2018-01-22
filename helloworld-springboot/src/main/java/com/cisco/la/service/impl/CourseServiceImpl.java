package com.cisco.la.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.cisco.la.mapper.CourseModelMapper;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModelExample;
import com.cisco.la.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addCourse(CourseModel courseModel) {
		CourseModelMapper courseModelMapper = sqlSession.getMapper(CourseModelMapper.class);
		courseModelMapper.insert(courseModel);
	}

	public void updateCourse(CourseModel courseModel) {
		CourseModelMapper courseModelMapper = sqlSession.getMapper(CourseModelMapper.class);
		courseModelMapper.updateByPrimaryKey(courseModel);
	}

	@Override
	public List<CourseModel> getCourseList() {
		CourseModelMapper courseModelMapper = sqlSession.getMapper(CourseModelMapper.class);
		CourseModelExample courseModelExample = new CourseModelExample();
		courseModelExample.setOrderByClause("order by rl_active desc");
		return courseModelMapper.selectByExample(null);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.CourseService#getCourseByName(java.lang.String)
	 */
	@Override
	public CourseModel getCourseByID(int id) {
		CourseModelMapper courseModelMapper = sqlSession.getMapper(CourseModelMapper.class);
		return courseModelMapper.selectByPrimaryKey(id);
	}

}
