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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.la.Application;
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
@RequestMapping(value="/api/hook")
public class HookController {
	@Autowired
	private RecordService recordService;
	
	@RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object postResponse(@RequestBody String json) {
		Map<String, Object> code = new HashMap<String, Object>();
		code.put("speech", "post welcome hook speech!");
		code.put("displayText", "post welcome hook displayText!");
		
		RecordModel recordModel = new RecordModel();
		recordModel.setRequest(json);
		Gson gson = new Gson();
		recordModel.setResponse(gson.toJson(code));
		recordModel.setTime(new Date());
		recordService.addRecord(recordModel);
		return code;
	}
	
	@RequestMapping(value = "ai/{input}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object aiResponse(@PathVariable("input") String input) {
		String speech = "";
		Application.logger.debug("1");
		Application.logger.debug(input);
		AIConfiguration configuration = new AIConfiguration("2bb9f258770a40dab97e8a021a1ec2fb");

		AIDataService dataService = new AIDataService(configuration);

		try {
			Application.logger.debug("2");
			AIRequest request = new AIRequest(input);

			AIResponse response = dataService.request(request);

			if (response.getStatus().getCode() == 200) {
				Application.logger.debug("3");
				speech = response.getResult().getFulfillment().getSpeech();
				System.out.println(response.getResult().getFulfillment().getSpeech());
			} else {
				Application.logger.debug("4");
				speech = response.getStatus().getErrorDetails();
				System.err.println(response.getStatus().getErrorDetails());
			}
		} catch (Exception ex) {
			Application.logger.debug("5");
			ex.printStackTrace();
		}
		Application.logger.debug("6");
		Map<String, Object> code = new HashMap<String, Object>();
		code.put("input", input);
		code.put("speech", speech);
		code.put("displayText", speech);
		
		RecordModel recordModel = new RecordModel();
		recordModel.setRequest(input);
		Gson gson = new Gson();
		recordModel.setResponse(gson.toJson(code));
		recordModel.setTime(new Date());
		recordService.addRecord(recordModel);
		
		return code;
	}
}
