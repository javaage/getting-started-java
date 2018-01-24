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
import java.util.Map;

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
import com.cisco.la.common.HttpService;
import com.cisco.la.model.RecordModel;
import com.cisco.la.service.RecordService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

@Controller
@RestController
@RequestMapping(value="/api/spark")
public class SparkController {
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private HttpService httpService;
	
	@RequestMapping( value = "check/{email}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object postResponse(@PathVariable("email") String email) {
		try{
			Object code = httpService.checkSparkPeople(email);
			
			RecordModel recordModel = new RecordModel();
			recordModel.setRequest("postResponse" + email);
			Gson gson = new Gson();
			recordModel.setResponse(gson.toJson(code));
			recordModel.setTime(new Date());
			recordService.addRecord(recordModel);
			return code;
		}catch(Exception exp){
			Map<String, Object> code = new HashMap<String, Object>();
			code.put("code", -2);
			code.put("message", exp.getMessage());
			return code;
		}
		
	}
	
	@RequestMapping( value = "sendMessage",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object postResponse() {
		try{
			JSONObject code = httpService.sendMessage("subing.xiao@pactera.com", "Hello");
			
			RecordModel recordModel = new RecordModel();
			recordModel.setRequest("sendMessage" + "subing.xiao@pactera.com");
			Gson gson = new Gson();
			recordModel.setResponse(gson.toJson(code));
			recordModel.setTime(new Date());
			recordService.addRecord(recordModel);
			return code;
		}catch(Exception exp){
			Map<String, Object> code = new HashMap<String, Object>();
			code.put("code", -2);
			code.put("message", exp.getMessage());
			return code;
		}
		
	}
	
	@RequestMapping(value = "ai/{input}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object aiResponse(@PathVariable("input") String input) {
		
		Map<String, Object> code = new HashMap<String, Object>();
		code.put("input", input);
		
		RecordModel recordModel = new RecordModel();
		recordModel.setRequest("ai" + input);
		Gson gson = new Gson();
		recordModel.setResponse(gson.toJson(code));
		recordModel.setTime(new Date());
		recordService.addRecord(recordModel);
		
		return code;
	}
}
