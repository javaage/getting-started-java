package com.cisco.la.service;
import java.util.List;

import com.cisco.la.entity.GoldenSampleJoin;
import com.cisco.la.model.GoldenSampleModel;

public interface GoldenSampleService {
	  public void addGoldenSample(GoldenSampleModel goldenSampleModel);

	  public void updateGoldenSample(GoldenSampleModel goldenSampleModel);

	  public GoldenSampleModel getGoldenSampleByID(int id);
	  
	  public List<GoldenSampleJoin> getGoldenSampleList();
	  
	  public List<GoldenSampleModel> getGoldenSampleListByRoleID(int roleID);
	  
	  public String getGoldenSampleStringByRoleID(int roleID);
}
