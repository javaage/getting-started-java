package com.cisco.la.service;
import java.util.List;

import com.cisco.la.model.PaperModel;

public interface PaperService {
  public void addPaper(PaperModel paperModel);

  public void updatePaper(PaperModel paperModel);

  public PaperModel getPaperByID(int id);
  
  public List<PaperModel> getPaperList();
}
