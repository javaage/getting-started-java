/**
 * 
 */
package com.cisco.la.entity;

import java.util.ArrayList;
import java.util.List;

import com.cisco.la.model.FlyerModel;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.UserModel;

/**
 * @author P9030576
 *
 */
public class FlyerJoin extends FlyerModel {
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
	
	private List<RoleModel> listRoleModel = new ArrayList<RoleModel>();
	
	private List<UserModel> listUserModel = new ArrayList<UserModel>();
}
