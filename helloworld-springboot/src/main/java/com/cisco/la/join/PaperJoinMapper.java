package com.cisco.la.join;

import com.cisco.la.model.PaperModel;
import com.cisco.la.model.PaperModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperJoinMapper {

	List<PaperModel> getWaitingPaper();
	
	void inactivePaperByQuizID(int quizID);
	
	PaperModel getActivePaperByUserID(String userID);
}