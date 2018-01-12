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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.la.model.UserModel;
import com.cisco.la.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RestController
@RequestMapping(value="/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "{id:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUser(HttpServletRequest request, @PathVariable("id") String id){
		UserModel userModel = userService.getUserByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", userModel);
		return map;
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
	
	@RequestMapping(value = "{id:.+}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object deleteUser(HttpServletRequest request, @PathVariable("id") String id){
		userService.inactiveUser(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addUser(HttpServletRequest request, @RequestBody String json){
		JSONObject jsonObject = JSONObject.fromObject(json);
		UserModel userModel = new UserModel();
		userModel.setActive(true);
		userModel.setBalance(jsonObject.getDouble("balance"));
		userModel.setBu(jsonObject.getString("bu"));
		userModel.setBudget(jsonObject.getDouble("budget"));
		userModel.setGrade(jsonObject.getString("grade"));
		userModel.setId(jsonObject.getString("id"));
		userModel.setName(jsonObject.getString("name"));
		userModel.setRoleName(jsonObject.getString("roleName"));
		userModel.setTitle(jsonObject.getString("title"));
		userService.addUser(userModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		return map;
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateUser(HttpServletRequest request, @RequestBody String json){
		JSONObject jsonObject = JSONObject.fromObject(json);
		UserModel userModel = new UserModel();
		userModel.setBalance(jsonObject.getDouble("balance"));
		userModel.setBu(jsonObject.getString("bu"));
		userModel.setBudget(jsonObject.getDouble("budget"));
		userModel.setGrade(jsonObject.getString("grade"));
		userModel.setId(jsonObject.getString("id"));
		userModel.setName(jsonObject.getString("name"));
		userModel.setRoleName(jsonObject.getString("roleName"));
		userModel.setTitle(jsonObject.getString("title"));
		userService.updateUser(userModel); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		return map;
	}
}
