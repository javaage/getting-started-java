package com.cisco.la.service;
import com.cisco.la.model.RoleModel;
import java.util.List;
import java.util.ArrayList;

public interface RoleService {
  public void addRole(RoleModel roleModel);

  public void updateRole(RoleModel roleModel);

  public RoleModel getRoleByID(int id);
  
  public List<RoleModel> getRoleList();
}
