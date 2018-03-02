package com.cisco.la.service;
import com.cisco.la.entity.UserJoin;
import com.cisco.la.model.UserModel;
import java.util.List;
import java.util.ArrayList;

public interface UserService {
  public void addUser(UserModel userModel);
  
  public void addUserWithHistory(UserJoin userJoin) throws Exception;

  public void updateUser(UserModel userModel);
  
  public void updateUserWithHistory(UserJoin userJoin) throws Exception;

  public UserModel getUserByID(String id);
  
  public List<UserModel> getUserList();
  
  public List<UserModel> getUserListByRoleID(int roleID);
 }
