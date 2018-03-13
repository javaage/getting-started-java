/**
 * 
 */
package com.cisco.la.entity;

import java.util.ArrayList;
import java.util.List;

import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuizModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;

/**
 * @author P9030576
 *
 */
public class QuizJoin extends QuizModel {
	public List<RoleModel> getListRoleModel() {
		return listRoleModel;
	}

	public void setListRoleModel(List<RoleModel> listRoleModel) {
		this.listRoleModel = listRoleModel;
	}

	public List<UserModel> getListUserModel() {
		return listUserModel;
	}

	public void setListUserModel(List<UserModel> listUserModel) {
		this.listUserModel = listUserModel;
	}

	private String courseName;
	
	private List<QuestionModel> listQuestionModel = new ArrayList<QuestionModel>();
	
	private List<RoleModel> listRoleModel = new ArrayList<RoleModel>();
	
	private List<UserModel> listUserModel = new ArrayList<UserModel>();

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<QuestionModel> getListQuestionModel() {
		return listQuestionModel;
	}

	public void setListQuestionModel(List<QuestionModel> listQuestionModel) {
		this.listQuestionModel = listQuestionModel;
	}

	
}
