package com.cisco.la.service;
import com.cisco.la.model.UserModel;
import java.util.List;
import java.util.ArrayList;

public interface UserService {
  public void addUser(UserModel userModel);

  public void inactiveUser(String id);

  public void updateUser(UserModel userModel);

  public UserModel getUserByID(String id);
 }
