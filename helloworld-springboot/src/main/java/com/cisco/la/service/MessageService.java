package com.cisco.la.service;
import java.util.List;

import com.cisco.la.model.MessageModel;

public interface MessageService {
  public void addMessage(MessageModel messageModel);

  public void updateMessage(MessageModel messageModel);

  public MessageModel getMessageByID(int id);
  
  public List<MessageModel> getMessageList();
  
  public MessageModel getLatestMessageByUserID();
  
  public List<MessageModel> getActiveMessage(String userID,String intentName,String action);
  
  public List<MessageModel> getLostSessionMessage();
}
