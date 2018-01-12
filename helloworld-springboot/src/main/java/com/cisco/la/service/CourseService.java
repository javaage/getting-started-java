package com.cisco.la.service;
import java.util.List;
import java.util.ArrayList;
import com.cisco.la.model.CourseModel;

public interface CourseService {
  public void addCourse(CourseModel courseModel);

  public void inactiveCourse(int id);

  public void updateCourse(CourseModel courseModel);

  public List<CourseModel> getCourseList();
}
