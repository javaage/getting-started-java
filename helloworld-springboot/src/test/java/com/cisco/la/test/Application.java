/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.cisco.la.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cisco.la.common.CustomMessage;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.RecordModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.google.gson.Gson;


@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cisco.la")
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class Application {
	public enum Env {
		local, alpha, prod
	};
	
	public final static Logger logger = LoggerFactory.getLogger(Application.class);
	public static Env envCurrent = Env.local;
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		envCurrent = Enum.valueOf(Env.class, ctx.getEnvironment().getProperty("spring.profiles.active"));
		
		String json = "{\"originalRequest\":{\"source\":\"spark\",\"data\":{\"data\":{\"created\":\"2018-03-01T06:53:44.861Z\",\"personEmail\":\"hb_java@sina.com\",\"personId\":\"Y2lzY29zcGFyazovL3VzL1BFT1BMRS8zMGRlZTYyMi0zMTRmLTRjNzgtYmYwNC1lOTFiOTYyYmE2Y2I\",\"id\":\"Y2lzY29zcGFyazovL3VzL01FU1NBR0UvNDhkZWFjZDAtMWQxZC0xMWU4LTgyYTUtM2ZkNTA0NjQxNjAy\",\"roomId\":\"Y2lzY29zcGFyazovL3VzL1JPT00vZjUzMTkxZDItZWU2Yy0zMGM0LWI3M2ItM2UzZDY0NDYxMmRi\",\"roomType\":\"direct\"},\"resource\":\"messages\",\"created\":\"2018-03-01T02:49:44.630Z\",\"orgId\":\"Y2lzY29zcGFyazovL3VzL09SR0FOSVpBVElPTi8xZWI2NWZkZi05NjQzLTQxN2YtOTk3NC1hZDcyY2FlMGUxMGY\",\"actorId\":\"Y2lzY29zcGFyazovL3VzL1BFT1BMRS8zMGRlZTYyMi0zMTRmLTRjNzgtYmYwNC1lOTFiOTYyYmE2Y2I\",\"createdBy\":\"Y2lzY29zcGFyazovL3VzL1BFT1BMRS9kYzBiMjJlMy00MGI1LTRhOWEtYTVhNS0xNzQ2YWQ1NTMxMzA\",\"appId\":\"Y2lzY29zcGFyazovL3VzL0FQUExJQ0FUSU9OL0MzMmM4MDc3NDBjNmU3ZGYxMWRhZjE2ZjIyOGRmNjI4YmJjYTQ5YmE1MmZlY2JiMmM3ZDUxNWNiNGEwY2M5MWFh\",\"name\":\"webhhok7894d2d5-4177-486f-8680-f6bb48996d8f\",\"id\":\"Y2lzY29zcGFyazovL3VzL1dFQkhPT0svZGU5ZjRiZWUtMzUzNC00Y2EzLTg2NmYtZjk4NjY5YzAzMzcy\",\"event\":\"created\",\"targetUrl\":\"https://bots.api.ai/spark/7894d2d5-4177-486f-8680-f6bb48996d8f/webhook\",\"ownedBy\":\"creator\",\"status\":\"active\"}},\"id\":\"56312cf4-376e-4463-853c-d31f7f5fa768\",\"timestamp\":\"2018-03-01T06:53:45.388Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"I want to take some new courses. Can you give me some suggestions?\",\"speech\":\"\",\"action\":\"input.suggestions\",\"actionIncomplete\":false,\"parameters\":{\"role\":\"\"},\"contexts\":[{\"name\":\"rolesuggestions-followup\",\"parameters\":{\"role\":\"\",\"role.original\":\"\"},\"lifespan\":2}],\"metadata\":{\"intentId\":\"67157e69-2abf-4a6b-a39c-bd37f30deb8e\",\"webhookUsed\":\"true\",\"webhookForSlotFillingUsed\":\"true\",\"intentName\":\"role:suggestions\"},\"fulfillment\":{\"speech\":\"Here is the training you need to take as @Role. @Course\",\"messages\":[{\"type\":0,\"speech\":\"Here is the training you need to take as @Role. @Course\"}]},\"score\":1.0},\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"6753dad6-67a0-404e-8578-9f3eed793419\"}";
		
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
//					userModel = userService.getUserByID(personEmail);
					if(userModel!=null){
						
						userModel.setSession(new Date());
//						userService.updateUser(userModel);
					}
//					roleModel = roleService.getRoleByName(role);
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
//				userService.updateUser(userModel);
//				String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(userModel.getId(), roleModel.getId());
				
//				if(prefCourse.isEmpty()){
//					code.put("speech", speech);
//					code.put("displayText", speech);
//				}else{
//					speech += " " + String.format(CustomMessage.CHAT_BOLT_COURSE_NEED_MESSAGE, roleModel.getRoleName(), prefCourse);
//					sparkService.sendMarkdownMessage(personEmail, speech);
//					sparkService.sendMarkdownMessage(personEmail, CustomMessage.CHAT_BOLT_OTHER_HELP);
//					code.put("speech", " ");
//					code.put("displayText", " ");
//				}
			}

			break;
		case "role:suggestions":
			if (userModel == null) {
				speech = CustomMessage.CHAT_BOLT_INVALID_USER_MESSAGE;
				code.put("speech", speech);
				code.put("displayText", speech);
			} else if (userModel != null && userModel.getRoleID() != null && userModel.getRoleID() > 0) {
//				String prefCourse = goldenSampleService.getGoldenSampleStringByRoleID(userModel.getId(), userModel.getRoleID());
//				roleModel = roleService.getRoleByID(userModel.getRoleID());
//				speech = speech.replace("@Role", roleModel.getRoleName());
//				speech = speech.replace("@Course", prefCourse);
//				code.put("speech", " ");
//				code.put("displayText", " ");
//				sparkService.sendMarkdownMessage(personEmail, speech);
			} else {
				speech = CustomMessage.CHAT_BOLT_QUERY_ROLE_MESSAGE_ONLY;
				code.put("speech", speech);
				code.put("displayText", speech);
			}
			break;
		case "accept":
//			List<MessageModel> activeMessages = messageService.getActiveMessage(personEmail,intentName,action);
//			
//			if(activeMessages.size()>0){
//				for(MessageModel messageModel: activeMessages){
//					sparkService.sendMarkdownMessage(messageModel.getUserID(), messageModel.getContent());
//					messageModel.setActive(false);
//					messageService.updateMessage(messageModel);
//				}
//				code.put("speech", " ");
//				code.put("displayText", " ");
//			}else{
//				if(userModel!=null){
//					userModel.setSession(new Date(1));
//					userService.updateUser(userModel);
//				}
//			}
			break;
		default:
			speech = CustomMessage.CHAT_BOLT_FALLBACK_MESSAGE;
			code.put("speech", speech);
			code.put("displayText", speech);
			break;
		}
		

		
	}
}
