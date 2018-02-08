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

import com.cisco.la.Application;
import com.cisco.la.common.CustomMessage;
import com.cisco.la.common.SparkService;
import com.cisco.la.entity.GoldenSampleJoin;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.GoldenSampleService;
import com.cisco.la.service.MessageService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;

@Controller
@RestController
@RequestMapping(value="/api/goldenSample")
public class GoldenSampleController {
	@Autowired
	private GoldenSampleService goldenSampleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SparkService sparkService;
	
	@Autowired
	private MessageService messageService;
	
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
			GoldenSampleModel oldGoldenSampleModel = goldenSampleService.getGoldenSampleByID(goldenSampleModel.getId());
 			goldenSampleService.updateGoldenSample(goldenSampleModel);
			
 			List<UserModel> listUserModel = userService.getUserListByRoleID(goldenSampleModel.getRoleID());
 			RoleModel  roleModel  = roleService.getRoleByID(goldenSampleModel.getRoleID());
 			
 			String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(goldenSampleModel.getRoleID());
 			int session = 1;
			int level = 1;
			int serial = 1;
			MessageModel latestMessageModel = messageService.getLatestMessageByUserID();
			if(latestMessageModel!=null){
				session = latestMessageModel.getSession()+1;
				level = latestMessageModel.getLevel()+1;
				serial = latestMessageModel.getSerial()+1;
			}
			String action = "input.changePreferCourse";
 			if(!oldGoldenSampleModel.getMandatory().contains(goldenSampleModel.getMandatory())
 					|| !oldGoldenSampleModel.getOptional().contains(goldenSampleModel.getOptional())){
 				for(UserModel userModel : listUserModel){
 	 				//sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_CHANGE_SAMPLE_HELLO, userModel.getName()));
 	 				//sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_CHANGE_SAMPLE_CHANGE, roleModel.getRoleName(),roleModel.getBu()));
 					MessageModel messageModelSayHello = new MessageModel();
            		messageModelSayHello.setActive(true);
            		messageModelSayHello.setContent(String.format(CustomMessage.CHAT_BOLT_CHANGE_SAMPLE_HELLO, userModel.getName()));
            		messageModelSayHello.setCreateDate(new Date());
            		messageModelSayHello.setLevel(level);
            		messageModelSayHello.setSerial(serial);
            		messageModelSayHello.setSession(session);
            		messageModelSayHello.setUserID(userModel.getId());
            		messageModelSayHello.setAction(action);
            		messageModelSayHello.setIntent("");
            		messageService.addMessage(messageModelSayHello);
            		
 					serial+=1;
            		MessageModel messageModelSampleChange = new MessageModel();
            		messageModelSampleChange.setActive(true);
            		messageModelSampleChange.setContent(String.format(CustomMessage.CHAT_BOLT_CHANGE_SAMPLE_CHANGE, roleModel.getRoleName(),roleModel.getBu()));
            		messageModelSampleChange.setCreateDate(new Date());
            		messageModelSampleChange.setLevel(level);
            		messageModelSampleChange.setSerial(serial);
            		messageModelSampleChange.setSession(session);
            		messageModelSampleChange.setUserID(userModel.getId());
            		messageModelSampleChange.setAction(action);
            		messageModelSampleChange.setIntent("");
            		messageService.addMessage(messageModelSampleChange);
            		
 					if(!prefCourse.isEmpty()){
 	 	        		//sparkService.sendMarkdownMessage(userModel.getId(), prefCourse);
 						serial+=1;
 	            		MessageModel messageModelPreferCourse = new MessageModel();
 	            		messageModelPreferCourse.setActive(true);
 	            		messageModelPreferCourse.setContent(prefCourse);
 	            		messageModelPreferCourse.setCreateDate(new Date());
 	            		messageModelPreferCourse.setLevel(level);
 	            		messageModelPreferCourse.setSerial(serial);
 	            		messageModelPreferCourse.setSession(session);
 	            		messageModelPreferCourse.setUserID(userModel.getId());
 	            		messageModelPreferCourse.setAction(action);
 	            		messageModelPreferCourse.setIntent("");
 	            		messageService.addMessage(messageModelPreferCourse);
 	 				}
 					messageService.disableMessage(userModel.getId(), action, session);
 	 			}
 			}
 			
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
