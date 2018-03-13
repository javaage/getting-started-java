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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.la.model.QuestionModel;
import com.cisco.la.service.QuestionService;

@Controller
@RestController
@RequestMapping(value="/api/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "list/{quizID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getQuestionList(HttpServletRequest request, @PathVariable("quizID") int quizID){
		List<QuestionModel> questionModelList = questionService.getQuestionList(quizID);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", questionModelList);
		return map;
	}
}
