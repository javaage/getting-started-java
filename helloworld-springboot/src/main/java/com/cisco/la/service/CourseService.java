package com.cisco.la.service;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.cisco.la.model.CourseModel;

public interface CourseService {
  public void addCourse(CourseModel courseModel);

  public void updateCourse(CourseModel courseModel);

  public List<CourseModel> getCourseList();
  
  public CourseModel getCourseByID(int id);
  
  public CourseModel getCourseByName(String courseName);
  
  public List<CourseModel> getUserCourseListByList(String userID, String strList);
  
  public List<CourseModel> getCourseListByList(String strList);
  
  public List<CourseModel> getCourseListRecent(Date startDate, Date endDate);
  
  public void deleteCourse(int id);
}
