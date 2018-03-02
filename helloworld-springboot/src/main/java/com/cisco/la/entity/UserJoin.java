/**
 * 
 */
package com.cisco.la.entity;

import java.util.ArrayList;
import java.util.List;

import com.cisco.la.model.UserModel;

/**
 * @author P9030576
 *
 */
public class UserJoin extends UserModel {
	private String roleName;
	private List<String> listHistory = new ArrayList<String>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getListHistory() {
		return listHistory;
	}

	public void setListHistory(List<String> listHistory) {
		this.listHistory = listHistory;
	}

	
}
