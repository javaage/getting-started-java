package com.cisco.la.service;
import java.util.List;

import com.cisco.la.entity.FlyerJoin;
import com.cisco.la.model.FlyerModel;

public interface FlyerService {
  public void addFlyer(FlyerModel flyerModel);

  public void updateFlyer(FlyerModel flyerModel);
  
  public FlyerJoin getFlyerByID(int id);
  
  public List<FlyerModel> getFlyerList();
  
  public List<FlyerModel> getWaitingFlyerList();
  
  public List<FlyerModel> getWaitingFlyerListByID(String userID);
  
  public void updateFlyerStatus(FlyerModel flyerModel);
}
