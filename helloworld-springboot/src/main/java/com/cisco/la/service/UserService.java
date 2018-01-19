package com.cisco.la.service;
import com.cisco.la.model.UserModel;
import java.util.List;
import java.util.ArrayList;

public interface UserService {
  public void addUser(UserModel userModel);

  public void updateUser(UserModel userModel);

  public UserModel getUserByID(String id);
  
  public List<UserModel> getUserList();
 }
