package com.cisco.la.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cisco.la.join.CourseJoinMapper;
import com.cisco.la.mapper.CourseModelMapper;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModelExample;
import com.cisco.la.model.CourseModelExample.Criteria;
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
		courseModelExample.setOrderByClause(" crs_active desc");
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

	/* (non-Javadoc)
	 * @see com.cisco.la.service.CourseService#getCourseListByList(java.lang.String)
	 */
	@Override
	public List<CourseModel> getCourseListByList(String strList) {
		String[] list = strList.split(",");
		List<Integer> ids = new ArrayList<Integer>();
		
		for(int i = 0; i < list.length; i++){
			ids.add(Integer.parseInt(list[i])); 
		}
		
		CourseModelMapper courseModelMapper = sqlSession.getMapper(CourseModelMapper.class);
		CourseModelExample example = new CourseModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		return courseModelMapper.selectByExample(example);
		
	}
	
	@Override
	public List<CourseModel> getUserCourseListByList(String userID, String strList) {
		String[] list = strList.split(",");
		List<Integer> ids = new ArrayList<Integer>();
		try{
			for(int i = 0; i < list.length; i++){
				ids.add(Integer.parseInt(list[i])); 
			}
			
			CourseJoinMapper courseJoinMapper = sqlSession.getMapper(CourseJoinMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userID", userID);
			map.put("ids", ids);
			
			List<CourseModel> listCourseModel = courseJoinMapper.getUserCourseListByList(map);
			return listCourseModel;
		}catch(Exception exp){
			exp.printStackTrace();
			return new ArrayList<CourseModel>();
		}
	}

	@Override
	public CourseModel getCourseByName(String courseName) {
		CourseJoinMapper courseJoinMapper = sqlSession.getMapper(CourseJoinMapper.class);
		 List<CourseModel> listCourseModel = courseJoinMapper.getCourseByName(courseName);
		 if(listCourseModel.size()>0)
			 return listCourseModel.get(0);
		 else
			 return null;
	}

}
