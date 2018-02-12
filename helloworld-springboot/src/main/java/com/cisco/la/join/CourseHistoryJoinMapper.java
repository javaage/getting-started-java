package com.cisco.la.join;

import java.util.List;

import com.cisco.la.entity.CourseHistoryJoin;

public interface CourseHistoryJoinMapper {

	public List<CourseHistoryJoin> getCourseHistoryByUserID(String userID);
}