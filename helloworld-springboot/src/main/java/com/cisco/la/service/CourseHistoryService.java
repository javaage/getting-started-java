package com.cisco.la.service;
import java.util.List;

import com.cisco.la.entity.CourseHistoryJoin;
import com.cisco.la.model.CourseHistoryModel;

public interface CourseHistoryService {
  public void addCourseHistory(CourseHistoryModel courseHistoryModel);

  public List<CourseHistoryJoin> getCourseHistoryByUserID(String userID);


}
