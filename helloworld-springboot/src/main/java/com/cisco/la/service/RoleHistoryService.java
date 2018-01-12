package com.cisco.la.service;
import com.cisco.la.model.RoleHistoryModel;
import java.util.List;
import java.util.ArrayList;

public interface RoleHistoryService {
  public void addRoleHistory(RoleHistoryModel roleHistoryModel);

  public List<RoleHistoryModel> getRoleHistoryList();
}
