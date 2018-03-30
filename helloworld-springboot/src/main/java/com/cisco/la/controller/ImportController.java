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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cisco.la.entity.GoldenSampleJoin;
import com.cisco.la.entity.UserJoin;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.model.RoleHistoryModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.CourseService;
import com.cisco.la.service.GoldenSampleService;
import com.cisco.la.service.RoleHistoryService;
import com.cisco.la.service.RoleService;
import com.cisco.la.service.UserService;


@Controller
@RestController
@RequestMapping(value="/api/import")
public class ImportController {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private GoldenSampleService goldenSampleService;
	
	@Autowired
	private RoleHistoryService roleHistoryService;
	
	@RequestMapping(value="/users",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addManyAccount(HttpServletRequest request, @RequestParam("file") MultipartFile[] files){
		
		try {
			InputStream is = files[0].getInputStream();
			Workbook wb = WorkbookFactory.create(is);
			
			importUser(wb);
			
			String message = "Successfully";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", message);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	@RequestMapping(value="/all",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addAllInformation(HttpServletRequest request, @RequestParam("file") MultipartFile[] files){
		
		try {
			InputStream is = files[0].getInputStream();
			Workbook wb = WorkbookFactory.create(is);
			
			importCourse(wb);
			importTrainningHistory(wb);
			importGoldenSample(wb);
			
			String message = "Successfully";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 1);
			map.put("message", message);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	
	private void importUser(Workbook wb) throws Exception {
		Sheet sheet = wb.getSheetAt(0);
		
		Row rowTitle = sheet.getRow(0);
		Map<String,Integer> columns = new HashMap<String,Integer>();
		for(int colNum=rowTitle.getFirstCellNum(); colNum<=rowTitle.getLastCellNum(); colNum++){
			if(rowTitle.getCell(colNum)!=null)
				columns.put(rowTitle.getCell(colNum).getStringCellValue(), colNum);
		}
		
		Row row = null ;
		for( int kk =1; kk < sheet.getPhysicalNumberOfRows() ;kk++){
			row = sheet.getRow(kk);
			if(row!=null){
				String employeeID = row.getCell(columns.get("Employee ID")).getStringCellValue();
				
				if(!employeeID.contains("@"))
					employeeID += "@cisco.com";
				
				String name = row.getCell(columns.get("Name")).getStringCellValue();
				String jobTitle = row.getCell(columns.get("Job Title"))==null? "" : row.getCell(columns.get("Job Title")).getStringCellValue();
				String BU = row.getCell(columns.get("BU")).getStringCellValue();
				String role = row.getCell(columns.get("Role")) == null? "" : row.getCell(columns.get("Role")).getStringCellValue();
				double budget = row.getCell(columns.get("Targeted Points")).getNumericCellValue();
				double balance = row.getCell(columns.get("Points Earned")).getNumericCellValue();
				
				String grade = "";
				if(columns.containsKey("Grade")){
					grade = row.getCell(columns.get("Grade"))==null? "" : row.getCell(columns.get("Grade")).getStringCellValue();
				}
				
				UserModel oldUserModel = userService.getUserByID(employeeID); 
				if(oldUserModel==null){
					UserModel userModel = new UserModel();
					
					userModel.setActive(true);
					userModel.setBalance(balance);
					userModel.setBu(BU);
					userModel.setTitle(jobTitle);
					userModel.setGrade(grade);
					userModel.setBudget(budget);
					userModel.setId(employeeID);
					userModel.setName(name);
					userModel.setSession(new Date());
					
					RoleModel roleModel = roleService.getRoleByName(role);
					if(roleModel!=null){
						userModel.setRoleID(roleModel.getId());
						RoleHistoryModel roleHistoryModel = new RoleHistoryModel();
						roleHistoryModel.setUserID(userModel.getId());
						roleHistoryModel.setRoleID(userModel.getRoleID());
						roleHistoryModel.setUpdateTime(new Date());
						roleHistoryService.addRoleHistory(roleHistoryModel);
					} else if(!role.isEmpty()){
						roleModel = new RoleModel();
						
						roleModel.setActive(true);
						roleModel.setBu(BU);
						roleModel.setRoleName(role);
						
						roleService.addRole(roleModel);
						roleModel = roleService.getRoleByName(role);
						
						userModel.setRoleID(roleModel.getId());
					} 
					
					userService.addUser(userModel);
				}else{
					UserModel userModel = new UserModel();
					
					userModel.setActive(true);
					userModel.setBalance(balance);
					userModel.setBu(BU);
					userModel.setTitle(jobTitle);
					userModel.setGrade(grade);
					userModel.setBudget(budget);
					userModel.setId(employeeID);
					userModel.setName(name);
					userModel.setSession(new Date());
					
					RoleModel roleModel = roleService.getRoleByName(role);
					if(roleModel!=null){
						userModel.setRoleID(roleModel.getId());
						
						if( oldUserModel.getRoleID()==null || roleModel.getId() != oldUserModel.getRoleID()){
							RoleHistoryModel roleHistoryModel = new RoleHistoryModel();
							roleHistoryModel.setUserID(userModel.getId());
							roleHistoryModel.setRoleID(userModel.getRoleID());
							roleHistoryModel.setUpdateTime(new Date());
							roleHistoryService.addRoleHistory(roleHistoryModel);
						}
					} else if(!role.isEmpty()){
						roleModel = new RoleModel();
						
						roleModel.setActive(true);
						roleModel.setBu(BU);
						roleModel.setRoleName(role);
						
						roleService.addRole(roleModel);
						roleModel = roleService.getRoleByName(role);
						
						userModel.setRoleID(roleModel.getId());
					}
					
					userService.updateUser(userModel); 
					
					userService.sendUpdateMessage(oldUserModel, userModel);
				}
				
			}
		}
	}
	
	private void importCourse(Workbook wb) throws Exception {
		Sheet sheet = wb.getSheet("Training Sessions");
		if(sheet==null){
			throw new Exception("Training Sessions does not exist.");
		}
		
		Row rowTitle = sheet.getRow(0);
		Map<String,Integer> columns = new HashMap<String,Integer>();
		for(int colNum=rowTitle.getFirstCellNum(); colNum<=rowTitle.getLastCellNum(); colNum++){
			if(rowTitle.getCell(colNum)!=null)
				columns.put(rowTitle.getCell(colNum).getStringCellValue(), colNum);
		}
		
		Row row = null ;
		for( int kk =1; kk < sheet.getPhysicalNumberOfRows() ;kk++){
			row = sheet.getRow(kk);
			if(row!=null){
				String courseName = row.getCell(columns.get("Course name")).getStringCellValue();
				Date startDate = row.getCell(columns.get("Start Date")).getDateCellValue();
				Date endDate = row.getCell(columns.get("End Date")).getDateCellValue();
				double price = row.getCell(columns.get("Price")).getNumericCellValue();
				
				CourseModel courseModel = courseService.getCourseByName(courseName);
				
				if(courseModel==null){
					courseModel = new CourseModel();
					courseModel.setCourseName(courseName);
					courseModel.setActive(true);
					courseModel.setStartDate(startDate);
					courseModel.setEndDate(endDate);
					courseModel.setPrice(price);
					courseModel.setUrl("");
					courseService.addCourse(courseModel);
				}else{
					courseModel.setStartDate(startDate);
					courseModel.setEndDate(endDate);
					courseModel.setPrice(price);
					courseService.updateCourse(courseModel);
				}
			}
		}
	}

	private void importTrainningHistory(Workbook wb) throws Exception {
		Sheet sheet = wb.getSheet("Employee Profile");
		
		if(sheet==null){
			throw new Exception("Employee Profile does not exist.");
		}
		
		Map<String,Integer> columns = new HashMap<String,Integer>();
		String[] cols = new String[]{"Training History","Employee ID","Name","Job Title","BU","Role","Budget","Balance"};
		UserJoin userJoin = null;
		
		Row rowTitle = sheet.getRow(0);
		
		for(int colNum=rowTitle.getFirstCellNum(); colNum<=rowTitle.getLastCellNum(); colNum++){
			if(rowTitle.getCell(colNum)!=null)
				columns.put(rowTitle.getCell(colNum).getStringCellValue(), colNum);
		}
		
		Row row = null ;
		for( int kk =1; kk < sheet.getPhysicalNumberOfRows() ;kk++){
			row = sheet.getRow(kk);
			if(row!=null){
				String userID = row.getCell(columns.get("Employee ID")).getStringCellValue();
				String courseName = row.getCell(columns.get("Training History")).getStringCellValue();
				
				if(courseName==null || courseName.isEmpty()){
					if(userJoin!=null){
						userService.addUserWithHistory(userJoin);
						userJoin = null;
					}
				}else if(userJoin!=null && (userID.isEmpty() ||  userID.equals(userJoin.getId()))){
					userJoin.getListHistory().add(courseName);
				}else{
					userJoin = new UserJoin();
					userJoin.getListHistory().add(courseName);
					userJoin.setId(row.getCell(columns.get("Employee ID")).getStringCellValue()+"@cisco.com");
					userJoin.setName(row.getCell(columns.get("Name")).getStringCellValue());
					userJoin.setTitle(row.getCell(columns.get("Job Title")).getStringCellValue());
					userJoin.setBu(row.getCell(columns.get("BU")).getStringCellValue());
					String roleName = row.getCell(columns.get("Role")).getStringCellValue();
					RoleModel roleModel = roleService.getRoleByName(roleName);
					if(roleModel!=null){
						userJoin.setRoleID(roleModel.getId());
					}
					userJoin.setBudget(row.getCell(columns.get("Budget")).getNumericCellValue());
					userJoin.setBalance(row.getCell(columns.get("Balance")).getNumericCellValue());
					userJoin.setActive(true);
					userJoin.setSession(new Date());
				}
			}else{
				if(userJoin!=null){
					userService.addUserWithHistory(userJoin);
					userJoin = null;
				}
			}
		}
		if(userJoin!=null){
			userService.addUserWithHistory(userJoin);
		}
	}
	
	private void importGoldenSample(Workbook wb) throws Exception {
		Sheet sheet = wb.getSheet("Golden Sample");
		if(sheet==null){
			throw new Exception("Golden Sample does not exist.");
		}
		
		Row rowTitle = sheet.getRow(0);
		Map<String,Integer> columns = new HashMap<String,Integer>();
		for(int colNum=rowTitle.getFirstCellNum(); colNum<=rowTitle.getLastCellNum(); colNum++){
			if(rowTitle.getCell(colNum)!=null)
				columns.put(rowTitle.getCell(colNum).getStringCellValue(), colNum);
		}
		
		Row row = null ;
		GoldenSampleJoin goldenSampleJoin = null;
		for( int kk =1; kk < sheet.getPhysicalNumberOfRows() ;kk++){
			row = sheet.getRow(kk);
			if(row!=null){
				String goldenSampleName = row.getCell(columns.get("Golden Sample Name")).getStringCellValue();
				String roleName = row.getCell(columns.get("Role Name")).getStringCellValue();
				String courseName = row.getCell(columns.get("Course Name")).getStringCellValue();
				String mandatory = row.getCell(columns.get("mandatory/optional")).getStringCellValue();
				
				if(courseName==null || courseName.isEmpty()){
					if(goldenSampleJoin!=null){
						goldenSampleService.addGoldenSampleJoin(goldenSampleJoin);
						goldenSampleJoin = null;
					}
				}else if(goldenSampleJoin!=null && (goldenSampleName==null || goldenSampleName.isEmpty())){
					if("m".equalsIgnoreCase(mandatory))
						goldenSampleJoin.getListMandatory().add(courseName);
					if("o".equalsIgnoreCase(mandatory))
						goldenSampleJoin.getListOptional().add(courseName);
				}else{
					RoleModel roleModel = roleService.getRoleByName(roleName);
					if(roleModel == null)
						continue;
					
					goldenSampleJoin = new GoldenSampleJoin();
					goldenSampleJoin.setActive(true);
					goldenSampleJoin.setGoldenSampleName(goldenSampleName);
					if("m".equalsIgnoreCase(mandatory))
						goldenSampleJoin.getListMandatory().add(courseName);
					if("o".equalsIgnoreCase(mandatory))
						goldenSampleJoin.getListOptional().add(courseName);
					goldenSampleJoin.setRoleID(roleModel.getId());
					goldenSampleJoin.setUpdateTime(new Date());
				}
			}else{
				if(goldenSampleJoin!=null){
					goldenSampleService.addGoldenSampleJoin(goldenSampleJoin);
					goldenSampleJoin = null;
				}
			}
		}
		if(goldenSampleJoin!=null){
			goldenSampleService.addGoldenSampleJoin(goldenSampleJoin);
		}
	}
}
