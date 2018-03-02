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
import org.springframework.web.bind.annotation.RestController;

import com.cisco.la.entity.UserJoin;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;
import com.cisco.la.service.RoleService;

@Controller
@RestController
@RequestMapping(value="/api/import")
public class ImportController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getRoleByName(HttpServletRequest request){
		Map<String,Integer> columns = new HashMap<String,Integer>();
		String[] cols = new String[]{"Training History","Employee ID","Name","Job Title","BU","Role","Budget","Balance"};
		UserJoin userJoin = null;
		try {
			File file = ResourceUtils.getFile("classpath:data for Chatbot.xlsx");
			InputStream is = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(is) ;
			Sheet sheet = wb.getSheetAt(0);
			
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
					if(userJoin!=null && (userID.isEmpty() ||  userID.equals(userJoin.getId()))){
						userJoin.getListHistory().add(row.getCell(columns.get("Training History")).getStringCellValue());
					}else{
						if(userJoin!=null){
							
						}
						
						userJoin = new UserJoin();
						userJoin.getListHistory().add(row.getCell(columns.get("Training History")).getStringCellValue());
						userJoin.setId(row.getCell(columns.get("Employee ID")).getStringCellValue());
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
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello";
	}
}
