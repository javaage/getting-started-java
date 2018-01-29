package com.cisco.la.join;

import com.cisco.la.model.RoleModel;

public interface RoleMapper {
	
	RoleModel getRoleByName(String roleName);
	
}