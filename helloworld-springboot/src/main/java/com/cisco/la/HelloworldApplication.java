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

package com.cisco.la;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.la.mapper.UserModelMapper;
import com.cisco.la.model.UserModel;

@SpringBootApplication
@RestController
public class HelloworldApplication {
	 @Autowired
	 private SqlSession sqlSession;

	@RequestMapping("/")
	  public Object home(){
			UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
		    UserModel userModel = userModelMapper.selectByPrimaryKey("test@test.com");
		    return userModel;
	  }
	
	@RequestMapping("/add")
	  public Object add(){
			UserModelMapper userModelMapper = sqlSession.getMapper(UserModelMapper.class);
			UserModel userModel = new UserModel();
			userModel.setActive(true);
			userModel.setBalance(1.0d);
			userModel.setBu("test");
			userModel.setBudget(10.0d);
			userModel.setGrade("test");
			userModel.setId("test1@test.com");
			userModel.setName("test");
			userModel.setRoleName("test");
			userModel.setTitle("title");
			userModelMapper.insert(userModel);
			return userModel;
	  }

	/**
	 * (Optional) App Engine health check endpoint mapping.
	 * 
	 * @see <a href=
	 *      "https://cloud.google.com/appengine/docs/flexible/java/how-instances-are-managed#health_checking"></a>
	 *      If your app does not handle health checks, a HTTP 404 response is
	 *      interpreted as a successful reply.
	 */
	@RequestMapping("/_ah/health")
	public String healthy() {
		// Message body required though ignored
		return "Still surviving.";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
