/**
 * 
 */
package com.cisco.la.entity;

import com.cisco.la.model.UserModel;

/**
 * @author P9030576
 *
 */
public class UserJoin extends UserModel {
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
