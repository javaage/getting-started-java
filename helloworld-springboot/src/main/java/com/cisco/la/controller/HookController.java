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
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.RecordModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.GoldenSampleService;
import com.cisco.la.service.MessageService;
import com.cisco.la.service.RecordService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;
import com.google.gson.Gson;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

@Controller
@RestController
@RequestMapping(value = "/api/hook")
public class HookController {
	@Autowired
	private RecordService recordService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private GoldenSampleService goldenSampleService;

	@Autowired
	private SparkService sparkService;
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object postResponse(@RequestBody String json) {
		String speech = "";
		Map<String, Object> code = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject(json);
		JSONObject result = jsonObject.getJSONObject("result");
		JSONObject parameters = result.getJSONObject("parameters");
		JSONObject metadata = result.getJSONObject("metadata");
		String intentName = metadata.optString("intentName","");
		String action = result.optString("action","");
		
		JSONObject originalRequest = jsonObject.optJSONObject("originalRequest");

		if (result.optString("fulfillment") != null) {
			JSONObject fulfillment = result.getJSONObject("fulfillment");
			speech = fulfillment.optString("speech","");
		} else if (result.optString("speech") != null) {
			speech = result.optString("speech","");
		}
		
		UserModel userModel = null;
		RoleModel roleModel = null;
		String role = "";
		String personEmail = "";
		if (originalRequest != null) {
			String source = originalRequest.optString("source");
			JSONObject data = originalRequest.optJSONObject("data");
			if (data != null) {
				JSONObject subData = data.optJSONObject("data");
				if (subData != null) {
					role = parameters.optString("Role","");
					personEmail = subData.optString("personEmail","");
					userModel = userService.getUserByID(personEmail);
					if(userModel!=null){
						
						userModel.setSession(new Date());
						userService.updateUser(userModel);
					}
					roleModel = roleService.getRoleByName(role);
				}
			}
		}

		code.put("speech", speech);
		code.put("displayText", speech);
		switch (intentName) {
		case "role":
			if (userModel == null) {
				speech = CustomMessage.CHAT_BOLT_INVALID_USER_MESSAGE;
				code.put("speech", speech);
				code.put("displayText", speech);
			} else if (userModel != null && roleModel == null) {
				speech = CustomMessage.CHAT_BOLT_INVALID_ROLE_MESSAGE.replace("@Role", role);
				code.put("speech", speech);
				code.put("displayText", speech);
			} else if (userModel != null && roleModel != null) {
				userModel.setRoleID(roleModel.getId());
				userService.updateUser(userModel);
				String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(roleModel.getId());
				speech = speech.replace("@Role", role);
				speech = speech.replace("@Course", prefCourse);
				code.put("speech", " ");
				code.put("displayText", " ");
				sparkService.sendMarkdownMessage(personEmail, speech);
				sparkService.sendMarkdownMessage(personEmail, CustomMessage.CHAT_BOLT_OTHER_HELP);
			}

			break;
		case "role:suggestions":
			if (userModel == null) {
				speech = CustomMessage.CHAT_BOLT_INVALID_USER_MESSAGE;
				code.put("speech", speech);
				code.put("displayText", speech);
			} else if (userModel != null && userModel.getRoleID() != null && userModel.getRoleID() > 0) {
				String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(userModel.getRoleID());
				roleModel = roleService.getRoleByID(userModel.getRoleID());
				speech = speech.replace("@Role", roleModel.getRoleName());
				speech = speech.replace("@Course", prefCourse);
				code.put("speech", " ");
				code.put("displayText", " ");
				sparkService.sendMarkdownMessage(personEmail, speech);
			} else {
				speech = CustomMessage.CHAT_BOLT_QUERY_ROLE_MESSAGE_ONLY;
				code.put("speech", speech);
				code.put("displayText", speech);
			}
			break;
		case "accept":
			List<MessageModel> activeMessages = messageService.getActiveMessage(personEmail,intentName,action);
			
			if(activeMessages.size()>0){
				for(MessageModel messageModel: activeMessages){
					sparkService.sendMarkdownMessage(messageModel.getUserID(), messageModel.getContent());
					messageModel.setActive(false);
					messageService.updateMessage(messageModel);
				}
				code.put("speech", " ");
				code.put("displayText", " ");
			}else{
				if(userModel!=null){
					userModel.setSession(new Date(1));
					userService.updateUser(userModel);
				}
			}
			break;
		default:
			speech = CustomMessage.CHAT_BOLT_FALLBACK_MESSAGE;
			code.put("speech", speech);
			code.put("displayText", speech);
			break;
		}
		
		if(userModel!=null){
			if(messageService.checkSessionFinished(userModel.getId())){
				userModel.setSession(new Date(1));
				userService.updateUser(userModel);
			}
		}
		
		Application.logger.debug(speech);

		RecordModel recordModel = new RecordModel();
		recordModel.setRequest("postResponse" + json);
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
		recordModel.setRequest("ai" + input);
		Gson gson = new Gson();
		recordModel.setResponse(gson.toJson(code));
		recordModel.setTime(new Date());
		recordService.addRecord(recordModel);

		return code;
	}
}
