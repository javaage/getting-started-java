package com.cisco.la.service;
import java.util.List;

import com.cisco.la.entity.QuizJoin;
import com.cisco.la.model.QuizModel;

public interface QuizService {
  public void addQuiz(QuizModel quizModel);

  public void updateQuiz(QuizModel quizModel);

  public QuizJoin getQuizByID(int id);
  
  public List<QuizModel> getQuizByCourseID(int courseID);
  
  public List<QuizJoin> getQuizList();
  
  public List<QuizModel> getWaitingQuizList();
  
  public void updateQuizStatus(QuizModel quizModel);
}
