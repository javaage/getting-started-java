package com.cisco.la.service;
import java.util.List;

import com.cisco.la.model.FlyerModel;

public interface FlyerService {
  public void addFlyer(FlyerModel flyerModel);

  public void updateFlyer(FlyerModel flyerModel);
  
  public FlyerModel getFlyerByID(int id);
  
  public List<FlyerModel> getFlyerList();
}
