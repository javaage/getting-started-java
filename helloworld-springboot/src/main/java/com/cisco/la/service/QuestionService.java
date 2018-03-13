package com.cisco.la.service;
import java.util.List;

import com.cisco.la.model.QuestionModel;

public interface QuestionService {
  public void addQuestion(QuestionModel questionModel);
  
  public List<QuestionModel> getQuestionList(int quizID);
  
  public void deleteQuestions(int quizID);
}
