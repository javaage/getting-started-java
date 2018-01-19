package com.cisco.la.service;
import com.cisco.la.model.RecordModel;
import java.util.List;
import java.util.ArrayList;

public interface RecordService {
  public void addRecord(RecordModel recordModel);

  public void updateRecord(RecordModel recordModel);

  public RecordModel getRecordByID(int id);
  
  public List<RecordModel> getRecordList();
 }
