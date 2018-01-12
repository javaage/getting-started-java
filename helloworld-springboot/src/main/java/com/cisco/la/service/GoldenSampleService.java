package com.cisco.la.service;
import com.cisco.la.model.GoldenSampleModel;
import java.util.List;
import java.util.ArrayList;

public interface GoldenSampleService {
  public void addGoldenSample(GoldenSampleModel goldenSampleModel) ;

  public void inactiveGoldenSample(String name);

  public void updateGoldenSample(GoldenSampleModel goldenSampleModel) ;
}
