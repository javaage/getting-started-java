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

import com.cisco.la.model.RoleModel;
import com.cisco.la.service.RoleService;

@Controller
@RestController
@RequestMapping(value="/api/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getRole(HttpServletRequest request, @PathVariable("id") int id){
		RoleModel roleModel = roleService.getRoleByID(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", roleModel);
		return map;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserList(HttpServletRequest request){
		List<RoleModel> roleModelList = roleService.getRoleList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", "Successfully");
		map.put("data", roleModelList);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addRole(HttpServletRequest request, @RequestBody String json){
		
		try {  
	        JSONObject jsonObject = new JSONObject(json);   
	        RoleModel roleModel = new RoleModel();
	        roleModel.setRoleName(jsonObject.getString("roleName"));
			roleModel.setBu(jsonObject.getString("bu"));
			if(jsonObject.has("title") && !jsonObject.isNull("title"))
				roleModel.setTitle(jsonObject.getString("title"));
			if(jsonObject.has("grade") && !jsonObject.isNull("grade"))
				roleModel.setGrade(jsonObject.getString("grade"));
			roleModel.setActive(true);
			roleService.addRole(roleModel);
			
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
	        RoleModel roleModel = new RoleModel();
	        roleModel.setRoleName(jsonObject.getString("roleName"));
			roleModel.setBu(jsonObject.getString("bu"));
			if(jsonObject.has("title") && !jsonObject.isNull("title"))
				roleModel.setTitle(jsonObject.getString("title"));
			if(jsonObject.has("grade") && !jsonObject.isNull("grade"))
				roleModel.setGrade(jsonObject.getString("grade"));
			roleModel.setActive(jsonObject.getBoolean("active"));
 			roleService.updateRole(roleModel);
			
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
