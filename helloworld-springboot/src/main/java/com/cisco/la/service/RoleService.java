package com.cisco.la.service;
import java.util.List;

import com.cisco.la.model.RoleModel;

public interface RoleService {
  public void addRole(RoleModel roleModel);

  public void updateRole(RoleModel roleModel);

  public RoleModel getRoleByID(int id);
  
  public RoleModel getRoleByName(String roleName);
  
  public List<RoleModel> getRoleList();
}
