package com.cisco.la.service;
import java.util.List;
import java.util.ArrayList;
import com.cisco.la.model.CourseHistoryModel;

public interface CourseHistoryService {
  public void addCourseHistory(CourseHistoryModel courseHistoryModel);

  public List<CourseHistoryModel> getCourseHistoryByID(String ID);


}
