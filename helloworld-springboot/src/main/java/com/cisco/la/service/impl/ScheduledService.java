/**
 * 
 */
package com.cisco.la.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cisco.la.Application;
import com.cisco.la.Application.Env;
import com.cisco.la.common.CustomMessage;
import com.cisco.la.common.SparkService;
import com.cisco.la.common.Util;
import com.cisco.la.entity.QuizJoin;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.FlyerModel;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.PaperModel;
import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuizModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.CourseService;
import com.cisco.la.service.FlyerService;
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
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private FlyerService flyerService;
	
	@Scheduled(fixedRate = 1000*30)
	public void fixedRate(){
		System.out.println(new Date());
		sendLostSessionMessage();
		generatePaper();
		startQuiz();
		sendFlyer();
		if(Application.envCurrent.equals(Env.local))
			test();
	}

	private void sendLostSessionMessage() {
		List<MessageModel> listMessageModel = messageService.getLostSessionMessage();
		
		for(MessageModel messageModel : listMessageModel){
			sparkService.sendMarkdownMessage(messageModel.getUserID(), messageModel.getContent());
			messageModel.setActive(false);
			messageService.updateMessage(messageModel);
		}
	}
	
	private void generatePaper(){
		List<QuizModel> listQuizModel = quizService.getWaitingQuizList();
		
		for(QuizModel quizModel : listQuizModel){
			QuizJoin quizJoin = quizService.getQuizByID(quizModel.getId());
			
			paperService.inactivePaperByQuizID(quizJoin.getId());
			
			List<QuestionModel> listQuestionModel = quizJoin.getListQuestionModel();
			
			List<String> subjects = new ArrayList<String>();
			List<String> standards = new ArrayList<String>();
			
			for(int i = 0; i < listQuestionModel.size(); i++){
				QuestionModel questionModel = listQuestionModel.get(i);
				String subject = String.format("Q%d: %s  <br> ", i+1, questionModel.getSubject());
				
				String choices = questionModel.getChoices();
				String[] cs = choices.split("@@@");
				for(int j = 0; j < cs.length; j++){
					subject += String.format("%d) %s  <br> ", j+1, cs[j]);
				}
				
				subjects.add(subject);
				standards.add(questionModel.getAnswer());
			}
			
			
			PaperModel paperModel = new PaperModel();
			paperModel.setAwswer("");
			paperModel.setContent(String.join("&&&", subjects));
			paperModel.setStandard(String.join("&&&", standards));
			paperModel.setIndex(0);
			paperModel.setQuizID(quizModel.getId());
			paperModel.setTotal(listQuestionModel.size());
			paperModel.setUpdateTime(new Date());
			paperModel.setSession(new Date(1));
			paperModel.setActive(true);
			
			if("U".equalsIgnoreCase(quizJoin.getAudienceType())){
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
			
			quizModel.setUpdateTime(new Date(9999,1,1));
			quizService.updateQuiz(quizModel);
		}
	}
	
	public void startQuiz(){
		
		List<PaperModel> listPaperModel = paperService.getWaitingPaper();
		for(PaperModel paperModel : listPaperModel){
			QuizModel quizModel = quizService.getQuizByID(paperModel.getQuizID());
			
			CourseModel courseModel = courseService.getCourseByID(quizModel.getCourseID());
			
			long delta = courseModel.getStartDate().getTime() - new Date().getTime();
			
			String message = String.format(CustomMessage.CHAT_BOLT_START_QUIZ_PAPER, courseModel.getCourseName(), Util.getDaysSentence(delta));
			
			sparkService.sendMarkdownMessage(paperModel.getUserID(), message);
			
			paperModel.setSession(new Date());
			paperService.updatePaper(paperModel);
		}
	}
	
	public void sendFlyer(){
		List<FlyerModel> listFlyerModel = flyerService.getWaitingFlyerList();
		
		for(FlyerModel flyerModel : listFlyerModel){
			List<UserModel> listUserModel = new ArrayList<UserModel>();
			if("U".equalsIgnoreCase(flyerModel.getAudienceType()))
				listUserModel = userService.getUserByIDs(flyerModel.getAudienceList());
			else{
				listUserModel = userService.getUserListByRoleIDs(flyerModel.getAudienceList());
			}
				
			for(UserModel userModel : listUserModel){
				sparkService.sendMarkdownMessage(userModel.getId(), flyerModel.getContent());
			}
			flyerModel.setActive(false);
			flyerService.updateFlyer(flyerModel);
		}
		
	}
	
	public void test(){
		String personEmail = "";
		String speech = "Hi, below is this week's new trainings:";
		Calendar cal = Calendar.getInstance();
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayofweek);
		Date startDate = cal.getTime();
		cal.add(Calendar.DATE, 7);
		Date endDate = cal.getTime();
		
		List<CourseModel> listCourseModel = courseService.getCourseListRecent(startDate, endDate);
		
		if(listCourseModel.size()>0){
			StringBuilder stringBuilder = new StringBuilder(speech + " ");
			for(CourseModel courseModel : listCourseModel){
				if(courseModel.getUrl()!=null && !courseModel.getUrl().isEmpty())
					stringBuilder.append(String.format("<br>[%s](%s)",courseModel.getCourseName(), courseModel.getUrl()));
				else
					stringBuilder.append("<br>" + courseModel.getCourseName());
			}
			sparkService.sendMarkdownMessage(personEmail, stringBuilder.toString());
		}else{
			speech = CustomMessage.CHAT_BOLT_NO_WEEKLY_COURSE;
			
		}
	}
}
