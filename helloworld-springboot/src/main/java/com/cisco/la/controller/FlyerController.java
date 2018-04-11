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

import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuizModel;
import com.cisco.la.model.FlyerModel;
import com.cisco.la.service.QuestionService;
import com.cisco.la.service.FlyerService;

@Controller
@RestController
@RequestMapping(value="/api/flyer")
public class FlyerController {
	@Autowired
	private FlyerService flyerService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getFlyer(HttpServletRequest request, @PathVariable("id") int id){
		FlyerModel flyerModel = flyerService.getFlyerByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", flyerModel);
		return map;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getFlyerList(HttpServletRequest request){
		List<FlyerModel> listFlyerJoin = flyerService.getFlyerList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", listFlyerJoin);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addFlyer(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        FlyerModel flyerModel = new FlyerModel();
	        flyerModel.setContent(jsonObject.getString("content"));
	        flyerModel.setActiveTime(formatter.parse(jsonObject.getString("activeTime")));
	        flyerModel.setAudienceType(jsonObject.getString("audienceType"));
	        flyerModel.setAudienceList(jsonObject.getString("audienceList"));
			flyerModel.setActive(true);
			flyerModel.setUpdateTime(new Date());
			flyerService.addFlyer(flyerModel);
			
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
	public Object updateFlyer(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        FlyerModel flyerModel = new FlyerModel();
	        flyerModel.setId(jsonObject.getInt("id"));
	        flyerModel.setContent(jsonObject.getString("content"));
	        
	        flyerModel.setActiveTime(formatter.parse(jsonObject.getString("activeTime")));
	        
	        flyerModel.setAudienceType(jsonObject.getString("audienceType"));
	        flyerModel.setAudienceList(jsonObject.getString("audienceList"));
			flyerModel.setActive(true);
			flyerModel.setUpdateTime(new Date());
			flyerService.updateFlyer(flyerModel);
			
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
	public Object updateFlyerOnly(HttpServletRequest request, @RequestBody String json){
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        FlyerModel flyerModel = new FlyerModel();
	        flyerModel.setId(jsonObject.getInt("id"));
			flyerModel.setActive(jsonObject.getBoolean("active"));
			flyerService.updateFlyerStatus(flyerModel);
			
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
