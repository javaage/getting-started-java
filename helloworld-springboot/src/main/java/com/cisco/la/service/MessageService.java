package com.cisco.la.service;
import com.cisco.la.model.MessageModel;
import java.util.List;
import java.util.ArrayList;

public interface MessageService {
  public void addMessage(MessageModel messageModel);

  public void updateMessage(MessageModel messageModel);

  public MessageModel getMessageByID(int id);
  
  public List<MessageModel> getMessageList();
  
  public MessageModel getLatestMessageByUserID(String userID);
  
  public List<MessageModel> getActiveMessage(String userID);
}
