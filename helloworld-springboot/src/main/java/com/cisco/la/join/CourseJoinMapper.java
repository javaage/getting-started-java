package com.cisco.la.join;

import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModelExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseJoinMapper {

	public List<CourseModel> getUserCourseListByList(Map map);
	
	public List<CourseModel> getCourseByName(String courseName);
}