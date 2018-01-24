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

import java.util.Date;
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

import com.cisco.la.entity.GoldenSampleJoin;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.service.GoldenSampleService;

@Controller
@RestController
@RequestMapping(value="/api/goldenSample")
public class GoldenSampleController {
	@Autowired
	private GoldenSampleService goldenSampleService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getGoldenSample(HttpServletRequest request, @PathVariable("id") int id){
		GoldenSampleModel goldenSampleModel = goldenSampleService.getGoldenSampleByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", goldenSampleModel);
		return map;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserList(HttpServletRequest request){
		List<GoldenSampleJoin> goldenSampleModelList = goldenSampleService.getGoldenSampleList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", goldenSampleModelList);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addGoldenSample(HttpServletRequest request, @RequestBody String json){
		
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        GoldenSampleModel goldenSampleModel = new GoldenSampleModel();
	        goldenSampleModel.setGoldenSampleName(jsonObject.getString("goldenSampleName"));
	        goldenSampleModel.setRoleID(jsonObject.getInt("roleID"));
	        goldenSampleModel.setMandatory(jsonObject.getString("mandatory"));
	        goldenSampleModel.setOptional(jsonObject.getString("optional"));
	        goldenSampleModel.setUpdateTime(new Date());
			goldenSampleModel.setActive(true);
			goldenSampleService.addGoldenSample(goldenSampleModel);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map; 
	          
	    } catch (JSONException e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
	}
	
	@RequestMapping( method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateUser(HttpServletRequest request, @RequestBody String json){
		try{
			JSONObject jsonObject = new JSONObject(json);   
	        GoldenSampleModel goldenSampleModel = new GoldenSampleModel();
	        goldenSampleModel.setId(jsonObject.getInt("id"));
	        goldenSampleModel.setGoldenSampleName(jsonObject.getString("goldenSampleName"));
	        goldenSampleModel.setRoleID(jsonObject.getInt("roleID"));
	        goldenSampleModel.setMandatory(jsonObject.getString("mandatory"));
	        goldenSampleModel.setOptional(jsonObject.getString("optional"));
	        goldenSampleModel.setUpdateTime(new Date());
			goldenSampleModel.setActive(jsonObject.getBoolean("active"));
 			goldenSampleService.updateGoldenSample(goldenSampleModel);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", "Successfully");
			return map;
		}catch (JSONException e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
		
	}
}
