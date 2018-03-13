/**
 * 
 */
package com.cisco.la.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cisco.la.Application;
import com.cisco.la.Application.Env;
import com.cisco.la.common.SparkService;
import com.cisco.la.entity.QuizJoin;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.PaperModel;
import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuizModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.MessageService;
import com.cisco.la.service.PaperService;
import com.cisco.la.service.QuizService;
import com.cisco.la.service.UserService;

/**
 * @author P9030576
 *
 */
@Service
public class ScheduledService {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SparkService sparkService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private UserService userService;
	
	@Scheduled(fixedRate = 1000*60)
	public void fixedRate(){
		System.out.println(new Date());
		sendLostSessionMessage();
		generatePaper();
	}

	private void sendLostSessionMessage() {
		List<MessageModel> listMessageModel = messageService.getLostSessionMessage();
		
		if(Application.envCurrent != Env.local){
			for(MessageModel messageModel : listMessageModel){
				sparkService.sendMarkdownMessage(messageModel.getUserID(), messageModel.getContent());
				messageModel.setActive(false);
				messageService.updateMessage(messageModel);
			}
		}
	}
	
	private void generatePaper(){
		List<QuizModel> listQuizModel = quizService.getWaitingQuizList();
		
		for(QuizModel quizModel : listQuizModel){
			QuizJoin quizJoin = quizService.getQuizByID(quizModel.getId());
			
			List<QuestionModel> listQuestionModel = quizJoin.getListQuestionModel();
			
			List<String> subjects = new ArrayList<String>();
			List<String> standards = new ArrayList<String>();
			
			for(int i = 0; i < listQuestionModel.size(); i++){
				QuestionModel questionModel = listQuestionModel.get(i);
				String subject = String.format("Q1: %s:\r\n", questionModel.getSubject());
				
				String choices = questionModel.getChoices();
				String[] cs = choices.split("|||");
				for(int j = 0; j < cs.length; j++){
					subject += String.format("1) %s\r\n", cs[j]);
				}
				
				subjects.add(subject);
				standards.add(questionModel.getAnswer());
			}
			
			
			PaperModel paperModel = new PaperModel();
			paperModel.setAwswer("[]");
			paperModel.setContent(String.join("&&&", subjects));
			paperModel.setIndex(0);
			paperModel.setQuizID(quizModel.getId());
			paperModel.setTotal(listQuestionModel.size());
			paperModel.setUpdateTime(new Date());
			
			if(quizJoin.getAudienceType()=="U"){
				String[] audiences = quizJoin.getAudienceList().split(",");
				for(String userID : audiences){
					if(!userID.trim().isEmpty()){
						paperModel.setUserID(userID.trim());
						paperService.addPaper(paperModel);
					}
				}
			}else{
				List<UserModel> listUserModel = userService.getUserListByRoleIDs(quizJoin.getAudienceList());
				for(UserModel userModel : listUserModel){
					paperModel.setUserID(userModel.getId());
					paperService.addPaper(paperModel);
				}
			}
			
			quizModel.setUpdateTime(new Date(Long.MAX_VALUE));
			quizService.updateQuiz(quizModel);
		}
	}
}
