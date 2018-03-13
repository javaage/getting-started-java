package com.cisco.la.join;

import java.util.List;

import com.cisco.la.entity.QuizJoin;

public interface QuizJoinMapper {
	
	List<QuizJoin> getQuizJoinList();
	
	QuizJoin getQuizJoinByID(int quizID);

}