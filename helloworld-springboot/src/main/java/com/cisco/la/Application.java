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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cisco.la")
@EnableCaching
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class Application {
	public enum Env {
		local, alpha, prod
	};
	
	public final static Logger logger = LoggerFactory.getLogger(Application.class);
	public static Env envCurrent = Env.local;
	public static String boltToken = "YjI0NDYxNjktYjFjYS00NTUyLTllZjQtMDU4OWIwMDgyZDdlNzAwNGM5NzUtZTgz";
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		boltToken = ctx.getEnvironment().getProperty("boltToken");
		envCurrent = Enum.valueOf(Env.class, ctx.getEnvironment().getProperty("spring.profiles.active")); 
	}
}
