package com.cisco.la.join;

import java.util.List;

import com.cisco.la.entity.RoleHistoryJoin;

public interface RoleHistoryJoinMapper {

	public List<RoleHistoryJoin> getRoleHistoryByUserID(String userID);
}