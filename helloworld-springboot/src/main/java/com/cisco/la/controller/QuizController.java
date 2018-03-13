/**
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cisco.la.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.la.entity.QuizJoin;
import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuizModel;
import com.cisco.la.service.QuestionService;
import com.cisco.la.service.QuizService;

@Controller
@RestController
@RequestMapping(value="/api/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getQuiz(HttpServletRequest request, @PathVariable("id") int id){
		QuizModel quizModel = quizService.getQuizByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", quizModel);
		return map;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getQuizList(HttpServletRequest request){
		List<QuizJoin> listQuizJoin = quizService.getQuizList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", listQuizJoin);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addQuiz(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        QuizModel quizModel = new QuizModel();
	        quizModel.setCourseID(jsonObject.getInt("courseID"));
	        quizModel.setActiveTime(formatter.parse(jsonObject.getString("activeTime")));
	        quizModel.setAudienceType(jsonObject.getString("audienceType"));
	        quizModel.setAudienceList(jsonObject.getString("audienceList"));
			quizModel.setActive(true);
			quizModel.setUpdateTime(new Date());
			quizService.addQuiz(quizModel);
			
			List<QuizModel> listQuizModel = quizService.getQuizByCourseID(quizModel.getCourseID());
			if(listQuizModel.size() > 0){
				int quizID = listQuizModel.get(0).getId();
				JSONArray questions = jsonObject.getJSONArray("questions");
				for(int i = 0; i < questions.length(); i++){
					JSONObject question = questions.getJSONObject(i);
					QuestionModel questionModel = new QuestionModel();
					
					questionModel.setNumber(i);
					questionModel.setSubject(question.getString("subject"));
					questionModel.setChoices(question.getString("choices"));
					questionModel.setAnswer(question.getString("answer"));
					questionModel.setQuizID(quizID);
					
					questionService.addQuestion(questionModel);
				}
				
			}
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map; 
	          
	    } catch (Exception e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
	}
	
	@RequestMapping( method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateQuiz(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        QuizModel quizModel = new QuizModel();
	        quizModel.setId(jsonObject.getInt("id"));
	        quizModel.setCourseID(jsonObject.getInt("courseID"));
	        quizModel.setActiveTime(formatter.parse(jsonObject.getString("activeTime")));
	        quizModel.setAudienceType(jsonObject.getString("audienceType"));
	        quizModel.setAudienceList(jsonObject.getString("audienceList"));
			quizModel.setActive(true);
			quizModel.setUpdateTime(new Date());
			quizService.updateQuiz(quizModel);
			
			JSONArray questions = jsonObject.getJSONArray("questions");
			questionService.deleteQuestions(quizModel.getId());
			
			for(int i = 0; i < questions.length(); i++){
				JSONObject question = questions.getJSONObject(i);
				QuestionModel questionModel = new QuestionModel();
				questionModel.setNumber(i);
				questionModel.setSubject(question.getString("subject"));
				questionModel.setChoices(question.getString("choices"));
				questionModel.setAnswer(question.getString("answer"));
				questionModel.setQuizID(quizModel.getId());
				questionService.addQuestion(questionModel);
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map; 
		}catch (Exception e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
		
	}
	
	@RequestMapping( value = "only", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateQuizOnly(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        QuizModel quizModel = new QuizModel();
	        quizModel.setId(jsonObject.getInt("id"));
	        quizModel.setCourseID(jsonObject.getInt("courseID"));
	        quizModel.setActiveTime(new Date(jsonObject.getLong("activeTime")));
	        quizModel.setAudienceType(jsonObject.getString("audienceType"));
	        quizModel.setAudienceList(jsonObject.getString("audienceList"));
			quizModel.setActive(jsonObject.getBoolean("active"));
			quizModel.setUpdateTime(new Date());
			quizService.updateQuiz(quizModel);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map; 
		}catch (Exception e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
		
	}
}
