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
import java.util.Timer;
import java.util.TimerTask;

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
import com.cisco.la.Application.Env;
import com.cisco.la.common.CustomMessage;
import com.cisco.la.common.SparkService;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.GoldenSampleService;
import com.cisco.la.service.MessageService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;



@Controller
@RestController
@RequestMapping(value="/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SparkService sparkService;
	
	@Autowired
	private GoldenSampleService goldenSampleService;
	
	@Autowired
	private MessageService messageService;
	
	private Timer timer = new Timer();
	
	@RequestMapping(value = "{id:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUser(HttpServletRequest request, @PathVariable("id") String id){
		UserModel userModel = userService.getUserByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", userModel);
		return map;
	}
	
	@RequestMapping(value = "check/{id:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object checkUserID(HttpServletRequest request, @PathVariable("id") String id){
		try{
			boolean result = true;
			String message = "Successfully.";
			if(Application.envCurrent != Env.local){
				result = sparkService.checkSparkPeople(id);
				if(result){
					UserModel userModel = userService.getUserByID(id);
					if(userModel!=null){
						result = false;
						message = "Spark account already exist.";
					}
				}else{
					message = "Invalid Spark account.";
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", message);
			map.put("data", result);
			return map;
		} catch (Exception e) {  
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map; 
	    } 
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserList(HttpServletRequest request){
		List<UserModel> userModelList = userService.getUserList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", userModelList);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addUser(HttpServletRequest request, @RequestBody String json){
		
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        UserModel userModel = new UserModel();
			userModel.setActive(true);
			userModel.setBalance(jsonObject.getDouble("balance"));
			userModel.setBu(jsonObject.getString("bu"));
			userModel.setBudget(jsonObject.getDouble("budget"));
			userModel.setId(jsonObject.getString("id"));
			userModel.setName(jsonObject.getString("name"));
			
			if(jsonObject.optInt("roleID", 0)>0)
				userModel.setRoleID(jsonObject.getInt("roleID"));
			if(jsonObject.has("title") && !jsonObject.isNull("title"))
				userModel.setTitle(jsonObject.getString("title"));
			if(jsonObject.has("grade") && !jsonObject.isNull("grade"))
				userModel.setGrade(jsonObject.getString("grade"));
			userModel.setSession(new Date(1));
			userService.addUser(userModel);
			
			String message = "Successfully";
//			if(Application.envCurrent != Env.local){
//				message = messageService.sendMessage(userModel.getId(), CHAT_BOLT_WELCOME_MESSAGE);
//			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", message);
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
			
			UserModel oldUserModel = userService.getUserByID(jsonObject.getString("id")); 
			
			UserModel userModel = new UserModel();
			userModel.setBalance(jsonObject.getDouble("balance"));
			userModel.setBu(jsonObject.getString("bu"));
			userModel.setBudget(jsonObject.getDouble("budget"));
			userModel.setId(jsonObject.getString("id"));
			userModel.setName(jsonObject.getString("name"));
			if(jsonObject.optInt("roleID", 0)>0)
				userModel.setRoleID(jsonObject.getInt("roleID"));
			if(jsonObject.has("title") && !jsonObject.isNull("title"))
				userModel.setTitle(jsonObject.getString("title"));
			if(jsonObject.has("grade") && !jsonObject.isNull("grade"))
				userModel.setGrade(jsonObject.getString("grade"));
			userModel.setActive(jsonObject.getBoolean("active"));
			
			if(userModel.getRoleID() == null || userModel.getRoleID()<=0){
				userModel.setSession(new Date());
			}else{
				userModel.setSession(new Date(1));
			}
			
			userService.updateUser(userModel); 
			
			MessageModel latestMessageModel = messageService.getLatestMessageByUserID(userModel.getId());
			int session = 1;
			int level = 1;
			int serial = 1;
			if(latestMessageModel!=null){
				session = latestMessageModel.getSession()+1;
				level = latestMessageModel.getLevel()+1;
				serial = latestMessageModel.getSerial()+1;
			}
			
			Application.logger.debug("begin send");
			if(Application.envCurrent != Env.local){
				if(userModel.getRoleID() == null || userModel.getRoleID()<=0){
					Application.logger.debug(String.format(CustomMessage.CHAT_BOLT_QUERY_ROLE_MESSAGE, userModel.getName()));
					String result = sparkService.sendMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_QUERY_ROLE_MESSAGE, userModel.getName()));
					Application.logger.debug(result);
				}else if(userModel.getRoleID() != oldUserModel.getRoleID()){
					RoleModel roleModel = roleService.getRoleByID(userModel.getRoleID());
					Application.logger.debug(String.format(CustomMessage.CHAT_BOLT_CONGRATS_ROLE_MESSAGE, userModel.getName(), roleModel.getRoleName()));
					String result = sparkService.sendMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_CONGRATS_ROLE_MESSAGE, userModel.getName(), roleModel.getRoleName()));
					Application.logger.debug(result);
					
					String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(roleModel.getId());
	            	if(!prefCourse.isEmpty()){
	            		Application.logger.debug(String.format(CustomMessage.CHAT_BOLT_PREFER_ROLE_MESSAGE, roleModel.getRoleName(), prefCourse));
						//result = sparkService.sendMarkdownMessage(userModel.getId(), String.format(CustomMessage.CHAT_BOLT_PREFER_ROLE_MESSAGE, roleModel.getRoleName(), prefCourse));
	            		MessageModel messageModelPreferRole = new MessageModel();
	            		messageModelPreferRole.setActive(true);
	            		messageModelPreferRole.setContent(String.format(CustomMessage.CHAT_BOLT_PREFER_ROLE_MESSAGE, roleModel.getRoleName(), prefCourse));
	            		messageModelPreferRole.setCreateDate(new Date());
	            		messageModelPreferRole.setLevel(level);
	            		messageModelPreferRole.setSerial(serial);
	            		messageModelPreferRole.setSession(session);
	            		messageModelPreferRole.setUserID(userModel.getId());
	            		messageService.addMessage(messageModelPreferRole);
	            		Application.logger.debug(result);
						
						String recentCourse = goldenSampleService.getRecentCoursePref(roleModel.getId());
						if(!recentCourse.isEmpty()){
							Application.logger.debug(recentCourse);
							//result = sparkService.sendMarkdownMessage(userModel.getId(), recentCourse);
							serial += 1;
							MessageModel messageModelPreferCourse = new MessageModel();
		            		messageModelPreferRole.setActive(true);
		            		messageModelPreferRole.setContent(recentCourse);
		            		messageModelPreferRole.setCreateDate(new Date());
		            		messageModelPreferRole.setLevel(level);
		            		messageModelPreferRole.setSerial(serial);
		            		messageModelPreferRole.setSession(session);
		            		messageModelPreferRole.setUserID(userModel.getId());
		            		messageService.addMessage(messageModelPreferRole);
							Application.logger.debug(result);
							
							Application.logger.debug(CustomMessage.CHAT_BOLT_REGISTER_URL);
							//result = sparkService.sendMarkdownMessage(userModel.getId(), CustomMessage.CHAT_BOLT_REGISTER_URL);
							serial += 1;
							level += 1;
							MessageModel messageModelRegistUrl = new MessageModel();
		            		messageModelPreferRole.setActive(true);
		            		messageModelPreferRole.setContent(CustomMessage.CHAT_BOLT_REGISTER_URL);
		            		messageModelPreferRole.setCreateDate(new Date());
		            		messageModelPreferRole.setLevel(level);
		            		messageModelPreferRole.setSerial(serial);
		            		messageModelPreferRole.setSession(session);
		            		messageModelPreferRole.setUserID(userModel.getId());
		            		messageService.addMessage(messageModelPreferRole);
							Application.logger.debug(result);
						}
	            	}
				}
			}
			/**
			 {"toPersonEmail":"subing.xiao@pactera.com","created":"2018-01-29T06:53:35.339Z","personEmail":"LnDBot@sparkbot.io","personId":"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9kYzBiMjJlMy00MGI1LTRhOWEtYTVhNS0xNzQ2YWQ1NTMxMzA","id":"Y2lzY29zcGFyazovL3VzL01FU1NBR0UvMjA2MzdiYjAtMDRjMS0xMWU4LWEzZGItYzdmMzc0NWViYTQw","text":"Hello Spring, what is your role?","roomId":"Y2lzY29zcGFyazovL3VzL1JPT00vOWVmYTZlYjYtOWQyZS0zOGQwLTkwZTMtN2QwYzljZDhhOWYw","roomType":"direct"}
			 */
			
			
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
