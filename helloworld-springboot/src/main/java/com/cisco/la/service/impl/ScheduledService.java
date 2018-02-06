/**
 * 
 */
package com.cisco.la.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cisco.la.Application;
import com.cisco.la.Application.Env;
import com.cisco.la.common.SparkService;
import com.cisco.la.model.MessageModel;
import com.cisco.la.service.MessageService;

/**
 * @author P9030576
 *
 */
@Service
public class ScheduledService {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SparkService sparkService;
	
	@Scheduled(fixedRate = 1000*60)
	public void fixedRate(){
		System.out.println(new Date());
		List<MessageModel> listMessageModel = messageService.getLostSessionMessage();
		
		if(Application.envCurrent != Env.local){
			for(MessageModel messageModel : listMessageModel){
				sparkService.sendMarkdownMessage(messageModel.getUserID(), messageModel.getContent());
				messageModel.setActive(false);
				messageService.updateMessage(messageModel);
			}
		}
	}
}
