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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.cisco.la.model.CourseModel;
import com.cisco.la.service.CourseService;

@Controller
@RestController
@RequestMapping(value="/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getCourse(HttpServletRequest request, @PathVariable("id") int id){
		CourseModel courseModel = courseService.getCourseByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", courseModel);
		return map;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserList(HttpServletRequest request){
		List<CourseModel> courseModelList = courseService.getCourseList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", courseModelList);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addCourse(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        CourseModel courseModel = new CourseModel();
	        courseModel.setCourseName(jsonObject.getString("courseName"));
	        courseModel.setPrice(jsonObject.getDouble("price"));
	        if(jsonObject.optString("startDate",null)!=null)
	        	courseModel.setStartDate(formatter.parse(jsonObject.getString("startDate")));
	        if(jsonObject.optString("endDate",null)!=null)
	        	courseModel.setEndDate(formatter.parse(jsonObject.getString("endDate")));
	        if(jsonObject.optString("url",null)!=null){
	        	courseModel.setUrl(jsonObject.getString("url"));
	        }
			courseModel.setActive(true);
			courseService.addCourse(courseModel);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map; 
	          
	    } catch (JSONException | ParseException e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
	}
	
	@RequestMapping( method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateUser(HttpServletRequest request, @RequestBody String json){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
			JSONObject jsonObject = new JSONObject(json);   
	        CourseModel courseModel = new CourseModel();
	        courseModel.setCourseName(jsonObject.getString("courseName"));
	        courseModel.setPrice(jsonObject.getDouble("price"));
	        if(jsonObject.optString("startDate",null)!=null)
	        	courseModel.setStartDate(formatter.parse(jsonObject.getString("startDate")));
	        if(jsonObject.optString("endDate",null)!=null)
	        	courseModel.setEndDate(formatter.parse(jsonObject.getString("endDate")));
	        if(jsonObject.optString("url",null)!=null){
	        	courseModel.setUrl(jsonObject.getString("url"));
	        }
			courseModel.setActive(jsonObject.getBoolean("active"));
 			courseService.updateCourse(courseModel);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map;
		}catch (JSONException | ParseException e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
		
	}	
}
